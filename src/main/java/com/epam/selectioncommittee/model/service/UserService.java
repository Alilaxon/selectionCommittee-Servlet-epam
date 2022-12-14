package com.epam.selectioncommittee.model.service;

import com.epam.selectioncommittee.model.builders.UserBuilder;
import com.epam.selectioncommittee.model.dao.RoleRepository;
import com.epam.selectioncommittee.model.dao.UserRepository;
import com.epam.selectioncommittee.model.dto.UserForm;
import com.epam.selectioncommittee.model.entity.Role;
import com.epam.selectioncommittee.model.entity.User;
import com.epam.selectioncommittee.model.exception.AuthenticationException;
import com.epam.selectioncommittee.model.exception.EmailIsReservedException;
import com.epam.selectioncommittee.model.exception.UserIsBlockedException;
import com.epam.selectioncommittee.model.exception.UsernameIsReservedException;
import com.epam.selectioncommittee.model.service.util.PasswordEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserService {
    private static final Logger log = LogManager.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;



    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(UserForm userForm)
            throws UsernameIsReservedException, EmailIsReservedException {

        checkUsername(userForm.getUsername());
        checkEmail(userForm.getEmail());
        log.info("{}",userForm.toString());

        log.info("User '{}' was created", userForm.getUsername());

        return userRepository.save(UserBuilder.builder()
                .username(userForm.getUsername())
                .email(userForm.getEmail())
               .password(passwordEncoder.encode(userForm.getPassword()))
                .role(roleRepository.findByRoleName(Role.RoleName.USER))
                .firstname(userForm.getFirstname())
                .surname(userForm.getSurname())
                .city(userForm.getCity())
                .region(userForm.getRegion())
                .institution(userForm.getInstitution())
                .blocked(false)
                .build());
    }

    public User Authentication(String username, String password) throws UserIsBlockedException, AuthenticationException {

        password = passwordEncoder.encode(password);

        User user = userRepository.findByUsernameAndPassword(username,password);

        if (user != null) {

            if (!user.getBlocked()) {

                log.warn("User = {} enter into system",user.getUsername());

                return user;
            } else {
                log.warn("User = {} is blocked",user.getUsername());
                throw new UserIsBlockedException();

            }
        } else {
            log.warn("User = {} not found",username);

            throw new AuthenticationException();
        }
    }

    private void checkUsername(String login) throws UsernameIsReservedException {

        if (userRepository.existsByUsername(login)) {

            log.warn(" '{}' is reserved", login);
            throw new UsernameIsReservedException();

        }
        System.out.println("false");
    }

    private void checkEmail(String email)
            throws EmailIsReservedException {

        if (userRepository.existsByEmail(email)) {

            log.warn(" '{}' is reserved", email);

            throw new EmailIsReservedException();
        }

    }

    private User findByUsername(String username) {

        return userRepository.findByUsername(username);

    }

    public User findUserById(Long id) {

        return userRepository.findById(id);
    }




    public List<User> getAllUsers() {

        return userRepository.findAllByRole();
    }

    public User findByName(String name) {

        return userRepository.findByUsername(name);
    }

    public User blockUserById(Long id) {

        User user = userRepository.findById(id);
        user.setBlocked(true);
        log.info(" '{}' is blocked", user.getUsername());
        return userRepository.update(user);
    }

    public User unblockUserById(Long id) {

        User user = userRepository.findById(id);
        user.setBlocked(false);
        log.info(" '{}' is unblocked", user.getUsername());

        return userRepository.update(user);

    }
}
