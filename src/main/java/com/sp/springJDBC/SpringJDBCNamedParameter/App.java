package com.sp.springJDBC.SpringJDBCNamedParameter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.sp.beans.Account;
import com.sp.resource.JavaConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	MapSqlParameterSource params=new MapSqlParameterSource();
//    	params.addValue("key_accoutno", 9002);
//    	params.addValue("key_firstname", "Ashhh choudhary");
//    	params.addValue("key_lasttname", "Sharan");
//    	params.addValue("key_balaace",1001);
//    
    	Account act=new Account();
		act.setAccountnum(1);
		act.setFirstname("cRASH");
		act.setLastname("erererer");
		act.setBalance(1000);
    	
    	BeanPropertySqlParameterSource pactarams= new BeanPropertySqlParameterSource(act);
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        
        NamedParameterJdbcTemplate jtmp=context.getBean(NamedParameterJdbcTemplate.class);
        
        String query="Insert into account values(:accountnum,:firstname,:lastname,:balance)";
        int count=jtmp.update(query, pactarams);
        if(count>0)
        {
        	System.out.println("Data inserted successfully");
        }
        else {
        	System.out.println("Data  inserted  Failed");
        }
        
        
        
    }
}
