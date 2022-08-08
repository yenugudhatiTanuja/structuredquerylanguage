package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class EnterMultRowCollection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
      List<Student> li=new ArrayList<>();
      li.add(new Student(4,"hari","b.Tech","hyderabad"));
      li.add(new Student(5,"harish","b.Tech","hyderabad"));
      li.add(new Student(6,"haritha","b.Tech","hyderabad"));
      String sql="insert into Student(sid,sname,sdegree,scity) values(?,?,?,?)";
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con=null;
      con=DriverManager.getConnection("jdbc:mysql://localhost/dbfirst", "root", "root");
      System.out.println("Database connection granted");
      PreparedStatement prestmt=con.prepareStatement(sql);
      con.setAutoCommit(false);
      for (Iterator < Student > iterator = li.iterator(); iterator.hasNext();) 
      {
    	  Student s=(Student) iterator.next();
    	  prestmt.setInt(1, s.getSid());
   	      prestmt.setString(2,s.getSname());
   	      prestmt.setString(3,s.getSdegree());
   	      prestmt.setString(4,s.getScity());
   	      prestmt.addBatch();
      }
      
	   int[] updateCounts = prestmt.executeBatch();
       System.out.println(Arrays.toString(updateCounts));
       con.commit();
       con.setAutoCommit(true);
	   prestmt.close();


	 

	}

}
