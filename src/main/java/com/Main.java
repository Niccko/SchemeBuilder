package com;

import com.EventManager.InputHandler;
import com.Objects.Block;
import com.Objects.SchemaObject;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class Main extends PApplet {
    private boolean canSpawn = true;
    private List<SchemaObject> objects = new ArrayList<>();

    public void settings() {
        size(1280, 720);
        GlobalContext.initContext(this);
    }

    @Override
    public void setup() {
        super.setup();
        objects.add(new Block(new PVector(0, 0), new PVector(100, 200)));
    }

    public void draw(){
        background(64);
        text(frameRate, width - 40, 20);
        for (SchemaObject obj: objects) {
            obj.draw();
            obj.update();

        }


        InputHandler.update();
    }

    @Override
    public void mousePressed(MouseEvent event) {
        super.mouseClicked();
        InputHandler.MousePressed(event);
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        super.mouseClicked();
        InputHandler.MouseClicked(event);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        super.mouseReleased();
        InputHandler.MouseReleased(event);
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        super.mouseDragged(event);
        InputHandler.MouseDragged(event);
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        super.mouseMoved();
        InputHandler.MouseMoved(event);
    }

    public void switchControl(){
        canSpawn = !canSpawn;
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "com.Main" };
        PApplet.main(appletArgs);
    }
}