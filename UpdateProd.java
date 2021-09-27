import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateProd extends JFrame implements ActionListener
{
	Connection cn;
	Statement st;
	ResultSet rs;
	JLabel l1,l2,l4,l5;
	JButton b2,b3,b4;
	JTextField t1,t3,t4;
	String u,sql1,rp1;
	JPanel p;
 
	UpdateProd()
	{
		pack();
		try
		{
			Class.forName("org.postgresql.Driver");
			cn = DriverManager.getConnection("jdbc:postgresql:project","postgres","");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		//design

		setSize(600,600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("   UPDATE PRODUCT COST   ");
		setLocation(50,50);

		Font F1 = new Font("arial",Font.BOLD,15);
		Font F2 = new Font("serif",Font.BOLD,20);

		//panel

                p = new JPanel();
                p.setLayout(null);
                p.setBounds(0,0,600,600);
                add(p);
                p.setBackground(Color.cyan);

		//label1 for title

		l1 = new JLabel("  UPDATE PRODUCT COST ",JLabel.CENTER);
		l1.setBounds(20,20,500,100);
		p.add(l1);
		l1.setForeground(Color.ORANGE);
		l1.setFont(new Font("calibri",Font.BOLD,30));

		//label2 

		l2 = new JLabel("PRODUCT NO",JLabel.CENTER);
		l2.setBounds(20,120,200,40);
		p.add(l2);
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("arial",Font.BOLD,15));
		
		//textfield1

		t1 = new JTextField(20);
		t1.setBounds(250,120,200,40);
		p.add(t1);

		//label4

		l4 = new JLabel("NEW COST",JLabel.CENTER);
		l4.setBounds(20,200,200,40);
		l4.setFont(F1);
		p.add(l4);

		//text field3

		t3 = new JTextField(20);
		t3.setBounds(250,200,200,40);
		p.add(t3);

		//label5

		l5 = new JLabel("CONFIRM COST",JLabel.CENTER);
		l5.setBounds(20,280,200,40);
		l5.setFont(F1);
		p.add(l5);

		//textfield4

		t4 = new JTextField(20);
		t4.setBounds(250,280,200,40);
		p.add(t4);

		// button 2 

		b2 = new JButton("Submit");
		b2.setBounds(50,380,200,60);
		p.add(b2);
		b2.setFont(F2);
		b2.addActionListener(this);

		//button 3

		b3 = new JButton("Reset");
		b3.setBounds(350,380,200,60);
		p.add(b3);
		b3.setFont(F2);
		b3.addActionListener(this);
	}


	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			b4 = (JButton)ae.getSource();
			if(b4==b2)
			{
				st = cn.createStatement();
				String sql = "select * from product where pno = '"+t1.getText()+"';";
				rs = st.executeQuery(sql);
				while(rs.next())
				{
					if(t3.getText().equals(t4.getText()))
					{
						sql1 = "update product set cost = '"+t3.getText()+"' where pno = '"+t1.getText()+"';"; 
						JOptionPane.showMessageDialog(null," MOBILE NUMBER IS SUCCESSFULLY UPDATED","Update Mobile Number",JOptionPane.INFORMATION_MESSAGE);
						st.executeQuery(sql1);
					}
					else
						JOptionPane.showMessageDialog(null,"NEW MOBILE NO AND CONFIRM MOBILENUMBER DOES NOT MATCH ","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}	
			else if(b4==b3)
			{
				t1.setText("");
				t3.setText("");
				t4.setText("");
			}
		}
		catch(Exception e){}
	}

	public static void main(String a[])
	{
		new UpdateProd();
	}
}


