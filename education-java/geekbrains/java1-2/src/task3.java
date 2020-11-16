import java.util.Arrays;

//Создать класс Task_3. В методе main(…) этого класса создать массив [1, 5, 25, 6, 7, 11, 15, 25, 9, 19, 16, 6, 5, 11, 18, 10, 4, 1, 8, 13] и найти в нем значения минимального и максимального элементов (находить индексы этих элементов не требуется);
//        *. [Примечание] Для вывода массива на консоль можно использовать конструкцию System.out.println("Массив: " + Arrays.toString(array)); (вместо переменной array указать переменную с массивом);
public class task3 {

    public static void main(String[] args){
        int[] arr= {1, 5, 25, 6, 7, 11, 15, 25, 9, 19, 16, 6, 5, 11, 18, 10, 4, 1, 8, 13};
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
            if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Максимальное значение: "+ max + " минимальное: " + min + " из массива - " + Arrays.toString(arr));
    }
}
