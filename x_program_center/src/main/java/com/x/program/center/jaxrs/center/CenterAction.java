package com.x.program.center.jaxrs.center;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.x.base.core.application.jaxrs.AbstractJaxrsAction;
import com.x.base.core.http.ActionResult;
import com.x.base.core.http.HttpMediaType;
import com.x.base.core.http.ResponseFactory;
import com.x.base.core.project.Report;
import com.x.base.core.project.ReportEcho;
import com.x.program.center.ThisApplication;

@Path("center")
public class CenterAction extends AbstractJaxrsAction {

	@PUT
	@Path("report")
	@Produces(HttpMediaType.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response report(Report report) {
		ActionResult<ReportEcho> result = new ActionResult<>();
		ReportEcho echo = null;
		try {
			ActionReport.send(report);
			echo = new ReportEcho();
			echo.setApplicationsToken(ThisApplication.applications.getToken());
			result.setData(echo);
		} catch (Throwable th) {
			th.printStackTrace();
			result.error(th);
		}
		return ResponseFactory.getDefaultActionResultResponse(result);
	}
}