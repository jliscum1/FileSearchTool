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

	private ArrayList<File> list;

	public DirectoryTree() {
		this.list = new ArrayList<File>();

	}

	public void GetAllFiles(File dir) {
		if (dir.isDirectory()) {
			for (File file : dir.listFiles()) {
				list.add(file);
				if (file.isDirectory()) {
					GetAllFiles(file);
				}
			}
		}
	}

	public void GetOnlyDirectories(File dir) {
		if (dir.isDirectory()) {
			for (File file : dir.listFiles()) {
				if (file.isDirectory()) {
					list.add(file);
					GetOnlyDirectories(file);
				}
			}
		}
	}

	public void GetOnlyFiles(File dir) {
		if (dir.isDirectory()) {
			for (File file : dir.listFiles()) {
				if (file.isDirectory()) {
					GetOnlyFiles(file);
				} else {
					this.list.add(file);
				}
			}

		}
	}

	public void clearList() {
		this.list.clear();

	}

	public ArrayList<File> getList() {
		return this.list;
	}
}
