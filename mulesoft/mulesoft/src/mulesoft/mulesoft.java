package mulesoft;
import java.sql.*;
import java.util.Scanner;
public class mulesoft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	    try {
	      Class.forName("org.sqlite.JDBC");
	      Connection con=DriverManager.getConnection("jdbc:sqlite:movies.db");
	      if(con!=null)
	      {
	        System.out.println("Connected\n");
	      }
	      Statement stmt=con.createStatement();
	      //int n=stmt.executeUpdate("create table movie(pmovie text primary key,pactor text,pactress text,pyor int,pdirector text)");
	      //System.out.println("Table created");
	      //PreparedStatement pstmt=con.prepareStatement("insert into movie values(?,?,?,?,?)");
	      //System.out.println("Enter Movie name");
	      //String pmovie=sc.next();
	      //System.out.println("Enter actor name");
	      //String pactor=sc.next();
	      //System.out.println("Enter actress name");
	      //String pactress=sc.next();
	      //System.out.println("Enter Year name");
	      //int pyor=sc.nextInt();
	      //System.out.println("Enter Director name");
	      //String pdirector=sc.next();
	      //pstmt.setString(1,pmovie);
	      //pstmt.setString(2,pactor);
	      //pstmt.setString(3,pactress);
	      //pstmt.setInt(4,pyor);
	      //pstmt.setString(5,pdirector);
	      //int n=pstmt.executeUpdate();
	      //System.out.println(n);
	      System.out.println("-------Display all the contents of table-----------\n");
	      PreparedStatement pstmt1=con.prepareStatement("select * from movie");
	      ResultSet rs=pstmt1.executeQuery();
	      System.out.println("movie\tactor\tactress\tyor\tdirector");
	      System.out.println("----------------------------------------------------------------------------------------------------------------");
	      while(rs.next())
	      {
	        System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5));
	      }
	      System.out.println("\n\n\n----------Display the movies of an actor-----------\n");
	      PreparedStatement pstmt2=con.prepareStatement("select * from movie where pactor='ram'");
	      ResultSet rs1=pstmt2.executeQuery();
	      System.out.println("movie\tactor\tactress\tyor\tdirector");
	      System.out.println("----------------------------------------------------------------------------------------------------------------");
	      while(rs1.next())
	      {
	        System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getInt(4)+"\t"+rs1.getString(5));
	      }
	    }
	    catch(Exception e)
	    {
	      System.out.println(e);
	    }

	}

}
