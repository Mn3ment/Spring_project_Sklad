package com.springboot.forms;

import lombok.Data;



@Data
public class OrdersForm {
    private Integer file_info_id;
    private Integer customer_id;
    private Integer product_id;
    private String orders_date;
    private Integer count;

}
