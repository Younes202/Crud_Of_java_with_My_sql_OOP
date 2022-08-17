package Crud_java;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.Scanner;


import java.sql.DriverManager;


public class crud {

    String Name;
    String LastName;
    String Phone;
    int Age;
    
    public crud(String Name,String LastName,String Phone,int personneAge) {
    	
    	this.Name=Name;
    	this.LastName=LastName;
    	this.Phone=Phone;
    	this.Age=personneAge;   	
    }
  
    public static void Display()
    {
    	try 
    	{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Personne","root","");
    		Statement st = con.createStatement();
    		ResultSet rs = st.executeQuery("select *from Personne");
           while(rs.next())
           {
        	  System.out.println("Name     : "+rs.getString(2));
        	  System.out.println("LastNmae : "+ rs.getString(3));
        	  System.out.println("Phone    : "+ rs.getString(4));
        	  System.out.println("Age      : "+rs.getInt(5));
              System.out.println("--------------------------");         
           }
          
    	}catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
    public static void insert(crud personne) {
       try {
    		Class.forName("com.mysql.cj.jdbc.Driver"); 
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Personne","root","");
    		PreparedStatement st = con.prepareStatement("insert into personne values("+null+",?,?,?,?)");
    		st.setString(1,personne.Name);
    		st.setString(2,personne.LastName);
    		st.setString(3,personne.Phone);
    		st.setInt(4,personne.Age);
    		st.executeUpdate();
    		System.out.println("Adding Of data Effected");
       }catch(Exception e){
    	   System.out.println(e);
       }
    }
	   public static void delete(String name_del) {
        try {
     		Class.forName("com.mysql.cj.jdbc.Driver"); 
     		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Personne","root","");
     		PreparedStatement st = con.prepareStatement("delete from personne where Name = ?");
     		st.setString(1,name_del);
     		st.executeUpdate();
     		System.out.println("deleting Of data Effected");
        }catch(Exception e){
     	   System.out.println(e);
        }
     }
    public static void update(crud new_data,String name_up) {
        try {
     		Class.forName("com.mysql.cj.jdbc.Driver"); 
     		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Personne","root","");
     		PreparedStatement st = con.prepareStatement("updtae personne set Name =? , LastName =? , Phone=?,Age=?  where Name = name_up");
     		st.setString(1,new_data.Name);
     		st.setString(2,new_data.LastName);
     		st.setString(3,new_data.Phone);
     		st.setInt(4,new_data.Age);
     		st.setString(1,name_up);
     		st.executeUpdate();
     		System.out.println("updating of  Of data Effected");
        }catch(Exception e){
     	   System.out.println(e);
        }
     }
   
		
	}


