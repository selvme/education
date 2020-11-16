// Создать класс Employee с полями: «фио», «должность», «email», «телефон», «зарплата» и «возраст»;
// Создать конструктор в классе Employee, который должен заполнять все поля при создании объекта;
public class Employee {
    private String fullName;
    String email;
    String phone;
    String position;
    private int age;
    private float salary;

    Employee(){
        this.fullName = "UnNamed";
        this.email = "Undefined email";
        this.phone = "Undefined phone";
        this.position = "Undefined post";
        this.age = 0;
        this.salary = 0.0f;
    }

    public static void main(String[] args) {
//        System.out.println("Вы создали нового сотрудника");
    }

    protected void setFullName(String name){
        this.fullName = name;
    }

    protected String  getFullName(){
        return this.fullName;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    protected void setSalary(float salary){
        this.salary = salary;
    }

    public float getSalary(){
        return this.salary;
    }
}
