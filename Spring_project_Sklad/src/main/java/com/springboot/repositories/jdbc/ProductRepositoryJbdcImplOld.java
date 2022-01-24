//package com.innopolis.springboot.repositories.jdbc;
//import com.innopolis.springboot.models.Products;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.util.List;
//
//@Component
//public class ProductRepositoryJbdcImpl implements ProductRepository {
//
//    //language=SQL
//    private static final String SQL_INSERT = "insert into goods(description, price, number) values(?, ?, ?)";
//
//    //language=SQL
//    private static final String SQL_SELECT_ALL = "select * from goods order by id";
//
//    //language=SQL
//    private static final String SQL_SELECT_BY_PRICE = "select * from goods where price = ? order by id";
//
//    //language=SQL
//    private static final String SQL_SELECT_BY_ORDER_COUNT = "select id, description, price, count from goods g left join orders o on g.id = o.product_id where count = ?;";
//    private static final String SQL_DELETE_BY_ID = "delete from goods where id = ?";
//    private static final String SQL_SELECT_BY_ID = "select * from goods where id = ?";
//    //language=SQL
//    private static final String SQL_UPDATE_BY_ID = "update goods set description = ?, price = ?, number = ? where id = ? ";
//
//    private JdbcTemplate jdbcTemplate;
//
//    public ProductRepositoryJbdcImpl(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    private static final RowMapper<Products> productRowMapper = (row, rowNumber) -> {
//        int id = row.getInt("id");
//        String description = row.getString("description");
//        Double price = row.getDouble("price");
//        int count = row.getInt("number");
//        return new Products(id, description, price, count);
//    };
//
//    private static final RowMapper<Products> productRowMapper2 = (row, rowNumber) -> {
//        int id = row.getInt("id");
//        String description = row.getString("description");
//        Double price = row.getDouble("price");
//        int count = row.getInt("count");
//        return new Products(id, description, price, count);
//    };
//
//    @Override
//    public void save(Products product) {
//        jdbcTemplate.update(SQL_INSERT, product.getDescription(), product.getPrice(), product.getCount());
//
//    }
//
//
//    @Override
//    public List<Products> findAll() {
//        return jdbcTemplate.query(SQL_SELECT_ALL, productRowMapper);
//    }
//
//    @Override
//    public List<Products> findAllByPrice(double price) {
//        return jdbcTemplate.query(SQL_SELECT_BY_PRICE, productRowMapper, price);
//    }
//
//    @Override
//    public List<Products> findAllByOrdersCount(int ordersCount) {
//        return jdbcTemplate.query(SQL_SELECT_BY_ORDER_COUNT, productRowMapper2, ordersCount);
//    }
//
//    @Override
//    public void delete(Long id) {
//        jdbcTemplate.update(SQL_DELETE_BY_ID, id);
//    }
//
//    @Override
//    public Products findById(Long productId) {
//        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, productRowMapper, productId);
//    }
//
//    @Override
//    public void update(Long productId, Products product) {
//        jdbcTemplate.update(SQL_UPDATE_BY_ID, product.getDescription(), product.getPrice(), product.getCount(), productId);
//    }
//}
