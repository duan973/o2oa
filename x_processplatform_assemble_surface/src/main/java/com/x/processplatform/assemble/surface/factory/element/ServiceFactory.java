package com.x.processplatform.assemble.surface.factory.element;

import java.util.List;

import com.x.base.core.exception.ExceptionWhen;
import com.x.processplatform.assemble.surface.Business;
import com.x.processplatform.core.entity.element.Process;
import com.x.processplatform.core.entity.element.Service;

public class ServiceFactory extends ElementFactory {

	public ServiceFactory(Business abstractBusiness) throws Exception {
		super(abstractBusiness);
	}

	public Service pick(String flag) throws Exception {
		return this.pick(flag, ExceptionWhen.none);
	}

	public Service pick(String flag, ExceptionWhen exceptionWhen) throws Exception {
		return this.pick(flag, Service.class, exceptionWhen, Service.FLAGS);
	}

	public List<Service> listWithProcess(Process process) throws Exception {
		List<Service> list = this.listWithProcess(Service.class, process);
		return list;
	}
}