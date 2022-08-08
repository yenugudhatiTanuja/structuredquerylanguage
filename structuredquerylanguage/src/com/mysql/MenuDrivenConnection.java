package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//import com.maven.mysql.jdbc.mavenmysqljdbc.Student;

public class MenuDrivenConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=null;
        con=DriverManager.getConnection("jdbc:mysql://localhost/dbfirst", "root", "root");
        System.out.println("Database connection granted");
		int sid;
		String sname;
		String sdegree;
		String scity;
       while(true)
       {
    	   System.out.println("1.add multiple row of  details");
    	   System.out.println("2.display details");
    	   System.out.println("3.update details");
    	   System.out.println("4.remove details");
    	   System.out.println("5.Exit");
		   List<Student> li=new ArrayList<>();

    	   System.out.println("Enter your choice::");
    	   Scanner s=new Scanner(System.in);
    	   int choice =s.nextInt();
    	   switch(choice)
    	   {
    	   case 1:
    		   //List<Student> li=new ArrayList<>();
    		      li.add(new Student(4,"hari","b.Tech","hyderabad"));
    		      li.add(new Student(5,"harish","b.Tech","hyderabad"));
    		      li.add(new Student(6,"haritha","b.Tech","hyderabad"));
    		      String sql="insert into Student(sid,sname,sdegree,scity) values(?,?,?,?)";
    		      PreparedStatement prestmt=con.prepareStatement(sql);
    		      con.setAutoCommit(false);
    		      for (Iterator < Student > iterator = li.iterator(); iterator.hasNext();) 
    		      {
    		    	  Student s1=(Student) iterator.next();
    		    	  prestmt.setInt(1, s1.getSid());
    		   	      prestmt.setString(2,s1.getSname());
    		   	      prestmt.setString(3,s1.getSdegree());
    		   	      prestmt.setString(4,s1.getScity());
    		   	      prestmt.addBatch();
    		      }
    		      
    			   int[] updateCounts = prestmt.executeBatch();
    		       System.out.println(Arrays.toString(updateCounts));
    		       con.commit();
    		       con.setAutoCommit(true);
    			   prestmt.close();
    			   System.out.println("successfully added multiple rows");
                   break;
    	   case 2:
            PreparedStatement prestmt1=con.prepareStatement("select * from student");

   			ResultSet rs = prestmt1.executeQuery();
   			//ArrayList<Student> alist = new ArrayList<Student>();
   			while(rs.next())
   			{
   				Student l = new Student();
   				l.setSid(rs.getInt("Sid"));
   				l.setSname(rs.getString("Sname"));
   				l.setSdegree(rs.getString("Sdegree"));
   				l.setScity(rs.getString("Scity"));
   				li.add(l);
   			}
   			for(Student lt : li)
   			{
   				System.out.println("sid : "+lt.getSid());
   				System.out.println("sname : "+lt.getSname());
   				System.out.println("degree: "+lt.getSdegree());
   				System.out.println("city: "+lt.getScity());

   			}
   			break;
    	   case 3:
    		   /*String sqlUpdate="update student"
    		   		+ " set scity= case sid"
    		   		+ " when 1 then 'maharastra' "
    		   		+ " when 4 then 'punjab' "
    		   		+ "end "
    		   		+ "where sid between 1 and 4";*/
    		   String sqlUpdate="update student"
       		   		+ " set scity= case sid"
       		   		+ " when ? then ? "
       		   		+ " when ? then ? "
       		   		+ "end "
       		   		+ "where sid between ? and ?";
 		      PreparedStatement ps=con.prepareStatement(sqlUpdate);
 		     Scanner s2=new Scanner(System.in);
     	   	System.out.println("Enter id1");
     	   	int id1=s2.nextInt(); 
     	   	System.out.println("Enter updatecity");
     	   	String sname1=s2.next(); 
     	   System.out.println("Enter id2");
    	   	int id2=s2.nextInt(); 
    	   	System.out.println("Enter updatecity");
    	   	String sname2=s2.next();
     	   	//ps.setString(1, name);
    	    System.out.println("Enter bet");
    	   	int b1=s2.nextInt(); 
    	   	System.out.println("Enter bet");
    	   	int b2=s2.nextInt(); 
    	   	ps.setInt(1, id1);
     	   	ps.setString(2, sname1);
     	   ps.setInt(3, id1);
    	   	ps.setString(4, sname1);
    	   	ps.setInt(5, b1);
    	   	ps.setInt(6, b2);

     	   //	int i= prestmt2.executeUpdate();
 		      ps.executeUpdate();
 		      System.out.println("Record updated");
 		      break;

    	   case 5:
    		   System.exit(0);
    	   }
		}
	}

}
