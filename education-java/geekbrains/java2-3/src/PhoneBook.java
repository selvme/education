import java.util.HashMap;
import java.util.Map;

final class PhoneBook{
    private Map<String, PhoneRec> map;

    PhoneBook(){
        map = new HashMap<>();
    }

    void addNewRec(String key, PhoneRec value){
        map.put(key, value);
    }

    void addNewPhoneForRec(String name, String phone){
        PhoneRec data = map.get(name);
        if (data != null){
            data.addPhone(phone);
            System.out.println("Телефон добавлен!");
        }else {
            System.out.println("Такого абонента не существует!");
        }
    }

    void addNewEmailForRec(String name, String email){
        PhoneRec data = map.get(name);
        if (data != null){
            data.addEmail(email);
            System.out.println("Почта добавлена!");
        }else {
            System.out.println("Такого абонента не существует!");
        }
    }

    void findPhoneByName(String name) {
        PhoneRec data = map.get(name);
        if (data != null) {
            System.out.println(data.getPhones());
        } else {
            System.out.println("Такого абонента не существует!");
        }
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
