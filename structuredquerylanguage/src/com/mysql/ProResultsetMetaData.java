package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ProResultsetMetaData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=null;
        con=DriverManager.getConnection("jdbc:mysql://localhost/dbfirst", "root", "root");
        System.out.println("Database connection granted");
        Statement stmt=con.createStatement();
        //String sql= "select eid, firstname, lastname, age from emp where lastname like 't%'";
        String sql= "select *from learner";
        ResultSet rs=stmt.executeQuery(sql);
        ResultSetMetaData rsmd=rs.getMetaData();
        System.out.println("Total columns"+rsmd.getColumnCount());
        System.out.println("column name of 1st column"+rsmd.getColumnName(1));
        System.out.println("column TYpe Name of 1st column:"+rsmd.getColumnTypeName(1));
        //rsmd.

       /* while(rs.next())
        {
      	  System.out.println("EID:"+rs.getInt("eid"));
      	  System.out.println("Age:"+rs.getInt("age"));
      	  System.out.println("First name:"+rs.getString("firstname"));
      	  System.out.println("Lastname:"+rs.getString("lastname"));


        }*/
      con.close();
        
	}

}
