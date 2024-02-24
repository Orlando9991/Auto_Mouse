/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rewdev.auto_mouse.core;
import javafx.scene.robot.Robot;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseButton;
/**
 *
 * @author orlan
 */
public class MouseMovement {
    
    private MouseMovement(){}
    
    public static void moveMouseToPosition(Point2D finalPosition, boolean isMousePressed){
        Robot robot = new Robot();        
        moveMouse(robot, finalPosition, isMousePressed);
    }
    
    public static void moveMouseFromPosToPos(Point2D initialPosition, Point2D finalPosition, boolean isMousePressed){
        Robot robot = new Robot();
        robot.mouseMove(initialPosition);
        moveMouse(robot, finalPosition, isMousePressed);
    }
    
    private static void moveMouse(Robot robot, Point2D finalPosition, boolean isMousePressed){
        double currentX = Math.round(robot.getMousePosition().getX());
        double currentY = Math.round(robot.getMousePosition().getX());
        double finalX = Math.round(finalPosition.getX());
        double finalY = Math.round(finalPosition.getY());
        
        if(isMousePressed){
            robot.mousePress(MouseButton.PRIMARY);
        }
        
        try {
            while (currentX != finalX && currentY != finalY) {
                currentX = currentX>finalX? currentX-1 : currentX+1;
                currentY = currentY>finalY? currentY-1 : currentY+1;
                robot.mouseMove(new Point2D(currentX, currentY));
                Thread.sleep(30);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }finally{
            if(isMousePressed){
                robot.mouseRelease(MouseButton.PRIMARY);
            }
        }
    }
    
}
