import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class EPrint extends JFrame implements ActionListener
{
	JLabel i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12;
	JLabel a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11;
	JButton b1,b2,b3;
	Connection cn;
	Statement st,st1;
	ResultSet rs,rs1;
	String sql,sql1;
	String name,eid,father,dob,age,mbno,address,email,aadhar,education,jdate;

	EPrint(String eid)
	{

		try
		{
			Class.forName("org.postgresql.Driver");
			cn = DriverManager.getConnection("jdbc:postgresql:project","postgres","");
			st = cn.createStatement();
			sql = "select * from employee where id ='"+eid+"';";
			rs = st.executeQuery(sql);

			while(rs.next())
			{
				eid = rs.getString("id");
				name = rs.getString("name");
				father = rs.getString("fname");
				dob= rs.getString("dob");
				aadhar= rs.getString("adh_no");
				age = rs.getString("age");
				address = rs.getString("address");
				email = rs.getString("email");
				education = rs.getString("educate");
				mbno = rs.getString("mobile");
				jdate = rs.getString("jdate");
			}
		}
		catch(Exception ep){}


		//DESIGN

		setSize(800,650);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Print employee");
		setLocation(20,20);

		Font f1 =new Font("calibri",Font.BOLD,35);
		Font f2 =new Font("arial",Font.ITALIC,20);
		Font f3 =new Font("serif",Font.BOLD,25);

		//LABEL 

		i1 = new JLabel("EMPLOYEE DETAIL ",JLabel.CENTER);
		i1.setBounds(30,30,700,50);
		i1.setFont(f1);
		add(i1);

		i2 = new JLabel("ID");
		i2.setBounds(50,150,100,30);
		i2.setFont(f2);
		add(i2);

		a1=new JLabel(eid);
		a1.setBounds(200,150,150,30);
		add(a1);

		i3 = new JLabel("Name");
		i3.setBounds(400,150,200,30);
		i3.setFont(f2);
		add(i3);

		a2=new JLabel(name);
		a2.setBounds(600,150,150,30);
		add(a2);

		i4= new JLabel("Father Name");
		i4.setBounds(50,200,130,30);
		i4.setFont(f2);
		add(i4);

		a3=new JLabel(father);
		a3.setBounds(200,200,150,30);
		add(a3);

		i5= new JLabel("Dob");
		i5.setBounds(400,200,200,30);
		i5.setFont(f2);
		add(i5);

		a4=new JLabel(dob);
		a4.setBounds(600,200,150,30);
		add(a4);                                                                            

		i6= new JLabel("Aadhar");
		i6.setBounds(50,250,100,30);
		i6.setFont(f2);
		add(i6);

		a5=new JLabel(aadhar);
		a5.setBounds(200,250,150,30);
		add(a5);

		i7= new JLabel("Age");
		i7.setBounds(400,250,100,30);
		i7.setFont(f2);
		add(i7);

		a6=new JLabel(age);
		a6.setBounds(600,250,150,30);
		add(a6);

		i8= new JLabel("Adderss");
		i8.setBounds(50,300,100,30);
		i8.setFont(f2);
		add(i8);

		a7=new JLabel(address);
		a7.setBounds(200,300,150,30);
		add(a7);

		i9= new JLabel("Email id");
		i9.setBounds(400,300,100,30);
		i9.setFont(f2);
		add(i9);

		a8=new JLabel(email);
		a8.setBounds(600,300,150,30);
		add(a8);

		i10= new JLabel("Education");
		i10.setBounds(50,350,100,30);
		i10.setFont(f2);
		add(i10);

		a9=new JLabel(education);
		a9.setBounds(200,350,150,30);
		add(a9);


		i11= new JLabel("Mobile");
		i11.setBounds(400,350,100,30);
		i11.setFont(f2);
		add(i11);

		a10=new JLabel(mbno);
		a10.setBounds(600,350,150,30);
		add(a10);

		i12= new JLabel("Join date");
                i12.setBounds(400,400,150,30);
                i12.setFont(f2);
                add(i12);
                                                                                                    
                a11=new JLabel(jdate);
                a11.setBounds(600,400,150,30);
                add(a11);

		b1 = new JButton("Print");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(100,500,150,50);
		b1.setFont(f3);
		add(b1);

		b2=new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(350,500,150,50);
		b2.setFont(f3);           
		add(b2);
		b2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b2)	
	new SearchEmp();
	dispose();
	}

	public static void main(String[ ] arg)
	{
		new EPrint("");
	}
}




