import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class EDelete extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3;
	Connection cn;
	Statement st;
	ResultSet rs;
	String sql1,sql;

	EDelete()
	{
		//design

		setSize(700,500);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("delete");
		setLocation(20,20);

		Font f1 = new Font("arial",Font.BOLD,35);
		Font f2 = new Font("calibri",Font.BOLD,20);
		Font f3 = new Font("serif",Font.BOLD,25);

		//label

		l1 = new JLabel("DELETE RECORDS OF EMPLOYEE",JLabel.CENTER);
		l1.setBounds(20,20,600,60);
		add(l1);
		l1.setFont(f1);

		//label 2

		l2 = new JLabel("Employee ID",JLabel.CENTER);
		l2.setBounds(20,120,200,40);
		add(l2);
		l2.setFont(f2);

		//textfield

		t1 = new JTextField();
		t1.setBounds(250,120,200,40);
		add(t1);

		b1 = new JButton("Delete Record");
		b1.setBounds(20,250,250,60);
		add(b1);
		b1.setFont(f3);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);

		b2 = new JButton("Cancel");
		b2.setBounds(300,250,150,60);
		add(b2);
		b2.setFont(f3);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae)
	{

		try
		{
			Class.forName("org.postgresql.Driver");
			cn = DriverManager.getConnection("jdbc:postgresql:project","postgres","");

			b3 =(JButton)ae.getSource();
			if(b3==b1)
			{
				st=cn.createStatement();
				sql1 = "select * from employee where id = "+t1.getText()+";";
				rs= st.executeQuery(sql1);
				while(rs.next())
				{
					if(t1.getText().equals(rs.getString(1)))
					{
						st = cn.createStatement();
						sql = "delete from employee where id ="+t1.getText()+";";
						JOptionPane.showMessageDialog(null,"RECORD IS DELETED","DELETE",JOptionPane.INFORMATION_MESSAGE);
						rs = st.executeQuery(sql);
					}
					else 
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
		new EDelete();
	}
}



