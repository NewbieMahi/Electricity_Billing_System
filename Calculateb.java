import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

class Calculateb extends JFrame implements ActionListener{
	JFrame a;
	JLabel l1,l2,hide;
	JTextField t1;
	JPanel p1,p2,p3;
	JButton cal;
	int ans;
	Calculateb(){
		 a = new JFrame("Calculate Bill");
		 p1 =new JPanel();
		 p2 = new JPanel();
		 p3 =new JPanel();
		 l1 = new JLabel("Calculate Bill");
		 p1.add(l1);
		 
		 p1.setLayout(new FlowLayout());
		 a.add(p1,BorderLayout.NORTH);
		 cal =new JButton("Calculate");
		 cal.addActionListener(this);
		  p3.add(cal);
		 p3.setLayout(new FlowLayout());
		
		
		
		
		 l2 = new JLabel("Enter Total units");
		 t1 =  new JTextField(20);
		 p2.add(l2);
		 p2.add(t1);
		 p2.add(p3);
		 p2.setLayout(new FlowLayout());
		 a.add(p2,BorderLayout.CENTER);
		
		// hide.setVisible(false);
		 a.setVisible(true);
		 a.setSize(440,400);
         
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==cal){
			ans = Integer.parseInt(t1.getText());
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
				res+=(50*8);
				ans-=50;
			}
			else
			{
				if(ans!=0){
				res+=(ans*8);
				ans=0;
				}
			}
			if(ans>0)
			{
				res+=(ans*11);
			}
		    //p2.add(hide,BorderLayout.SOUTH);
		
		   JOptionPane.showMessageDialog(this,"Total Amount is : " + res);
		//System.out.println(ans);
			//hide.setVisible(true);
		}
	}
	public static void main(String args[]){
		new Calculateb();
	}
}