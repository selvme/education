// 1. Создать классы Cat, Dog и Horse, которые наследуются от родительского класса Animal;
// 2. Все классы должны иметь возможность выполнять следующие действия: бежать, плыть, перепрыгивать препятствие.
// При этом у каждого класса должны быть свои ограничения на каждое из действий (например, для перепрыгивания
// препятствия можно установить ограничение по максимальной высоте этого препятствия);
// 3. Создать класс AnimalDemo. В методе main(…) этого же класса протестировать экземпляры каждого класса
// Cat, Dog и Horse (то есть проверить все методы всех объектов и, в зависимости от результата,
// вывести на консоль соответствующее сообщение).

public class AnimalDemo {
    public static void main(String[] args){
        Cat catObama = new Cat();
        Dog dogMerkel = new Dog();
        Horse horseOlland = new Horse();

        System.out.println("-------- Кот: "+ catObama.name +" --------");
        System.out.println("-------- Порода: "+ catObama.race +" --------");
        System.out.println("-------- Возраст: "+ catObama.age +" --------");
        catObama.runAnimal(125);
        catObama.runAnimal(80);
        catObama.swimAnimal(10);
        catObama.swimAnimal(1);
        catObama.jumpOver(5);
        catObama.jumpOver(1);
        System.out.println("-------- Собака: "+ dogMerkel.name +" --------");
        System.out.println("-------- Порода: "+ dogMerkel.race +" --------");
        System.out.println("-------- Возраст: "+ dogMerkel.age +" --------");
        dogMerkel.runAnimal(3500);
        dogMerkel.runAnimal(2000);
        dogMerkel.swimAnimal(125);
        dogMerkel.swimAnimal(30);
        dogMerkel.jumpOver(5);
        dogMerkel.jumpOver(1);
        System.out.println("-------- Лошадь: "+ horseOlland.name +" --------");
        System.out.println("-------- Порода: "+ horseOlland.race +" --------");
        System.out.println("-------- Возраст: "+ horseOlland.age +" --------");
        horseOlland.runAnimal(18000);
        horseOlland.runAnimal(5000);
        horseOlland.swimAnimal(125);
        horseOlland.swimAnimal(30);
        horseOlland.jumpOver(5);
        horseOlland.jumpOver(2);
    }
}
