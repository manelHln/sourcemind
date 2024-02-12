package com.example.javafxdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CalculatorApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("calculator.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setResizable(false);
        stage.setTitle("Simple Calculator");
        stage.setScene(scene);
        stage.show();
    }
}