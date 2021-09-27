import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
                                                                                                    
class PView extends JFrame implements ActionListener
{
        Connection cn;
        Statement st;
        ResultSet rs;
                                                                                                    
        String data[][] = new String[40][6];
        String head[] = {"pno","product","company","cost","quantity","issue date"};
        JButton b1;
        int i;
                                                                                                    
        public PView()
        {
                setLayout(null);
                b1 = new JButton("display");
                b1.addActionListener(this);
                b1.setBounds(100,100,100,30);
                add(b1);
                i=0;
                setSize(1000,600);
                setVisible(true);
        	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

             try
                {
                                                                                                    
                        Class.forName("org.postgresql.Driver");
                        cn = DriverManager.getConnection("jdbc:postgresql:project","postgres","");
                        st = cn.createStatement();
                        rs = st.executeQuery("select * from product");
                        while(rs.next())
                        {
                                data[i][0] = rs.getString(1);
                                data[i][1] = rs.getString(2);
                                data[i][2] = rs.getString(3);
				data[i][3] = rs.getString(4);
				data[i][4] = rs.getString(5);
				data[i][5] = rs.getString(6);
		                i++;
                        }
                }
                catch(Exception e){}
        }
                                                                                                    
        public void actionPerformed(ActionEvent ae)
        {
                JTable jt = new JTable(data,head);
                JScrollPane jp = new JScrollPane(jt);
                jp.setBounds(100,150,800,400);
                add(jp);
	}

	public static void main(String a[])
	{
		new PView();
	}
}

