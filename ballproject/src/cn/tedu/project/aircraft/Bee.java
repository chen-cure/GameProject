package cn.tedu.project.aircraft;

import javax.swing.*;

public class Bee extends Plane {
    double step;
    public Bee(double x, double y, double step) {
        super(x, y, Images.bee[0], Images.bee,Images.boom);
        this.step = step;
    }

    public Bee() {
        super(Images.bee[0],Images.bee,Images.bee);
//        images = Images.bee;
//        boms = Images.boom;
//        this.image = new ImageIcon("images/bee0.png");
    }
}
