package com.x.base.core.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ObjectUtils;

public class SortTools {

	public static void asc(List<?> list, final String... attributes) throws Exception {
		asc(list, false, attributes);
	}

	public static void asc(List<?> list, final boolean nullGreater, final String... attributes) throws Exception {
		Collections.sort(list, new Comparator<Object>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public int compare(Object o1, Object o2) {
				int c = 0;
				try {
					for (String attribute : attributes) {
						Object p1 = PropertyUtils.getProperty(o1, attribute);
						Object p2 = PropertyUtils.getProperty(o2, attribute);
						Comparable c1 = null;
						Comparable c2 = null;
						if (null != p1) {
							c1 = (p1 instanceof Comparable) ? (Comparable) p1 : p1.toString();
						}
						if (null != p2) {
							c2 = (p2 instanceof Comparable) ? (Comparable) p2 : p2.toString();
						}
						c = ObjectUtils.compare(c1, c2, nullGreater);
						if (c != 0) {
							return c;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return c;
			}
		});
	}

	public static void desc(List<?> list, final String... attributes) throws Exception {
		desc(list, false, attributes);
	}

	public static void desc(List<?> list, final boolean nullGreater, final String... attributes) throws Exception {
		Collections.sort(list, new Comparator<Object>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public int compare(Object o1, Object o2) {
				int c = 0;
				try {
					for (String attribute : attributes) {
						Object p1 = PropertyUtils.getProperty(o1, attribute);
						Object p2 = PropertyUtils.getProperty(o2, attribute);
						Comparable c1 = null;
						Comparable c2 = null;
						if (null != p1) {
							c1 = (p1 instanceof Comparable) ? (Comparable) p1 : p1.toString();
						}
						if (null != p2) {
							c2 = (p2 instanceof Comparable) ? (Comparable) p2 : p2.toString();
						}
						c = ObjectUtils.compare(c2, c1, nullGreater);
						if (c != 0) {
							return c;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return c;
			}
		});
	}

	public static void order(List<?> list, final String attribute, List<?> orders) throws Exception {
		order(list, false, attribute, orders);
	}

	public static void order(List<?> list, final boolean nullGreater, final String attribute, List<?> orders)
			throws Exception {
		Collections.sort(list, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				int c = 0;
				try {
					Object p1 = PropertyUtils.getProperty(o1, attribute);
					Object p2 = PropertyUtils.getProperty(o2, attribute);
					int c1 = orders.indexOf(p1);
					int c2 = orders.indexOf(p2);
					c = ObjectUtils.compare(c1, c2, nullGreater);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return c;
			}
		});
	}
}