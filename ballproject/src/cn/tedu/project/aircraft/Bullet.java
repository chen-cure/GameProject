package cn.tedu.project.aircraft;

import javax.swing.*;

public class Bullet extends FlyObject {

    public Bullet(double x, double y) {
        super(x, y,Images.bullet,null,null);
        this.step = 2.5;
    }

    public Bullet() {
        this.image = new ImageIcon("images/bullet.png");
    }

    @Override
    protected void move() {
        y-=step;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
