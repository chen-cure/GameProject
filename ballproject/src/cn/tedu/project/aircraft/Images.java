package cn.tedu.project.aircraft;

import javax.swing.*;

/**
 * 用于加载飞机大战中所有图片资源
 * 定义静态变量
 * 1.单张图片利用静态变量
 * 2.多张你图片利用静态数据来存储
 * 定义静态代码块来给属性赋值
 */
public class Images {
    public static ImageIcon[] airplane;
    public static ImageIcon[] bee;
    public static ImageIcon[] bigairplane;
    public static ImageIcon[] boom;
    public static ImageIcon[] hero;
    public static ImageIcon start;
    public static ImageIcon pause;
    public static ImageIcon sky;
    public static ImageIcon gameover ;
    public static ImageIcon bullet;
    static {
        airplane = new ImageIcon[2];
        for (int i = 0; i < airplane.length; i++) {
            airplane[i] = new ImageIcon("images/airplane"+i+".png");
        }
        bigairplane = new ImageIcon[2];
        for (int i = 0; i < bigairplane.length; i++) {
            bigairplane[i] = new ImageIcon("images/bigairplane"+i+".png");
        }
        bee = new ImageIcon[2];
        for (int i = 0; i < bee.length; i++) {
            bee[i] = new ImageIcon("images/bee"+i+".png");
        }
        boom = new ImageIcon[4];
        for (int i = 0; i < boom.length; i++) {
            boom[i] = new ImageIcon("images/bom"+(i+1)+".png");
        }
        hero = new ImageIcon[2];
        for (int i = 0; i < hero.length; i++) {
            hero[i] = new ImageIcon("images/hero"+i+".png");
        }
        start = new ImageIcon("images/start.png");
        pause = new ImageIcon("images/pause.png");
        sky= new ImageIcon("images/background.png");
        gameover = new ImageIcon("images/gameover.png");
        bullet = new ImageIcon("images/bullet.png");
    }

    public static void main(String[] args) {
        for (int i = 0; i < airplane.length; i++) {
            System.out.println("小敌机"+airplane[i].getImageLoadStatus());
        }
        for (int i = 0; i < bigairplane.length; i++) {
            System.out.println("大敌机"+bigairplane[i].getImageLoadStatus());
        }
        for (int i = 0; i < bee.length; i++) {
            System.out.println("小蜜蜂"+bee[i].getImageLoadStatus());
        }
        for (int i = 0; i < boom.length; i++) {
            System.out.println("爆炸效果"+boom[i].getImageLoadStatus());
        }
        for (int i = 0; i < hero.length; i++) {
            System.out.println("英雄机"+hero[i].getImageLoadStatus());
        }
        System.out.println("天空:"+sky.getImageLoadStatus());
        System.out.println("结束"+gameover.getImageLoadStatus());
        System.out.println("暂停"+pause.getImageLoadStatus());
        System.out.println("子弹"+bullet.getImageLoadStatus());
        System.out.println("开始"+start.getImageLoadStatus());


    }



}
