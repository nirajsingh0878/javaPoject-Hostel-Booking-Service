import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BookRoom extends JFrame{
	//for database storing values
	static String room="";
	static int roomd=123;
	static String bck;
	
	String label2;
	BookRoom (){				
		
		JLabel headerLabel;
		   JLabel statusLabel;
		   JPanel pan1=new JPanel(new GridLayout(4,4));		   
		   JPanel pan=new JPanel(new GridLayout(9,9));
		   pan.setBounds(0,400,1300,250);
		   pan1.setBounds(20,160,600,150);
		   headerLabel = new JLabel("", JLabel.CENTER);        
		   statusLabel = new JLabel("",JLabel.CENTER);   
	
		 
	//radio button for Seater selection 	
		   final JRadioButton oneseater = new JRadioButton("ONE SEATER");
	    final JRadioButton twoseater = new JRadioButton("TWO SEATER");
	     final JRadioButton threeseater = new JRadioButton("THREE SEATER");
	     final JRadioButton fourseater = new JRadioButton("FOUR SEATER");
	     ButtonGroup bG = new ButtonGroup();
	     bG.add(oneseater);
	     bG.add(twoseater);
	     bG.add(threeseater);    
	     bG.add(fourseater);
	     
	   //status label
	     statusLabel.setBounds(620, 60, 500, 200);
	     statusLabel.setText("<html><span style='font-size:25px;color:BLUE'>"+"CHOOSE ROOM AND BLOCK"+"</span></html>");
	   //block  selection
	 	final  JRadioButton A = new JRadioButton("Block A");
	     final JRadioButton B = new JRadioButton("Block B");
         
	     ButtonGroup r1 = new ButtonGroup();
	     r1.add(A);
	     r1.add(B);
	   
	     headerLabel.setText("<html><span style='font-size:30px;color:RED'>"+"WELCOME TO HOSTEL BOOKING SERVICE"+"</span></html>");
	     headerLabel.setBounds(170, 10, 900, 80);
		   
	     JLabel regnol=new JLabel("<html><span style='font-size:14px'>"+"Reg no : "+"</span></html>");
			regnol.setFont(new Font("SansSerif", Font.BOLD, 16));
			regnol.setBounds(0,100, 100, 30);
			
	
		     JLabel uregnol=new JLabel("<html><span style='font-size:14px'>"+StudentInfo.reg+"</span></html>");
				uregnol.setFont(new Font("SansSerif", Font.BOLD, 16));
				uregnol.setBounds(100,100, 200, 30);
		

				JLabel name = new JLabel("<html><span style='font-size:14px'>"+"Name : "+"</span></html>");
				name.setBounds(350, 100, 100, 30);

				JLabel uname = new JLabel("<html><span style='font-size:14px'>"+StudentInfo.name1+"</span></html>");
				uname.setBounds(450, 100, 200, 30);

				JLabel Room = new JLabel("<html><span style='font-size:25px;color:BLUE'>"+"CHOOSE ROOM:"+"</span></html>");
				Room.setBounds(20, 350, 300, 30);
				
				//for submit button
				JButton jb1 = new JButton("<html><span style='font-size:15px;color:GREEN'>"+"BOOK NOW"+"</span></html>");
				jb1.setBounds(520, 350, 200, 40);	
				jb1.setBackground(Color.white);
				JButton jb2 = new JButton("<html><span style='font-size:15px;color:RED'>"+"CHECK AVAILIBLITY"+"</span></html>");
				jb2.setBounds(720, 350, 400, 40);
				jb2.setBackground(Color.white);
				
				
				
				add(jb2);
				add(jb1);
				add(Room);
				add(uname);
				add(uregnol);
				add(name);
				add(regnol);
				add(pan);
				jb1.addActionListener(new ActionListener(){
					
					public void actionPerformed(ActionEvent actionEvent) {
				          {
				        	  int flag=0,flag1=0;
				        	  if( ( !(A.isSelected() ) && ( !(B.isSelected() ) ) ) ) 
				        			  {
				        		  flag=1;flag1=1;
				        		  JOptionPane.showMessageDialog(null,"PLEASE SELECT A BLOCK");
				        	  }
				        	  if(  (!(oneseater.isSelected() ) && ( !(twoseater.isSelected()))&& (!(threeseater.isSelected() ) )&& ( !(fourseater.isSelected()) ) )) 
		        			  {
				        		  flag=1;flag1=1;
		        		  JOptionPane.showMessageDialog(null,"PLEASE GIVE A PREFRENCE ABOUT THE ROOM ex.ONE SEATER");
		        			  }
				  
				        	  if(flag==0&&flag1==0){
				        		  int nreg=Integer.parseInt(StudentInfo.reg);
				        		   try{
				        			
				        			   Class.forName("com.mysql.jdbc.Driver");
				        			                System.out.println("Driver Loaded");
				        					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nj", "root", "123456");
				        			                System.out.println("Connection made");

				        					PreparedStatement pstat = con.prepareStatement("insert into bhh1 values(?,?,?,?)");
				        					
				        			                
				     
				        			 System.out.println(BookRoom.roomd);
				        					 pstat.setInt(1,nreg);
				        					pstat.setString(2,StudentInfo.name1);
				        			 pstat.setInt(3,BookRoom.roomd);
				        		      pstat.setString(4,A.isSelected()?"A":"B");
				        			 pstat.executeUpdate();
				        			 JOptionPane.showMessageDialog(null,"YOU HAVE BOOKED ROOM NO:"+room);
				        			 int aaa=1;
				        			 con.close();
				        			 if(aaa==1){
				        			 new EndingPage();
				        			 dispose();
				        			 }				        			 
				        		  }
				        		  
				        		   catch(SQLException e){
				        			   JOptionPane.showMessageDialog(null,room+":IS BOOKED PLEASE SELECT OTHER ROOM") ;
					        		  }
				        		   catch(Exception e){
					        			  e.printStackTrace();
					        		  }
				        		  
				        		  
				        		  
				        	  }
				          }
					
					
					}
				});
			//start
			
jb2.addActionListener(new ActionListener(){
					
					public void actionPerformed(ActionEvent actionEvent) {
				          {
				        	  int flag=0,flag1=0;
				        	  bck=A.isSelected()?" A":" B";
				        	  if( ( !(A.isSelected() ) && ( !(B.isSelected() ) ) ) ) 
				        			  {
				        		  flag=1;flag1=1;
				        		  JOptionPane.showMessageDialog(null,"PLEASE SELECT A BLOCK");
				        	  }
				        	  if(  (!(oneseater.isSelected() ) && ( !(twoseater.isSelected()))&& (!(threeseater.isSelected() ) )&& ( !(fourseater.isSelected()) ) )) 
		        			  {
				        		  flag=1;flag1=1;
		        		  JOptionPane.showMessageDialog(null,"PLEASE GIVE A PREFRENCE ABOUT THE ROOM ex.ONE SEATER");
		        			  }
				        	  if(BookRoom.roomd=='\0'){  
				        		  flag=1;flag1=1;
				        		  JOptionPane.showMessageDialog(null,"PLEASE SELECT THE ROOM AND BLOCK");
						        	
				        	  }
				        	  
				  
				        	 
				        	  
				        	  
				        	  if(flag==0&&flag1==0){
				        		  int nreg=Integer.parseInt(StudentInfo.reg);
				        		   try{
				        			
				        			   Class.forName("com.mysql.jdbc.Driver");
				        			                System.out.println("Driver Loaded");
				        					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nj", "root", "123456");
				        			                System.out.println("Connection made");
				        			         
				        			         	 Statement stat1 = con.createStatement();
				        					
				        					
				        			               
				        			         	 ResultSet rs = stat1.executeQuery("select *from bhh1 where room=\'"+BookRoom.roomd+"\'"+" and block=\'"+(A.isSelected()?"A":"B")+"\'");
				        			        	 if( !rs.next()){
				        			         		System.out.println("Room is avaliabel");
				        			   			 JOptionPane.showMessageDialog(null,"ROOM is FREE SMASH BOOK NOW");
				     					        
				        			        	 } 	
				        			        	 else{ 
				        			        		 String spp="MR."+rs.getString("name")+" ";
				        			        		 JOptionPane.showMessageDialog(null,spp+"IS ALREADY BOOKED THIS ROOM");
						     					        	 
				        			        	 }
				        			        	 
				        			//	 JOptionPane.showMessageDialog(null,"ROOM is FREE SMASH BOOK NOW");
					        				        		  
				        		   }
				        		   catch(SQLException e){
				        			   e.printStackTrace();
				        			   //JOptionPane.showMessageDialog(null,room+" IS BOOKED PLEASE SELECT OTHER ROOM") ;
					        
				        		   }
				        		   catch(Exception e){
					        			  e.printStackTrace();
					        		  }
				        		  
				        		  
				        	 		  
				        	  }
				          }
					
					
					}
				});
				
	    
				JButton a[]=new JButton[120];
				int k=0;	
				
				ActionListener actionListener = new ActionListener()
				{
               public void actionPerformed(ActionEvent actionEvent) {
            	    
            	   JButton button = (JButton)actionEvent.getSource();
                 
                    button.setForeground(Color.RED);
                     label2 = button.getText();
                     room=label2.substring(5);
                     roomd=Integer.parseInt((button.getText()).substring(6, 9));
                     String v=String.valueOf(room);
                 
                     JOptionPane.showMessageDialog(null,"ROOM SELECTED:"+room);
                     statusLabel.setText("<html><span style='font-size:25px;color:ORANGE'>"+"ROOM SELECTED:"+room+"</span></html>");
               }
         };
        
						
         for(int i=1;i<10;i++){
         		for(int j=1;j<=12;j++){
         			int t=i*100+j;
         		a[k]=new JButton("ROOM: "+t);
         		a[k].setForeground(Color.BLUE);
         		pan.add(a[k]);
         		a[k].addActionListener(actionListener);
         		k++;
         		}
         	}
         
         
         ItemListener itemListener = new ItemListener()
			{
     public void itemStateChanged(ItemEvent e) {
    	
    	 if(oneseater.isSelected())
    		statusLabel.setText("<html><span style='font-size:25px;color:ORANGE'>"+"SELECT ROOM NO:FROM 101 TO 212 for 1-SEATER"+"</span></html>");
    	 if(twoseater.isSelected())
     		statusLabel.setText("<html><span style='font-size:25px;color:GREEN'>"+"SELECT ROOM NO:FROM 301 TO 412 for 2-SEATER"+"</span></html>");
    	 if(threeseater.isSelected())
     		statusLabel.setText("<html><span style='font-size:25px;color:PINK'>"+"SELECT ROOM NO:FROM 501 TO 612 for 3-SEATER"+"</span></html>");
    	 if(fourseater.isSelected())
     		statusLabel.setText("<html><span style='font-size:25px;color:BLUE'>"+"SELECT ROOM NO:FROM 701 TO 912 for 4-SEATER"+"</span></html>");
     		}     
			};
       
		oneseater.addItemListener(itemListener);
	    twoseater.addItemListener(itemListener);
	    threeseater.addItemListener(itemListener);
	    fourseater.addItemListener(itemListener);
	     pan1.add(oneseater);
	     pan1.add(twoseater);
	     pan1.add(threeseater);    
	     pan1.add(fourseater);
	     pan1.add(A);
	     pan1.add(B);
	     add(headerLabel);
	     add(statusLabel);
	     //f1.setBounds(x, y, width, height)
   
	     add(pan1);
	     setSize(1600,1600);   
	     setLayout(null);
	     add(statusLabel);
	     setVisible(true);
	 }
	/*
	
public static void main(String afff[]){
	new BookRoom();
}
*/

}
