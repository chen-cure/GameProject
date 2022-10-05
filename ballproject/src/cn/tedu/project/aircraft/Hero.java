package cn.tedu.project.aircraft;

import javax.swing.*;

public class Hero extends FlyObject {

    public Hero(double x, double y) {
        super(x, y, Images.hero[0],Images.hero,Images.boom);
    }

    public Hero() {
//        images = Images.hero;
//        boms = Images.boom;
    }

    /**
     * 移动方法
     * @param x 鼠标位置X
     * @param y 鼠标位置Y
     */
    void move(int x, int y) {
        this.x = x-width/2;
        this.y = y-height/2;
//        this.x = x;
//        this.y = y;
    }

    //子弹发射方法
    /**
     *
     * @return
     */
    public Bullet fire(){
        //找到子弹的坐标
        double x = this.x+width/2-5;
        double y = this.y-20;
        return  new Bullet(x,y);
    }

    @Override
    protected void move() {

    }
}
