package com.example.currencyconverter;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class Controller {


    @FXML
    private Label myLabel;

    @FXML
    private TextField amountToConvert;

    @FXML
    private ChoiceBox<String> fromCurrency;

    @FXML
    private ChoiceBox<String> toCurrency;

    private float getAmountToConvert;
    private String getFromCurrency;
    private String getToCurrency;
    String convertedAmount;
    String setCurrency = "";

    @FXML
    protected void convert() {
        String amount = amountToConvert.getText();
        if(amount.isEmpty()){
            myLabel.setText("0");
        }

        if(isNumeric(amount)){

            if(!amount.isEmpty()){
                getAmountToConvert = Float.parseFloat(amountToConvert.getText());
            }

            if(!fromCurrency.getValue().isEmpty()){
                getFromCurrency = fromCurrency.getValue();
            }

            if(!toCurrency.getValue().isEmpty()){
                getToCurrency = toCurrency.getValue();
            }

            DecimalFormat dc = new DecimalFormat();
            dc.setMaximumFractionDigits(1);
            if(getToCurrency.equals("USD")){
                convertedAmount = dc.format(getAmountToConvert*0.1563);
                setCurrency = "$";
            }
            if(getToCurrency.equals("EUR")){
                convertedAmount = dc.format(getAmountToConvert/7.46);
                setCurrency = "€";
            }

            if(getToCurrency.equals("INR")){
                convertedAmount = dc.format(getAmountToConvert*13.47);
                setCurrency = "₹";
            }

            myLabel.setText(setCurrency + convertedAmount);
        }
    }

    public boolean isNumeric(String i){
        try{
            Float.parseFloat(i);

            return true;
        }catch (NumberFormatException e){
            return false;
        }
    };
}