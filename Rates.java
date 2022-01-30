import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
// 
class Rates extends JFrame implements ActionListener{
	JFrame r;
	JLabel hu,hc,a,b,c,d,e,f,g,h;
	JPanel p1,p2;
	JButton but;
	Rates(){
		r =new JFrame("View All Rates ");
	
		p1 = new JPanel();
		p2 =new JPanel();
		hu = new JLabel("Units");
		hc = new JLabel("Costs Per Unit");
		hu.setFont(new Font("Elephant",Font.BOLD,15));
		hc.setFont(new Font("Elephant",Font.BOLD,15));
		but =new JButton("Ok");
		but.addActionListener(this);
		p2.add(but);
		a = new JLabel("0-50");
		b = new JLabel("6 Rupayee per Unit");
		c = new JLabel("51-100");
		d = new JLabel("7 Rupayee per Unit");
		e = new JLabel("101-150");
		f = new JLabel("9 Rupayee per Unit");
		g = new JLabel("150 and above");
		h = new JLabel("11 Rupayee per Unit");
		p1.add(hu);p1.add(hc);
		p1.add(a);p1.add(b);
		a.setForeground(Color.BLACK);
		b.setForeground(Color.BLACK);
		p1.add(c);p1.add(d);
		c.setForeground(Color.BLACK);
		d.setForeground(Color.BLACK);
		p1.add(e);p1.add(f);
		e.setForeground(Color.BLACK);
		f.setForeground(Color.BLACK);
		p1.add(g);p1.add(h);
		g.setForeground(Color.BLACK);
		h.setForeground(Color.BLACK);
		p1.setLayout(new GridLayout(5,2));
		p2.setLayout(new FlowLayout());
		r.add(p1,BorderLayout.CENTER);
		r.add(p2,BorderLayout.SOUTH);
		r.setVisible(true);
		r.setSize(600,190);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==but){
			r.dispose();
		}
	}
	public static void main(String args[]){
		new Rates();
	}
}