package com.fastfood.service.interfacesImpl;

import com.fastfood.Repository.UserRepository;
import com.fastfood.model.DTO.UserDTO;
import com.fastfood.model.DTO.UserLogin;
import com.fastfood.model.DTO.UserPasswordDTO;
import com.fastfood.model.User;
import com.fastfood.service.interfaces.UserInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserInterfaceImpl implements UserInterface {

    private final UserRepository userRepository;

    public UserInterfaceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User fetchCurrentUser(String userId) {
        return userRepository.findById(userId).orElse(new User());
    }

    @Override
    public User saveNewUser(UserDTO userDTO) {
        User newUser = new User(UUID.randomUUID().toString(), userDTO.getName(), userDTO.getUsername(), userDTO.getEmail(),
                userDTO.getPassword(), userDTO.getPhoneNumber(), new ArrayList<>());

        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public User updateUser(User user) {
        User inDataBase = userRepository.findById(user.getId()).get();

        inDataBase.setName(user.getName());
        inDataBase.setUsername(user.getUsername());
        inDataBase.setPhoneNumber(user.getPhoneNumber());
        inDataBase.setEmail(user.getEmail());

        userRepository.save(inDataBase);
        return inDataBase;
    }

    @Override
    public User changePasswordUser(UserPasswordDTO userDTO) {
        User inDataBase = userRepository.findAll()
                .stream()
                .filter(user -> user.getEmail().equals(userDTO.getEmail()))
                .findFirst()
                .get();

        inDataBase.setPassword(userDTO.getPassword());

        userRepository.save(inDataBase);

        return inDataBase;
    }

    @Override
    public User loginUser(UserLogin userLogin) {

        return userRepository.findAll()
                .stream()
                .filter(user -> user.getEmail().equals(userLogin.getEmail()))
                .findFirst()
                .get();
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }
}
