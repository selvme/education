//Создать класс TicTacToe_2. Скопировать исходный код с занятия (без комментариев в коде), усовершенствовать метод проверки победы и доработать искусственный интеллект так, чтобы он мог блокировать ходы игрока. При этом искусственный интеллект не должен пытаться оценивать каждый раз наиболее выгодный ход, а только предотвращать ход игрока при наличии у него комбинации 2 из 3.


import java.util.Random;
import java.util.Scanner;

public class Task_2 {

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static char[][] field = new char[3][3];
    private static final char SYMBOL_EMPTY = ' ';
    private static final char SYMBOL_X = 'X';
    private static final char SYMBOL_O = 'O';
    private static int firstTurn = 0;

    public static void main(String[] args) {
        initField();
        drawField();
        while (true) {
            playerTurn();
            drawField();
            if (isWin(SYMBOL_X)) {
                System.out.println("Победил игрок.");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья.");
                break;
            }
            computerTurn();
            drawField();
            if (isWin(SYMBOL_O)) {
                System.out.println("Победил компьютер.");
                break;
            }
        }
        if (scanner != null) {
            scanner.close();
        }
    }

    private static void initField() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                field[y][x] = SYMBOL_EMPTY;
            }
        }
    }

    private static void drawField() {
        System.out.print("╔═══╦═══╦═══╦═══╗\n");
        System.out.print("║   ║ 1 ║ 2 ║ 3 ║\n");
        for (int y = 0; y < 3; y++) {
            System.out.print("╠═══╬═══╬═══╬═══╣\n");
            System.out.print("║ " + (y + 1) + " ║");
            for (int x = 0; x < 3; x++) {
                System.out.print(" " + field[y][x] + " ║");
            }
            System.out.print("\n");
        }
        System.out.print("╚═══╩═══╩═══╩═══╝\n");
    }

    private static void playerTurn() {
        int y = 0;
        int x = 0;
        while (true) {
            System.out.print("Ход игрока [<строка> <столбец>]: ");
            if (scanner.hasNextInt()) {
                y = scanner.nextInt() - 1;
            }
            else {
                System.out.println("[Ошибка] Введены неверные координаты.");
                scanner = new Scanner(System.in);
                continue;
            }
            if (scanner.hasNextInt()) {
                x = scanner.nextInt() - 1;
                scanner = new Scanner(System.in);
            }
            else {
                System.out.println("[Ошибка] Введены неверные координаты.");
                scanner = new Scanner(System.in);
                continue;
            }
            if (isFieldCellValid(y, x) && isFieldCellEmpty(y, x)) {
                field[y][x] = SYMBOL_X;
                break;
            }
            System.out.println("[Ошибка] Введены неверные координаты.");
        }
    }

    private static void computerTurn() {
        int strategy = random.nextInt(2);
        char sym;
        if (strategy==0){
            sym = SYMBOL_X;			// Стратегия защиты
        } else sym = SYMBOL_O;		// Агрессивная стратегия
        turn(sym);
    }

    private static void turn(char sym) {
        int countMatchForComp = 0;
        int turn = 0;
        int emptyX = 0;
        int emptyY = 0;
        if (firstTurn>0){
            for (int y = 0; y < 3; y++) {                           // Поиск в строках
                for (int x = 0; x < 3; x++) {
                    if (field[y][x] == sym) {                  		// Проверка на наличие символа
                        countMatchForComp++;
                    } else {
                        if (isFieldCellEmpty(y, x)) {               // Если символа нет то проверяем не пуста ли ячейка
                            emptyX = x;                             // Если пуста, то запоминаем координаты
                            emptyY = y;
                        }
                    }
                }
                if (countMatchForComp == 2) {						// Если есть совпадение в 2 ячейках - ставим символ в свободную
                    System.out.println("Ход компьютера [<строка> <столбец>]: " + (emptyY + 1) + " " + (emptyX + 1));
                    field[emptyY][emptyX] = SYMBOL_O;
                    turn++;
                    break;
                }
                countMatchForComp = 0;
            }
        }

        if (firstTurn>0 && turn==0) {
            for (int x = 0; x < 3; x++) {                            // Поиск в столбцах
                for (int y = 0; y < 3; y++) {
                    if (field[y][x] == sym) {
                        countMatchForComp++;
                    } else {
                        if (isFieldCellEmpty(y, x)) {
                            emptyX = x;
                            emptyY = y;
                        }
                    }
                }
                if (countMatchForComp == 2) {
                    System.out.println("Ход компьютера [<строка> <столбец>]: " + (emptyY + 1) + " " + (emptyX + 1));
                    field[emptyY][emptyX] = SYMBOL_O;
                    turn++;
                    break;
                }
                countMatchForComp = 0;
            }
        }

        if (firstTurn>0 && turn==0) {
            for (int y = 0, x = 0; y < 3; y++, x++) {                // Поиск по 1 диагонали
                if (field[y][x] == sym) {
                    countMatchForComp++;
                } else {
                    if (isFieldCellEmpty(y, x)) {
                        emptyX = x;
                        emptyY = y;
                    }
                }
            }
            if (countMatchForComp == 2) {
                System.out.println("Ход компьютера [<строка> <столбец>]: " + (emptyY + 1) + " " + (emptyX + 1));
                field[emptyY][emptyX] = SYMBOL_O;
                turn++;
                countMatchForComp = 0;
            }
        }

        if (firstTurn>0 && turn==0) {
            for (int y = 0, x = 2; y < 3; y++, x--) {                // Поиск по 2 диагонали
                if (field[y][x] == sym) {
                    countMatchForComp++;
                } else {
                    if (isFieldCellEmpty(y, x)) {
                        emptyX = x;
                        emptyY = y;
                    }
                }
            }
            if (countMatchForComp == 2) {
                System.out.println("Ход компьютера [<строка> <столбец>]: " + (emptyY + 1) + " " + (emptyX + 1));
                field[emptyY][emptyX] = SYMBOL_O;
                turn++;
            }
        }

        if(firstTurn>=0 && turn==0) {
            while (true) {
                int y = random.nextInt(3);                  // 1 ход ПК рандом
                int x = random.nextInt(3);
                if (isFieldCellEmpty(y, x)) {
                    System.out.println("Ход компьютера [<строка> <столбец>]: " + (y + 1) + " " + (x + 1));
                    field[y][x] = SYMBOL_O;
                    firstTurn++;
                    break;
                }
            }
        }
    }

    private static boolean isFieldCellValid(int y, int x) {
        return y >= 0 && y <= 2 && x >= 0 && x <= 2;
    }

    private static boolean isFieldCellEmpty(int y, int x) {
        return field[y][x] == SYMBOL_EMPTY;
    }

    private static boolean isWin(char symbol){
        int countMatch = 0;
        for (int y = 0; y < 3; y++) {							// Поиск в строках
            for (int x = 0; x < 3; x++) {
                if (field[y][x] == symbol) {
                    countMatch++;
                }
            }
            if (countMatch == 3) {
                return true;
            } else countMatch = 0;
        }

        for (int x = 0; x < 3; x++) {							// Поиск в столбцах
            for (int y = 0; y < 3; y++) {
                if (field[y][x] == symbol) {
                    countMatch++;
                }
            }
            if (countMatch == 3) {
                return true;
            } else countMatch = 0;
        }

        for (int y = 0, x = 0; y < 3; y++, x++) {                // Поиск по 1 диагонали
            if (field[y][x] == symbol){
                countMatch++;
            }
        }
        if (countMatch == 3) {
            return true;
        } else countMatch = 0;

        for (int y = 0, x = 2; y < 3; y++, x--) {                // Поиск по 2 диагонали
            if (field[y][x] == symbol){
                countMatch++;
            }
        }
        if (countMatch == 3) {
            return true;
        } else return false;
    }

    private static boolean isFieldFull() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if(field[y][x] == SYMBOL_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}

