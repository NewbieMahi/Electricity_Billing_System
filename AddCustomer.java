import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
class AddCustomer extends JFrame implements ActionListener
{
	JFrame f;
	JTextField tname,taddress,tmno,tage,tmeterno,tcity,temail;
	JButton bsubmit,bcancel;
	JPanel p1,p2;
	JLabel lname,laddress,lmno,lage,lmeterno,lcity,lemail;
	AddCustomer()
	{
		f=new JFrame("Customer Detail");
		tname = new JTextField(10);
		taddress = new JTextField(10);
		tmno = new JTextField(10);
		tage = new JTextField(20);
		tmeterno = new JTextField(20);
		tcity = new JTextField(20);
		temail= new JTextField(20);
		bsubmit=new JButton("submit");
		bcancel=new JButton("cancel");
		p1=new JPanel();
		p2=new JPanel();
		lname=new JLabel("customer Name:");
		laddress=new JLabel("Address:");
		lmno=new JLabel("Mobile Number:");
		lage=new JLabel("Age:");
		lmeterno=new JLabel("Meter Number:");
		lcity=new JLabel("City:");
		lemail=new JLabel("Email:");
		p1.setLayout(new GridLayout(7,7,2,2));
		p1.add(lname);  			 p1.add(tname);
		p1.add(laddress);		 p1.add(taddress);
		p1.add(lmno);			p1.add(tmno);
		p1.add(lage);			p1.add(tage);
		p1.add(lmeterno);		p1.add(tmeterno);
		p1.add(lcity);			p1.add(tcity);
		p1.add(lemail);			p1.add(temail);
		p2.add(bsubmit);
		bsubmit.addActionListener(this);
		p2.add(bcancel);
		bcancel.addActionListener(this);
		f.add(p1,BorderLayout.CENTER);
		f.add(p2,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,300);
		f.setResizable(false);
		f.setLocation(400,200);
	}
	
	public void actionPerformed(ActionEvent ae)
	{	String name,address,email,city,mno,meterno,age;
		if(ae.getSource()==bsubmit)
		{
			name=tname.getText();
			address=taddress.getText();
			email=temail.getText();
			city=tcity.getText();
			mno=tmno.getText();
			meterno=tmeterno.getText();
			age=tage.getText();
			Connection conn=null;
			Statement stmt=null;
			ResultSet rs=null;
			String sql;
			int ch;
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/electricity","root","Mahesh@2001");
			stmt=conn.createStatement();
			sql="insert into Customer values('"+name+"','"+address+"','"+mno+"','"+age+"','"+meterno+"','"+city+"','"+email+"');";
			ch =stmt.executeUpdate(sql);
			if(ch==1)
			{
				JOptionPane.showMessageDialog(
            this, "Record Added Successfully");
			//bsubmit.setEnabled(true);
			}
			
			
			}
			
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(
            this, "Record added  failure");
				System.out.println(e);
				
			}
		}
		if(ae.getSource()==bcancel)
		{
			f.dispose();
		}
	}
	public static void main(String args[])
	{
		new AddCustomer();
	}
}
		
		
		
	