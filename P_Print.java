import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class P_Print extends JFrame implements ActionListener
{
	JLabel i1,i2,i3,i4,i5,i6,i7;
	JLabel a1,a2,a3,a4,a5,a6,a7;
	JButton b1,b2,b3,b4;
	Connection cn;
	Statement st,st1;
	ResultSet rs,rs1;
	String sql,sql1;
	String pno,pname,cname,cost,quantity,isdate;
	JFrame f = new JFrame();

	P_Print(String pid)
	{
		pack();
		try
		{
			Class.forName("org.postgresql.Driver");
			cn = DriverManager.getConnection("jdbc:postgresql:project","postgres","");
			st = cn.createStatement();
			sql = "select * from product where pno ='"+pid+"';";
			rs = st.executeQuery(sql);

			while(rs.next())
			{
				pno = rs.getString("pno");
				pname = rs.getString("pname");
				cname = rs.getString("cname");
				cost = rs.getString("cost");
				quantity = rs.getString("quantity");
				isdate = rs.getString("isdate");
			}
		}
		catch(Exception ep){ ep.printStackTrace();}


		//DESIGN

		setSize(700,600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("           PRINT  PRODUCT       ");
		setLocation(20,20);

		Font f1 =new Font("calibri",Font.BOLD,35);
		Font f2 =new Font("arial",Font.BOLD,20);
		Font f3 =new Font("serif",Font.BOLD,25);

		//LABEL 

		i1 = new JLabel(" PRODUCT DETAIL ",JLabel.CENTER);
		i1.setBounds(30,20,600,60);
		i1.setFont(f1);
		add(i1);

		//label id

		i2 = new JLabel("Product no");
		i2.setBounds(30,120,200,30);
		i2.setFont(f2);
		add(i2);

		a1=new JLabel(pno);
		a1.setBounds(250,120,200,30);
		add(a1);

		i3 = new JLabel("Product Name");
		i3.setBounds(30,170,200,30);
		i3.setFont(f2);
		add(i3);

		a2=new JLabel(pname);
		a2.setBounds(250,170,200,30);
		add(a2);

		i4= new JLabel("Company Name");
		i4.setBounds(30,220,200,30);
		i4.setFont(f2);
		add(i4);

		a3=new JLabel(cname);
		a3.setBounds(250,220,200,30);
		add(a3);

		i5= new JLabel("Cost");
		i5.setBounds(30,270,200,30);
		i5.setFont(f2);
		add(i5);

		a4=new JLabel(cost);
		a4.setBounds(250,270,200,30);
		add(a4);

		i6 = new JLabel("Quantity");
		i6.setBounds(30,320,200,30);
		i6.setFont(f2);
		add(i6);

		a5=new JLabel(quantity);
		a5.setBounds(250,320,200,30);
		add(a5);

		i7 = new JLabel("Issue Date");
		i7.setBounds(30,370,200,30);
		i7.setFont(f2);
		add(i7);

		a6 = new JLabel(isdate);
		a6.setBounds(250,370,200,30);
		add(a6);

		//label

		b1 = new JButton("Print");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(150,500,150,50);
		b1.setFont(f3);
		add(b1);
		
		b2=new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(400,500,150,50);
		b2.setFont(f3);           
		add(b2);
		b2.addActionListener(this);

	}


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b2)
			new SearchProd();
		dispose();
	}
	public static void main(String a[])
	{
		new P_Print("1");
	}
}

