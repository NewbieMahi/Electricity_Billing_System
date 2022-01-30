import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Add extends JFrame implements ActionListener{
	JFrame fr1;
	JLabel mno,name,addr,mono,email,heading;
	JTextField mno1,name1,addr1,mono1,email1;
	JPanel p0,p1,p2;
	JButton addd,cancel;
	Add(){
		fr1 = new JFrame("Add Customer");
		//ll = new JLabel("Add Customer");
		//fr1.add(ll);
		p0 = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		
		// adding heading 
		heading = new JLabel("ADD CUSTOMER",JLabel.CENTER);
	    p0.add(heading);
		p0.setLayout(new FlowLayout());
		
		// creating Labels
		mno = new JLabel("Meter Number",JLabel.CENTER);
		name = new JLabel("Name",JLabel.CENTER);
		addr = new JLabel("Address",JLabel.CENTER);
		mono = new JLabel("Mobile Number",JLabel.CENTER);
		email = new JLabel("E-mail",JLabel.CENTER);

        // createing text fields **
		mno1 = new JTextField();
		name1 = new JTextField();
		addr1 = new JTextField();
		mono1 = new JTextField();
		email1 = new JTextField();
		p1.setLayout(new GridLayout(5,2));
		// adding lables to frame
		
		p1.add(mno);
		p1.add(mno1);
		p1.add(name);
		p1.add(name1);
		p1.add(addr);
		p1.add(addr1);
		p1.add(mono);
		p1.add(mono1);
		p1.add(email);
		p1.add(email1);
		
		// adding p1
		
		
		fr1.setLayout(new BorderLayout());
		fr1.add(p0,BorderLayout.NORTH);
		fr1.add(p1,BorderLayout.CENTER);
		// adding text fields to frame
		
		// adding buttons panel -2
		addd = new JButton("ADD");
		cancel = new JButton("Cancel");
		// panel -2
		
		p2.add(addd);
		p2.add(cancel);
		p2.setLayout(new FlowLayout());
		fr1.add(p2,BorderLayout.SOUTH);
		addd.addActionListener(this);
		cancel.addActionListener(this);
		fr1.setVisible(true);
		//fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr1.setSize(700,270);
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{	
	    String sql;
	    int ch;
		String mn,nn,aa,mmnn,ee;
		Statement stmt=null;
		Connection conn=null;
		ResultSet rs=null;
		if(ae.getSource()==addd)
		{
		try
		{
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/Login","root","Mahesh@2001");
		mn=mno1.getText();
		nn=name1.getText();
		aa=addr1.getText();
		mmnn=mono1.getText();
		ee = email1.getText();
	 //	int ans = 1;
	
		stmt=conn.createStatement();
		sql="insert into addcust values('"+mn+"','"+nn+"','"+aa+"','"+mmnn+"','"+ee+"');";
		ch=stmt.executeUpdate(sql);
		if(ch==1)
		{
		JOptionPane.showMessageDialog(this,"data added Successfully");
		}	
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Fail to add data");
			System.out.println(e);
		}
		}
		if(ae.getSource()==cancel)
		{
			fr1.dispose();
		}
	}
	public static void main(String args[])
	{
		
		new Add();
	}
}

