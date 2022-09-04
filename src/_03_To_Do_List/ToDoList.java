package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JButton addTask = new JButton();
	JButton viewTask = new JButton();
	JButton removeTask = new JButton();
	JButton saveList = new JButton();
	JButton loadList = new JButton();
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	
	public void run() {
		ArrayList<String> tasks = new ArrayList<String>();
		String location = "src/_03_To_Do_List/todolist.txt";
		try {
			FileReader fr = new FileReader(location);
			int c = fr.read();
			ArrayList<Character> arr = new ArrayList<Character>();
			while(c != -1) {
				arr.add((char) c);
				c = fr.read();
			}
			fr.close();
			String result = "";
			for(char let : arr) {
				if(let == ' ' ) {
					tasks.add(result);
					result = "";
				}
				else {
					result += let;
				}
			}
			System.out.println("Last saved tasks: " + result);
		}
		catch(FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch(IOException e2) {
			e2.printStackTrace();
		}
	
		addTask.addActionListener(e -> {
			String task = JOptionPane.showInputDialog("Input a task: ");
			tasks.add(task);
		});
		viewTask.addActionListener(e -> {
			for(String task : tasks) {
				System.out.println(task);
			}
		});
		removeTask.addActionListener(e -> {
			String input = JOptionPane.showInputDialog("What index task do you want to remove?");
			int index = Integer.parseInt(input);
			tasks.remove(index);
		});
		saveList.addActionListener(e -> {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/todolist.txt");
				for(String task: tasks) {
					fw.write(task);
					fw.write("\n");
				}
				fw.close();
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		loadList.addActionListener(e -> {
			String location = JOptionPane.showInputDialog("Input the location of the file you want to retrieve: ");
			try {
				FileReader fr = new FileReader(location);
				int c = fr.read();
				ArrayList<Character> arr = new ArrayList<Character>();
				while(c != -1) {
					arr.add((char) c);
					c = fr.read();
				}
				fr.close();
				String result = "";
				for(char let : arr) {
					result += let;
				}
				System.out.println(result);
			}
			catch(FileNotFoundException e1) {
				e1.printStackTrace();
			}
			catch(IOException e2) {
				e2.printStackTrace();
			}
		});
		
		frame.add(panel);
		addTask.setText("Add a task");
		viewTask.setText("View tasks");
		removeTask.setText("Remove Tasks");
		saveList.setText("Save tasks");
		loadList.setText("Load tasks");
		panel.add(addTask);
		panel.add(viewTask);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		frame.setVisible(true);
	}

}
