package com.epam.selectioncommittee.controller.command.user;

import com.epam.selectioncommittee.controller.command.Command;
import com.epam.selectioncommittee.controller.mapper.UserFormMapper;
import com.epam.selectioncommittee.model.dto.UserForm;
import com.epam.selectioncommittee.model.exception.EmailIsReservedException;
import com.epam.selectioncommittee.model.exception.UsernameIsReservedException;
import com.epam.selectioncommittee.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class PostCreateUser implements Command {

    UserService userService;

    public PostCreateUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        UserForm userForm = UserFormMapper.mapper(request);

        try {
            userService.createUser(userForm);
            return "redirect:/registration";
        }
        catch (UsernameIsReservedException exception){



            request.setAttribute("LoginIsReserved",true);
        }
        catch (EmailIsReservedException exception){



            request.setAttribute("EmailIsReserved",true);
        }


        return "registration.jsp";
    }


    }
