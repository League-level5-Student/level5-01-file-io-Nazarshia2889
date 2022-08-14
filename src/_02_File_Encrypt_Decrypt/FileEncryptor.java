package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	
	public static void main(String[] args) {
//		char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a message:");
		String message = scanner.nextLine();
		System.out.println("Enter a key:");
		String key = scanner.nextLine();
		int keyInt = Integer.parseInt(key);
		char[] messageArr = message.toCharArray();
		for(int i = 0; i < messageArr.length; i++) {
			if(messageArr[i] == ' ') {
				continue;
			}
			
			char newChar = (char)((messageArr[i] + keyInt));
			
			if((((messageArr[i] + keyInt) > 90) && (messageArr[i] == Character.toUpperCase(messageArr[i]))) ||
					((messageArr[i] + keyInt) > 122) && (messageArr[i] != Character.toUpperCase(messageArr[i]))) {
				newChar = (char)((messageArr[i] + keyInt) - 26);
			}
			messageArr[i] = newChar;
		}
		scanner.close();
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/encryption.txt");
			fw.write(messageArr);
			
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
