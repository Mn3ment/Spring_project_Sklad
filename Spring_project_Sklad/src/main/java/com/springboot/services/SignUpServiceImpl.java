package com.springboot.services;

import com.springboot.forms.SignUpForm;
import com.springboot.models.Users;
import com.springboot.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SignUpServiceImpl implements SignUpService {
    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    @Override
    public void signUpUser(SignUpForm form) {
        Users user = Users.builder()
                .first_name(form.getFirst_name())
                .last_name(form.getLast_name())
                .email(form.getEmail())
                .role(Users.Role.USER)
                .hashPassword(passwordEncoder.encode(form.getHashPassword()))
                .build();
        usersRepository.save(user);
    }
}
