/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.processplatform.core.entity.element;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.Boolean;
import java.lang.String;
import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.processplatform.core.entity.element.Agent.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Fri Dec 02 16:19:07 CST 2016")
public class Agent_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<Agent,String> afterArriveScript;
    public static volatile SingularAttribute<Agent,String> afterArriveScriptText;
    public static volatile SingularAttribute<Agent,String> afterExecuteScript;
    public static volatile SingularAttribute<Agent,String> afterExecuteScriptText;
    public static volatile SingularAttribute<Agent,String> afterInquireScript;
    public static volatile SingularAttribute<Agent,String> afterInquireScriptText;
    public static volatile SingularAttribute<Agent,String> alias;
    public static volatile SingularAttribute<Agent,Boolean> allowReroute;
    public static volatile SingularAttribute<Agent,Boolean> allowRerouteTo;
    public static volatile SingularAttribute<Agent,String> beforeArriveScript;
    public static volatile SingularAttribute<Agent,String> beforeArriveScriptText;
    public static volatile SingularAttribute<Agent,String> beforeExecuteScript;
    public static volatile SingularAttribute<Agent,String> beforeExecuteScriptText;
    public static volatile SingularAttribute<Agent,String> beforeInquireScript;
    public static volatile SingularAttribute<Agent,String> beforeInquireScriptText;
    public static volatile SingularAttribute<Agent,Date> createTime;
    public static volatile SingularAttribute<Agent,String> description;
    public static volatile SingularAttribute<Agent,String> extension;
    public static volatile SingularAttribute<Agent,String> form;
    public static volatile SingularAttribute<Agent,String> id;
    public static volatile SingularAttribute<Agent,String> name;
    public static volatile SingularAttribute<Agent,String> position;
    public static volatile SingularAttribute<Agent,String> process;
    public static volatile ListAttribute<Agent,String> readDepartmentList;
    public static volatile SingularAttribute<Agent,String> readDuty;
    public static volatile ListAttribute<Agent,String> readIdentityList;
    public static volatile SingularAttribute<Agent,String> readScript;
    public static volatile SingularAttribute<Agent,String> readScriptText;
    public static volatile ListAttribute<Agent,String> reviewDepartmentList;
    public static volatile ListAttribute<Agent,String> reviewIdentityList;
    public static volatile SingularAttribute<Agent,String> reviewScript;
    public static volatile SingularAttribute<Agent,String> reviewScriptText;
    public static volatile SingularAttribute<Agent,String> route;
    public static volatile SingularAttribute<Agent,String> script;
    public static volatile SingularAttribute<Agent,String> scriptText;
    public static volatile SingularAttribute<Agent,String> sequence;
    public static volatile SingularAttribute<Agent,Date> updateTime;
}
