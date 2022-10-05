package cn.tedu.project.aircraft;

public class Test {
    public static void main(String[] args) {
//        FlyObject flyObject = new FlyObject();
//        System.out.println(flyObject.toString());
        Airplane airplane = new Airplane();
        System.out.println(airplane);
//        for(int i = 0;i<4;i++){
//            airplane.nextImage();
//            System.out.println(airplane.image);
//        }
//        System.out.println(airplane.toString());
//        //输出为8 即加载成功，若为4，就加载失败
//        System.out.println(airplane.image.getImageLoadStatus());
        Bee bee = new Bee();
        System.out.println(bee);
//        for(int i=0;i<4;i++){
//            bee.nextImage();
//            System.out.println(bee.image);
//        }
//        System.out.println(bee.toString());
//        System.out.println(bee.image.getImageLoadStatus());
        Bigplane bigplane = new Bigplane();
        System.out.println(bigplane);
//        for(int i=0;i<4;i++){
//            bigplane.nextImage();
//            System.out.println(bigplane.image);
//        }
//        System.out.println(bigplane.toString());
//        System.out.println(bigplane.image.getImageLoadStatus());
        Hero hero = new Hero();
        System.out.println(hero);
//        System.out.println(hero.image.getImageLoadStatus());
        Bullet bullet = new Bullet();
        System.out.println(bullet);
//        System.out.println(bullet.image.getImageLoadStatus());
        Sky sky = new Sky();
        System.out.println(sky);
//        System.out.println(sky.image.getImageLoadStatus());
    }

}
