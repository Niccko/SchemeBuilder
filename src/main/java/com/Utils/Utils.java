package com.Utils;

import processing.core.PApplet;
import processing.core.PVector;

public class Utils {
    public static void lineVector(PApplet pp,PVector a, PVector b){
        pp.line(a.x, a.y, b.x, b.y);
    }

    public static void rect(PApplet p, PVector ul, PVector dr){
        PVector size = PVector.sub(dr, ul);
        p.rect(ul.x, ul.y, size.x, size.y);
    }
}
