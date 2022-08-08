package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class CheckConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try
      {
    	  Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con=null;
          con=DriverManager.getConnection("jdbc:mysql://localhost/dbfirst", "root", "root");
          System.out.println("Database connection granted");
          Statement stmt=con.createStatement();
         /* String sql= "create table EMP " +
                      "(eid integer not null, " +
        		        "firstname varchar(255)," +
                        "lastname varchar(255)," +
        		        "age integer, " +
                        "primary key (eid))";
          stmt.executeUpdate(sql);
          System.out.println("table created in dbfirst database");*/
         // stmt.executeUpdate("INSERT INTO EMP " + "VALUES (1, 'yenugudhati', 'Tanuja', 23)");
          //System.out.println("one record inserted into emp table");
         // String sql="insert into EMP values(2,'yenu','vanu',23)";
         // stmt.executeUpdate(sql);
          //System.out.println("second record inserted into emp table");
         // String sql = "UPDATE EMP " +
             //     "SET age = 30 WHERE eid = 1";
          //stmt.executeUpdate(sql);
          //System.out.println("updation successfull");

         // String e="insert into EMP values(3,'abd','orange',25)";
         // stmt.executeUpdate(e);
         //System.out.println("insert successfull");
       // String f = "delete from emp where eid=3";
       // stmt.executeUpdate(f);
        //System.out.println("delete successfull");
          ResultSet rs=stmt.executeQuery("select *from emp");
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
