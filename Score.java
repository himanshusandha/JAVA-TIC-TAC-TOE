import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Score implements ActionListener
{
	JFrame f2;
	JLabel l;
	JButton b,b1; 
	public Score(int x,int y,String x1,String y1)
	{
		f2=new JFrame();
		if(x>y)
		{
			l=new JLabel(x1+" is the Winner");
		}
		else if(y>x)
		{
			l=new JLabel(y1+" is the Winner");
		}
		else
		{
			l=new JLabel("Match was Draw");
		}
		f2.setSize(500,300);
		f2.setVisible(true);
		f2.setResizable(false);
		f2.setLayout(null);
		f2.setDefaultCloseOperation(f2.HIDE_ON_CLOSE);
		b=new JButton("PLAY AGAIN");
		b1=new JButton("EXIT");
		l.setBounds(200,150,200,50);
		b.setBounds(220,200,110,30);
		b1.setBounds(350,250,150,20);
		f2.add(l);
		f2.add(b);
		f2.add(b1);
		b.addActionListener(this);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b)
		{
			new Start();
			f2.dispose();
		}
		else
		{
			System.exit(0);
		}
	}
}