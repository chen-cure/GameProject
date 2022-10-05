package cn.tedu.project.aircraft;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Swing是java中内核的一套图形界面的API，可以用它快速构建桌面应用程序
 * JFrame类：java中封装好的窗口类
 * JPanel类：java中封装好的面板容器类
 * Graphics类：画笔
 *
 */
public class World extends JPanel{
    //1.加载到图片至内存

    //添加飞机大战中对象
//    private FlyObject[] flyObject;
    private Plane[] planes ;
    private Bullet[] bullets;
//    private Bullet bullet;
    private Sky sky;
    private Hero hero;
    private int index = 0;

    //
    public World() {
        planes = new Plane[0];
        //小敌机
//        planes = new Plane[12];
//        for (int i = 0; i <  planes.length; i++) {
//            if(i<4){
//                planes[i] = new Airplane();
//            }
//            else if(i<8){
//                planes[i] = new Bigplane();
//            }
//            else
//                planes[i] = new Bee();
//        }
//        //大敌机
//        bigplanes = new Bigplane[4];
//        for (int i = 0; i < bigplanes.length; i++) {
//            bigplanes[i] = new Bigplane();
//        }
//        //小蜜蜂
//        bees = new Bee[4];
//        for (int i = 0; i < bees.length; i++) {
//            bees[i] = new Bee();
//        }
        //子弹
        bullets = new Bullet[0];
//        for (int i = 0; i < bullets.length; i++) {
//            bullets[i] = new Bullet();
//        }
        sky = new Sky();
        hero = new Hero(150, 570);
    }
//        //实例化小敌机
//        airplanes = new Airplane[4];
//        for (int i = 0; i < airplanes.length; i++) {
//            airplanes[i] = new Airplane(100,100,100,100,1);
//        }
//        //实例化大敌机
//        bigplanes = new Bigplane[4];
//        for (int i = 0; i < bigplanes.length; i++) {
//            bigplanes[i] = new Bigplane(200,200,200,200,1);
//        }
//        //实例化小蜜蜂
//        bees = new Bee[4];
//        for (int i = 0; i < bees.length; i++) {
//            bees[i] = new Bee(300,300,100,100,1);
//        }
//        //实例化子弹
//        bullets = new Bullet[2];
//        for (int i = 0; i < bullets.length; i++) {
//            bullets[i] = new Bullet(180,510,50,50,0);
//        }
//        //实例化天空
//        sky = new Sky(0,0,436,738,1);
//        //实例化英雄机
//        hero = new Hero(180,530,50,50,0);
//    }

    //2.利用Jpanel中所提供的绘制方法绘制到面板上
    @Override
    public void paint(Graphics g) {
        /**
         * 参数this可以为null
         * 参数g：画笔
         * 参数x，y：--要绘制的位置坐标
         */
//        for (int i = 0; i < sky.length; i++) {
//            sky[i].paint(g);
//        }
//        Images.sky.paintIcon(null,g,0,0);
        sky.paint(g);
        hero.paint(g);
//        Images.airplane
//        for (int i = 0; i <  plane.length; i++) {
//            plane[i].paint(g);
//        }
        for(int i = 0;i<planes.length;i++){
            planes[i].paint(g);
        }
//        for (int i = 0; i < bigplanes.length; i++) {
//            bigplanes[i].paint(g);
//        }
//        for (int i = 0; i < bees.length; i++) {
//            bees[i].paint(g);
//        }
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].paint(g);
        }
