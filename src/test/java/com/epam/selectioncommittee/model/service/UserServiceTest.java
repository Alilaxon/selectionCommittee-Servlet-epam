package com.epam.selectioncommittee.model.service;

import com.epam.selectioncommittee.model.builders.UserBuilder;
import com.epam.selectioncommittee.model.builders.UserFormBuilder;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

class UserServiceTest {



    private UserRepository userRepository = mock(UserRepository.class);;

    private RoleRepository roleRepository = mock(RoleRepository.class);

    private PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);

    private UserService userService = new UserService(userRepository,passwordEncoder,roleRepository);

    private User USER;

    private UserForm USER_FORM;

    private final static Long ID = 1L;

    private final static String USERNAME = "TestUser";

    private final static String PASSWORD = "qwerty12";

    private final static String PASSWORD_ENCODED = "$2a$10$N6TSClHcE.f/AvwwJNruT.wrZVNIW6cqNIN9h97BnyTwp4TNnf53K";

    private final static String EMAIL = "HarryPotter@gmail.com";

    private final static String FIRSTNAME = "Harry";

    private final static String SURNAME = "Potter";

    private final static String CITY = "London";

    private final static String REGION = "England";

    private final static String INSTITUTION = "Hogwarts";

    private final static Role ROLE = new Role(ID,Role.RoleName.USER);

    @BeforeEach
    void setUp() {

        USER = UserBuilder.builder()
                .username(USERNAME)
                .password(PASSWORD_ENCODED)
                .email(EMAIL)
                .firstname(FIRSTNAME)
                .surname(SURNAME)
                .city(CITY)
                .region(REGION)
                .institution(INSTITUTION)
                .role(ROLE)
                .blocked(false)
                .build();

        USER_FORM = UserFormBuilder.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .email(EMAIL)
                .firstname(FIRSTNAME)
                .surname(SURNAME)
                .city(CITY)
                .region(REGION)
                .institution(INSTITUTION)
                .build();
    }

    @Test
    void createUser() throws EmailIsReservedException, UsernameIsReservedException {
        when(userRepository.existsByUsername(USERNAME)).thenReturn(false);
        when(userRepository.existsByEmail(EMAIL)).thenReturn(false);
        when(passwordEncoder.encode(PASSWORD)).thenReturn(PASSWORD_ENCODED);
        when(roleRepository.findByRoleName(Role.RoleName.USER)).thenReturn(ROLE);
        when(userRepository.save(USER)).thenReturn(USER);

        assertEquals(userService.createUser(USER_FORM),USER);
        verify(userRepository,times(1)).save(USER);
    }

    @Test
    void createUserThrowsUsernameIsReservedException() {
        when(userRepository.existsByUsername(USERNAME)).thenReturn(true);
        assertThrows(UsernameIsReservedException.class ,() -> userService.createUser(USER_FORM));
    }

    @Test
    void CreateUserThrowsEmailIsReservedException() {
        when(userRepository.existsByEmail(EMAIL)).thenReturn(true);
        assertThrows(EmailIsReservedException.class ,() -> userService.createUser(USER_FORM));
    }

    @Test
    void authentication() throws UserIsBlockedException, AuthenticationException {
        when(passwordEncoder.encode(PASSWORD)).thenReturn(PASSWORD_ENCODED);
        when(userRepository.findByUsernameAndPassword(USERNAME,PASSWORD_ENCODED)).thenReturn(USER);
        assertEquals(userService.Authentication(USERNAME,PASSWORD),USER);

    }

    @Test
    void authenticationThrowsAuthenticationException()  {
        when(passwordEncoder.encode(PASSWORD)).thenReturn(PASSWORD_ENCODED);
        when(userRepository.findByUsernameAndPassword(USERNAME,PASSWORD_ENCODED)).thenReturn(null);
        assertThrows(AuthenticationException.class,() -> userService.Authentication(USERNAME,PASSWORD));

    }

    @Test
    void authenticationThrowsUserIsBlockedException()  {
        USER.setBlocked(true);
        when(passwordEncoder.encode(PASSWORD)).thenReturn(PASSWORD_ENCODED);
        when(userRepository.findByUsernameAndPassword(USERNAME,PASSWORD_ENCODED)).thenReturn(USER);
        assertThrows(UserIsBlockedException.class,() -> userService.Authentication(USERNAME,PASSWORD));

    }

    @Test
    void findUserById() {
        when(userRepository.findById(ID)).thenReturn(USER);
        assertEquals(userService.findUserById(ID),USER);
        verify(userRepository,times(1)).findById(ID);
    }

    @Test
    void getAllUsers() {
        when(userRepository.findAllByRole()).thenReturn(List.of(USER));
        assertEquals(userService.getAllUsers(),List.of(USER));
    }

    @Test
    void findByName() {
        when(userRepository.findByUsername(USERNAME)).thenReturn(USER);
        assertEquals(userService.findByName(USERNAME),USER);
    }

    @Test
    void blockUserById() {
        //TODO
    }

    @Test
    void unblockUserById() {
        //TODO
    }
}