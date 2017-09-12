import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class UsernameSet implements ActionListener
{
	JFrame f3;
	JLabel luser1,luser2,head;
	JButton b,b1; 
	JTextField tuser1,tuser2;
	public UsernameSet()
	{
		f3=new JFrame();
		f3.setSize(500,300);
		f3.setVisible(true);
		f3.setResizable(false);
		f3.setLayout(null);
		f3.setDefaultCloseOperation(f3.HIDE_ON_CLOSE);
		b=new JButton("CONTINUE");
		b1=new JButton("EXIT");
		head=new JLabel("Enter the Choices");
		luser1=new JLabel("Enter username 1: ");
		luser2=new JLabel("Enter username 2: ");
		tuser1=new JTextField();
		tuser2=new JTextField();
		head.setBounds(10,50,110,40);
		luser1.setBounds(10,100,110,20);
		luser2.setBounds(10,140,110,20);
		tuser1.setBounds(120,100,110,20);
		tuser2.setBounds(120,140,110,20);
		b.setBounds(180,200,110,30);
		b1.setBounds(310,240,100,20);
		f3.add(head);
		f3.add(luser1);
		f3.add(tuser1);
		f3.add(luser2);
		f3.add(tuser2);
		f3.add(b);
		f3.add(b1);
		b.addActionListener(this);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b)
		{
			new Xo(0,0,tuser1.getText(),tuser2.getText());
			f3.dispose();
		}
		else
		{
			System.exit(0);
		}
	}
}