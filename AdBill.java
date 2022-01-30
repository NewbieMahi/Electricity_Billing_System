import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class AdBill extends JFrame implements ActionListener{
	
	JFrame a;
	JLabel l1,l2,l3,head;
	JTextField t1,t2,t3;
	JPanel p1,p2,p3;
	JButton add,canc;
	AdBill()
	{
		a = new JFrame("Add Bill");
		p1 =new JPanel();
		p2 =new JPanel();
		p3 =new JPanel();
		head = new JLabel("Add Bill");
		p3.add(head);
		p3.setLayout(new FlowLayout());
		a.add(p3,BorderLayout.NORTH);
		l1 = new JLabel("Enter Meter Number");
		l2 = new JLabel("Enter Total units");
		l3 = new JLabel("Enter a Date (yy-mm-dd)");
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 =new JTextField(20);
		p1.add(l1);p1.add(t1);
		p1.add(l2);p1.add(t2);
		p1.add(l3);p1.add(t3);
		p1.setLayout(new GridLayout(3,2));
		a.add(p1,BorderLayout.CENTER);
		add = new JButton("Add Bill");
		canc = new JButton("Cancel");
		p2.add(add);
		p2.add(canc);
		p2.setLayout(new FlowLayout());
		a.add(p2,BorderLayout.SOUTH);
		
		add.addActionListener(this);
		canc.addActionListener(this);
		
		a.setVisible(true);
		a.setSize(600,200);
	}
	public void actionPerformed(ActionEvent ae)
	{	String sql;
	    int ch,ans;
	   
		Statement stmt=null;
		Connection conn=null;
		ResultSet rs=null;
		if(ae.getSource()==add)
		{
			String mnum = t1.getText();
			String date = t3.getText();
				ans = Integer.parseInt(t2.getText());
		    int res=0;
		     //hide = new JLabel("Total Amount is : " + ans*9);
			if(ans>=50)
			{
				res+=(50*6);
				ans-=50;
			}
			else
			{
				res+=(ans*6);
				ans=0;
			}
			if(ans>=50)
			{
				res+=(50*7);
				ans-=50;
			}
			else
			{
				if(ans!=0){
				 res+=(ans*7);
				 ans=0;
				}
			}
			if(ans>=50)
			{
				res+=(50*9);
				ans-=50;
			}
			else
			{
				if(ans!=0){
				res+=(ans*9);
				ans=0;
				}
			}
			if(ans>0)
			{
				res+=(ans*11);
			}
		try
		{
			
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/login","root","Mahesh@2001");
		
		stmt=conn.createStatement();
		sql="insert into bill values('"+mnum+"','"+res+"','"+date+"');";
		ch=stmt.executeUpdate(sql);
		if(ch==1)
		{
		JOptionPane.showMessageDialog(this,"data added Successfully");
		t3.setText("");
		t2.setText("");
		
		}	
		else{
			JOptionPane.showMessageDialog(this,"Sorry ! data added Failure");
		}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Sorry !! check you enter correct Information");
			System.out.println(e);
		}
		}
		if(ae.getSource()==canc)
		{
			a.dispose();
		}
	}

		
	public static void main(String args[])
	{
		new AdBill();
	}
}
		
		
		
		