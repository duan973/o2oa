package com.x.processplatform.assemble.bam.jaxrs.state;

import com.x.base.core.http.ActionResult;
import com.x.base.core.http.WrapOutMap;
import com.x.processplatform.assemble.bam.ThisApplication;

class ActionSummary extends ActionBase {

	ActionResult<WrapOutMap> execute() throws Exception {
		ActionResult<WrapOutMap> result = new ActionResult<>();
		result.setData(ThisApplication.state.getSummary());
		return result;
	}

}
