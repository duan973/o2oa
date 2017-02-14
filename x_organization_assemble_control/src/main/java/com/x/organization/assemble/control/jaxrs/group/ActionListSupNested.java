package com.x.organization.assemble.control.jaxrs.group;

import java.util.List;

import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.exception.ExceptionWhen;
import com.x.base.core.utils.SortTools;
import com.x.organization.assemble.control.Business;
import com.x.organization.assemble.control.wrapout.WrapOutGroup;
import com.x.organization.core.entity.Group;

public class ActionListSupNested extends ActionBase {

	protected List<WrapOutGroup> execute(Business business, String id) throws Exception {
		EntityManagerContainer emc = business.entityManagerContainer();
		Group group = emc.find(id, Group.class, ExceptionWhen.not_found);
		List<String> ids = business.group().listSupNested(group.getId());
		List<WrapOutGroup> wraps = outCopier.copy(emc.list(Group.class, ids));
		SortTools.asc(wraps, false, "name");
		return wraps;
	}

}