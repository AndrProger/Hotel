package com.example.javaproject.dop;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public  class CSS {
    public static void ButtonEnterChange (Button button){
        button.styleProperty().set("-fx-background-color: #8e8d81");
    }
    public static void ButtonExitedChange (Button button){
        button.styleProperty().set("-fx-background-color: #FFFFFF");
    }
    public static void exitButtonEnterChange (Button button){
        button.styleProperty().set("-fx-background-color: #B22222");
    }
    public static void enterButtonEnterChange (Button button){
        button.styleProperty().set("-fx-background-color: #8c7e7e");
    }
    public static void standTextField(TextField TextField){
        String str="-fx-background-color: #FFFFFF;" +
                "-fx-border-radius: 15;" +
                "-fx-border-color: #BFBFBF";
        TextField.styleProperty().set(str);
    }
    public static void errorTextField (TextField TextField){
        String str="-fx-background-color: #FF9999;" +
                "-fx-border-radius: 0;" +
                "-fx-border-color: #BFBFBF";
        TextField.styleProperty().set(str);
    }
}
