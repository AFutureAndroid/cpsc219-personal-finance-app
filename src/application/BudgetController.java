package application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BudgetController {
	Stage applicationStage;

    @FXML
    private TextField expAmount;

    @FXML
    private TextField note;

    @FXML
    private Label bdgDisplay;

    @FXML
    private Label balDisplay;

    @FXML
    private ChoiceBox<String> expType;

    @FXML
    private Label expDisplay;

    @FXML
    private TextField budget;
    
    private ExpenseEntry exp;
    
//    private ExpEntry e;
//    private ExpHis h;
//    
//    BudgetController() {
//    	e = new ExpEntry();
//    	h = new ExpHis();
//    }

    @FXML
    void getExpHistory(ActionEvent expHistoryEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	VBox expHistoryBox = new VBox();
    	Label expHistoryLabel = new Label("Expenese History");
    	
    	Button returnButton = new Button("Go Back");
    	returnButton.setOnAction(returnEvent -> applicationStage.setScene(mainScene));
    	
    	
    	expHistoryBox.getChildren().addAll(expHistoryLabel, returnButton);
    	Scene expHistoryScene = new Scene(expHistoryBox);
    	applicationStage.setScene(expHistoryScene);
    }
    
    @FXML
    void enterBudget(ActionEvent bdgEnterEvent) {
    	double currentBal = 0.0;
    	double money = Double.parseDouble(budget.getText());
    	currentBal = money;
    	bdgDisplay.setText(String.format("$%.2f", currentBal));
    	balDisplay.setText(String.format("$%.2f", currentBal));
    }
    
    @FXML
    void addExpense(ActionEvent addExpEvent) {
    	String t = expType.getValue();
    	String n = note.getText();
    	String a = expAmount.getText();
    	
    	System.out.println("Entry: " + t + "\t" + n + "\t" + a);
    }
    
//    e.setType()

}

