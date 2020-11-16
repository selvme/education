import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 1. Создать 2 текстовых файла (text1.txt и text2.txt) в каталоге src\text\, примерно по 50-100 символов в каждом;
 * 2. Создать класс, отвечающий за «склеивание» этих файлов (то есть вначале идет текст из первого файла,
 * потом текст из второго, без дополнительных символов). Результат должен быть помещен в файл text3.txt в каталоге src\text.
 * Тестирование провести в методе main(…) этого же класса;
 * 3. Создать класс, отвечающий за поиск наличия указанного пользователем слова (или любого набора символов)
 * в файле text3.txt в каталоге src\text\ (не используя регулярные выражения, а также встроенные в класс String
 * методы contains(…) и indexOf(…)). Данные для поиска должны вводиться с помощью сканера. При поиске совпадений
 * не нужно искать их количество или позицию в тексте, необходимо только подтвердить или опровергнуть факт наличия
 * хотя бы одного совпадения. Тестирование провести в методе main(…) этого же класса.
 */

public class MergeFiles {
    public static void main(String[] args) {
        try{
            merge("src/text/text1.txt", "src/text/text2.txt", "src/text/text3.txt");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void merge(String pathFirst, String pathSec, String newPath) throws IOException{
        FileReader reader;
        FileWriter fw;
        Scanner scanner;
        final String[] PATHS = {pathFirst, pathSec};

        for (String str: PATHS) {
            reader = new FileReader(str);
            scanner = new Scanner(reader);
            fw = new FileWriter(newPath, true);

            while (scanner.hasNextLine()){
                fw.write(scanner.nextLine());
                fw.write('\n');
            }

            reader.close();
            fw.close();
            scanner.close();
        }
        System.out.println("Слияние завершено!");
    }
}
