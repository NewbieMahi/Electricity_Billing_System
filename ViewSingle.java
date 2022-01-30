import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
class ViewSingle extends JFrame implements ActionListener{
	JFrame v;
	JLabel l1,l2,l3;
	JTextField t1;
	JButton view;
	JPanel p1,p2;
	ViewSingle()
	{
		v = new JFrame("View Bill of Single Customer");
		p1 =new JPanel();
		p2 =new JPanel();
		l1 = new JLabel("Enter meter Number");
		t1 = new JTextField(20);
		view = new JButton("View Bill");
		view.addActionListener(this);
		//p1.add(l1);p1.add(t1);
		//p1.setLayout(new FlowLayout());
		//v.add(p1,BorderLayout.CENTER);
		//v.add(p1);
		//v.add(view);
		//p2.add(view);
		//view.setSize(30,20);
		
		//p2.setLayout(new GridLayout());
		//v.add(p2,BorderLayout.SOUTH);
		
		//v.add(p2);
		v.add(l1);v.add(t1);
		v.add(view);
		v.setLayout(new FlowLayout());
		v.setVisible(true);
		v.setSize(400,300);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==view)
		{
	    int ch;
		String ans = t1.getText();
		Statement stmt=null;
		Connection conn=null;
		ResultSet rs=null;
		
		try
		{
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/Login","root","Mahesh@2001");
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select * from bill where mnumber='"+ans+"'");
		if(rs.next())
		{
		JOptionPane.showMessageDialog(this,"Total amount to pay is :"+rs.getString(2));
		}
		else{
			JOptionPane.showMessageDialog(this,"Please Enter Correct Meter Number ");
		}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"No Result Found");
			System.out.println(e);
		}
		}
		
	}
	
	public static void main(String args[])
	{
		new ViewSingle();
	}			
		
}