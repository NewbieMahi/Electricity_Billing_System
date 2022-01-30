import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Delete extends JFrame implements ActionListener{
	JFrame delFrame;
	JTextField input1,input2;
	JButton delbut;
	JLabel delleb,delleb2;
	Delete(){
		delFrame = new JFrame("Delete Customer");
		delleb = new JLabel("Enter Meter Id to delete a customer");
		input1 = new JTextField(20);
		delleb2 = new JLabel("Re-Enter Meter Id");
		input2 = new JTextField(20);
		delbut = new JButton("Delete");
		delFrame.add(delleb);
		delFrame.add(input1);
		delFrame.add(delleb2);
		delFrame.add(input2);
		delbut.addActionListener(this);
		delFrame.add(delbut);
		delFrame.setLayout(new FlowLayout());
		delFrame.setVisible(true);
		delFrame.setSize(300,200);
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{	
	    String sql;
	    int ch;
		String m_no,m_no2;
		Statement stmt=null;
		Connection conn=null;
		ResultSet rs=null;
		if(ae.getSource()==delbut)
		{
		try
		{
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/Login","root","Mahesh@2001");
		m_no=input1.getText();
		m_no2=input2.getText();
       
		stmt=conn.createStatement();
		//if(ans==1){
		sql="delete from addcust WHERE Meternumber='"+m_no+"';";
		ch=stmt.executeUpdate(sql);
		if(ch==1)
		{
		JOptionPane.showMessageDialog(this,"Users Deleted");
		}
		else{
			JOptionPane.showMessageDialog(this,"Wrong Meter-ID");
		}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Error");
			System.out.println(e);
		}
		}
	}

	public static void main(){
		new Delete();
	}
}