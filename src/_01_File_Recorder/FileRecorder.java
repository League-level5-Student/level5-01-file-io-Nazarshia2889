package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRecorder { 
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Write a message to save to the file.");
			String line = scanner.nextLine();
			scanner.close();
			
			FileWriter fw = new FileWriter("src/_01_File_Recorder/text3");
			
			fw.write("Hello");
			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}//Copyright © 2022 Arshia Nayebnazar