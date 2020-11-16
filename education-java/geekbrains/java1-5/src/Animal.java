public abstract class Animal {
    String name = "Unnamed";
    String race = "Unrace";
    int age = 0;

    protected void runAnimal(){
        System.out.println("The animal ready to run");
    }
    protected void swimAnimal(){
        System.out.println("The animal ready to swim");
    }
    protected void jumpOver(){
        System.out.println("The animal ready to jump");
    }
}
