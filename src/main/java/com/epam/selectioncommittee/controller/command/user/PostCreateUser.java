package com.epam.selectioncommittee.controller.command.user;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.controller.mapper.UserFormMapper;
import com.epam.selectioncommittee.controller.util.Validator;
import com.epam.selectioncommittee.model.dto.UserForm;
import com.epam.selectioncommittee.model.exception.EmailIsReservedException;
import com.epam.selectioncommittee.model.exception.UsernameIsReservedException;
import com.epam.selectioncommittee.model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class PostCreateUser implements Command {

    private static final Logger log = LogManager.getLogger(PostCreateUser.class);

    UserService userService;

    public PostCreateUser(UserService userService) {

        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        UserForm userForm = UserFormMapper.mapper(request);

        log.info("User = {} want create account", userForm.getUsername());
        log.info("temp ms {} and {}",userForm.getPassword(),userForm.getPasswordCopy());
         if(Validator.validate(userForm,request)) {
            try {

                userService.createUser(userForm);
                return "redirect:/registered";

            } catch (UsernameIsReservedException exception) {
                request.setAttribute("LoginIsReserved", true);
            } catch (EmailIsReservedException exception) {
                request.setAttribute("EmailIsReserved", true);
            }
        }
         UserFormMapper.request(userForm,request);
        return "/jsp/registration.jsp";
    }

}

