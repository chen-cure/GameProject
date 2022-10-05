package cn.tedu.project.aircraft;

import javax.swing.*;
import java.awt.*;

public class Sky extends FlyObject {
    /**
     *
     */
    private double y0;
    public Sky() {
        super(0,0,Images.sky,null,null);
        this.step = 0.8;
        y0 = -height;
    }

//    public Sky() {
//
//    }

    @Override
    protected void move() {
        y+=step;
        y0+=step;
        if (y>=height){
            y=-y;
        }
        if (y0>=height){
            y0=-y0;
        }
    }

    @Override
    public void paint(Graphics g) {
        image.paintIcon(null,g,(int)x,(int)y);
        image.paintIcon(null,g,(int)x,(int)y0);
    }
}