//        hero.paint(g);
//        for (int i = 0; i < 1; i++) {
//            if (i == 0 | i == 1) {
//                products.aircrafts[i].paint(g);
////                Airplane airplane = new Airplane();
////                products.icons[i].paintIcon(this,g,(int)airplane.x,(int)airplane.y);
//            }
//        }
//            else if(i==3|i==2){
//                Bee bee = new Bee();
//                products.icons[i].paintIcon(this,g,(int)bee.x,(int)bee.y);
//            }
//            else{
//                Bigplane bigplane = new Bigplane();
//                products.icons[i].paintIcon(this,g,(int)bigplane.x,(int)bigplane.y);
//            }
////            products.icons[i].paintIcon(this,g,(int)(new Airplane()).x,(int)(new Airplane()).y);
//        }

    }

    //定义飞行物的移动方法
    void planemove(){
        //小敌机的移动
//        for (int i = 0; i < airplanes.length; i++) {
//            airplanes[i].move();
//        }
//        for (int i = 0; i < bigplanes.length; i++) {
//            bigplanes[i].move();
//        }
//        for (int i = 0; i < bees.length; i++) {
//            bees[i].move();
//        }
//        for (int i = 0; i < bullets.length; i++) {
//            bullets[i].move();
//        }
//        Images.sky
        sky.move();
//        repaint();
        for (int i = 0;i<planes.length;i++){
            planes[i].move();
        }
        //小敌机的移动
//        for (int i = 0; i < planes.length ; i++) {
//            planes[i].move();
//        }
        //大敌机的移动
//        for (int i = 0; i < bigplanes.length; i++ ) {
//            bigplanes[i].move();
//        }
//        //小蜜蜂的移动
//        for (int i = 0; i < bees.length; i++) {
//            bees[i].move();
//        }
        //子弹的移动
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].move();
        }
        //天空的移动
        sky.move();

        repaint();
    }

    //创建飞机
    public void creatPlane(){
        index++;
        if (index%20==0){
            Random random = new Random();
            int n =random.nextInt(10);
            Plane plane;
            if (n<=6){ plane = new Airplane(); }
            else if (n<=8){ plane = new Bigplane(); }
            else{ plane = new Bee(); }
//            Airplane a = new Airplane();
            planes = Arrays.copyOf(planes,planes.length+1);
            planes[planes.length-1] = plane;

        }
//        if(index%25==0){
//            Bee b = new Bee();
//            planes = Arrays.copyOf(planes,planes.length+1);
//            planes[planes.length-1] = b;
//        }

    }

    //创建子弹
    public void createBullet(){

        if(index%20==0){
            Bullet bullet = hero.fire();
            bullets = Arrays.copyOf(bullets,bullets.length+1);
            bullets[bullets.length-1] = bullet;
        }
//        bullet = new Bullet(hero.x+hero.width/2-5,hero.y+hero.height/8,5.5);
//        Bullet bullet =hero.fire();
//        Arrays.copyOf(bullets,bullets.length+1);
//        bullets[bullets.length-1] = bullet;
        }

    /**
     * 定义内部类来执行飞机的移动
     * 目的：可以共享world类中成员
     */
    class MoveTask extends TimerTask {
        @Override
        public void run() {
            index++;
            creatPlane();
            createBullet();
            planemove();
        }
    }

    //单独
    public  void action(){
        //实例化定时器
        Timer timer = new Timer();
        //实例化定时器任务类
        MoveTask myTask = new MoveTask();
        //执行定时器任务
        timer.schedule(myTask,1000,1000/100);

        //创建鼠标事件处理对象
//        MouseAdapter mouseAdapter = new MouseAdapter(){
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                System.out.println("鼠标在移动");
//            }
//        };
//        //将鼠标事件添加到面板中
//        this.addMouseMotionListener(mouseAdapter);
        this.addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseMoved(MouseEvent e) {//在鼠标事件发生的时候，参数mouseevent中包含了x,y等信息
                //将鼠标的坐标赋值给英雄机x，y
                int x = e.getX();
                int y = e.getY();
//                System.out.println("鼠标移动："+x+","+y);
                hero.move(x,y);
//                System.out.println("鼠标在移动");
            }
        });

    }

    //显示窗口显示绘制的图片
    public static void main(String[] args) {
        //设置窗口
        JFrame jFrame = new JFrame();
        //设置标题
        jFrame.setTitle("飞机大战");
        //设置窗口大小
        jFrame.setSize(420,747);
        //设置窗口居中位置
        jFrame.setLocationRelativeTo(null);
        //设置默认关闭
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        //实例化画板
        World jPanel = new World();
        //将画板添加到窗口上
        jFrame.add(jPanel);
        //显示窗口可见
        jFrame.setVisible(true);

        jPanel.action();
//        //创建鼠标事件处理对象
//        MouseAdapter mouseAdapter = new MouseAdapter(){
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                System.out.println("鼠标在移动");
//            }
//        };
//        //将鼠标事件添加到面板中
//        jPanel.addMouseMotionListener(mouseAdapter);


    }

}
