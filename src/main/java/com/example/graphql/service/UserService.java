package com.example.graphql.service;

import com.example.graphql.dao.UserDao;
import com.example.graphql.dto.UserDto;
import com.example.graphql.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDao> getAllUsers(){
       return userRepository.findAll();
    }

    public UserDao createUser(UserDto userDto){
        UserDao userDao = new UserDao();
        userDao.setName(userDto.getName());
        userDao.setSurname(userDto.getSurname());
        return  userRepository.save(userDao);
    }

    public UserDao updateUser(UserDto userDto,Long id) {
       UserDao inDB= userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
       inDB.setName(userDto.getName());
       inDB.setSurname(userDto.getSurname());
       return   userRepository.save(inDB);
    }

    public Boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return  true;
    }
}
