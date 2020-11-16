package ru.geekbrains.hw.service.repository;

import ru.geekbrains.hw.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDAOimpl implements ProductDAO {

    private Connection connection;

    public JdbcDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Product get(String name) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM product WHERE title = \"" + name + "\"");
            return createProduct(resultSet);
        } catch (SQLException e) {
            System.out.println("There is no such product!");
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void changePriceByName(String name, String price) {
        Product product = get(name);
        product.setCost(Integer.parseInt(price));
        saveProduct(product);
    }

    @Override
    public List<Product> getPrInRangePrice(int start, int end) {
        List<Product> products = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM product WHERE cost BETWEEN " + start + " AND " + end);
            while(resultSet.next()){
                products.add(createProduct(resultSet));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return products;
    }

    @Override
    public void saveProduct(Product product) {
        PreparedStatement create = null;
        Statement update = null;
        try {
            Product prInDB = get(product.getTitle());
            if (prInDB == null){
                create = connection.prepareStatement("INSERT INTO product (prodid, title, cost) "
                        + "VALUES(?, ?, ?)");
                create.setInt(1, product.getProdid());
                create.setString(1, product.getTitle());
                create.setInt(1, product.getCost());
                create.executeUpdate();

                System.out.println("Record create");
            }else {
                update = connection.createStatement();
                update.execute("UPDATE product SET"
                        + " prodid = " + product.getProdid()
                        + ", title = \"" + product.getTitle() + "\""
                        + ", cost = " + product.getCost());

                System.out.println("Record updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (create != null){
                try {
                    create.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (update != null){
                try {
                    update.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Product createProduct(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int prodid = resultSet.getInt("prodid");
        String title = resultSet.getString("title");
        Integer cost = resultSet.getInt("cost");

        Product product = new Product();
        product.setId(id);
        product.setProdid(prodid);
        product.setTitle(title);
        product.setCost(cost);

        return product;
    }
}
