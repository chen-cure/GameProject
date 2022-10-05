package cn.tedu.project.ballproject;

interface Destination{
    String readLabel();
}

interface Contents{
    int values();
}

public class Test {
    public Destination dest(String s){
        class PDestination implements Destination {
            private String label;
            private PDestination(String whereTo){
                label = whereTo;
            }
            public String readLabel() {
                System.out.println(label);
                return label;

            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Test t=new Test();
        Destination d = t.dest("Tanzania");
        getType(d);
        System.out.println(d);
        d.readLabel();
    }
    public static void getType(Object o){
        System.out.println(o.getClass().toString());
    }
}
