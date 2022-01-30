import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class SignIn extends JFrame implements ActionListener{
	
	JFrame s;
	JLabel l1,l2,l3;
	JTextField t1,t3;
	JPasswordField t2;
	JPanel p1,p2,p3;
	JButton forgot,login,reset;
	SignIn(){
		s = new JFrame("Login Here");
		
		p1 = new JPanel();
		p2 =new JPanel();
		p3 = new JPanel();
		
		l1 =new JLabel("Login Here");
		p1.add(l1);
		p1.setLayout(new FlowLayout());
		s.add(p1,BorderLayout.NORTH);
		l2 = new JLabel("Enter userName:");
		t1 = new JTextField(20);
		l3 = new JLabel("Enter Password :");
		t2 = new JPasswordField(20);
		p2.add(l2);p2.add(t1);
		p2.add(l3);p2.add(t2);
		p2.setLayout(new GridLayout(2,2));
		s.add(p2,BorderLayout.CENTER);
		forgot = new JButton("Forgot Password");
		forgot.addActionListener(this);
		login = new JButton("Login");
		login.addActionListener(this);
		reset = new JButton("Reset Password");
		//reset.addActionListener(this);
		reset.setVisible(false);
		p3.add(login);p3.add(forgot);p3.add(reset);
		p3.setLayout(new FlowLayout());
		s.add(p3,BorderLayout.SOUTH);
		s.setVisible(true);
		s.setSize(530,200);
		s.setLayout(new FlowLayout());
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
    public void actionPerformed(ActionEvent ae)
	{	
	    String sql;
	    int ch;
		String mn,nn,aa,mmnn,ee;
		Statement stmt=null,stmt2=null;
		Connection conn=null;
		ResultSet rs=null,rs1=null;
		if(ae.getSource()==login)
		{
		try
		{
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/Login","root","Mahesh@2001");
		String uname = t1.getText();
		String upass = t2.getText();
	 //	int ans = 1;
	
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select * from signin where Name='"+uname+"' and Password='"+upass+"'");
		if(rs.next())
		{
		   new Main();
		   s.dispose();
		}	
		else{
			JOptionPane.showMessageDialog(this,"Please Enter Correct Data");
		}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Fail to Login");
			System.out.println(e);
		}
		}
		if(ae.getSource()==forgot)
		{
			String sec = JOptionPane.showInputDialog(this,"Enter Security Key");
			try
		   {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/Login","root","Mahesh@2001");
		stmt2=conn.createStatement();
		rs1 = stmt2.executeQuery("select * from signin where securekey='"+sec+"'");
		if(rs1.next())
		{
		   JOptionPane.showMessageDialog(this,"Your Password is : "+rs1.getString(2));
		}	
		else{
			JOptionPane.showMessageDialog(this,"you forgot ur password ! then how can I remember ur Password");
		}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Can not find ur password");
			System.out.println(e);
		}
			
		}
		
	}
	public static void main(String args[]){
		new SignIn();
	}
}