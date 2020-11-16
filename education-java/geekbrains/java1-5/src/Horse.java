public class Horse extends Animal{
    String name = "Олланд";
    String race = "Легушатникус";
    int age = 5;

    protected void runAnimal(int length){
        if (length > 16000){
            System.out.println("Dog has refused");
        } else super.runAnimal();
    }

    protected void swimAnimal(int length){
        if (length > 50){
            System.out.println("Dog has refused");
        } else super.swimAnimal();
    }

    protected void jumpOver(int length){
        if (length > 2){
            System.out.println("Dog has refused");
        } else jumpOver();
    }
}
