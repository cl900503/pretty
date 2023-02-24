package com.dragon.pretty.elastisearch.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

	@FXML
	private TextField mainTextField;

	@FXML
	private TextArea mainTextArea;

	@FXML
	private void connect() {
		System.out.println("hello world");
		String address = mainTextField.getText();
		System.out.println(address);
	}

}
