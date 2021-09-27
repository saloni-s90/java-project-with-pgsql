import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
                                                                                                    
class EmpView extends JFrame implements ActionListener
{
        Connection cn;
        Statement st;
        ResultSet rs;
                                                                                                    
        String data[][] = new String[40][12];
        String head[] = {"id","name","fname","dob","adhar no","age","address","email","education","mobile","jdate"};
        JButton b1;
        int i;
                                                                                                    
        public EmpView()
        {
                setLayout(null);
                b1 = new JButton("display");
                b1.addActionListener(this);
                b1.setBounds(100,100,100,30);
                add(b1);
                i=0;
                setSize(1000,700);
                setVisible(true);
        	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

             try
                {
                                                                                                    
                        Class.forName("org.postgresql.Driver");
                        cn = DriverManager.getConnection("jdbc:postgresql:project","postgres","");
                        st = cn.createStatement();
                        rs = st.executeQuery("select * from employee");
                        while(rs.next())
                        {
                                data[i][0] = rs.getString(1);
                                data[i][1] = rs.getString(2);
                                data[i][2] = rs.getString(3);
				data[i][3] = rs.getString(4);
				data[i][4] = rs.getString(5);
				data[i][5] = rs.getString(6);
				data[i][6] = rs.getString(7);
				data[i][7] = rs.getString(8);
				data[i][8] = rs.getString(9);
				data[i][9] = rs.getString(10);               
				data[i][10] = rs.getString(11);
		                i++;
                        }
                }
                catch(Exception e){}
        }
                                                                                                    
        public void actionPerformed(ActionEvent ae)
        {
                JTable jt = new JTable(data,head);
                JScrollPane jp = new JScrollPane(jt);
                jp.setBounds(100,150,800,500);
                add(jp);
	}

	public static void main(String a[])
	{
		new EmpView();
	}
}

