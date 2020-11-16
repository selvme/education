package ru.geekbrains.hw;

import ru.geekbrains.hw.service.ProductService;
import ru.geekbrains.hw.service.repository.ProductDAO;
import ru.geekbrains.hw.userAction.AskUser;

class Execute {

    void start(){
        choiceMeth(AskUser.ask());
    }

    private void choiceMeth(String[] command){
        try (ProductService service = new ProductService("hw-lesson-2.db")) {
            ProductDAO dao = service.getDao();
            switch (command[0]) {
                case "/цена":
                    System.out.println(dao.get(command[1]));
                    break;
                case "/сменитьцену":
                    dao.changePriceByName(command[1], command[2]);
                    break;
                case "/товарыпоцене":
                    dao.getPrInRangePrice(Integer.parseInt(command[1]), Integer.parseInt(command[2]))
                            .forEach(System.out::println);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
