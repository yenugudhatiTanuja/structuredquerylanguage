package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProCaLi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try
	      {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection con=null;
	          con=DriverManager.getConnection("jdbc:mysql://localhost/dbfirst", "root", "root");
	          System.out.println("Database connection granted");
	          Statement stmt=con.createStatement();
	          //String sql= "select eid, firstname, lastname, age from emp where lastname like 't%'";
	          String sql= "select *from emp order by lastname desc";
	          ResultSet rs=stmt.executeQuery(sql);
	          while(rs.next())
	          {
	        	  System.out.println("EID:"+rs.getInt("eid"));
	        	  System.out.println("Age:"+rs.getInt("age"));
	        	  System.out.println("First name:"+rs.getString("firstname"));
	        	  System.out.println("Lastname:"+rs.getString("lastname"));


	          }
	        con.close();
	          
	      }
	      catch(Exception e)
	      {
	    	  System.out.println("connection is not connected :Error"+e);
	      }
	
	}

}
