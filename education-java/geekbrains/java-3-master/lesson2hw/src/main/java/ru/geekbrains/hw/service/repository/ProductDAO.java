package ru.geekbrains.hw.service.repository;

import ru.geekbrains.hw.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {

    Product createProduct(ResultSet resultSet) throws SQLException;

    void saveProduct(Product product);

    Product get(String name);

    void changePriceByName(String name, String price);

    List<Product> getPrInRangePrice(int start, int end);
}
