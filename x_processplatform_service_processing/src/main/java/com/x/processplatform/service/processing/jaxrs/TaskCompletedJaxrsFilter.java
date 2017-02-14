package com.x.processplatform.service.processing.jaxrs;

import javax.servlet.annotation.WebFilter;

import com.x.base.core.application.jaxrs.CipherManagerJaxrsFilter;

@WebFilter(urlPatterns = { "/jaxrs/taskcompleted/*" })
public class TaskCompletedJaxrsFilter extends CipherManagerJaxrsFilter {

}
