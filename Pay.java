import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class Pay extends JFrame implements ActionListener{
	
	JFrame a;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3;
	JPanel p1,p2,p3;
	JButton see,close,py;
	Pay()
	{
		
		a =new JFrame("Pay Bill");
		p1 = new JPanel();
		p2 =new JPanel();
		p3 =new JPanel();
		l1 = new JLabel("Pay Bill");
		p1.add(l1);
		p1.setLayout(new FlowLayout());
		
		l2 = new JLabel("Enter Meter Number");
		t1 = new JTextField(20);
		l3 = new JLabel("Total amount to be pay is :");
		l4 = new JLabel("");
		l5 = new JLabel("Pay amount :");
		t2 = new JTextField(20);
		p2.add(l2);p2.add(t1);
		p2.add(l3);p2.add(l4);
		p2.add(l5);p2.add(t2);
		l3.setVisible(false);l4.setVisible(false);
		l5.setVisible(false);t2.setVisible(false);
		p2.setLayout(new GridLayout(3,2));
		see  = new JButton("View Amount");
		close = new JButton("Cancel");
		py = new JButton("Pay");
		py.addActionListener(this);
		p3.add(see);
		p3.add(close);
		p3.add(py);
		p3.setLayout(new FlowLayout());
		
		see.addActionListener(this);
		close.addActionListener(this);
		a.add(p1,BorderLayout.NORTH);
		a.add(p2,BorderLayout.CENTER);
		a.add(p3,BorderLayout.SOUTH);
		
		a.setVisible(true);
		a.setSize(490,400);
		a.setLayout(new FlowLayout());
	}
	public void actionPerformed(ActionEvent ae)
	{	
	  
	  
	  if(ae.getSource()==see){
		
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
			l3.setVisible(true);l4.setVisible(true);
			l5.setVisible(true);t2.setVisible(true);
		   l4.setText(rs.getString(2));
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
	   if(ae.getSource()==py){
		
		int ch;
		String ans = t1.getText();
		//String ans = t2.getText();
		Statement stmt=null,stmt2=null;
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
			int up = Integer.parseInt(rs.getString(2));
		    int val = Integer.parseInt(t2.getText());
		    int fin = up-val;
		    if(fin<0)
			  fin=0;
		    //String res = fin;
		   // JOptionPane.showMessageDialog(this,"Total remain  "+fin);
		   try{
		    String query1 = "update bill set Amount='"+fin+"' " + "where Mnumber='"+ans+"'";
			stmt.executeUpdate(query1);
			
		   	JOptionPane.showMessageDialog(this,"Thank You For Paying Bill !\n Your Remaining Amount is :"+fin+" Rupayee");
			t2.setText("");
			l4.setText(""+fin);
		   }
		  catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"No Result Found");
			System.out.println(e);
		}
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
	  if(ae.getSource()==close)
	  {
		  a.dispose();
	  }
	}

		
	public static void main(String args[])
	{
		new Pay();
	}
}
		
		
		
		