<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="cn.com.bestpay.posp.system.dao.${entityForm.className}Dao" >

  <resultMap id="BaseResultMap" type="cn.com.bestpay.posp.system.entity.${entityForm.className}" >
	  <#list entityForm.properties as p>
	    <result column="${p.columnName}" property="${p.property}" jdbcType="${p.jdbcType}" />
	  </#list>
  </resultMap>
  
  <sql id="Base_Column_List" >
	${entityForm.sqlColumns}
  </sql>
  
  <select id="findById" parameterType="java.lang.Long"  resultMap="BaseResultMap" >
  	  select 
  	  	<include refid="Base_Column_List"/>
  	  from ${entityForm.tableName} where ${entityForm.sqlPKName} = ${'#'}{id}
  </select>
  
  <select id="findUnique" parameterType="cn.com.bestpay.posp.system.entity.${entityForm.className}" resultType="cn.com.bestpay.posp.system.entity.${entityForm.className}">
  		select 
  			<include refid="Base_Column_List"/>
  		from ${entityForm.tableName}
  		where 1=1 
  		
	  <#list entityForm.properties as p>
  		<if test="${p.property} != null">
  			and ${p.columnName} = ${'#{'+p.property+'}'}
  		</if>
	  </#list>
  		 
  </select>
  
  <select id="find" parameterType="cn.com.bestpay.posp.system.entity.${entityForm.className}" resultMap="BaseResultMap">
  		select 
  			<include refid="Base_Column_List"/>
  		from ${entityForm.tableName}
  		where 1=1 
	  <#list entityForm.properties as p>
  		<if test="${p.property} != null">
  			and ${p.columnName} = ${'#{'+p.property+'}'}
  		</if>
	  </#list>
  </select>
  
  <select id="findAll" parameterType="cn.com.bestpay.posp.system.entity.${entityForm.className}" resultMap="BaseResultMap">
  		select 
  			<include refid="Base_Column_List"/>
  		from ${entityForm.tableName}
  </select>
  
  <select id="countBy" parameterType="cn.com.bestpay.posp.system.entity.${entityForm.className}" resultType="java.lang.Integer">
  		select 
  			count(*)
  		from ${entityForm.tableName}
  		where 1=1 
	  <#list entityForm.properties as p>
  		<if test="${p.property} != null">
  			and ${p.columnName} = ${'#{'+p.property+'}'}
  		</if>
	  </#list>
  </select>
  
  <insert id="insert" parameterType="cn.com.bestpay.posp.system.entity.${entityForm.className}">
     <selectKey keyProperty="${entityForm.primaryKey}" resultType="java.lang.Long" order="BEFORE" >
     	select SQ_${entityForm.sqlPKName}.nextval from dual
     </selectKey>
	 INSERT INTO ${entityForm.tableName}
	   (${entityForm.sqlColumns})
     VALUES (
	  <#list entityForm.properties as p>
	    ${'#'}{${p.property},jdbcType=${p.jdbcType}}<#if (p_index+1 != entityForm.properties?size) >,</#if>
	  </#list>
     ) 
  </insert>
  
  <update id="update" parameterType="cn.com.bestpay.posp.system.entity.${entityForm.className}">
	UPDATE ${entityForm.tableName} SET
	  <#list entityForm.properties as p>
	  	${p.columnName} = ${'#'}{${p.property},jdbcType=${p.jdbcType}}<#if (p_index+1 != entityForm.properties?size) >,</#if>
	  </#list>
		WHERE ${entityForm.sqlPKName} = ${'#'}{${entityForm.primaryKey}, jdbcType=DECIMAL}
  </update>
  <!-- 增加新的接口请在下方编写  -->
   
</mapper>