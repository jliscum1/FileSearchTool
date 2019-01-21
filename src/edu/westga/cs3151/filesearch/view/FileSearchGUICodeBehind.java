/**
 * 
 */
package edu.westga.cs3151.filesearch.view;

import java.io.File;

import edu.westga.cs3151.filesearch.controller.DirectoryTree;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

	@FXML
	void initialize() {
		this.directoryTree = new DirectoryTree();
	}

	@FXML
	void handleChooseDirectory(ActionEvent event) {
		DirectoryChooser name = new DirectoryChooser();

		File folder = name.showDialog(((Node) event.getTarget()).getScene().getWindow());

		if (folder != null) {
			this.directoryTree.clearList();
			this.directoryTree.addFiles(folder);
			if (fullPathNames.isSelected()) {
				for (String currName : this.directoryTree.getList()) {
					this.fileSearchTextArea.setText(currName);
				}
				
			}
		}

	}

}
