import java.util.HashMap;
import java.util.Map;

public class ExMap {
    private Map map = new HashMap();
    private long st, time;

    void add(String str, Data.Box elem){
        map.put(str, elem);
    }

    void search(String ss){
        int count = 0;
        System.out.printf(" Поиск символов - %s в коллекции\n", ss);
        this.st = System.nanoTime();
        System.out.printf("  %s объемом - %d из объектов типа Box, с 2 полями Name & Date.\n", this.map.getClass().getSimpleName(), this.map.size());
//        TODO: 2
        if (count > 0){
            System.out.printf("  --- Нашел --- Кол-во элементов: %d ---\n", count);
        }else {
            System.out.println("  --- Не нашел ---");
        }

        time = System.nanoTime() - st;
        System.out.printf(" Поиск завершен за %d мс\n", time / 1000000);

        if(this.map != null){
            map.clear();
        }
    }
}
