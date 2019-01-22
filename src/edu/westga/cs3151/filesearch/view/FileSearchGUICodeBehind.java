/**
 * 
 */
package edu.westga.cs3151.filesearch.view;

import java.io.File;

import edu.westga.cs3151.filesearch.controller.DirectoryTree;
import edu.westga.cs3151.filesearch.formatter.OutPutFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.DirectoryChooser;

/**
 * @author Jeremiah Liscum
 *
 */
public class FileSearchGUICodeBehind {
	@FXML
	private Button chooseDirectoryButton;

	@FXML
	private TextField patternMatchTextFlied;

	@FXML
	private RadioButton selectAllRadioButton;

	@FXML
	private RadioButton directoriesOnlyRadioButton;

	@FXML
	private RadioButton filesOnlyRadioButton;

	@FXML
	private RadioButton onlyFilesNamesRadioButton;

	@FXML
	private RadioButton fullPathNames;
	@FXML
	private TextArea fileSearchTextArea;
	private DirectoryTree directoryTree;
	private OutPutFormatter outPutFormatter;

	@FXML
	void initialize() {
		this.directoryTree = new DirectoryTree();
		this.outPutFormatter = new OutPutFormatter();
		this.setUpToggleGroupOne();
		this.setUpToggleGroupTwo();

	}

	private void setUpToggleGroupTwo() {
		ToggleGroup groupTwo = new ToggleGroup();
		this.onlyFilesNamesRadioButton.setToggleGroup(groupTwo);
		this.fullPathNames.setToggleGroup(groupTwo);
	}

	private void setUpToggleGroupOne() {
		ToggleGroup groupOne = new ToggleGroup();
		this.selectAllRadioButton.setToggleGroup(groupOne);
		this.directoriesOnlyRadioButton.setToggleGroup(groupOne);
		this.filesOnlyRadioButton.setToggleGroup(groupOne);
	}

	@FXML
	void handleChooseDirectory(ActionEvent event) {

		DirectoryChooser name = new DirectoryChooser();

		File folder = name.showDialog(((Node) event.getTarget()).getScene().getWindow());

		if (folder != null) {
			this.directoryTree.clearList();
			if (this.patternMatchTextFlied.getText().isEmpty()) {
				this.radioButtonSelectionForGroupOne(folder);
				this.fileSearchTextArea.setText(this.outPut());
			}
			if (!this.patternMatchTextFlied.getText().isEmpty()) {
				this.radioButtonSelectionForGroupOne(folder);
				this.fileSearchTextArea.setText(this.outPutForSearch());
			}
		}

	}

	private void radioButtonSelectionForGroupOne(File folder) {

		if (this.selectAllRadioButton.isSelected()) {
			this.directoryTree.GetAllFiles(folder);
		}
		if (this.directoriesOnlyRadioButton.isSelected()) {
			this.directoryTree.GetOnlyDirectories(folder);
		}
		if (this.filesOnlyRadioButton.isSelected()) {
			this.directoryTree.GetOnlyFiles(folder);
		}

	}

	private String outPut() {
		String outPut = "";
		if (this.onlyFilesNamesRadioButton.isSelected()) {
			outPut = this.outPutFormatter.outPutForOnlyFileNames(this.directoryTree.getList());

		} else {
			outPut = this.outPutFormatter.outPutForFullPathNames(this.directoryTree.getList());
		}
		return outPut;

	}

	private String outPutForSearch() {
		String outPut = "";
		File file = new File(this.patternMatchTextFlied.getText());
		if (this.onlyFilesNamesRadioButton.isSelected()) {

			outPut = this.outPutFormatter.outPutForOnlyFileNamesAndSearchArea(this.directoryTree.getList(), file);

		} else {

			outPut = this.outPutFormatter.outPutForOnlyFullPathsAndSearchArea(this.directoryTree.getList(), file);
		}
		return outPut;
	}

}
