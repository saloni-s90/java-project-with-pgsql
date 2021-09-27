import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener,ItemListener
{
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,b3,b4;
	JPanel p;
	JTextField t1;
	TextField t2;
	Connection cn;
	Statement st;
	ResultSet rs;
	JCheckBox c1;
	ImageIcon img;

	public Login()
	{

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
		pack();
		setSize(750,650);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("LOGIN");
		setLocation(20,20);

		//panel

		p = new JPanel();
		p.setLayout(null);
		p.setBounds(130,100,500,550);
		add(p);
		p.setBackground(Color.cyan);

		//image

		img = new ImageIcon("lg1.png"); 

		//label image

		l5 = new JLabel(img);
		l5.setBounds(60,90,350,90);
		p.add(l5);

		//label l1

		l1 = new JLabel("ELECTRONIC MANAGEMENT SYSTEM",JLabel.CENTER);
		l1.setBounds(20,10,800,70);
		add(l1);
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("calibri",Font.BOLD,31));

		//label l2

		l2 = new JLabel("LOGIN ACCOUNT",JLabel.CENTER);
		l2.setBounds(100,10,400,60);
		p.add(l2);
		l2.setForeground(Color.RED);
		l2.setFont(new Font("arial",Font.BOLD,28));

		//label l3

		l3 = new JLabel("USER NAME ",JLabel.CENTER);
		l3.setBounds(30,210,150,40);
		p.add(l3);
		l3.setFont(new Font("Georgia",Font.BOLD,20));

		//text field

		t1 = new JTextField();
		t1.setBounds(200,210,200,40);
		p.add(t1);
		t1.setToolTipText("only character are valid");

		//label

		l4 = new JLabel("PASSWORD",JLabel.CENTER);
		l4.setBounds(30,280,150,40);
		p.add(l4);
		l4.setFont(new Font("Georgia",Font.BOLD,20));

		//password field

		t2 = new TextField(20);
		t2.setEchoChar('*');
		t2.setBounds(200,280,200,40);
		p.add(t2);
		t2.setBackground(Color.white);

		//checkbox

		c1 = new JCheckBox("Forgot password");
		c1.setBounds(100,340,150,30);
		p.add(c1);
		c1.addItemListener(this);

		//button

		b1 = new JButton("LOGIN");
		b1.setBounds(60,410,160,60);
		b1.setFont(new Font("serif",Font.BOLD,25));
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		p.add(b1);

		b2=new JButton("CANCEL");
		b2.setBounds(240,410,160,60);
		b2.setFont(new Font("serif",Font.BOLD,25));
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		p.add(b2);             
	}

	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			b4 = (JButton)ae.getSource();
			if(b4==b1)
			{		
				st = cn.createStatement();
				String sql = "select * from Login where username='"+t1.getText()+"';";
				rs = st.executeQuery(sql);
				while(rs.next())
				{
					if((t1.getText().equals(rs.getString(1))) && (t2.getText().equals(rs.getString(2))))
					{
						JOptionPane.showMessageDialog(null,"LOGIN IS VALID");
						dispose();
						new MainPage();                                            
					}
					else
						JOptionPane.showMessageDialog(null,"LOGIN IS INVALID","ERROR",JOptionPane.ERROR_MESSAGE);
				}

				st.close();
				rs.close();
			}
			else if(b4 == b2)
			{
				t1.setText("");
				t2.setText("");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void itemStateChanged(ItemEvent ie)
	{
		JCheckBox c2=(JCheckBox)ie.getSource();

		if(c2==c1)
		{
			new ForgetPassword();
		}
	}
	public static void main(String a[])
	{
		new Login();
	}
}

