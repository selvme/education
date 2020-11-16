import java.util.Scanner;

public class task4 {

    static int integer;
    static final int min = 0;
    static final int max = 9;
    static final int tryCount = 3;

    public static void main(String[] args){
        String str = "";
        int check = 0;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("Сыграем в угадай число? ДА | НЕТ");
            if (in.hasNext("^[а-яА-Я ]+$")) {
                str = in.nextLine().toLowerCase();
                if (str.equals("да")) {
                    check = 1;
                    System.out.println("Тогда угадай число которое я загадал от " + min +" до " + max + ", у тебя " + tryCount + " попытки/ок :P");
                    integer = getRnd(min,max);
                    startGame();
                } else {
                    System.out.println("Тогда в следующий раз");
                    break;
                }
            } else {
                System.out.println("Я тебя не понимаю...");
            }
        } while(check == 0);
    }

    public static void startGame(){
        int t;
        int att = 0;
        for (t = 1; tryCount >= t; t++){
            Scanner in = new Scanner(System.in);
            System.out.print(t + " Попытка:  ");
            if (in.hasNextInt()){
                att = in.nextInt();
                if (att > integer){
                    System.out.println("Ваше число больше");
                }
                if (att < integer){
                    System.out.println("Ваше число меньше");
                }
                if (att == integer){
                    System.out.println("Вы угадали!!!");
                    break;
                }
            } else {
                System.out.println("Введите целое число от " + min + " до " + max + "!");
                t--;
            }

        }
        if (tryCount < t){
            System.out.println("Ни одна из попыток не была правильной :(");
        }
    }

    public static int getRnd(int min, int max){
        return min + (int)(Math.random() * max);
    }

}