package coding_test2;

public class Main2 {
    public static void main(String[] args) {
       Animal animal =new Animal();
       INAnimal mouse = new Mouse();  
       INAnimal panda = new Panda();
       Mouse digMouse = new Mouse();

        System.out.println("============");
        System.out.println("老鼠吃东西：");
        animal.setAnimal(mouse);
        animal.eat();
        System.out.println("老鼠睡觉：");
        animal.sleep();
        System.out.println("老鼠打洞：");
        digMouse.digHole();

        System.out.println("============");
        System.out.println("熊猫吃东西：");
        animal.setAnimal(panda);
        animal.eat();
        System.out.println("熊猫睡觉：");
        animal.sleep();



    }
}
