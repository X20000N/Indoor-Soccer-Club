package GroupBar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Paket.StartLayout;
import Paket.User;
import Sides.Layout_03Start;

public class GroupBar_Layout implements ActionListener {
	
	private static JLabel Group_Layout = new JLabel();
	
	private static JLabel Group_Headline = new JLabel();
	
	private static JButton Group_Create = new JButton();
	private static JButton Group_Enter = new JButton();
	
	private static JLabel Group_Member1 = new JLabel();
	private static JLabel Group_Member2 = new JLabel();
	private static JLabel Group_Member3 = new JLabel();
	private static JLabel Group_Member4 = new JLabel();
	private static JLabel Group_Member5 = new JLabel();
	
	private static String[] List = null;
		
	private static boolean CloseCreateGroup = false;
	
	private static Timer t = new Timer(1000, new GroupCheck());
		
	public GroupBar_Layout() {
		
		new GroupBar_01CreateGroup();
		new GroupBar_02EnterGroup();
		
		// Labels
		
		Group_Layout.setBounds(0,0,2000,2000);
		
		Font Font_label = new Font("Arial", Font.BOLD, 20);

		Group_Headline.setText("Gruppe");
		Group_Headline.setBounds(10,5,150,50);
		Group_Headline.setFont(new Font("Arial", Font.BOLD, 25));

		Group_Member1.setText("Mitglied");
		Group_Member1.setBounds(10,100+50*1,200,50);
		Group_Member1.setFont(Font_label);
		
		Group_Member2.setText("Mitglied");
		Group_Member2.setBounds(10,100+50*2,200,50);
		Group_Member2.setFont(Font_label);

		Group_Member3.setText("Mitglied");
		Group_Member3.setBounds(10,100+50*3,200,50);
		Group_Member3.setFont(Font_label);

		Group_Member4.setText("Mitglied");
		Group_Member4.setBounds(10,100+50*4,200,50);
		Group_Member4.setFont(Font_label);

		Group_Member5.setText("Mitglied");
		Group_Member5.setBounds(10,100+50*5,200,50);
		Group_Member5.setFont(Font_label);

		// Buttons
		
		Font Font_button = new Font("Arial", Font.BOLD, 18);

		Group_Create.setText("Erstellen");
		Group_Create.addActionListener(this);
		Group_Create.setBackground(new Color(167,210,168));
		Group_Create.setBounds(10,55,147,35);
		Group_Create.setFont(Font_button);
		Group_Create.addActionListener(this);

		Group_Enter.setText("Beitreten");
		Group_Enter.addActionListener(this);
		Group_Enter.setBackground(new Color(167,210,168));
		Group_Enter.setBounds(10,105,147,35);
		Group_Enter.setFont(Font_button);
		Group_Enter.addActionListener(this);
		
		// Layout
		
		StartLayout.RightBar.add(Group_Layout);

		Group_Layout.add(Group_Headline);
		Group_Layout.add(Group_Create);
		Group_Layout.add(Group_Enter);
		Group_Layout.add(Group_Member1);
		Group_Layout.add(Group_Member2);
		Group_Layout.add(Group_Member3);
		Group_Layout.add(Group_Member4);
		Group_Layout.add(Group_Member5);
		
		ReloadMember();
		CloseSide();
	}
	
	private static void ReloadMember() {
		
		Group_Headline.setText("Gruppe");
		
		Group_Member1.setVisible(false);
		Group_Member2.setVisible(false);
		Group_Member3.setVisible(false);
		Group_Member4.setVisible(false);
		Group_Member5.setVisible(false);
	}
	
	public static void OpenSide() {
		
		Group_Layout.setVisible(true);
	}
	
	public static void CloseSide() {
		
		Group_Layout.setVisible(false);
		ReloadMember();
	}
	
	static void Start_Reloader() {
		
		Group_Create.setText("Austreten");
		User.InGroup = true;
		t.start();
	}
	
	static void Escape_Group() {
		
		StartLayout.DeleteDir("Groups/" + User.User_Group[0] + "/" + User.User_Data[2] + ".txt");

		System.out.println("Gruppe: " + User.User_Group[0] );
		System.out.println("Gruppe: " + User.User_Data[2] );
		
		List = StartLayout.getFiles("Groups/" + User.User_Group[0] + "/", List, 0);
		
		Group_Create.setText("Erstellen");
		t.stop();
		
		User.EscapeGroup();
		ReloadMember();
		
		GroupBar_01CreateGroup.CloseSide();
		GroupBar_02EnterGroup.CloseSide();
	}
	
	public void actionPerformed(ActionEvent e) {

		if ( e.getSource() == Group_Create && User.InGroup == true ) {
						
			User.InGroup = false;
			CloseCreateGroup = true;
			Escape_Group();	

		} else

		if ( e.getSource() == Group_Create && User.InGroup == false ) {
			
			Layout_03Start.OpenSide();

			if ( CloseCreateGroup == true ) {
				
				CloseCreateGroup = false;

			} else {
				
				GroupBar_01CreateGroup.OpenSide();
			}
		} 
		
		if ( e.getSource() == Group_Enter ) {
			
			Layout_03Start.OpenSide();

			GroupBar_02EnterGroup.OpenSide();
		}
	}
	
	static class GroupCheck implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			ReloadMember();

			List = StartLayout.getFiles("Groups/" + User.User_Group[0], List, 0);
			
			Group_Headline.setText(User.User_Group[0]);
			
			// If don't work
			if ( User.InGroup == true && List.length == 0 ) {
				
				Group_Member1.setText(User.User_Data[2]);
				Group_Member1.setVisible(true); 
			} 
			
			if ( List.length > 0+2 ) { 
			
				String s = List[2];
				s = s.substring(0, s.length()-4);

				Group_Member1.setText(s); 				
				Group_Member1.setVisible(true); 
			}
			
			if ( List.length > 1+2 ) { 
			
				String s = List[3];
				s = s.substring(0, s.length()-4);

				Group_Member2.setText(s); 				
				Group_Member2.setVisible(true); 
			}
			
			if ( List.length > 2+2 ) { 
			
				String s = List[4];
				s = s.substring(0, s.length()-4);

				Group_Member3.setText(s); 				
				Group_Member3.setVisible(true); 
			}
			
			if ( List.length > 3+2 ) { 
			
				String s = List[5];
				s = s.substring(0, s.length()-4);

				Group_Member4.setText(s); 				
				Group_Member4.setVisible(true); 
			}
			
			if ( List.length > 4+2 ) { 
			
				String s = List[6];
				s = s.substring(0, s.length()-4);

				Group_Member5.setText(s); 				
				Group_Member5.setVisible(true); 
			}
		}
	}

}
