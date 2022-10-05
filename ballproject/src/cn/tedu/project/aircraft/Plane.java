package cn.tedu.project.aircraft;

import javax.swing.*;
import java.util.Random;

/**
 * Plane是一个中间类
 */
public abstract class Plane extends FlyObject{
    //添加无参构造避免子类继承错误
    public Plane(){
//        x = Math.random()*370;
//        y = -Math.random()*650;
//        step = Math.random()*5+1;
    }

    //根据位置初始化对象数据
    public Plane(double x, double y, ImageIcon image,ImageIcon[] images,ImageIcon[] boms){
        super(x,y,image,images,boms);
    }

    //利用算法实现飞机从屏幕上方随机出现
    public Plane(ImageIcon image , ImageIcon[] images , ImageIcon[] boms ){
        this.image = image;
        this.width = image.getIconWidth();
        this.height = image.getIconHeight();
        Random random = new Random();
        x = random.nextInt(400-(int)width);
        y = -height;
        this.images = images;
        this.boms = boms;
        this.step = Math.random()*3+1;
    }

    @Override
    protected void move() {
        y+=step;
    }
}
