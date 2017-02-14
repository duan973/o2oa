package com.x.attendance.assemble.control.jaxrs.attendancestatisticrequirelog;

import java.util.ArrayList;
import java.util.List;

import com.x.attendance.entity.AttendanceStatisticRequireLog;
import com.x.base.core.entity.JpaObject;
import com.x.base.core.http.annotation.Wrap;

@Wrap( AttendanceStatisticRequireLog.class)
public class WrapInAttendanceStatisticRequireLog extends AttendanceStatisticRequireLog {
	private static final long serialVersionUID = -5076990764713538973L;
	public static List<String> Excludes = new ArrayList<String>(JpaObject.FieldsUnmodifies);

	private String identity = null;

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
}