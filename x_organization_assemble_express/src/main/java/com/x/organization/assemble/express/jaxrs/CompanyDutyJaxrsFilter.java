package com.x.organization.assemble.express.jaxrs;

import javax.servlet.annotation.WebFilter;

import com.x.base.core.application.jaxrs.CipherManagerUserJaxrsFilter;

@WebFilter(urlPatterns = "/jaxrs/companyduty/*")
public class CompanyDutyJaxrsFilter extends CipherManagerUserJaxrsFilter {

}
