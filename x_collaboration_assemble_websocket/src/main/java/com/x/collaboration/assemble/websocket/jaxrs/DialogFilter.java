package com.x.collaboration.assemble.websocket.jaxrs;

import javax.servlet.annotation.WebFilter;

import com.x.base.core.application.jaxrs.CipherManagerUserJaxrsFilter;

@WebFilter(urlPatterns = { "/jaxrs/dialog/*" })
public class DialogFilter extends CipherManagerUserJaxrsFilter {

}
