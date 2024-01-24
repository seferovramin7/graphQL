package com.example.graphql.controller;

import com.example.graphql.dao.UserDao;
import com.example.graphql.dto.UserDto;
import com.example.graphql.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @QueryMapping
    List<UserDao> getAllUsers(){
        return userService.getAllUsers();
    }

    @MutationMapping
    UserDao createUser(@Argument UserDto userDto){
        return userService.createUser(userDto);
    }

    @MutationMapping
    UserDao updateUser(@Argument UserDto userDto,@Argument Long id){
        return  userService.updateUser(userDto,id);
    }
    @MutationMapping
    Boolean deleteUser(@Argument Long id){
        return  userService.deleteUser(id);
    }

}
