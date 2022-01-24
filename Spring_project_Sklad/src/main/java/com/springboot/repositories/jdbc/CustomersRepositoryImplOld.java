//package com.innopolis.springboot.repositories.jdbc;
//import com.innopolis.springboot.models.Customer;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.util.List;
//
//
//@Component
//public class CustomersRepositoryImpl implements CustomersRepository {
//
//    //language=SQL
//    private static final String SQL_INSERT = "insert into customer(first_name, last_name) values(?, ?)";
//
//    //language=SQL
//    private static final String SQL_SELECT_ALL = "select * from customer order by id";
//
//    private static final String SQL_DELETE_BY_ID = "delete from customer where id = ?";
//    private static final String SQL_SELECT_BY_ID = "select * from customer where id = ?";
//    //language=SQL
//    private static final String SQL_UPDATE_BY_ID = "update customer set first_name = ?, last_name = ? where id = ?";
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public CustomersRepositoryImpl(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    private static final RowMapper<Customer> productRowMapper = (row, rowNumber) -> {
//        int id = row.getInt("id");
//        String firstName = row.getString("first_name");
//        String secondName = row.getString("last_name");
//        return new Customer(id, firstName, secondName);
//    };
//
//    @Override
//    public void save(Customer customer) {
//        jdbcTemplate.update(SQL_INSERT, customer.getFirst_name(), customer.getLast_name());
//    }
//
//    @Override
//    public List<Customer> findAll() {
//        return jdbcTemplate.query(SQL_SELECT_ALL, productRowMapper);
//    }
//
//    @Override
//    public void delete(Long id) {
//        jdbcTemplate.update(SQL_DELETE_BY_ID, id);
//    }
//
//    @Override
//    public Customer findById(Long customerId) {
//        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, productRowMapper, customerId);
//    }
//
//    @Override
//    public void update(Long customerId, Customer customer) {
//        jdbcTemplate.update(SQL_UPDATE_BY_ID, customer.getFirst_name(), customer.getLast_name(), customerId);
//    }
//}