import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.time.*;
class Print extends JFrame implements ActionListener{
	JFrame p;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,ask,ldate,lans;
	JTextField t1;
	JPanel p1,p2,p3;
	JButton search,ok;
	Print(){
		p=new JFrame("Print Bill");
		ask = new JLabel("Enter Meter Number");
		t1 = new JTextField(20);
		search =new JButton("View");
		p2 =new JPanel();
		p1 =new JPanel();
		p3 =new JPanel();
		p3.setLayout(new FlowLayout());
		p2.add(ask);
		p2.add(t1);
		p2.add(search);
		search.addActionListener(this);
		p2.setLayout(new FlowLayout());
		l1 = new JLabel("Meter Number :");
		l7 = new JLabel("");
		l2 = new JLabel("Name :");
		l8 = new JLabel("");
		l3 = new JLabel("Address :");
		l9 = new JLabel("");
		l4 = new JLabel("Mobile Number :");
		l10 = new JLabel("");
		l5 = new JLabel("Email :");
		l11 = new JLabel("");
		ldate = new JLabel("Date :");
		lans = new JLabel("");
		l6 = new JLabel("Total Amount :");
		l12 = new JLabel("");
		ok = new JButton("Ok");
		p1.add(l1);p1.add(l7);
		p1.add(l2);p1.add(l8);
		p1.add(l3);p1.add(l9);
		p1.add(l4);p1.add(l10);
		p1.add(l5);p1.add(l11);
		p1.add(ldate);p1.add(lans);
		p1.add(l6);p1.add(l12);
		p3.add(ok);
		ok.addActionListener(this);
		p1.setLayout(new GridLayout(8,2));

		p.add(p2,BorderLayout.NORTH);
		p.add(p1,BorderLayout.CENTER);
        p.add(p3,BorderLayout.SOUTH);
		p3.setVisible(false);
		p1.setVisible(false);
		p.setVisible(true);
		//p.setLayout(new FlowLayout());
		p.setSize(550,300);
		
	}
	public void actionPerformed(ActionEvent ae)
	{	
	   if(ae.getSource()==ok)
	   {
		   p.dispose();
	   }
	   if(ae.getSource()==search){

		Statement stmt=null,stmt2=null;
		Connection conn=null;
		ResultSet rs=null,rr=null;
		String ans = t1.getText();
		try
		{
			
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/login","root","Mahesh@2001");
		stmt=conn.createStatement();
		stmt2 = conn.createStatement();
		rs = stmt.executeQuery("select * from addcust where Meternumber ='"+ans+"'");
		if(rs.next())
		{
		   l7.setText(rs.getString(1));
		   l8.setText(rs.getString(2));
		   l9.setText(rs.getString(3));
		   l10.setText(rs.getString(4));
		   l11.setText(rs.getString(5));
		   p1.setVisible(true);
		   
		}	
		else{
			JOptionPane.showMessageDialog(this,"Please Enter Correct Meter Number");
		}
		rr = stmt2.executeQuery("select * from bill where mnumber ='"+ans+"'");
		if(rr.next()){
			
			lans.setText(java.time.LocalDate.now().toString());
			l12.setText(rr.getString(2));
			p3.setVisible(true);
		}
		else{
			JOptionPane.showMessageDialog(this,"***Please Enter Correct Meter Number***");
		}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Please check You Enter Correct Data");
			System.out.println(e);
		}
		}
	 }
	

		
	public static void main(String args[])
	{
		new Print();
	}
}
		
		
		
		