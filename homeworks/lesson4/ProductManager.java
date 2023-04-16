package homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private Connection connection;
    public ProductManager(Connection connection) {
        this.connection = connection;
    }

    public boolean insert(Product product) throws Exception{
        String sql = """
                 insert into "product"("productname", "salesprice") values(?,?)
               """;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getSalesPrice());
        statement.executeUpdate();
        return true;
    }

    public boolean update(Product product) throws Exception{
        String sql = """
                UPDATE "product" SET "productname" = ?, "salesprice" = ? WHERE "productid" = ?
               """;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getSalesPrice());
        statement.setLong(3, product.getProductId());
        statement.executeUpdate();
        return true;
    }

    public boolean delete(long productId) throws Exception{
        String sql = """
                DELETE FROM "product" WHERE "productid" = ?
               """;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, productId);
        statement.executeUpdate();
        return true;
    }

    public Product find(long productId) throws Exception {
        String sql = """
                SELECT * FROM "product" WHERE "productid" = ?
               """;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, productId);
        ResultSet resultSet = statement.executeQuery();
        /*
        resultSet.last();
        int rowCount = resultSet.getRow();
        resultSet.beforeFirst();
        if(rowCount > 1){
            throw new Exception("Birden fazla değer bulundu");
        }else if(rowCount == 0){
            throw new Exception("Hiç değer bulunamadı");
        }
         */
        resultSet.next();
        return new Product(resultSet.getLong("productid"), resultSet.getString("productname"), resultSet.getDouble("salesprice"));
    }

    public List<Product> findAll() throws Exception{
        String sql = """
                SELECT * FROM "product"
               """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Product> productList = new ArrayList<>();
        while (resultSet.next()){
            productList.add(new Product(resultSet.getLong("productid"), resultSet.getString("productname"), resultSet.getDouble("salesprice")));
        }
        return productList;
    }
}
