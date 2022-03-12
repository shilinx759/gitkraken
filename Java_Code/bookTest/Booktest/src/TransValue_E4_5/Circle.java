package TransValue_E4_5;

public class Circle {
    double radius;
    Circle(double r){
        radius=r;
    }
    double getRadius(){
        return radius;
    }
    void setRadius(double r){
        radius=r;
    }
    double getArea(){
        return radius*radius*3.14;
    }
     
    
}
