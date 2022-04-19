package coding_test2;

public class Animal {
    private INAnimal dongwu;

    public Animal(){}
    
    public void setAnimal(INAnimal dongwu){
        this.dongwu=dongwu ;
    }
    public INAnimal getAnimal(){
        return dongwu ;
    }

    public void eat(){
        this.dongwu.eat();
    }

    public void sleep(){
        this.dongwu.sleep();
    }
}
