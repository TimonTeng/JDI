package cn.teng.jdi.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component("MetaDataSource")
public class MetaDataSource {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) { 
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public void tableColumn() throws SQLException{
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		DatabaseMetaData meta = jdbcTemplate.getDataSource().getConnection().getMetaData();
		String catalog = conn.getCatalog();
		System.out.println(catalog);
		
		ResultSet result = meta.getColumns(catalog, catalog, "platform_user", null);
		
		while(result.next()){
			
		}
		
		System.out.println(JSONObject.fromObject(result).toString());
		
	}
	
	
	 

}
