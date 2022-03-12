package TransValue_E4_5;

public class Circular {
    Circle bottom;
    double height;
    Circular(Circle c,double h){//把circle类的实例c传引用给bottom
        bottom=c;
        height=h;
    }

    double getVolme(){
        return bottom.getArea()*height;
    }

    public void setBottomRadius(double r){
        bottom.setRadius(r);
    }

    double getBottomRadius(){
        return bottom.getRadius();
    }



    
}
