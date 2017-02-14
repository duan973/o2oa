package com.x.processplatform.assemble.surface.factory.element;

import java.util.List;

import com.x.base.core.exception.ExceptionWhen;
import com.x.processplatform.assemble.surface.Business;
import com.x.processplatform.core.entity.element.Process;
import com.x.processplatform.core.entity.element.Split;

public class SplitFactory extends ElementFactory {

	public SplitFactory(Business abstractBusiness) throws Exception {
		super(abstractBusiness);
	}

	public Split pick(String flag) throws Exception {
		return this.pick(flag, ExceptionWhen.none);
	}

	public Split pick(String flag, ExceptionWhen exceptionWhen) throws Exception {
		return this.pick(flag, Split.class, exceptionWhen, Split.FLAGS);
	}

	public List<Split> listWithProcess(Process process) throws Exception {
		List<Split> list = this.listWithProcess(Split.class, process);
		return list;
	}
}