package cn.tedu.project.ballproject;

import cn.tedu.util.App;

import java.awt.*;
import java.util.Random;

public class BallDemo extends App {
    Random random = new Random();
//    int[] c = new int[3];
//    public int[] color(){
//        for (int i = 0; i < 3; i++) {
//            c[i] = random.nextInt(256);
//        }
//        return c;
//    }
    //生成颜色的随机数
    int c1 = random.nextInt(256);
    int c2 = random.nextInt(256);
    int c3 = random.nextInt(256);
    //直径
    int d = (int)(Math.random()*(60-10)+10);
    //小球移动的距离
    double x= (int)(Math.random()*(800-d));
    double y= (int)(Math.random()*(600-d));
    //移动速度
    double setX= Math.random()*(6-1)+1;
    double setY= Math.random()*(6-1)+1;
    {
        setX = Math.random()>0.5 ? setX : -setX;
        setY = Math.random()>0.5 ? setY : -setY;
    }

    //小球移动轨迹
    public void move(){
        x+=setX;
        y+=setY;
        if (x>800-d){
            setX=-setX;
        }
        else if (x<0){
            setX=-setX;
        }else if (y<0){
            setY=-setY;
        }else if (y>600-d){
            setY=-setY;
        }
    }

    public static void main(String[] args) {
        BallDemo ballDemo = new BallDemo();
        ballDemo.start();
    }

    //绘制
    @Override
    public void painting(Graphics2D g){

        //设置颜色
//        color();
        g.setColor(new Color(c1,c2,c3));
        //斜向下移动
        move();
//        x+=setX;
//        y+=setY;
//        if (x>800-d){
//            setX=-setX;
//        }
//        else if (x<0){
//            setX=-setX;
//        }else if (y<0){
//            setY=-setY;
//        }else if (y>600-d){
//            setY=-setY;
//        }




        //绘制小球
        g.fillOval((int)x,(int)y,d,d);

    }
}
