import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class AddAdmin extends JFrame implements ActionListener{
	JFrame a;
	JLabel l1,l2,l3,l4,head;
	JPasswordField m2;
	JTextField m1,m3;
	JPanel p1,p2,p3;
	JButton ad,can;
	  AddAdmin(){
		  a = new JFrame("Add Admin");
		  p3 =new JPanel();
		  head = new JLabel("Add New Admin");
		  p3.add(head);
		  
		  p3.setLayout(new FlowLayout());
		  a.add(p3,BorderLayout.NORTH);
		  l1 = new JLabel("Enter Name");
		  l2 = new JLabel("Enter Password");
		  l3 = new JLabel("Enter Security Key");
		  m1 = new JTextField(20);
		  m2 = new JPasswordField(20);
		  m3 = new JTextField(20);
		  ad = new JButton("Add");
		  can = new JButton("Cancel");
		  p1= new JPanel();
		  p2 = new JPanel();
		  p1.add(l1);
		  p1.add(m1);
		  p1.add(l2);
		  p1.add(m2);
		  p1.add(l3);
		  p1.add(m3);
		  p1.setLayout(new GridLayout(3,2));
		  p2.add(ad);
		  p2.add(can);
		  p2.setLayout(new FlowLayout());
		  ad.addActionListener(this);
		  can.addActionListener(this);
		  a.add(p1,BorderLayout.CENTER);
		  a.add(p2,BorderLayout.SOUTH);
		  a.setSize(540,180);
		  a.setVisible(true);
		  //a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
	  }
	
	public void actionPerformed(ActionEvent ae)
	{
		String sql;
	    int ch;
		String name,pass,secure;
		Statement stmt=null;
		Connection conn=null;
		ResultSet rs=null;
		if(ae.getSource()==ad)
		{
		try
		{
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/Login","root","Mahesh@2001");
		name=m1.getText();
		pass=m2.getText();
		secure=m3.getText();
	
		stmt=conn.createStatement();
		sql="insert into signin values('"+name+"','"+pass+"','"+secure+"');";
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
		if(ae.getSource()==can)
		{
			a.dispose();
		}
	  }
		
	public static void main(String args[]){
		new AddAdmin();
	}
}