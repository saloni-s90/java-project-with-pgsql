import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class MainPage extends JFrame implements ActionListener 
{
	JButton b1,b2,b3,b4,b5;
	JLabel l1,l2,l3,l4;
	JMenuBar mb;
	JMenu m1,m2,m3,m4,m5;
	JMenuItem EA,EU,EV,ED,ES,CA,CU,CV,CD,CS,PA,PU,PP,PD,PS;
	ImageIcon img,img1;
	JPanel p1;

	public MainPage()
	{
		mb = new JMenuBar();
		setJMenuBar(mb);
		m1 = new JMenu("       Employee      ");
		m2 = new JMenu("       Customer      ");
		m3 = new JMenu("       Product       ");
		m5 = new JMenu("       Exit          ");

		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m5);

		m5.addActionListener(this);

		//employee

		EA=new JMenuItem("     Add  ");
		m1.add(EA);
		EA.addActionListener(this);

			EU = new JMenuItem("     Update  ");		
			m1.add(EU);
			EU.addActionListener(this);

			ES = new JMenuItem("     Search   ");
			m1.add(ES);
			ES.addActionListener(this);

			EV = new JMenuItem("     View   ");
			m1.add(EV);
			EV.addActionListener(this);

			ED = new JMenuItem("     Delete   ");
			m1.add(ED);
			ED.addActionListener(this);

		//customer

		CA=new JMenuItem("   Add   ");
		m2.add(CA);
		CA.addActionListener(this);

		CU = new JMenuItem("   Update   ");
		m2.add(CU);
		CU.addActionListener(this);                                                                                                    
		CS = new JMenuItem("   Search   ");
		m2.add(CS);
		CS.addActionListener(this);

		CV = new JMenuItem("   View   ");
		m2.add(CV);
		CV.addActionListener(this);

		CD = new JMenuItem("Delete");
		m2.add(CD);
		CD.addActionListener(this);

		//product

		PA=new JMenuItem("Add");
		m3.add(PA);
		PA.addActionListener(this);

		PU = new JMenuItem("Update");
		m3.add(PU);
		PU.addActionListener(this);                                                                                                    
		PS = new JMenuItem("Search");
		m3.add(PS);
		PS.addActionListener(this);

		PP = new JMenuItem("Print");
		m3.add(PP);
		PP.addActionListener(this);

		PD = new JMenuItem("Delete");
		m3.add(PD);
		PD.addActionListener(this);

		//design
				
		setSize(1000,700);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("               MAIN PAGE            ");
		setLocation(0,0);
		
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(0,0,1000,700);
		add(p1);
		//p1.setBackground(Color.yellow);

		l1 = new JLabel("ELECTRONIC MANAGEMENT SYSTEM",JLabel.CENTER);
		l1.setBounds(100,0,800,100);
		l1.setFont(new Font("Arial Black",Font.BOLD,40));
		l1.setForeground(Color.black);
		
		img = new ImageIcon("s3.png");
//		img1 = new ImageIcon("hh.jpg");

		l2=new JLabel(img);
		l2.setBounds(0,0,1000,700);
		p1.add(l2);
		l2.add(l1);

//		l3 = new JLabel(img1);
//		l3.setBounds(20,400,100,100);
//		l2.add(l3);

		l4 = new JLabel("WELCOME TO HOME PAGE",JLabel.CENTER);
		l4.setBounds(100,150,800,80);
		l4.setFont(new Font("Arial Black",Font.BOLD,30));
		l4.setForeground(Color.cyan);
		l2.add(l4);

		/*while(true)
		  {
		  l1.setVisible(false); // lid =  j label
		  try
		  {
		  Thread.sleep(500); //1000 = 1 second
		  }
		  catch(Exception e){}

		  l1.setVisible(true);

		  try
		  {
		  Thread.sleep(500);
		  }
		  catch(Exception e){}
		 */
	//}


	}

	public void actionPerformed(ActionEvent e)
	{
		JMenuItem c=(JMenuItem)e.getSource();
		if(c==EA)
			new AddEmploy();
		/*		if(c==EU)
				new Update();
*/
				if(c==ES)
				new SearchEmp();

				if(c==ED)
				new EDelete();

				if(c==EV)
				new EmpView();	
				
				if(c==CA)
				new CustAdd();

				if(c==CS)
				new SearchCust();

				if(c==CD)
				new CDelete();

				if(c==CV)
				new CustView();

				if(c==PA)
				new ProdAdd();

				if(c==PS)
				new SearchProd();

				if(c==PD)
				new PDelete();
			
				if(c==PU)
				new UpdateProd();

				if(c==PP)
				new PView();

				if(c==EU)
				new UpdateEmp();

				if(c==CU)
				new UpdateCust();
				
				if(c==m5)
				dispose();

		 	}

		public static void main(String a[])
		{
			new MainPage();
		}
}



