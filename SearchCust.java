import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class SearchCust extends JFrame implements ActionListener
{
	JButton b1,b2,b3;
	JLabel l1,l2;
	JTextField t1;
	Connection cn;
	Statement st;
	ResultSet rs;

	SearchCust()
	{		
		//design

		setSize(500,400);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("SEARCH");
		setLocation(20,20);
		Font f1 = new Font("calibri",Font.BOLD,20);
		Font f2 = new Font("arial",Font.BOLD,25);
		Font f3 = new Font("serif",Font.BOLD,35);

		//label

		l2 = new JLabel("SEARCH CUSTOMER",JLabel.CENTER);
		l2.setBounds(10,10,400,70);
		add(l2);
		l2.setFont(f3);

		l1 = new JLabel("Customer ID",JLabel.CENTER);
		l1.setBounds(50,120,150,30);
		add(l1);
		l1.setFont(f1);

		t1 = new JTextField(20);
		t1.setBounds(250,120,150,30);
		add(t1);
		t1.setToolTipText("Enter vaild employee id");

		//button

		b1 = new JButton("Search");
		b1.setBounds(50,250,150,50);
		add(b1);
		b1.setFont(f2);
		b1.setBackground(Color.pink);
		b1.addActionListener(this);

		b2 = new JButton("Cancel");
		b2.setBounds(250,250,150,50);
		add(b2);
		b2.setFont(f2);
		b2.setBackground(Color.pink);
		b2.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae)
	{
		try 
		{
		Class.forName("org.postgresql.Driver");
		cn = DriverManager.getConnection("jdbc:postgresql:project","postgres","");
		b3 = (JButton)ae.getSource();
			if(b3==b1)	
			{
				st = cn.createStatement();
				String sql = "select * from customer where cid = "+t1.getText()+";";
				rs = st.executeQuery(sql);
				while(rs.next())
				{
					if((t1.getText().equals(rs.getString(1))))
						new CPrint(rs.getString(1));
					else
						if((t1.getText())!=(rs.getString(1)))
						JOptionPane.showMessageDialog(null,"ID IS INVALID","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
				if(b3==b2)
					t1.setText("");
		}
		catch(Exception e){}
	}	

	public static void main(String a[])
	{
		new SearchCust();
	}
}

