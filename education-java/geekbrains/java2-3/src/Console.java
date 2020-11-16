import java.util.Scanner;

class Console {

    static String askUser(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Введите ФИО абонента для поиска (например Петров В.В.): ");
            if (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (!line.isEmpty() && isCorrect(line)){
                    return line;
                }else{
                    System.out.println("Вы ввели не корректные данные, попробуйте еще раз...");
                }
            }else {
                System.out.println("Не могу прочесть...");
            }
        }
    }

    private static boolean isCorrect(String data){
        return (!data.isEmpty() && data.matches("^[А-Я][а-я]+\\s?[А-Я]\\.\\s?[А-Я]\\.$"));
    }
}
