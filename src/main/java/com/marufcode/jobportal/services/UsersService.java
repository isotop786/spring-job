package com.marufcode.jobportal.services;

import com.marufcode.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marufcode.jobportal.entity.Users;
import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {

    private final UserRepository userRepository;

    @Autowired
    public UsersService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Users addNew(Users users)
    {
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));


        return userRepository.save(users);
    }

    public Optional<Users> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }






}
