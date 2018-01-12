package Paket;

import java.io.BufferedReader;
import java.io.FileReader;

import Extern.SafeUser;

public class User {
	
	public static boolean Login = false;
		
	public static int Side_ID = 1000;
	
	public static int CurrentSideNumber = 0;
	public static int[] OpenSides = new int[1000];
	
	public static String[] User_Data = new String[99];
	
	public static boolean InGroup = false;
	public static boolean PlayGame = false;
	public static String[] User_Group = new String[6];
	
	// User_Data:
	// 0 = PW
	// 1 = ID
	// 2 = Lastname
	// 3 = Firstname
	// 4 = Place
	// 5 = Town
	// 6 = FirstData
	// 7 = Gamenumbers

	// User_Goup:
	// 0 = GroupName
	// 1 = Member1
	// 2 = Member2
	// 3 = Member3
	// 4 = Member4
	// 5 = Member5
	
	public User() {
		
		CurrentSideNumber = 0;
		OpenSides[CurrentSideNumber] = 1000;
	}
	
	public static void ReadUser(String Secondname) {

		try {
		
			FileReader fr = new FileReader("Users/" + Secondname + ".usr");
			BufferedReader br = new BufferedReader(fr);

			for(int i=0; i<99; i++) { User.User_Data[i] = br.readLine(); }
			
			fr.close();
			br.close();
		
		} catch (Exception e) { }
	}
	
	public static void EscapeGroup() {
		
		for(int i=0; i<6; i++) {
			
			User_Group[i] = "";
		}
	}
	
	public static void SetNewSide(int Number) {
		
		if ( CurrentSideNumber < 1000 ) {
			
			CurrentSideNumber++;
			OpenSides[CurrentSideNumber] = Number;
		}		
	}
	
	public static void UpdatePlayGames() {
		
		int i = Integer.parseInt(User_Data[7]);
		i++;

		User_Data[7] = i + "";
		SafeUser.SafeUserFromEdit();
		
		String file = "Users/" + User.User_Data[2] + ".usr";			
		StartLayout.UploadFile(file, file);
	}

}
