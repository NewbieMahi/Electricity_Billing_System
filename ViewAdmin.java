import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
class ViewAdmin extends JFrame implements ActionListener{
	JFrame f;
	ResultSet rs;
	Connection conn;
	Statement stmt;
	JTable jtb;
	JScrollPane jsp;
	Vector heading,rowdata,row;
	JButton b;
	
	ViewAdmin()
	{
		try
		{
		f=new JFrame("display Customer");
		b= new JButton("Okay");
		b.addActionListener(this);
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/login","root","Mahesh@2001");
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select * from signin");
		heading = new Vector();
	    heading.add("Name");
		heading.add("Password");
		
		rowdata= new Vector();
		while(rs.next())
		{
			row= new Vector();
			row.add(rs.getString(1));
			row.add(rs.getString(2));
			
			rowdata.add(row);
		}
		jtb= new JTable(rowdata,heading);
		jsp=new JScrollPane(jtb);
		f.add(jsp);
		f.setVisible(true);
		f.add(b,BorderLayout.SOUTH);
		f.setSize(1200,500);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	f.pack();
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	public void actionPerformed(ActionEvent ae)
	{
		f.dispose();
	}
	

	public static void main(String args[])
	{
		new ViewAdmin();
	}			
		
}