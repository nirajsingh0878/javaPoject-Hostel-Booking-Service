import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class StudentInfo extends JFrame { 

	JFrame f1;
	JButton jb1;
	JTextField sregno;
	ImageIcon img;
//	JLabel imgL;
	JTextField sname;
	public static String name1;
	public static String reg;
	void StudentInfo2(){
		f1=new JFrame("WELCOME TO HOSTEL BOOKING SERVICE //\\");
	img=new ImageIcon("lpu4.jpg");
		//imgL=new JLabel(img);
		f1.setContentPane(new JLabel(img));
	//	imgL.setBounds(10,20,800,500);
	//	f1.add(imgL);
		f1.getContentPane().setBackground(Color.WHITE); 
		JLabel lovely = new JLabel("<html><span style='font-size:40px;color:RED'>"+"Lovely Professional University"+"</span></html>");
		lovely.setBounds(100, 10, 900, 80);
		JLabel l = new JLabel("<html><span style='font-size:25px;color:BLUE'>"+"Welcome To Hostel Booking Service"+"</span></html>");
		l.setBounds(200, 100, 900, 40);
		
		JLabel regno=new JLabel("<html><span style='font-size:14px;color:YELLOW'>"+"REGISTRATION NO : "+"</span></html>");
		regno.setFont(new Font("SansSerif", Font.BOLD, 16));
		regno.setOpaque(isDefaultLookAndFeelDecorated());
		regno.setBounds(100, 200, 200, 30);
		
		JLabel name = new JLabel("<html><span style='font-size:14px;color:YELLOW'><b>"+"NAME : "+"</b></span></html>");
		name.setBounds(100, 300, 200, 30);
		name.setOpaque(false);
		
		sregno = new JTextField(10);
		sregno.setBounds(400, 200, 200, 30);
		
		sname = new JTextField(20);
		sname.setBounds(400, 300, 200, 30);
		
		JButton jb1 = new JButton("<html><span style='font-size:14px;color:BLACK'>"+" SUBMIT "+"</span></html>");
		jb1.setBounds(350, 500, 200, 30);	
		
		
		
		jb1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			reg = sregno.getText();
			name1 = sname.getText();
			if(reg.length()==8 && name1.length()>=2 )
			{
				JOptionPane.showMessageDialog(null,"Succesfully login");
				f1.dispose();
				new BookRoom();
				
				
				//then goto Book
			}
			else
			{
				JOptionPane.showMessageDialog(null,"wrong info");
			}	
		}
		});
		
		//f1.add(imgL);
		f1.add(regno);
	    f1.add(name);
	    f1.add(sregno);
	    f1.add(sname);
	    f1.add(jb1);
		f1.add(l);
		f1.add(lovely);
	    f1.setLayout(null);
		f1.setVisible(true);
		f1.setSize(1000,600);
		f1.setLocationRelativeTo(null);
		
	}
	
	
public static void main(String args[]){
	try{
	
		StudentInfo s1=new StudentInfo();	
		s1.StudentInfo2();
		}
		catch(Exception e){e.printStackTrace();}
		}

}

