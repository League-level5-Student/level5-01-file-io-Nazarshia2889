package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		
		
		JFileChooser jfc = new JFileChooser("/Users/arshianayebnazar/Documents/GitHub");
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File directory = jfc.getSelectedFile();
			File[] files = directory.listFiles();
			if(files != null) {
				for(File f : files) {
				  System.out.println(f.getAbsolutePath());
				  File[] newFiles = f.listFiles();
				  if(newFiles != null) {
					  for(File f2 : newFiles) {
						  String path = f2.getAbsolutePath();
						  if(path.substring(path.length()-4, path.length()).equals("java")) {
							  try {
									FileWriter fw = new FileWriter(path, true);
									fw.write("//Copyright © 2022 Arshia Nayebnazar");
									fw.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
						  }
					  }
				  }
				}
			}
			
		}
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */

		
	}
}
//Copyright © 2022 Arshia Nayebnazar