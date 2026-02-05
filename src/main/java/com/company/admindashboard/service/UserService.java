package com.company.admindashboard.service;

import com.company.admindashboard.dto.UserRequest;
import com.company.admindashboard.entity.UserEntity;
import com.company.admindashboard.mapper.UserMapper;
import com.company.admindashboard.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void createUser(UserRequest request){
        if(userRepository.findByUsername(request.getUsername()).isPresent()){
            throw new IllegalArgumentException(" Username already present");
        }
        UserEntity entity = userMapper.toEntity(request);
        userRepository.save(entity);


    }
}
