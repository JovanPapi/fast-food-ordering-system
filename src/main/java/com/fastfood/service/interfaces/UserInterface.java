package com.fastfood.service.interfaces;

import com.fastfood.model.DTO.UserDTO;
import com.fastfood.model.DTO.UserLogin;
import com.fastfood.model.DTO.UserPasswordDTO;
import com.fastfood.model.Product;
import com.fastfood.model.User;
import java.util.*;

public interface UserInterface {
    User fetchCurrentUser(String userId);

    User saveNewUser(UserDTO userDTO);

    User updateUser(User user);

    User changePasswordUser(UserPasswordDTO userDTO);

    User loginUser(UserLogin userLogin);

    User findById(String id);

    List<Product> fetchUserProductCart();
}
