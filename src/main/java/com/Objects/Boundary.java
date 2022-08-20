package com.Objects;

import lombok.Getter;
import lombok.Setter;
import processing.core.PVector;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
public class Boundary {
    private BoundingPoint ul, ur, dl, dr;
    private List<BoundingPoint> bps;

    public Boundary(PVector pos, PVector size) {
        this.ul = new BoundingPoint(BPType.UL, pos.copy());
        this.dr = new BoundingPoint(BPType.DR, PVector.add(pos, size));
        this.ur = new BoundingPoint(BPType.UR, new PVector(dr.pos.x, ul.pos.y));
        this.dl = new BoundingPoint(BPType.DL, new PVector(ul.pos.x, dr.pos.y));
        bps = (Arrays.asList(ul, ur, dl, dr));
    }

    public boolean containsPoint(PVector p) {
        return ul.pos.x <= p.x && ul.pos.y <= p.y && dr.pos.x >= p.x && dr.pos.y >= p.y;
    }

    public void setBPPos(BPType type, PVector p) {
        p = p.copy();
        switch (type) {
            case UR -> {
                ur.pos.set(p);
                dr.pos.x = p.x;
                ul.pos.y = p.y;

            }
            case DR -> {
                dr.pos.set(p);
                ur.pos.x = p.x;
                dl.pos.y = p.y;
            }
            case UL -> {
                ul.pos.set(p);
                dl.pos.x = p.x;
                ur.pos.y = p.y;
            }
            case DL -> {
                dl.pos.set(p);
                ul.pos.x = p.x;
                dr.pos.y = p.y;
            }
        }
    }

    public void setPos(PVector p) {
        PVector diff = PVector.sub(p, ul.pos);
        ul.pos.add(diff);
        dl.pos.add(diff);
        ur.pos.add(diff);
        dr.pos.add(diff);
    }
}
