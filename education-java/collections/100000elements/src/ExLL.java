import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class ExLL {
    private List<Data.Box> ll;
    private long st, time;

    void add(Data.Box[] list){
        this.st = System.nanoTime();
        this.ll = new LinkedList<>();
        Collections.addAll(this.ll, list);
        this.time = System.nanoTime() - st;
        System.out.printf("Добавление объектов завершено за %d мс\n", time / 1000000);
    }

    void search(String ss){
        int count = 0;
        System.out.printf(" Поиск символов - %s в коллекции\n", ss);
        this.st = System.nanoTime();
        System.out.printf("  %s объемом - %d из объектов типа Box, с 2 полями Name & Date.\n", this.ll.getClass().getSimpleName(), this.ll.size());
        for (Data.Box box : this.ll) {
            if (box.getName().contains(ss)){
                count++;
            }
        }
        if (count > 0){
            System.out.printf("  --- Нашел --- Кол-во элементов: %d ---\n", count);
        }else {
            System.out.println("  --- Не нашел ---");
        }

        time = System.nanoTime() - st;
        System.out.printf(" Поиск завершен за %d мс\n", time / 1000000);

        if(this.ll != null){
            ll.clear();
        }
    }
}
