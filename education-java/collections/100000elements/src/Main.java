import java.util.*;

public class Main {
    public static void main(String[] args) {
        Data.Box[] boxes = generateObj(100000);
        String[] strgs = generateStr(100000);
        HashMap<String, Data.Box> res = new HashMap<>();
        String searchStr = "21af3";
//
//        ExAL al = new ExAL();
//        al.add(boxes);
//        al.search(searchStr);
//
//        ExLL ll = new ExLL();
//        ll.add(boxes);
//        ll.search(searchStr);
//
//        ExHS hs = new ExHS();
//        hs.add(boxes);
//        hs.search(searchStr);
        HashMap<String, Data.Box> map = new HashMap<>();
        for (int i=0; i<boxes.length; i++) {
            map.put(strgs[i], boxes[i]);
        }

        long st, time;
        st = System.nanoTime();

        for (Map.Entry<String, Data.Box> box : map.entrySet()) {
            if (box.getKey().contains(searchStr)) {
                res.put(box.getKey(), box.getValue());
            }
        }
        for (Map.Entry<String, Data.Box> box :
                res.entrySet()) {
            System.out.println(box.getKey() + " / " + box.getValue());
        }

        time = System.nanoTime() - st;
        System.out.printf("Поиск объектов завершен за %d мс\n", time / 1000000);

    }

    private static Data.Box[] generateObj(int cap){
        long st, time;
        st = System.nanoTime();
        Data data = new Data(cap);
        time = System.nanoTime() - st;
        System.out.printf("Генерация объектов завершена за %d мс\n", time / 1000000);
        System.out.println("-------------------------------------");
        return data.getBox();
    }
    private static String[] generateStr(int cap){
        String[] strs = new String[cap];
        Random random = new Random();
        char c;
        for (int i=0; i< strs.length; i++){
            strs[i] = generateString();
        }
        return strs;
    }
    private static String generateString() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }
}
