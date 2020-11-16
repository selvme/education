import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ExAL {
    private List<Data.Box> al;
    private long st, time;

    void add(Data.Box[] list){
        this.st = System.nanoTime();
        this.al = new ArrayList<>(list.length);
        Collections.addAll(this.al, list);
        this.time = System.nanoTime() - st;
        System.out.printf("Добавление объектов завершено за %d мс\n", time / 1000000);
    }

    void search(String ss){
        int count = 0;
        System.out.printf(" Поиск символов - %s в коллекции\n", ss);
        this.st = System.nanoTime();
        System.out.printf("  %s объемом - %d из объектов типа Box, с 2 полями Name & Date.\n", this.al.getClass().getSimpleName(), this.al.size());
        for (Data.Box box : this.al) {
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

        if(this.al != null){
            al.clear();
        }
    }
}
