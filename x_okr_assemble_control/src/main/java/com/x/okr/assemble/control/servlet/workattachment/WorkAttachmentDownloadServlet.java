package com.x.okr.assemble.control.servlet.workattachment;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.x.base.core.application.servlet.FileUploadServletTools;
import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.container.factory.EntityManagerContainerFactory;
import com.x.base.core.entity.StorageType;
import com.x.base.core.http.ActionResult;
import com.x.base.core.http.annotation.HttpMethodDescribe;
import com.x.base.core.project.server.Config;
import com.x.base.core.project.server.StorageMapping;
import com.x.okr.assemble.control.ThisApplication;
import com.x.okr.entity.OkrAttachmentFileInfo;

@WebServlet(urlPatterns = "/servlet/download/workattachment/*")
public class WorkAttachmentDownloadServlet extends HttpServlet {

	private static final long serialVersionUID = -4314532091497625540L;
	private Logger logger = LoggerFactory.getLogger( WorkAttachmentDownloadServlet.class );

	@HttpMethodDescribe(value = "下载附件 servlet/download/workattachment/{id}/stream", response = Object.class)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionResult<Object> result = new ActionResult<>();
		OkrAttachmentFileInfo okrAttachmentFileInfo = null;
		StorageMapping mapping = null;
		String part = null;
		String attachId = null;
		boolean streamContentType = false;
		boolean check = true;

		request.setCharacterEncoding("UTF-8");

		// 获取文件ID
		if (check) {
			try {
				part = FileUploadServletTools.getURIPart(request.getRequestURI(), "workattachment");
				attachId = StringUtils.substringBefore(part, "/");
			} catch (Exception e) {
				check = false;
				result.setUserMessage("系统URL信息获取传入的附件ID时发生异常。");
				result.error(e);
				logger.error("system get id from request url got an exception.", e);
			}
		}

		/* 确定是否要用application/octet-stream输出 */
		if (check) {
			streamContentType = StringUtils.endsWith(part, "/stream");
			logger.info("streamContentType = " + streamContentType);
		}

		if (check) {
			try (EntityManagerContainer emc = EntityManagerContainerFactory.instance().create()) {
				okrAttachmentFileInfo = emc.find(attachId, OkrAttachmentFileInfo.class);
				if (null == okrAttachmentFileInfo) {
					check = false;
					result.error(new Exception("文件信息不存在:" + attachId));
					result.setUserMessage("文件信息不存在。");
					logger.error("okrAttachmentFileInfo{'id':'" + attachId + "'} not existed.");
				}
			} catch (Exception e) {
				check = false;
				result.setUserMessage("系统根据ID获取文件信息时发生异常。");
				result.error(e);
				logger.error("system get okrAttachmentFileInfo{'id':'" + attachId + "'} got an exception.", e);
			}
		}
		//文件下载		
		if (check) {
			mapping = ThisApplication.storageMappings.get( StorageType.okr, okrAttachmentFileInfo.getStorage() );
			try {
				this.setResponseHeader( response, streamContentType, okrAttachmentFileInfo );
			} catch (Exception e) {
				check = false;
				result.setUserMessage("系统下载文件时设置responseHeader时发生异常。");
				result.error(e);
				logger.error("system set response header got an exception.", e);
			}
		}

		if (check) {
			try {
				okrAttachmentFileInfo.readContent( mapping, response.getOutputStream() );
			} catch (Exception e) {
				check = false;
				result.setUserMessage("系统读取文件输出时发生异常。");
				result.error(e);
				logger.error("system read content got an exception.", e);
			}
		}

		if (!check) {
			response.setStatus( HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
			FileUploadServletTools.result( response, result );
		}
	}

	private void setResponseHeader(HttpServletResponse response, boolean streamContentType,
			OkrAttachmentFileInfo okrAttachmentFileInfo) throws Exception {
		if (streamContentType) {
			response.setHeader("Content-Type", "application/octet-stream");
			response.setHeader("Content-Disposition", "fileInfo; filename=" + URLEncoder.encode(okrAttachmentFileInfo.getName(), "utf-8"));
		} else {
			response.setHeader("Content-Type", Config.mimeTypes().getContentType(okrAttachmentFileInfo.getName()));
			response.setHeader("Content-Disposition", "inline; filename=" + URLEncoder.encode(okrAttachmentFileInfo.getName(), "utf-8"));
		}
		response.setIntHeader("Content-Length", okrAttachmentFileInfo.getLength().intValue());
	}
}