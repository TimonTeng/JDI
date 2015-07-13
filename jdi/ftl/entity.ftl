package cn.com.bestpay.posp.system.entity;

import java.util.Date;

public class ${entityForm.className} {

  <#list entityForm.properties as p>
    ${p.propertyName}
  </#list>
   
  <#list entityForm.methods as method>
  	${method.methodHead}{
  		${method.methodBody}
  	}
  </#list>
 
}
