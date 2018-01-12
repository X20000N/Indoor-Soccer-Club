package Extern;

import java.io.FileWriter;

public class SafeGame {
	
	public static void SafeUserFromRegister(String Name) {

		try {
						
			FileWriter fw = new FileWriter("Games/" + Name + ".usr");
			
			fw.write("Gamename" + "\n");
			fw.write("Gameclock" + "\n");

			fw.write("Place" + "\n");
			fw.write("Clock From" + "\n");
			fw.write("Clock To" + "\n");

			fw.write("Member1" + "\n");
			fw.write("Member2" + "\n");
			fw.write("Member3" + "\n");
			fw.write("Member4" + "\n");
			fw.write("Member5" + "\n");
			fw.write("Member6" + "\n");
			fw.write("Member7" + "\n");
			fw.write("Member8" + "\n");
			fw.write("Member9" + "\n");
			fw.write("Member10" + "\n");
			
			fw.close();
			
		} catch (Exception e) { System.out.println("Error"); }
		
	}
}
