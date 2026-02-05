package com.company.admindashboard.mapper;

import com.company.admindashboard.dto.UserRequest;
import com.company.admindashboard.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toEntity(UserRequest userRequest){
        UserEntity entity = new UserEntity();
        entity.setUsername(userRequest.getUsername());
        entity.setPassword(userRequest.getPassword());
        entity.setRole(userRequest.getRole());

        return entity;
    }
}
