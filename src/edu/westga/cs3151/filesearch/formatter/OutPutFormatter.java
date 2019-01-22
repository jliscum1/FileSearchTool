package edu.westga.cs3151.filesearch.formatter;

import java.io.File;
import java.util.List;

/*
 * 
 */
public class OutPutFormatter {
	
	public String outPutForOnlyFileNames(List<File> list) {
		String outPut = "";
		for(File currFile : list) {
			outPut += currFile.getName() + System.lineSeparator();
		}
		
		return outPut;
	}
	public String outPutForFullPathNames(List<File> list) {
		String outPut = "";
		for(File currFile : list) {
			outPut += currFile.getAbsolutePath() + System.lineSeparator();
		}
		return outPut;
	}
	
	

}
