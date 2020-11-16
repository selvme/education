import java.util.*;

public class Main {

    public static void main(String[] args) {

//        Task 1
        System.out.println("///////////////////TASK 1/////////////////////");
        String phrase = "Всем привет меня зовут Александр, я учу java на geekbrains."
                + " А также учу web технологии в свободное от работы время.";
        String[] words = phrase.toLowerCase().split("[ {,|.}?]+");
        Map<String, Integer> hm = new HashMap<>();
        Integer count;
        for (String word :
                words) {
            count = hm.get(word);
            hm.put(word, (count == null ? 1 : count + 1));
        }
        System.out.println(hm);
        System.out.printf("Общее кол-во слов в тексте: %d Без повторений: %d\n", words.length, hm.size());



//        Task 2
        System.out.println("///////////////////TASK 2/////////////////////");
        PhoneBook book = new PhoneBook();

        book.addNewRec("Петров В.В.", new PhoneRec( "kavnjklf@kdasf.ru", "89999999999"));
        book.addNewRec("Иванов", new PhoneRec("sdfhgjgf@kdasf.ru", "89999999998" ));
        book.addNewRec("Сидоров", new PhoneRec("sdflsdf@kdasf.ru","89999999997" ));
        book.addNewRec("Пашутин", new PhoneRec("nvbaof@kdasf.ru","89999999995"));
        book.addNewRec("Капустин", new PhoneRec("kavnjklf@kdasf.ru", "89999999999" ));
        book.addNewPhoneForRec("Петров В.В.", "89999999996");
        book.addNewEmailForRec("Петров В.В.", "89999999996");


//        Тест перезаписи
        book.addNewRec("Петров В.В.", new PhoneRec("89999999995"));

        book.findPhoneByName(Console.askUser());
        
    }
}
