import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

	
class Main extends JFrame implements ActionListener{
	JFrame j;
	JMenuBar me;
	JMenu m1,m2,m3,m4,m5;
	JMenuItem seerates,print,i1,i2,i3,i4,logout,addbill,paybill,viewallbills,calculatebill,viewbill,addnewAdmin,viewadmin;
	JLabel background;
	Main(){
		j = new JFrame("Electricity Billing System");
		me = new JMenuBar();
		j.setBackground(Color.BLACK);
		m1 = new JMenu("Customer");
		m2 = new JMenu("Department");
		m3 = new JMenu("Bills");
		m4 = new JMenu("Rates");
		m5 = new JMenu("Logout");
		m1.setForeground(Color.WHITE);
		m2.setForeground(Color.WHITE);
		m3.setForeground(Color.WHITE);
		m4.setForeground(Color.WHITE);
		m5.setForeground(Color.WHITE);
		me.add(m1);
		me.add(m2);
		me.add(m3);
		me.add(m4);
		me.add(m5);
		i1 = new JMenuItem("Add Customer");
		i2 = new JMenuItem("Update Customer");
		i4 = new JMenuItem("View all customers");
		i3 = new JMenuItem("Delete Customer");
		
		
		
		
		logout = new JMenuItem("Logout");
		seerates =new JMenuItem("See Rates");
		addbill = new JMenuItem("Add Bill");
		viewallbills = new JMenuItem("View All Bills");
		viewbill = new JMenuItem("View Bill");
		print = new JMenuItem("Print Bill");
		viewallbills.addActionListener(this);
		viewbill.addActionListener(this);
		print.addActionListener(this);
		paybill = new JMenuItem("Pay Bill");
		paybill.addActionListener(this);
		calculatebill = new JMenuItem("Calculate Bill");
		addnewAdmin = new JMenuItem("Add new Admin");
		viewadmin = new JMenuItem("view Admin");
		m1.add(i1);
		m1.add(i2);
		m1.add(i4);
		m1.add(i3);
		m2.add(addnewAdmin);
		m2.add(viewadmin);
		m3.add(addbill);
		m3.add(viewbill);
		m3.add(viewallbills);
		m3.add(calculatebill);
		m3.add(paybill);
		m3.add(print);
		m4.add(seerates);
		m5.add(logout);
		logout.addActionListener(this);
		j.setJMenuBar(me);
		me.setBackground(Color.BLACK);
		seerates.addActionListener(this);
		//j.setBackground(Color.Pink);
		/* m1.setFont(new Font("",Font.BOLD,15));
		 m1.setForeground(Color.BLACK);
		 m2.setFont(new Font("",Font.BOLD,15));
		 m2.setForeground(Color.BLACK);
		 m3.setFont(new Font("",Font.BOLD,15));
		 m3.setForeground(Color.BLACK);
		 m4.setFont(new Font("",Font.BOLD,15));
		 m4.setForeground(Color.BLACK);
		 m5.setFont(new Font("",Font.BOLD,15));
		 m5.setForeground(Color.BLACK);*/
		//j.pack();*/
		
		// adding image
		background=new JLabel(new ImageIcon("electric2.jpg"));
		background.setBounds(0,0,800,500);
	    j.add(background);
	    background.setLayout(new FlowLayout());
		
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		addbill.addActionListener(this);
		addnewAdmin.addActionListener(this);
		viewadmin.addActionListener(this);
		calculatebill.addActionListener(this);
		j.setVisible(true);
		j.setSize(825,570);
		j.setLayout(new FlowLayout(FlowLayout.LEFT));
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		j.getContentPane().setBackground(Color.GRAY);
        //j.pack();
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==i1){
			new Add();
		}
	    else if(ae.getSource()==i2){
			new Update();
		}
		else if(ae.getSource()==i3)
		{
			new Delete();
		}
		else if(ae.getSource()==i4)
		{
			new View();
		}
		else if(ae.getSource()==logout)
		{
			new SignIn();
			j.dispose();
		}
		
		else if(ae.getSource()==viewadmin){
			new ViewAdmin();
		}
		else if(ae.getSource()==addnewAdmin)
		{
			new AddAdmin();
		}
		else if(ae.getSource()== addbill){
			new AdBill();
		}
		
		else if(ae.getSource() == calculatebill)
		{
			new Calculateb();
		}
		else if(ae.getSource()==seerates)
		{
			new Rates();
		}
		else if(ae.getSource()==viewallbills){
			new ViewAllbill();
		}
		else if(ae.getSource()==viewbill)
		{
			new ViewSingle();
		}
		else if(ae.getSource()==print)
		{
			new Print();
		}
		else if(ae.getSource()==paybill)
		{
			new Pay();
		}
		
		
		
	}
	public static void main(String args[])
	{
		new Main();
	
	}
}