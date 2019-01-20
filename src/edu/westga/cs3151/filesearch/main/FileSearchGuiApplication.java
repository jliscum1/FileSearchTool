package edu.westga.cs3151.filesearch.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FileSearchGuiApplication extends Application  {
	private static final String WINDOW_TITLE = "Project One By Jeremiah Liscum";
	private static final String GUI_FXML = "../view/FileSearchGUI.fxml";

	/**
	 * Constructs a new Application object for the Student Management demo program.
	 * s
	 * @precondition none
	 * @postcondition the object is ready to execute
	 */
	public FileSearchGuiApplication() {
		super();
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane pane = this.loadGui();
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.setTitle(WINDOW_TITLE);
			primaryStage.show();
		} catch (IllegalStateException | IOException anException) {
			anException.printStackTrace();
		}
	}

	private Pane loadGui() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(GUI_FXML));
		return (Pane) loader.load();
	}

	/**
	 * Launches the application.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
