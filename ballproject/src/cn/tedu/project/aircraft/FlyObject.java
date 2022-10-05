package cn.tedu.project.aircraft;

import javax.swing.*;
import java.awt.*;

/**
 * 飞机类
 */
public abstract class FlyObject {
    protected double x,y,width,height;
    protected double step;
    /**
     * image--每个子类的图片属性
     * images--当前对象的动画珍图片属性
     *  如果没有动画帧，则这个属性为null，比如：天空，
     * boms--爆炸图片
     */
    protected ImageIcon image;
    protected ImageIcon[] images;
    protected ImageIcon[] boms;
    protected int index = 0;

    protected FlyObject(double x, double y,ImageIcon image,ImageIcon[] images,ImageIcon[] boms) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.images = images;
        this.boms = boms;
        this.width = image.getIconWidth();
        this.height = image.getIconHeight();
    }

    protected FlyObject() {
//        x = Math.random()*370;
//        y = Math.random()*650;
//        step = Math.random()*(5-1)+1;
    }

    //移动方法
    protected abstract void move();

    //绘制方法
    public void paint(Graphics g){
        nextImage();
        image.paintIcon(null,g,(int)x,(int)y);
    }

    //定义动画切换的
    public void nextImage(){
        if (images ==null)
            return;
//        System.out.println(index+","+(index% images.length));
        image = images[(index++/20)% images.length];
    }



    @Override
    public String toString() {
        String className = getClass().toString();
        return className+"{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", step=" + step +
                '}';
    }
}
