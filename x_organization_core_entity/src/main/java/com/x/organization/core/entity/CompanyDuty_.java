/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.organization.core.entity;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.String;
import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.organization.core.entity.CompanyDuty.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Fri Dec 02 16:18:53 CST 2016")
public class CompanyDuty_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<CompanyDuty,String> company;
    public static volatile SingularAttribute<CompanyDuty,Date> createTime;
    public static volatile SingularAttribute<CompanyDuty,String> id;
    public static volatile ListAttribute<CompanyDuty,String> identityList;
    public static volatile SingularAttribute<CompanyDuty,String> name;
    public static volatile SingularAttribute<CompanyDuty,String> pinyin;
    public static volatile SingularAttribute<CompanyDuty,String> pinyinInitial;
    public static volatile SingularAttribute<CompanyDuty,String> sequence;
    public static volatile SingularAttribute<CompanyDuty,String> unique;
    public static volatile SingularAttribute<CompanyDuty,Date> updateTime;
}
