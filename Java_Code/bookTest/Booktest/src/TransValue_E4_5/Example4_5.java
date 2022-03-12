package TransValue_E4_5;

public class Example4_5 {
    public static void main(String[] args) {
        Circle circle=new Circle(10);
        System.out.println("main中circle的引用为："+circle);
        System.out.println("main中circle的半径为"+circle.getRadius());
        Circular circular=new Circular(circle, 20);
        System.out.println("main中圆锥的bottom的引用："+circular.bottom);
        System.out.println("main中圆锥的bottom的半径："+circular.getBottomRadius());
        System.out.println("圆锥的体积为："+circular.getVolme());

        //改变半径后
        double r=8888;
        System.out.println("圆锥将半径改为"+r);
        circular.setBottomRadius(r);
        System.out.println("圆锥更改半径后底圆半径为："+circular.getBottomRadius());
        System.out.println("圆锥体积："+circular.getVolme());
        System.out.println("main方法中circle的半径："+circle.getRadius());
        System.out.println("main方法中circle的引用将发生变化");

        //重新创建circle
        System.out.println("将circle的半径为1000");;
        circle =new Circle(1000);
        System.out.println("现在main方法中的引用："+circle);
        System.out.println("circle的半径："+circle.getRadius());
        System.out.println("但是不影响circula的bottom的引用");
        System.out.println("circular的bottom的引用:"+circular.bottom);;
        System.out.println("圆锥的bottom的半径："+circular.getBottomRadius());
    }
    
}
