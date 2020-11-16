// [Выбор 2] Создать отдельный класс с отдельным методом, который выводит информацию об объекте класса Employee на консоль;
public class showInfoAboutEmplo {
    public static void main(String[] args){
        Employee task3 = new Employee();
        task3.setFullName("Сотрудник 1");
        task3.email = "employee1@mail.ru";
        task3.phone = "8-800-535-35-35";
        task3.position = "Должность 1";
        task3.setAge(40);
        task3.setSalary(500.5f);

        info(task3);
    }
    protected static void info(Employee employ) {
        System.out.println("ФИО: "+employ.getFullName());
        System.out.println("Возраст: "+employ.getAge());
        System.out.println("E-mail: "+employ.email);
        System.out.println("Phone: "+employ.phone);
        System.out.println("Зарплата: "+employ.getSalary() + " $");
        System.out.println("---------------------------------------");
    }
}
