/**
 * My example of the solution Java-2-2
 *  1. Есть строка вида: "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0"; (другими словами матрица 4x4)

 1 3 1 2
 2 3 2 2
 5 6 7 1
 3 3 1 0
 Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
 3. Ваш метод должен бросить исключения в случаях:

 Если размер матрицы, полученной из строки, не равен 4x4;
 Если в одной из ячеек полученной матрицы не число; (например символ или слово)

 4. В методе main необходимо вызвать полученный метод, обработать возможные исключения и вывести результат расчета.

 *
 * @author Alexandr Yudin
 * @version 0.1
 */
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static String[][] matrix = new String[4][4];
    private static String text = "";

    public static void main(String[] args) {
        readFile();
        writeToArray();
        System.out.println(summArray());
    }

    private static void readFile(){
        try(FileReader reader = new FileReader("src/text.txt"))
        {
            int c;
            while((c = reader.read())!=-1){
                text += (char)c;
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Строка из файла: " + text);
        text = text.replace("\\n", " ");
        System.out.println("Очистка строки: " + text);

    }

    private static void writeToArray(){
        //        Task 1
        String[] tmp = text.split(" ");
        int indexOfString = 0;
        try {
            if (tmp.length != 16){
                throw new UnsupportedOperationException("Строка не подходящего содержания для массива 4х4");
            }
            for (int i=0;i<matrix.length;i++) {
                for (int j=0;j<matrix[i].length;j++){
                    matrix[i][j] = tmp[indexOfString];
                    indexOfString++;
                }

            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static String summArray(){
        //        Task 2
        String result = "";
        int summ = 0;

        try {
            for (int i=0;i<matrix.length;i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (!Character.isDigit(matrix[i][j].charAt(0))){
                        throw new UnsupportedOperationException("В строке должны содержаться только цифры!");
                    }else {
                    summ += (double)Integer.parseInt(matrix[i][j]);
                    }
                }
            }
            result = "Результат суммы всех элементов / на 2: " + Double.toString(summ /2);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}