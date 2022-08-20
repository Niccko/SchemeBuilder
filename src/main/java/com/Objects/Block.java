package com.Objects;

import com.GlobalContext;
import com.Utils.Utils;
import lombok.Getter;
import lombok.Setter;
import processing.core.PVector;

import java.awt.Color;
import java.util.Arrays;

@Getter
@Setter
public class Block extends SchemaObject {
    private Color color = Color.BLACK;

    public Block(PVector pos, PVector size) {
        setBoundary(new Boundary(pos, size));
        setPosition(boundary.getUl().pos);
        setSize(size);
    }


    @Override
    public void update() {
        super.update();
    }

    @Override
    public void draw() {
        super.draw();
        GlobalContext.pp.strokeWeight(0);
        GlobalContext.pp.fill(color.getRGB());
        Utils.rect(GlobalContext.pp, boundary.getUl().pos, boundary.getDr().pos);
        if(isSelected()){
            GlobalContext.pp.stroke(255);
            GlobalContext.pp.strokeWeight(8);
            for (BoundingPoint p: boundary.getBps()) {
                GlobalContext.pp.point(p.pos.x, p.pos.y);
            }
        }
    }
}
