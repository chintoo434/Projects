package com.chintoo;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.*;

public class Addservlet extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		
		String sub=req.getParameter("sub");
		
		
		if(sub.equals("Submit"))
	{
			String f_n=req.getParameter("fn");
			String l_n=req.getParameter("ln");
			String d_ob=req.getParameter("dob");
			String e_i=req.getParameter("ei");
			String m_n=req.getParameter("mn");
			
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ashish", "root", "chintook");
			
			
			//inserting data into Database
			PreparedStatement pst = con.prepareStatement("insert into Mlogin(Fname, Lname, BOD, Email, Mnumber) values(?,?,?,?,?)");					
			pst.setString(1, f_n);
			pst.setString(2, l_n);
			pst.setString(3,d_ob);
			pst.setString(4, e_i);
			pst.setString(5, m_n);
			
			int i = pst.executeUpdate();
            if(i!=0){
           	 System.out.println("added Successfully\n");
            }
            else{
           	 System.out.println("failed to add");
            }
            
            
            //print Database on console
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Mlogin");
            while(rs.next())
            {
           	 System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
            }
            
            ResultSet rs1 = stmt.executeQuery("select * from Mlogin");
            PrintWriter out = res.getWriter();
            while(rs1.next())
            {
            	
            	out.print(rs1.getString(1)+"\t\t");
            	out.print(rs1.getString(2)+"\t\t");
            	out.print(rs1.getString(3)+"\t\t");
            	out.print(rs1.getString(4)+"\t\t");
            	out.println(rs1.getString(5)+"\t\t");
            }
            
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
		else
		{
			
			res.sendRedirect("add");
		}
		
		
		
	}
}
