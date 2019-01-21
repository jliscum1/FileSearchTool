package edu.westga.cs3151.filesearch.controller;

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

	private ArrayList<String> list;
	private ArrayList<String> listOfFiles;

	public DirectoryTree() {
		this.list = new ArrayList<String>();
		

	}

	public void addFiles(File dir) {
		if (dir.isDirectory()) {
			for (File file : dir.listFiles()) {
				this.list.add(file.getAbsolutePath());
				if (file.isDirectory()) {
					addFiles(file);
				}
			}
		}
		
	}

	public void clearList() {
		this.list.clear();

	}
	
	public ArrayList<String> getList() {
		return this.list;
	}
}
