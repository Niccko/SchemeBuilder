package com.EventManager;

import processing.core.PVector;

import processing.event.MouseEvent;

public class InputHandler{
    public static boolean mousePressed;
    public static boolean mouseClicked;
    public static boolean mouseDragged;
    public static boolean mouseMoved;
    public static boolean mouseReleased;
    public static PVector mousePos = new PVector(0,0);
    public static PVector dragStartPos = new PVector(0,0);

    public static void MousePressed(MouseEvent e) {
        mousePressed = true;
        mouseClicked = true;
        mousePos.x = e.getX();
        mousePos.y = e.getY();
        dragStartPos.x = e.getX();
        dragStartPos.y = e.getY();
    }

    public static void MouseReleased(MouseEvent e){
        mousePos.x = e.getX();
        mousePos.y = e.getY();
        mouseReleased = true;
        mousePressed = false;
        mouseDragged = false;
    }

    public static void MouseClicked(MouseEvent e){
        mousePos.x = e.getX();
        mousePos.y = e.getY();

    }

    public static void MouseMoved(MouseEvent e){
        mousePos.x = e.getX();
        mousePos.y = e.getY();
        mouseMoved = true;
    }

    public static void MouseDragged(MouseEvent e){
        mousePos.x = e.getX();
        mousePos.y = e.getY();
        mouseDragged = true;

    }

    public static void update(){
        mouseClicked = false;
        mouseMoved = false;
        mouseReleased = false;
    }


}
