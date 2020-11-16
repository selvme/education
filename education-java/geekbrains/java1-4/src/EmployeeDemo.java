// Создать класс EmployeeDemo. В методе main(…) этого же класса создать массив из 5 сотрудников и с помощью цикла вывести информацию только о сотрудниках старше 40 лет.
public class EmployeeDemo {

    public static void main(String[] args){

        Employee[] employees = new Employee[5];
        for (int i=0; i<employees.length; i++) {
            employees[i] = new Employee();
        }

        employees[0].setFullName("Сотрудник 1");
        employees[1].setFullName("Сотрудник 2");
        employees[2].setFullName("Сотрудник 3");
        employees[3].setFullName("Сотрудник 4");
        employees[4].setFullName("Сотрудник 5");
        employees[0].email = "employee1@mail.ru";
        employees[1].email = "employee2@mail.ru";
        employees[2].email = "employee3@mail.ru";
        employees[3].email = "employee4@mail.ru";
        employees[4].email = "employee5@mail.ru";
        employees[0].phone = "8-800-535-35-35";
        employees[1].phone = "8-800-535-35-35";
        employees[2].phone = "8-800-535-35-35";
        employees[3].phone = "8-800-535-35-35";
        employees[4].phone = "8-800-535-35-35";
        employees[0].position = "Должность 1";
        employees[1].position = "Должность 2";
        employees[2].position = "Должность 3";
        employees[3].position = "Должность 4";
        employees[4].position = "Должность 5";
        employees[0].setAge(40);
        employees[1].setAge(20);
        employees[2].setAge(30);
        employees[3].setAge(41);
        employees[4].setAge(50);
        employees[0].setSalary(500.5f);
        employees[1].setSalary(550.0f);
        employees[2].setSalary(500.0f);
        employees[3].setSalary(500.7f);
        employees[4].setSalary(510.5f);

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                showInfoAboutEmplo.info(employee);
            }
        }
    }
}
