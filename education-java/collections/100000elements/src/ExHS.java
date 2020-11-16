import java.util.*;

class ExHS {
    private Set<Data.Box> hs;
    private long st, time;

    void add(Data.Box[] set){
        this.st = System.nanoTime();
        this.hs = new HashSet<>();
        Collections.addAll(this.hs, set);
        this.time = System.nanoTime() - st;
        System.out.printf("Добавление объектов завершено за %d мс\n", time / 1000000);
    }

    void search(String ss){
        int count = 0;
        System.out.printf(" Поиск символов - %s в коллекции\n", ss);
        this.st = System.nanoTime();
        System.out.printf("  %s объемом - %d из объектов типа Box, с 2 полями Name & Date.\n", this.hs.getClass().getSimpleName(), this.hs.size());
        for (Data.Box box : this.hs) {
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

        if(this.hs != null){
            hs.clear();
        }
    }
}
