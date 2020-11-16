public class Cat extends Animal{
    String name = "Обама";
    String race = "Афро";
    int age = 3;

    protected void runAnimal(int length){
        if (length > 100){
            System.out.println("Cat has refused");
        } else super.runAnimal();
    }

    protected void swimAnimal(int length){
        if (length != 0){
            System.out.println("Cat is not a swimmer");
        }
    }

    protected void jumpOver(int length){
        if (length > 2){
            System.out.println("Cat has refused");
        } else jumpOver();
    }
}
