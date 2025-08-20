package com.jellerijk.aoc.aoc2017;

import com.jellerijk.aoc.aoc2017.launcher.gui.MainScreen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// To Run: mvn clean javafx:run
public class App extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainScreen root = new MainScreen();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("AOC 17 launcher");
		primaryStage.show();
	}

}
