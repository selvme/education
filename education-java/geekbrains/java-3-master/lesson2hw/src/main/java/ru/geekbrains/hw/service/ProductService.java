package ru.geekbrains.hw.service;

import ru.geekbrains.hw.service.repository.JdbcDAOimpl;
import ru.geekbrains.hw.service.repository.ProductDAO;
import java.sql.*;
import static java.lang.Math.random;

public class ProductService implements AutoCloseable{

    private final Connection connection;
    private final ProductDAO dao;

    public ProductService(String dbUrl) {
        connectDriver();
        this.connection = createConnection(dbUrl);
        this.dao = new JdbcDAOimpl(connection);
        try {
            init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void init() throws SQLException {
        connection.setAutoCommit(false);
        try {
            Statement dropTable = connection.createStatement();
            dropTable.execute("DROP TABLE IF EXISTS product");
            dropTable.execute("CREATE TABLE IF NOT EXISTS product "
                    + "("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + " prodid INTEGER NOT NULL,"
                    + " title TEXT NOT NULL,"
                    + " cost INTEGER NOT NULL"
                    + ")"
            );
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product"
                    + " (prodid, title, cost)"
                    + " VALUES(?, ?, ?)");
            for (int i=0; i < 10_000; i++){
                preparedStatement.setInt(1,((int) (random() * 100) + 1));
                preparedStatement.setString(2, "товар" + i);
                preparedStatement.setInt(3, (int) (random() * 100) + i);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
        }catch (SQLException e){
            connection.rollback();
            e.printStackTrace();
        }finally {
            connection.setAutoCommit(true);
        }
    }

    public ProductDAO getDao() {
        return dao;
    }

    private Connection createConnection(String dbUrl) {
        try {
            return DriverManager.getConnection("jdbc:sqlite:" + dbUrl);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Invalid database URL: " + dbUrl);
        }
    }

    private void connectDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to find JDBC driver", e);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null){
            connection.close();
        }
    }
}
