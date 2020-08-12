package com.fastfood.service.interfaces;

import com.fastfood.model.DTO.UserDTO;
import com.fastfood.model.DTO.UserLogin;
import com.fastfood.model.DTO.UserPasswordDTO;
import com.fastfood.model.User;
import org.springframework.stereotype.Service;

public interface UserInterface {
    User fetchCurrentUser(String userId);

    User saveNewUser(UserDTO userDTO);

    User updateUser(User user);

    User changePasswordUser(UserPasswordDTO userDTO);

    User loginUser(UserLogin userLogin);

    User findById(String id);
}
