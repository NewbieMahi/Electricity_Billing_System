import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
class ViewAllbill extends JFrame implements ActionListener{
	JFrame f;
	ResultSet rs;//,mm,nn;
	Connection conn;
	Statement stmt;//,kk,ll;
	JTable jtb;
	JScrollPane jsp;
	Vector heading,rowdata,row;
	JButton b;
	
	ViewAllbill()
	{
		try
		{
		f=new JFrame("display All bills");
		b= new JButton("Okay");
		b.addActionListener(this);
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/login","root","Mahesh@2001");
		stmt=conn.createStatement();
		
		rs=stmt.executeQuery("select * from bill");
		//mm = kk.executeQuery("select COUNT(mnumber) from bill");
		//nn =ll.executeQuery("select SUM(amount) from bill");
		
		heading = new Vector();
	    heading.add("Meter Number");
		heading.add("Total Bill");
		heading.add("Date");
		
		rowdata= new Vector();
		while(rs.next())
		{
			row= new Vector();
			row.add(rs.getString(1));
			row.add(rs.getString(2));
			row.add(rs.getString(3));
			rowdata.add(row);
		}
		/*row = new Vector();
		if(mm.next())
		  row.add("Total Meter Numbers are " + mm.getString(1));
	    if(nn.next())
		 row.add("Total Amount of all users is "+ nn.getString(1));
		row.add("NA");
		rowdata.add(row);*/
		jtb= new JTable(rowdata,heading);
		jsp=new JScrollPane(jtb);
		f.add(jsp);
		f.setVisible(true);
		f.add(b,BorderLayout.SOUTH);
		f.setSize(700,500);
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
		new ViewAllbill();
	}			
		
}