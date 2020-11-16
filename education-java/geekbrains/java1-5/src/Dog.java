public class Dog extends Animal{
    String name = "Меркель";
    String race = "Фашистос";
    int age = 8;

    protected void runAnimal(int length){
        if (length > 3000){
            System.out.println("Dog has refused");
        } else super.runAnimal();
    }

    protected void swimAnimal(int length){
        if (length > 100){
            System.out.println("Dog has refused");
        } else super.swimAnimal();
    }

    protected void jumpOver(int length){
        if (length > 1){
            System.out.println("Dog has refused");
        } else jumpOver();
    }
}
