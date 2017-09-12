import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Xo implements ActionListener
{
	JFrame f;
	JLabel luser,turn,shape;
	JPanel pcenter,peast;
	JButton b[]=new JButton[9];
	JTable t;
	int u1,u2;
	String lu1,lu2;
	public Xo(int x,int y,String x1,String y1)
	{
		u1=x;
		u2=y;
		lu1=x1;
		lu2=y1;
		f=new JFrame();
		pcenter=new JPanel();
		peast=new JPanel();
		for(int i=0;i<9;i++)
		{
			b[i]=new JButton();
		}
		f.setLayout(new BorderLayout());
		f.setSize(500,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(f.HIDE_ON_CLOSE);
		f.setResizable(false);
		for(int i=0;i<9;i++)
		{
			pcenter.add(b[i]);
		}
		pcenter.setLayout(new GridLayout(3,3));
		f.add(pcenter,BorderLayout.CENTER);
		luser=new JLabel(lu1+" : X        "+lu2+" : O");
		f.add(luser,BorderLayout.NORTH);
		String arr1[]={"",""};
		String arr[][]={{lu1,lu2},{Integer.toString(x),Integer.toString(y)}};
		t=new JTable(arr,arr1);
		turn=new JLabel("Turm of "+lu1);
		shape=new JLabel("             X");
		peast.setLayout(new GridLayout(3,1));
		peast.add(t);
		peast.add(turn);
		peast.add(shape);
		f.add(peast,BorderLayout.EAST);
		for(int i=0;i<9;i++)
		{
			b[i].addActionListener(this);
		}
	}
	int count=1,draw=0,dialogButton=0;
	char bb1,bb2,bb3,bb4,bb5,bb6,bb7,bb8,bb9;
	public void actionPerformed(ActionEvent ae)
	{
		count%=2;
		String s;
		if(count==1)
		{
			s="X";
			turn.setText("Turm of "+lu2);
			shape.setText("             O");
		}
		else
		{
			s="O";
			turn.setText("Turm of "+lu1);
			shape.setText("             X");
		}
		if(ae.getSource()==b[0])
		{
			b[0].setText(s);
			bb1=s.charAt(0);
			b[0].setEnabled(false);
		}
		else if(ae.getSource()==b[1])
		{
			b[1].setText(s);
			bb2=s.charAt(0);
			b[1].setEnabled(false);
		}
		else if(ae.getSource()==b[2])
		{
			b[2].setText(s);
			bb3=s.charAt(0);
			b[2].setEnabled(false);
		}
		else if(ae.getSource()==b[3])
		{
			b[3].setText(s);
			bb4=s.charAt(0);
			b[3].setEnabled(false);
		}
		else if(ae.getSource()==b[4])
		{
			b[4].setText(s);
			bb5=s.charAt(0);
			b[4].setEnabled(false);
		}
		else if(ae.getSource()==b[5])
		{
			b[5].setText(s);
			bb6=s.charAt(0);
			b[5].setEnabled(false);
		}
		else if(ae.getSource()==b[6])
		{
			b[6].setText(s);
			bb7=s.charAt(0);
			b[6].setEnabled(false);
		}
		else if(ae.getSource()==b[7])
		{
			b[7].setText(s);
			bb8=s.charAt(0);
			b[7].setEnabled(false);
		}
		else if(ae.getSource()==b[8])
		{
			b[8].setText(s);
			bb9=s.charAt(0);
			b[8].setEnabled(false);
		}
		draw++;
		count++;
		if(bb1=='X' && bb2=='X' && bb3=='X' || bb3=='X' && bb6=='X'&& bb9=='X' || bb1=='X' && bb4=='X' && bb7=='X' || bb7=='X' && bb8=='X' && bb9=='X' || bb1=='X' && bb5=='X' && bb9=='X' || bb3=='X' && bb5=='X' && bb7=='X' || bb2=='X' && bb5=='X' && bb8=='X' || bb4=='X' && bb5=='X' && bb6=='X')
		{
			draw=10;
			dialogButton=JOptionPane.showConfirmDialog (f,lu1+" won this Match.\n Do You Want to Continue Playing?","Result",JOptionPane.YES_NO_OPTION);
			u1++;
			decision();
		}
		if(bb1=='O' && bb2=='O' && bb3=='O' || bb3=='O' && bb6=='O' && bb9=='O' || bb1=='O' && bb4=='O' && bb7=='O' || bb7=='O' && bb8=='O' && bb9=='O' || bb1=='O' && bb5=='O' && bb9=='O' || bb3=='O' && bb5=='O' && bb7=='O' || bb2=='O' && bb5=='O' && bb8=='O' || bb4=='O' && bb5=='O' && bb6=='O')
		{
			draw=10;
			dialogButton=JOptionPane.showConfirmDialog (f,lu2+" won this Match.\n Do You Want to Continue Playing?","Result",JOptionPane.YES_NO_OPTION);
			u2++;
			decision();
		}
		if(draw==9)
		{
			dialogButton=JOptionPane.showConfirmDialog (f,"No One Won the Match.\n Do You Want to Continue Playing?","Result",JOptionPane.YES_NO_OPTION);
			decision();
		}
	}
	public void decision()
	{
		for(int i=0;i<9;i++)
		{
			b[i].setEnabled(false);
		}
		if(dialogButton == JOptionPane.YES_OPTION) 
		{
            new Xo(u1,u2,lu1,lu2);
			f.dispose();
		}
        if(dialogButton == JOptionPane.NO_OPTION)
		{
			new Score(u1,u2,lu1,lu2);
			f.dispose();
        }
	}
}