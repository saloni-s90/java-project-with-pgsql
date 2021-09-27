import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class AddEmploy extends JFrame implements ActionListener
{
	JLabel i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12;
	JTextField t1,t2,t3,t5,t6,t7,t8,t9,t10;
	final JTextField t4,t11;
	JButton b1,b2,b3,b4;
	Connection cn;
	Statement st;
	ResultSet rs;
	JFrame f;

	AddEmploy()
	{
	pack();
	f = new JFrame();
		
		try
		{
			Class.forName("org.postgresql.Driver");
			cn = DriverManager.getConnection("jdbc:postgresql:project","postgres","");
		}
		catch(Exception ep)
		{
			ep.printStackTrace();
		}


		//DESIGN

		setSize(900,650);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add Employee");
		setLocation(20,20);

		Font f1 =new Font("calibri",Font.BOLD,35);
		Font f2 =new Font("arial",Font.BOLD,20);
		Font f3 =new Font("serif",Font.BOLD,25);

		//LABEL 

		i1 = new JLabel("ADD EMPLOYEE DETAIL ",JLabel.CENTER);
		i1.setBounds(30,20,750,50);
		i1.setFont(f1);
		add(i1);

		//label id

		i2 = new JLabel("Employee ID");
		i2.setBounds(30,120,160,30);
		i2.setFont(f2);
		add(i2);

		t1=new JTextField();
		t1.setBounds(210,120,150,30);
		add(t1);

		i3 = new JLabel("Name");
		i3.setBounds(420,120,100,30);
		i3.setFont(f2);
		add(i3);

		t2=new JTextField();
		t2.setBounds(550,120,150,30);
		add(t2);
		t2.setToolTipText("only character are valid");

		i4= new JLabel("Father's Name");
		i4.setBounds(30,170,160,30);
		i4.setFont(f2);
		add(i4);

		t3=new JTextField();
		t3.setBounds(210,170,150,30);
		add(t3);
		t3.setToolTipText("only character are valid");

		i5= new JLabel("DOB");
		i5.setBounds(420,170,100,30);
		i5.setFont(f2);
		add(i5);

		t4=new JTextField();
		t4.setBounds(550,170,150,30);
		add(t4);
		t4.setEditable(false);

		//button

		b3 = new JButton("Select Date");
		b3.setBounds(710,170,120,30);
		add(b3);
		b3.addActionListener(new ActionListener()
                {
                        public void actionPerformed(ActionEvent ae)
                        {
                                t4.setText(new DatePicker(f).setPickedDate());
                        }
                });


		i6= new JLabel("Aadhar no");
		i6.setBounds(30,220,160,30);
		i6.setFont(f2);
		add(i6);

		t5=new JTextField();
		t5.setBounds(210,220,150,30);
		add(t5);
		t5.setToolTipText("only number are valid");

		i7= new JLabel("Age");
		i7.setBounds(420,220,100,30);
		i7.setFont(f2);
		add(i7);

		t6=new JTextField();
		t6.setBounds(550,220,150,30);
		add(t6);
		t6.setToolTipText("only number are valid but less than 120");

		i8= new JLabel("Adderss");
		i8.setBounds(30,270,160,30);
		i8.setFont(f2);
		add(i8);

		t7=new JTextField();
		t7.setBounds(210,270,150,30);
		add(t7);

		i9= new JLabel("Email id");
		i9.setBounds(420,270,100,30);
		i9.setFont(f2);
		add(i9);
		
		t8=new JTextField();
		t8.setBounds(550,270,150,30);
		add(t8);

		i10= new JLabel("Education");
		i10.setBounds(30,320,160,30);
		i10.setFont(f2);
		add(i10);

		t9=new JTextField();
		t9.setBounds(210,320,150,30);
		add(t9);


		i11= new JLabel("Mobile");
		i11.setBounds(420,320,100,30);
		i11.setFont(f2);
		add(i11);

		t10=new JTextField();
		t10.setBounds(550,320,150,30);
		add(t10);

		i12 = new JLabel("Join Date");
		i12.setBounds(30,370,160,30);
		i12.setFont(f2);
		add(i12);

		t11 = new JTextField();
		t11.setBounds(210,370,150,30);
		add(t11);
		t11.setEditable(false);
		
		b4 = new JButton("Select Date");
		b4.setBounds(230,410,120,30);
                add(b4);
                b4.addActionListener(new ActionListener()
                {
                        public void actionPerformed(ActionEvent ae)
                        {
                                t11.setText(new DatePicker(f).setPickedDate());
                        }
                });

		b1 = new JButton("Submit");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(250,550,150,40);
		b1.setFont(f3);
		add(b1);
		b1.addActionListener(this);

		b2=new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(450,550,150,40);
		b2.setFont(f3);           
		add(b2);
		b2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{	
		String a = t1.getText();
		String b = t2.getText();
		String c = t3.getText();
		String d = t4.getText();
		String e = t5.getText();
		String f = t6.getText();
		String g = t7.getText();
		String h = t8.getText();
		String i = t9.getText();
		String j = t10.getText();
		String k = t11.getText();

JButton b3 = (JButton)ae.getSource();
		if(b3 == b1)
		{
			try{
st = cn.createStatement();
				String q = "insert into employee values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"','"+k+"');";
				st.executeUpdate(q);
				JOptionPane.showMessageDialog(null,"Details Successfully Inserted");

			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}

		else if(b3 == b2)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");
			t9.setText("");
			t10.setText("");
		}
	}
	public static void main(String[ ] arg)
	{
		new AddEmploy();
	}
}

//date picker

class DatePicker
{
	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
	JLabel l = new JLabel("", JLabel.CENTER);
	String day = "";
	JDialog d;
	JButton[] button = new JButton[49];

	public DatePicker(JFrame parent)
	{
		d = new JDialog();
		d.setModal(true);
		String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
		JPanel p1 = new JPanel(new GridLayout(7, 7));
		p1.setPreferredSize(new Dimension(430, 120));

		for (int x = 0; x < button.length; x++)
		{
			final int selection = x;
			button[x] = new JButton();
			button[x].setFocusPainted(false);

			button[x].setBackground(Color.white);
			if (x > 6)
				button[x].addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						day = button[selection].getActionCommand();
						d.dispose();
					}
				});
			if (x < 7)
			{
				button[x].setText(header[x]);
				button[x].setForeground(Color.red);
			}
			p1.add(button[x]);
		}
		JPanel p2 = new JPanel(new GridLayout(1, 3));
		JButton previous = new JButton("<< Previous");
		previous.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				month--;
				displayDate();
			}
		});
		p2.add(previous);
		p2.add(l);
		JButton next = new JButton("Next >>");
		next.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				month++;
				displayDate();
			}
		});
		p2.add(next);
		d.add(p1, BorderLayout.CENTER);
		d.add(p2, BorderLayout.SOUTH);
		d.pack();
		d.setLocationRelativeTo(parent);
		displayDate();
		d.setVisible(true);
	}

	public void displayDate()
	{
		for (int x = 7; x < button.length; x++)
			button[x].setText("");
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);
		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
			button[x].setText("" + day);
		l.setText(sdf.format(cal.getTime()));
		d.setTitle("Date Picker");
	}

	public String setPickedDate()
	{
		if (day.equals(""))
			return day;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, Integer.parseInt(day));
		return sdf.format(cal.getTime());
	}
}

