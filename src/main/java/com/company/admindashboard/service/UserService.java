package com.company.admindashboard.service;

import com.company.admindashboard.dto.UserRequest;
import com.company.admindashboard.entity.UserEntity;
import com.company.admindashboard.mapper.UserMapper;
import com.company.admindashboard.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserRequest request){
        if(userRepository.findByUsername(request.getUsername()).isPresent()){
            throw new IllegalArgumentException(" Username already present");
        }
        UserEntity entity = userMapper.toEntity(request);
        String encoded  =passwordEncoder.encode((request.getPassword()));
        entity.setPassword(encoded);
        userRepository.save(entity);


    }
}
