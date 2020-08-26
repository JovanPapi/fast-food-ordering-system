package com.fastfood.web;

import com.fastfood.model.DTO.UserDTO;
import com.fastfood.model.DTO.UserLogin;
import com.fastfood.model.DTO.UserPasswordDTO;
import com.fastfood.model.Product;
import com.fastfood.model.User;
import com.fastfood.service.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserInterface userInterface;

    public UserController(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    // USER LOGIN ACTIONS
    @GetMapping("/login")
    private String logInPage(Model model) {
        UserLogin userLogin = new UserLogin();
        model.addAttribute("userLogin", userLogin);

        return "user-login";
    }

    @PostMapping("/login")
    private String logIn(UserLogin login, Model model) {
        model.addAttribute("userProfile", userInterface.loginUser(login));
        return "user-profile";
    }

    // CREATE USER ACTIONS
    @GetMapping("/create")
    private String createUserPage(Model model) {
        model.addAttribute("newUser", new UserDTO());
        return "create-user";
    }

    @PostMapping("/save-new")
    private String saveNewUser(UserDTO userDTO, Model model) {
        model.addAttribute("userProfile", userInterface.saveNewUser(userDTO));
        return "profile";
    }

    // UPDATE USER ACTIONS
    @GetMapping("/update/{id}")
    private String updateUserPage(Model model, @PathVariable String id) {
        model.addAttribute("userProfile", userInterface.findById(id));
        return "update-user";
    }

    @PostMapping("/update-user")
    private String saveUpdateUser(User user, Model model) {
        model.addAttribute("userProfile", userInterface.updateUser(user));
        return "profile";
    }

    //CHANGE USER PASSWORD ACTIONS
    @GetMapping("/change-password/{id}")
    private String changeUserPasswordPage(Model model, @PathVariable String id) {
        model.addAttribute("userProfile", userInterface.findById(id));
        return "change-user-password";
    }

    @PostMapping("/save-user-new-password")
    private String saveUserNewPassword(Model model, UserPasswordDTO userPasswordDTO) {
        model.addAttribute("userProfile", userInterface.changePasswordUser(userPasswordDTO));
        return "profile";
    }

    @GetMapping("/get-cart-products")
    private String userCart(HttpSession session) {
        session.setAttribute("userCart", userInterface.fetchUserProductCart());
        session.setAttribute("totalPrice", userInterface.fetchUserProductCart()
                .stream()
                .mapToInt(Product::getPrice).sum());
        session.setAttribute("currency","DOLLAR" );
        session.setAttribute("STRIPE_P_KEY" ,"pk_test_TKKQFrZ2nBlaSL3wILTdTfsh00Z3VIYNVg");
        return "cart";
    }

}
