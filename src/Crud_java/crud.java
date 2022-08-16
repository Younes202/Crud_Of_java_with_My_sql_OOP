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
    public static void update(crud personne,String Name_updated)
    {
    	 try {
     		Class.forName("com.mysql.cj.jdbc.Driver"); 
     		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Personne","root","");
     		PreparedStatement st = con.prepareStatement("update  personne set Name= ? , LastName=? , Phone = ? , Age =?  where Name = ?");
     		st.setString(1,personne.Name);
     		st.setString(2,personne.LastName);
     		st.setString(3,personne.Phone);
     		st.setInt(4,personne.Age);
     		st.setString(5,Name_updated);
     		st.executeUpdate();
     		System.out.println("Updating  successfully ");
        }catch(Exception e){
     	   System.out.println(e);
        }
     }
    public static void Delete(String Name)
    {
    	try {
     		Class.forName("com.mysql.cj.jdbc.Driver"); 
     		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Personne","root","");
     		PreparedStatement st = con.prepareStatement("delete from personne where Name=?");
     		st.setString(1, Name);
     		st.executeUpdate();
     		System.out.println("Delete  successfully ");
        }catch(Exception e){
     	   System.out.println(e);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Scanner input = new Scanner(System.in);
   	 	int i;

	    do {
	    	System.out.println("**********  Hello in this mini programme ***********************");
	    	System.out.println("**********  Insert a personne in database  : (1) ***************");
	    	System.out.println("**********  Display all personne in database  : (2) *************");
	    	System.out.println("**********  Update  one personne in database  : (3) *************");
	    	System.out.println("**********  delete  one personne in database  : (4) *************");
	    	System.out.println("**********  delete  one personne in database  : (0) *************");
		    i = input.nextInt();
	    	switch(i)
	    	{
	    	case 0 : 
	    		   System.out.println("**********  Quite of programme  ***************");
	    		   break;
	    	case 1: 
	    			System.out.println("  Write The Name  ");
					String PersonneName = input.nextLine();
					
					System.out.println("Write the LastName ");
					String PersonneLastName = input.nextLine();
					
					System.out.println("Write The Phone ");
					String PersonnePhone = input.nextLine();
					
					System.out.println("Write The Age ");
					int PersonneAge = input.nextInt();
					
					crud Personne = new crud(PersonneName,PersonneLastName,PersonnePhone,PersonneAge);
					insert(Personne);
	    	break;
	    	case 2:
	    			Display(); 
	    	break;
	    	case 3:
	    			Display(); 
	    		   System.out.println("**********  Write The Name who you would update ***************");
	    	       String in = input.nextLine();
	    	   	   String PersonnName = input.nextLine();
				   System.out.println("Write the LastName ");
				   String PersonnLastName = input.nextLine();
				   System.out.println("Write The Phone ");
				   String PersonnPhone = input.nextLine();
				   System.out.println("Write The Age ");
				   int PersonnAge = input.nextInt();   	
				   crud Personn = new crud(PersonnName,PersonnLastName,PersonnPhone,PersonnAge);
				   update(Personn,in);
	        break;
	    	case 4 :
    				Display(); 
	    		    System.out.println("**********  Write The Name who you would delete ***************");
	    		    String de = input.nextLine();
	    		    Delete(de);
	    	break;
	    	}
	    }while(i!=0);
		
	}

}
