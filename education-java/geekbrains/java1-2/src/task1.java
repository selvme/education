import java.util.Arrays;
// Создать класс Task_1. В методе main(…) этого класса создать массив [1, 1, 0, 1, 0, 0, 0, 1, 0, 1] и с помощью цикла заменить все 0 на 1, а все 1 на 0 (результат записать в этот же массив);
public class task1 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 0, 0, 0, 1, 0, 1};
        System.out.println("Исходный массив - " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++){
            arr[i] ^= 1;
        }
        System.out.println("Обратный массив - " + Arrays.toString(arr));
    }
}