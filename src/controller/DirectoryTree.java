package controller;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 * 
 * Example of recursively descending a directory tree
 * 
 * @author CS3151
 *
 */
public class DirectoryTree {

	private static ArrayList<String> list;
	
	private static void addFiles(File dir) {
		if(dir.isDirectory()) {
			for(File file : dir.listFiles()) {
				list.add(file.getAbsolutePath());
				if(file.isDirectory()) {
					addFiles(file);
				}
			}
		}
	}
	public static void main(String[] arg) {
		
		list = new ArrayList<String>();
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		int value = chooser.showOpenDialog(null);
		
		if(value != JFileChooser.APPROVE_OPTION) {
			return;
		}
		addFiles(chooser.getSelectedFile());
		for(String name : list) {
			System.out.println(name);
		}
		
	}
}
