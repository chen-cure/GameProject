package cn.tedu.project.aircraft;

import javax.swing.*;

public class Bigplane extends Plane {

    public Bigplane(double x, double y, double step) {
        super(x, y, Images.bigairplane[0],Images.bigairplane,Images.boom);
        this.step = step;
    }

    public Bigplane() {
        super(Images.bigairplane[0],Images.bigairplane,Images.boom);
//        images = Images.bigairplane;
//        boms = Images.boom;
//        this.image = new ImageIcon("images/bigairplane0.png");
    }

}
