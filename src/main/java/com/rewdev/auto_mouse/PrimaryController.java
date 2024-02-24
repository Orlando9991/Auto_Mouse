package com.rewdev.auto_mouse;

import com.rewdev.auto_mouse.core.MouseMovement;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    private TextField xField;
    
    @FXML
    private TextField yField;
    
    @FXML
    private TextField xInitialField;
    
    @FXML
    private TextField xFinalField;
    
    @FXML
    private TextField yInitialField;
    
    @FXML
    private TextField yFinalField;
    
    @FXML
    private CheckBox mousePressedCheckBox;
    
    @FXML
    private void startMoveTo(){
        boolean isMousePressed = mousePressedCheckBox.isSelected();
        int x = getValueTextField(xField);
        int y = getValueTextField(yField);
        MouseMovement.moveMouseToPosition(new Point2D(x, y), isMousePressed);
    }
    
    @FXML
    private void startMoveFromPosToPos(){
        boolean isMousePressed = mousePressedCheckBox.isSelected();
        int xi = getValueTextField(xInitialField);
        int xf = getValueTextField(xFinalField);
        int yi = getValueTextField(yInitialField);
        int yf = getValueTextField(yFinalField);

        MouseMovement.moveMouseFromPosToPos(new Point2D(xi, yi), new Point2D(xf,yf), isMousePressed);
    }
    
    private int getValueTextField(TextField textField){
        int value = 0;
        if(textField.getLength()>0){
            value = Integer.parseInt(textField.getText());
        }
        return value;
    }
}
