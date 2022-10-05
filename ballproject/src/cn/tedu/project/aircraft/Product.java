package cn.tedu.project.aircraft;

import javax.swing.*;

public class Product {
    FlyObject[] flyObjects = new FlyObject[1];
    ImageIcon[] icons = new ImageIcon[6];
    Product(){
        for (int i = 0; i < icons.length; i++) {
            if(i==0) {
                flyObjects[i] = new Airplane();
//                icons[i]=new ImageIcon("images/airplane0.png");
//                Airplane airplane = new Airplane();
//            }else if (i==1){
//                aircrafts[i] = new Bee();
////                icons[i]=new ImageIcon("images/airplane1.png");
////                Airplane airplane = new Airplane();
//            } else if (i==2){
//                icons[i]=new ImageIcon("images/bee0.png");
//                Bee bee = new Bee();
//            } else if (i==3){
//                icons[i]=new ImageIcon("images/bee1.png");
//                Bee bee = new Bee();
//            }else if (i==4){
//                icons[i]=new ImageIcon("images/bigairplane0.png");
//                Bigplane bigplane = new Bigplane();
//            }else{
//                icons[i]=new ImageIcon("images/bigairplane1.png");
//                Bigplane bigplane = new Bigplane();
//            }
            }
        }

    }


}
