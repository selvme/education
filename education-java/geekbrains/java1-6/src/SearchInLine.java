import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchInLine {
    public static void main(String[] args) {
        try {
            System.out.println(hasPhrase(getUserText()) ? "Такая фраза есть" : "Такой фразы нет");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getUserText(){
        Scanner cScan = new Scanner(System.in);
        while(true){
            System.out.println("Введите Вашу фразу для поиска в файле: ");
            if (cScan.hasNextLine()){
                String input = cScan.nextLine();
                if (!input.isEmpty()){
                    cScan.close();
                    return input;
                }
            }else {
                System.out.println("Возникла проблема с чтением фразы, введите повторно: ");
                cScan = new Scanner(System.in);
            }
        }
    }

    private static boolean hasPhrase(String phrase) throws IOException{
        phrase = phrase.toLowerCase();
        final int STOP_FLAG = phrase.length();
        int count = 0;
        FileReader fr = new FileReader("src/text/text3.txt");
        Scanner fScan = new Scanner(fr);
        String line;

        while(fScan.hasNextLine()){
            line = fScan.nextLine().toLowerCase();
            for (int i=0; i<line.length(); i++){
                if (line.charAt(i) == phrase.charAt(0)){
                    count++;
                    if (phrase.length() == count){
                        return true;
                    }else {
                        for (int j=count, k=i+1; k < line.length() && j < STOP_FLAG; k++, j++){
                            if (line.charAt(k) == phrase.charAt(j)){
                                count++;
                            }
                        }
                        if (count == STOP_FLAG){
                            return true;
                        }
                    }
                }
                count = 0;
            }
        }
        return false;
    }
}
