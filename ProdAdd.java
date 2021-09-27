import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class ProdAdd extends JFrame implements ActionListener
{
	JLabel i1,i2,i3,i4,i5,i6,i7,i8,i9,i10;
	JTextField t1,t2,t3,t5,t6,t7,t8,t9,t10;
	final JTextField t4;
	JButton b1,b2,b3,b4;
	Connection cn;
	Statement st;
	ResultSet rs;
	JFrame f = new JFrame();

	ProdAdd()
	{
		pack();
			try
			{
			Class.forName("org.postgresql.Driver");
			cn = DriverManager.getConnection("jdbc:postgresql:project","postgres","");
			System.out.println("connnection set");
			}
			catch(Exception ep)
			{
			ep.printStackTrace();
			}

		
		//DESIGN

		setSize(700,600);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add Product");
		setLocation(20,20);

		Font f1 =new Font("calibri",Font.BOLD,35);
		Font f2 =new Font("arial",Font.BOLD,20);
		Font f3 =new Font("serif",Font.BOLD,25);

		//LABEL 

		i1 = new JLabel("ADD PRODUCT DETAIL ",JLabel.CENTER);
		i1.setBounds(30,20,600,60);
		i1.setFont(f1);
		add(i1);

		//label id

		i2 = new JLabel("Product ID");
		i2.setBounds(30,120,200,30);
		i2.setFont(f2);
		add(i2);

		t1=new JTextField();
		t1.setBounds(250,120,200,30);
		add(t1);

		i3 = new JLabel("Product name");
		i3.setBounds(30,170,200,30);
		i3.setFont(f2);
		add(i3);

		t2=new JTextField();
		t2.setBounds(250,170,200,30);
		add(t2);
		t2.setToolTipText("only character are valid");

		i4= new JLabel("Company name");
		i4.setBounds(30,220,200,30);
		i4.setFont(f2);
		add(i4);

		t3=new JTextField();
		t3.setBounds(250,220,200,30);
		add(t3);

		i5= new JLabel("Cost");
		i5.setBounds(30,270,200,30);
		i5.setFont(f2);
		add(i5);

		t4=new JTextField();
		t4.setBounds(250,270,200,30);
		add(t4);

		i6 = new JLabel("Quantity");
		i6.setBounds(30,320,200,30);
		i6.setFont(f2);
		add(i6);

		t5=new JTextField();
		t5.setBounds(250,320,200,30);
		add(t5);

		i7 = new JLabel("Issue Date");
		i7.setBounds(30,370,200,30);
		i7.setFont(f2);
		add(i7);

		t6 = new JTextField();
		t6.setBounds(250,370,200,30);
		add(t6);
		t6.setEditable(false);

		b4 = new JButton("Select Date");
		b4.setBounds(470,370,120,30);
		add(b4);
		b4.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent ae)
				{
				t6.setText(new DatePicker(f).setPickedDate());
				}
				});

		//label

		b1 = new JButton("Submit");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(150,500,150,50);
		b1.setFont(f3);
		add(b1);
		b1.addActionListener(this);

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
	   String a = t1.getText();
	   String b = t2.getText();
	   String c = t3.getText();
	   String d = t4.getText();
	   String e = t5.getText();
	   String f = t6.getText(); 

	   JButton b3 = (JButton)ae.getSource();
	   if(b3 == b1)
	   {
	   try
{
	   st = cn.createStatement();
	   String q = "insert into product values("+a+",'"+b+"','"+c+"','"+d+"','"+e+"','"+f+"');";
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
	   }
	   }
	public static void main(String[ ] arg)
	{
		new ProdAdd();
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

