package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
		String message = "";
		try {
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/encryption.txt");
			int c = fr.read();
			while(c != -1) {
				message += (char) c;
				c = fr.read();
			}
			fr.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a key:");
		String key = scanner.nextLine();
		int keyInt = Integer.parseInt(key);
		char[] messageArr = message.toCharArray();
		for(int i = 0; i < messageArr.length; i++) {
			if(messageArr[i] == ' ') {
				continue;
			}
			

			char newChar = (char)((messageArr[i] - keyInt));
			
			if((((messageArr[i] - keyInt) < 65) && (messageArr[i] == Character.toUpperCase(messageArr[i]))) ||
					((messageArr[i] - keyInt) < 96) && (messageArr[i] != Character.toUpperCase(messageArr[i]))) {
				newChar = (char)((messageArr[i] - keyInt) + 26);
			}
			messageArr[i] = newChar;
		}
		scanner.close();
		String result = "";
		for(int i = 0; i < messageArr.length; i++) {
			result += messageArr[i];
		}
		JOptionPane.showMessageDialog(null, result);
	}
}
//Copyright © 2022 Arshia Nayebnazar