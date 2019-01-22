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
	public String outPutForOnlyFileNamesAndSearchArea(List<File> list, File fileToSearchBy) {
		String outPut = "";
		for(File currFile: list) {
			if(currFile.getName().equals(fileToSearchBy.getName())) {
				outPut = currFile.getName();
			}
		}
		if(outPut.isEmpty()) {
			outPut = "Look somewhere else bud it ain't here";
		}
		
		
		return outPut;
	}
	public String outPutForOnlyFullPathsAndSearchArea(List<File> list, File fileToSearchBy) {
		String outPut = "";
		for(File currFile: list) {
			if(currFile.getAbsolutePath().equals(fileToSearchBy.getAbsolutePath())) {
				outPut = currFile.getAbsolutePath();
			}
		}
		if(outPut.isEmpty()) {
			outPut = "I told you it's not here maybe it's out yonder";
		}
		return outPut;
	}
	
	

}
