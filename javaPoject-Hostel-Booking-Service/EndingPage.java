	import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
	import javax.swing.*;
	
public class EndingPage extends JFrame{
		EndingPage (){				
						JFrame f1;
				JButton jb1;
				ImageIcon img;
				JLabel imgL;
					f1=new JFrame("WELCOME TO HOSTEL BOOKING SERVICE //\\");
				img=new ImageIcon("ty.jpg");
					imgL=new JLabel(img);
					f1.setContentPane(new JLabel(img));
					imgL.setBounds(10,20,800,500);
					f1.getContentPane().setBackground(Color.WHITE); 
					JLabel lovely = new JLabel("<html><span style='font-size:40px;color:RED'>"+"YOUR ROOM IS BOOKED"+"</span></html>");
					lovely.setBounds(100, 10, 900, 80);
					JLabel l = new JLabel("<html><span style='font-size:25px;color:BLUE'>"+"ROOM NO  :"+BookRoom.roomd+"  BLOCK:"+BookRoom.bck+"</span></html>");
					l.setBounds(200, 100, 900, 40);
					
					
					
					 jb1 = new JButton("<html><span style='font-size:14px;color:YELLOW'>"+"BOOK AGAIN"+"</span></html>");
					jb1.setBounds(150, 500, 200, 30);	
					
					
					
					jb1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						int aac=1;
					
						if(aac==1){
						System.out.println("niraj");
						StudentInfo ss1=new StudentInfo();
						ss1.StudentInfo2();
						f1.dispose();
						}
					}
					});
					jb1.setBackground(Color.BLUE);
						
				JButton jb2 = new JButton("<html><span style='font-size:14px;color:YELLOW'>"+"EXIT"+"</span></html>");
						jb2.setBounds(550, 500, 200, 30);	
						jb2.setBackground(Color.RED);
						
						
						jb2.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							f1.dispose();
							
						}
						});
					//f1.add(imgL);
					
				    f1.add(jb1);
				 f1.add(jb2);
					f1.add(l);
					f1.add(lovely);
				    f1.setLayout(null);
					f1.setVisible(true);
					f1.setSize(1000,600);
					f1.setLocationRelativeTo(null);
					
						}

		public static void main(String args[]){
			
			new EndingPage();
		}



}
		
		 
	


