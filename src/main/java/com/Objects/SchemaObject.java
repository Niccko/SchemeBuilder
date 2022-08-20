package com.Objects;

import com.EventManager.InputHandler;
import com.GlobalContext;
import lombok.Data;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
public abstract class SchemaObject {
    protected boolean isSelected = false;
    protected PVector position = new PVector(0, 0);
    protected List<BoundingPoint> boundaryPoints = new ArrayList<>();
    protected PVector size = new PVector(0, 0);
    protected Boundary boundary = new Boundary(new PVector(0, 0), new PVector(0, 0));

    private PVector selectDiffPos = new PVector(0, 0);
    private boolean isDrag = false;
    private boolean isResize = false;

    public void update() {
        if (InputHandler.mouseClicked) {
            onClick();
        }
        if (InputHandler.mouseDragged) {
            onDrag();
        }
        if (InputHandler.mouseReleased) {
            onRelease();
        }
    }

    ;

    protected void onClick() {
        if (boundary.containsPoint(InputHandler.mousePos)) {
            setSelected(!isSelected);
            selectDiffPos = PVector.sub(position, InputHandler.dragStartPos);
            isDrag = true;
        } else if (!isDrag) {
            setSelected(false);
        }
        BoundingPoint point = getNearestBP(InputHandler.mousePos);
        if (PVector.dist(InputHandler.mousePos, point.pos) < 5) {
            setSelected(true);
            isDrag = false;
            isResize = true;
        }
    }

    protected void onDrag() {
        if (isResize) {
            BoundingPoint point = getNearestBP(InputHandler.mousePos);
            boundary.setBPPos(point.type, InputHandler.mousePos);
        }

        if (isDrag && !isResize) {
            setPosition(PVector.add(InputHandler.mousePos, selectDiffPos));
        }
    }

    protected void onRelease() {
        isDrag = false;
        isResize = false;
    }

    private BoundingPoint getNearestBP(PVector p) {
        return boundary.getBps().stream()
                .min((o1, o2) -> (int) (PVector.dist(p, o1.getPos()) - PVector.dist(p, o2.getPos()))).get();
    }

    public void setPosition(PVector p) {
        PVector diff = PVector.sub(p, position);
        for (BoundingPoint bp : boundaryPoints) {
            bp.pos.add(diff);
        }
        //TODO Возможно поменять boundary чтобы не создавать новый вектор
        boundary.setPos(PVector.add(boundary.getUl().getPos(), diff));
        position.add(diff);
    }

    public void draw() {

    }

}
