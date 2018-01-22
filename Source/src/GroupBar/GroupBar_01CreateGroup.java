package GroupBar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Paket.StartLayout;
import Paket.User;

public class GroupBar_01CreateGroup implements ActionListener {
	
	static JInternalFrame Group_Create = new JInternalFrame("Gruppe erstellen", false, true, false, false);
	private JLabel Group_Internal_Background = new JLabel();
	
	private JLabel Group_CreateGroup_Lab = new JLabel();
	private JButton Group_CreateGroup_But = new JButton();
	private static JTextField Group_CreateGroup_Tf = new JTextField();

	static JLabel Group_CreateInfo = new JLabel();

	public GroupBar_01CreateGroup() {
		
		// Labels
		
		Group_Internal_Background.setBounds(0,0,2000,2000);
		Group_Internal_Background.setOpaque(true);
		Group_Internal_Background.setBackground(new Color(224,226,224));
		
		Font Font_label = new Font("Arial", Font.BOLD, 20);

		Group_CreateGroup_Lab.setText("Gruppenname:");
		Group_CreateGroup_Lab.setBounds(10,10,250,50);
		Group_CreateGroup_Lab.setFont(Font_label);
		
		Group_CreateInfo.setBounds(10,100,400,50);
		Group_CreateInfo.setFont(Font_label);
		
		// Textfield
		
		Font Font_testfield = new Font("Arial", Font.BOLD, 20);
		
		Group_CreateGroup_Tf.setBounds(180,15,220,40);
		Group_CreateGroup_Tf.setFont(Font_testfield);

		// InternalFrame
		
		Group_Create.setBounds(30,30,420,150);
	//	try { Group_Create.setMaximum(true); } catch (Exception e) { }
		Group_Create.setVisible(false);

		// Buttons

		Font Font_button = new Font("Arial", Font.BOLD, 18);

		Group_CreateGroup_But.setText("Gruppe erstellen");
		Group_CreateGroup_But.addActionListener(this);
		Group_CreateGroup_But.setBackground(new Color(167,210,168));
		Group_CreateGroup_But.setBounds(10, 65, 230, 35);
		Group_CreateGroup_But.setFont(Font_button);
		
		// Layout

		StartLayout.Mainground.add(Group_Create);
		Group_Create.add(Group_Internal_Background);

		Group_Internal_Background.add(Group_CreateGroup_Lab);
		Group_Internal_Background.add(Group_CreateGroup_But);
		Group_Internal_Background.add(Group_CreateGroup_Tf);

		Group_Internal_Background.add(Group_CreateInfo);
	}

	static void OpenSide() {

		Group_Create.setLocation(30,30);
		Group_Create.setVisible(true);
		
		Group_CreateGroup_Tf.setBackground(new Color(255,255,255));
		Group_CreateInfo.setText("");
	}
	
	static void CloseSide() {
		
		Group_Create.setVisible(false);
		GroupBar_02EnterGroup.Group_Enter.setVisible(false);
	}
		
	public void actionPerformed(ActionEvent e) {

		if ( e.getSource() == Group_CreateGroup_But ) {
						
			Group_CreateGroup_Tf.setBackground(new Color(255,255,255));
			
			if ( !Group_CreateGroup_Tf.getText().equals("") &&
					Group_CreateGroup_Tf.getText().length() < 14 ) {
				
				// Create Gruppe
				StartLayout.CreateDir("Groups/" + Group_CreateGroup_Tf.getText());
				Group_CreateInfo.setText("Gruppe wurde erstellt");
				
				// Enter Group 
				User.User_Group[0] = Group_CreateGroup_Tf.getText();
				GroupBar_02EnterGroup.Check_Group(User.User_Group[0]);
				
				CloseSide();
				GroupBar_02EnterGroup.CloseSide();
				
			} else { 
				
				Group_CreateGroup_Tf.setBackground(new Color(200,0,10));
			}
		}
		
	}
}
