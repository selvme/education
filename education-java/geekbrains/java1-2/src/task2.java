import java.util.Arrays;
// Создать класс Task_2. В методе main(…) этого класса создать пустой массив из 10 целых чисел и с помощью цикла заполнить его значениями, каждое из которых будет на 3 больше предыдущего (начиная с 1), то есть [1, 4, 7, 10, 13, 16, 19, 22, 25, 28];
public class task2 {

    public static void main(String[] args){
        int[] arr= new int[10];

        for (int i = 0, j = 1; i < arr.length; i++, j+=3) {
            arr[i] = j;
        }
        System.out.println(Arrays.toString(arr));
    }
}