package cn.tedu.project.ballproject;

import cn.tedu.util.App;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Ball extends App {
    Ballparam b= new Ballparam();
    Ballparam[] ballparams = new Ballparam[100];
//    protected ImageIcon image = new ImageIcon("images/Kobe.jpg");


    Ball() {
        for (int i = 0; i < ballparams.length; i++) {
            ballparams[i] = new Ballparam();
        }

    }

    public void eating(){
        //大球和小球
        Ballparam[] big =  ballparams;
        Ballparam[] small =  ballparams;
        boolean[] eaten = new boolean[small.length]; //创建了吃掉标志，默认都是false，表示没吃掉。boolean默认false
        int n = 0; //记录有几个球被吃掉了
        for (int i = 0;i<big.length;i++){   //每一个大球
            //如果大球已经被吃掉了，就忽略
            if(eaten[i]){
                continue;
            }
            for (int j=0;j<small.length;j++){   //每一个小球
                //球不能吃自己
                if(big[i]==small[j]){
                    continue;
                }
                //如果小球被吃掉就忽略
                if(eaten[j]){
                    continue;
                }
                if(big[i].eaten(small[j])){
                    System.out.println("吃...");
                    System.out.println(big[i].x+ ","+big[i].y+ ","+big[i].d);
                    System.out.println(small[j].x+ ","+small[j].y+ ","+small[j].d);
                    //把小球的位置设置为true
                    eaten[j] = true;
                    n++;
                }
            }
        }
        System.out.println(Arrays.toString(eaten));
        System.out.println(n);
        if(n==0){ //什么都没吃掉
            return;
        }
        //缩容处理
        Ballparam[] arr = new Ballparam[small.length]; //此时为新数组，但都为空
        int index = 0;
        for (int i =0;i<small.length; i++){
            if (!eaten[i]){  //如果index不为true
                arr[index++] = small[i]; //就放入arr中,不为true的元素都放进了数组，后面的部分为0
                // index++;
            }
        }
        System.out.println(Arrays.toString(arr));
        ballparams =  Arrays.copyOf(arr,arr.length-n); //缩容处理,并替换原数组
    }

    public static void main(String[] args) {
        Ball ball = new Ball();
        ball.start();
    }

    @Override
    public void painting(Graphics2D g) {
        b.image.paintIcon(null,g,0,0);

        for (int i = 0; i < ballparams.length; i++) {
            ballparams[i].paint(g);
//            g.setColor(ballparams[i].color);
//            ballparams[i].move();
//            g.fillOval((int)ballparams[i].x,(int)ballparams[i].y,ballparams[i].d,ballparams[i].d);
        }
        eating();

//        eat();
    }


//    public Ballparam eat(Ballparam a, Ballparam b){
//        Ballparam c;
//        double r1=(a.x+a.d/2)-(b.x+b.d/2);
//        double r2=(a.y+a.d/2)-(b.y+b.d/2);
//        double R = Math.sqrt(r1*r1+r2*r2);
//        double D = Math.sqrt(a.d*a.d+b.d+b.d)*2;
//        if (R<Math.abs(r1-r2)|a.d>b.d){
//            if (a.d>b.d){
//                a.d=(int)D;
//                 c = a;
//            }
//            else{
//                b.d = (int)D;
//                c = b;
//            }
//            return c;
//        }
//        return  ;
//
//    }
//
//    public void combine(){
//        for (int i = 0; i < ballparams.length; i++) {
//            eat(ballparams[i],ballparams[i+1]);
//        }
//    }
//}

class Ballparam {
        //小球所具备的共同属性
        int d;
        double x;
        double y;
        int r, g, b;
        Color color;
        double offsetX, offsetY;

        protected ImageIcon image;

        //无参数构造器
        Ballparam() {
            d = (int) (Math.random() * (60 - 10) + 10);
            x = Math.random() * (800 - d);
            y = Math.random() * (600 - d);
            r = (int) (Math.random() * 256);
            g = (int) (Math.random() * 256);
            b = (int) (Math.random() * 256);
            color = new Color(r, g, b);
            //移动速度
            offsetX = Math.random() * (6 - 1) + 1;
            offsetY = Math.random() * (6 - 1) + 1;
            {
                offsetX = Math.random() > 0.5 ? offsetX : -offsetX;
                offsetY = Math.random() > 0.5 ? offsetY : -offsetY;
            }
            this.image = new ImageIcon("images/Kobe.jpg");
        }

        //小球移动
        public void move() {
            x += offsetX;
            y += offsetY;
            //触及右边缘反弹
            if (x > 800 - d) {
                offsetX = -offsetX;
            }
            //触及左边缘
            else if (x < 0) {
                offsetX = -offsetX;
            }
            //触及上边缘
            else if (y < 0) {
                offsetY = -offsetY;
            }
            //触及下边缘
            else if (y > 600 - d) {
                offsetY = -offsetY;
            }
        }


     public boolean eaten(Ball.Ballparam ball){
        double X = x, Y = y, D = this.d;  //大球
        double x=ball.x, y=ball.y, d=ball.d; //小球
//        int red=ball.r,green = ball.g, blue = ball.b;
        Color newColor = ball.color;
        //检查球的直径是否合理
        if(d > D){
            return false; //直径不合理，不进行进一步比较
        }
        //利用勾股定理计算两个球之间的距离
        double a = (X+D/2) - (x+d/2);
        double b = (Y+D/2) - (y+d/2);
        double c = Math.sqrt(a*a + b*b);
        boolean eaten = c < D/2-d/2;
        //如果发生吃了，就进行合并
        if(eaten){
            //计算合并后的圆面积
            double R = D/2,r = d/2;
            double area = Math.PI*R*R + Math.PI*r*r;
            double rx = Math.sqrt(area/Math.PI);
            this.d = (int) rx*2;  //替换当前圆的直径
            this.color = newColor;
        }
        return eaten;
    }

        //绘制小球
        public void paint(Graphics2D g) {
//            image.paintIcon(null,g,0,0);
            //设置颜色
            g.setColor(color);
            //斜向下移动
            move();
            //绘制小球
            g.fillOval((int) x, (int) y, d, d);
//            image.paintIcon(null,g,0,0);
        }

        //求半径
        public double collide(double a, double b, double c, double d) {
            return (a + c / 2) - (b + d / 2);
        }

        public void contain(double a, double b, double c) {
            if (c < (a - b)) {
//            eat();
            } else if (c < (b - a)) {
//            eat();
            }
        }

        //求合并之后的半径
        public int getR(int a, int b) {
            return (int) (Math.sqrt(a * a + b * b));
//        return C;
        }

//    小球合并
//    public void eat(Ballparam a, Ballparam b){
//        double r1=(a.x+a.d/2)-(b.x+b.d/2);
//        double r2=(a.y+a.d/2)-(b.y+b.d/2);
//        double R = Math.sqrt(r1*r1+r2*r2);
//        double D = Math.sqrt(a.d*a.d+b.d+b.d)*2;
//        if (R<Math.abs(r1-r2)){
//            if (a.d>b.d){
//                a.d=(int)D;
//            }
//            else{
//                b.d = (int)D;
//            }
//        }
//
//    }
//    public boolean eaten(Ball ball){
//        double X = x , Y = y,D =this.d;
//        double x = ball.
//    }
    }
}

