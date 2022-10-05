package cn.tedu.project.aircraft;

import javax.swing.*;

/**
 * 小敌机
 */
public class Airplane extends Plane {

    //自定义出场
    public Airplane(double x, double y,  double step) {
        super(x, y, Images.airplane[0],Images.airplane,Images.boom);
        this.step = step;
    }

    //随机出场
    public Airplane() {
        super(Images.airplane[0],Images.airplane,Images.boom);

//        Images.airplane[1];
//        this.image = new ImageIcon("images/airplane0.png");
//        images = Images.airplane;
//        images = Images.airplane;
//        for(int i=0;i<2;i++){
//            if(i%2==0){
//                images[i%2] = Images.airplane[i%2];
//            }
//            if(i%2==1){
//                images[i%2] = Images.airplane[i%2];
//            }
//        }
    }


}
