package GroupBar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.*;

import Paket.StartLayout;
import Paket.User;

public class GroupBar_02EnterGroup implements ActionListener {

	static JInternalFrame Group_Enter = new JInternalFrame("Gruppe beitreten", false, true, false, false);
	private static JLabel Group_Internal_Background = new JLabel();

	private static JLabel Group_EnterGroup_Lab = new JLabel();
	private static JButton Group_EnterGroup_But = new JButton();
	private static JComboBox<String> Group_EnterGroup_Box = new JComboBox<>();
	
	private static JLabel Group_EnterInfo = new JLabel();

	static String[] List = null;
	
	public GroupBar_02EnterGroup() {
		
		// Labels
		
		Group_Internal_Background.setBounds(0,0,2000,2000);
		Group_Internal_Background.setOpaque(true);
		Group_Internal_Background.setBackground(new Color(224,226,224));
		
		Font Font_label = new Font("Arial", Font.BOLD, 20);

		Group_EnterGroup_Lab.setText("Gruppenname:");
		Group_EnterGroup_Lab.setBounds(10,10,250,50);
		Group_EnterGroup_Lab.setFont(Font_label);
		
		Group_EnterInfo.setBounds(10,100,400,50);
		Group_EnterInfo.setFont(Font_label);
		
		// ComboBox
		
		Font Font_combobox = new Font("Arial", Font.BOLD, 20);
		
		Group_EnterGroup_Box.setBounds(180,15,220,40);
		Group_EnterGroup_Box.setFont(Font_combobox);

		// InternalFrame
		
		Group_Enter.setBounds(30,200,420,150);
	//	try { Group_Enter.setMaximum(true); } catch (Exception e) { }
		Group_Enter.setVisible(false);

		// Buttons

		Font Font_button = new Font("Arial", Font.BOLD, 18);

		Group_EnterGroup_But.setText("Gruppe beitreten");
		Group_EnterGroup_But.addActionListener(this);
		Group_EnterGroup_But.setBackground(new Color(167,210,168));
		Group_EnterGroup_But.setBounds(10, 65, 230, 35);
		Group_EnterGroup_But.setFont(Font_button);
		
		// Layout

		StartLayout.Mainground.add(Group_Enter);
		Group_Enter.add(Group_Internal_Background);

		Group_Internal_Background.add(Group_EnterGroup_Lab);
		Group_Internal_Background.add(Group_EnterGroup_But);
		Group_Internal_Background.add(Group_EnterGroup_Box);

		Group_Internal_Background.add(Group_EnterInfo);
		
	}

	static void OpenSide() {

		Group_Enter.setLocation(30,200);
		Group_Enter.setVisible(true);
		
		Group_EnterInfo.setText("");
		
		List = StartLayout.getFiles("Groups/", List, 0);
		
		Group_EnterGroup_Box.removeAllItems();
		
		for(int i=2; i<List.length; i++) {
			
			Group_EnterGroup_Box.addItem(List[i]); 
		}
	}
	
	static void CloseSide() {
		
		Group_Enter.setVisible(false);		
		GroupBar_01CreateGroup.Group_Create.setVisible(false);
	}
	
	static void Check_Group(String Group_Name) {
		
		List = StartLayout.getFiles("Groups/" + Group_Name, List, 4);
		
		if ( List.length < 7 ) {
			
			Enter_Group(Group_Name);
		}
	}
	
	static void Enter_Group(String Group_Name) {
				
		File f = new File("Groups/" + Paket.User.User_Data[2] + ".txt");
		
		try {
		
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("");
			
			bw.close();
			fw.close();
			
			StartLayout.UploadFile("Groups/" + Group_Name + "/" + Paket.User.User_Data[2] + ".txt", f.getPath());
			
			GroupBar_Layout.Start_Reloader();
			
		} catch (Exception e) { }
	}

	public void actionPerformed(ActionEvent e) {

		if ( e.getSource() == Group_EnterGroup_But ) {
				
			GroupBar_Layout.Escape_Group(); 
			
			User.User_Group[0] = (String) Group_EnterGroup_Box.getSelectedItem();
						
			GroupBar_02EnterGroup.Check_Group(User.User_Group[0]);
			
			CloseSide();
			GroupBar_01CreateGroup.CloseSide();
		}
	}
}
