package com.springboot.forms;

import lombok.Data;

@Data
public class SignUpForm {
    private String first_name;
    private String last_name;
    private String email;
    private String hashPassword;
}
