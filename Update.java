import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.*;
class Update extends JFrame implements ActionListener{
	JFrame fr;
	JLabel ll2,first;
	JPanel p3,p4,p1,p5;
	JTextField meter_id;
	JButton search_but,cancel,update,close;
	JLabel mno,name,addr,mono,email,heading;
	JTextField mno1,name1,addr1,mono1,email1;
	String intmeter;
	Update(){
		fr = new JFrame("Update Customer");
		//ll2 =new JLabel("Update Customer");
		//fr.add(ll2);
		
		// taking first label for show msg to input meter ID;
		p3 = new JPanel();
		p4 =new JPanel();
		p1 = new JPanel();
		p5 = new JPanel();
		first = new JLabel("Enter Meter-ID",JLabel.LEFT);
		meter_id = new JTextField(20);
		search_but =new JButton("Search");
		cancel =new JButton("Cancel");
		search_but.addActionListener(this);
		cancel.addActionListener(this);
		p3.add(first);
		p3.add(meter_id);
		p4.add(search_but);
		p4.add(cancel);
		
		p3.setLayout(new FlowLayout());
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		fr.add(p3,BorderLayout.NORTH);
		fr.add(p4);
		
		
		// 
		
		
		// creating Labels
		mno = new JLabel("Meter Number",JLabel.CENTER);
		name = new JLabel("Name",JLabel.CENTER);
		addr = new JLabel("Address",JLabel.CENTER);
		mono = new JLabel("Mobile Number",JLabel.CENTER);
		email = new JLabel("E-mail",JLabel.CENTER);
        update = new JButton("Update");
		close = new JButton("Close");
        // createing text fields **
		close.addActionListener(this);
		name1 = new JTextField(20);
		addr1 = new JTextField(20);
		mono1 = new JTextField(20);
		email1 = new JTextField(20);
		p1.setLayout(new GridLayout(4,2));
		// adding lables to frame
		
		
		
		p1.add(name);
		p1.add(name1);
		p1.add(addr);
		p1.add(addr1);
		p1.add(mono);
		p1.add(mono1);
		p1.add(email);
		p1.add(email1);
		p5.add(update);
		p5.add(close);
		
		p1.setVisible(false);
		p5.setVisible(false);
		//
		//p5.setLayout(new FlowLayout());
		update.addActionListener(this);
		fr.setLayout(new BorderLayout());
		fr.add(p1,BorderLayout.CENTER);
		//fr.add(p5,BorderLayout.SOUTH);
		fr.add(p5);
		fr.setVisible(true);
		//fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLayout(new FlowLayout());
		fr.setSize(500,300);
		
	}
	public void actionPerformed(ActionEvent ae)
	{	
	    String sql;
	    int ch;
		String mn,nn,aa,mmnn,ee;
		Statement stmt=null;
		Connection conn=null;
		ResultSet rs=null;
		if(ae.getSource()==search_but)
		{
			
			//p5.setVisible(true);
		   intmeter = meter_id.getText();
		  
		try
		{
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/Login","root","Mahesh@2001");
		stmt=conn.createStatement();
		
		// inserting previous values in textfields
	//	String query = "Select * from addcust Where Meternumber='"+intmeter+"'";
		
		rs=stmt.executeQuery("select * from addcust where Meternumber='"+intmeter+"'");
		int i=0;
		if(rs.next()){
			p1.setVisible(true);
			p5.setVisible(true);
			name1.setText(rs.getString(2));
		    addr1.setText(rs.getString(3));
		 	mono1.setText(rs.getString(4));
			email1.setText(rs.getString(5));
		}
		else{
		JOptionPane.showMessageDialog(this,"Wrong Meter number ! Please Enter Correct Meter Number");
		}
	 	}
		/*
	
		sql="insert into addcust values('"+mn+"','"+nn+"','"+aa+"','"+mmnn+"','"+ee+"');";
		ch=stmt.executeUpdate(sql);
		if(ch==1)
		{
		JOptionPane.showMessageDialog(this,"data added Successfully");
		}	
			
		}*/
	
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Fail to add data");
			System.out.println(e);
		
		}
	}
	    if(ae.getSource()==update)
		{
			try
		  {
			
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   conn=DriverManager.getConnection("jdbc:mysql://localhost/Login","root","Mahesh@2001");
		   stmt=conn.createStatement();
			mn=meter_id.getText();
		    nn=name1.getText();
		    aa=addr1.getText();
		    mmnn=mono1.getText();
		    ee = email1.getText();
			String query1 = "update addcust set Name='"+nn+"' " + "where Meternumber='"+mn+"'";
			stmt.executeUpdate(query1);
			String query2 = "update addcust set address='"+aa+"' " + "where Meternumber='"+mn+"'";
			stmt.executeUpdate(query2);
			String query3 = "update addcust set Mobilenumber='"+mmnn+"' " + "where Meternumber='"+mn+"'";
			stmt.executeUpdate(query3);
			String query4 = "update addcust set email='"+ee+"' " + "where Meternumber='"+mn+"'";
			stmt.executeUpdate(query4);
			JOptionPane.showMessageDialog(this,"Successfully Updated");
		  }
		 catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Fail to Update data");
			System.out.println(e);
		
		}
		}
		if(ae.getSource()==cancel)
		{
			fr.dispose();
		}
		if(ae.getSource()==close)
		{
			fr.dispose();
		}
	}
	public static void main(String args[])
	{
		new Update();
	}
}
