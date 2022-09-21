package com.epam.selectioncommittee.controller.util;

import com.epam.selectioncommittee.controller.command.admin.PostBlockUsers;
import com.epam.selectioncommittee.controller.util.Exception.*;
import com.epam.selectioncommittee.model.dto.FacultyForm;
import com.epam.selectioncommittee.model.dto.UserForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final Logger log = LogManager.getLogger(PostBlockUsers.class);

    public static final String PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).+$";

    public static final String EMAIL = "^[A-Za-z0-9._]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    private Validator() {
    }

    public static boolean facultyValid(FacultyForm facultyForm){
        return facultyForm.getBudgetPlaces() > facultyForm.getGeneralPlaces()
                || facultyForm.getRequiredSubjects().size() < 2;
    }

    public static boolean validate(UserForm userForm, HttpServletRequest request) {
        try {
            checkUsernameSize(userForm.getUsername());
            checkEmailSize(userForm.getEmail());
            checkForEmailMatchingTemplate(userForm.getEmail());
            checkPasswordSize(userForm.getPassword());
            checkPasswordsIdentical(userForm.getPassword(), userForm.getPasswordCopy());
            checkForPasswordMatchTemplate(userForm.getPassword());
            checkFirstNameSize(userForm.getFirstname());
            checkSecondNameSize(userForm.getSurname());
            checkCitySize(userForm.getCity());
            checkRegionSize(userForm.getRegion());
            checkInstitutionSize(userForm.getInstitution());
            return true;
        } catch (PasswordsNotSameException e) {log.warn("Passwords not same");
            request.setAttribute(ValidationErrors.PASSWORDS_NOT_SAME, true);
        } catch (LoginSizeOutOfBoundsException e) {log.warn("Username error");
            request.setAttribute(ValidationErrors.USERNAME_SIZE_OUT_OF_BOUNDS, true);
        } catch (PasswordSizeOutOfBoundsException e) {log.warn("Password error");
            request.setAttribute(ValidationErrors.PASSWORD_SIZE_OUT_OF_BOUNDS, true);
        } catch (FirstNameSizeOutOfBoundsException e) {log.warn("First error");
            request.setAttribute(ValidationErrors.FIRSTNAME_SIZE_OUT_OF_BOUNDS, true);
        } catch (SecondNameSizeOutOfBoundsException e) {log.warn("Second error");
            request.setAttribute(ValidationErrors.SURNAME_SIZE_OUT_OF_BOUNDS, true);
        } catch (InstitutionSizeOutOfBoundsException e) {log.warn("Institution error");
            request.setAttribute(ValidationErrors.INSTITUTION_SIZE_OUT_OF_BOUNDS, true);
        } catch (RegionSizeOutOfBoundsException e) {log.warn("Region error");
            request.setAttribute(ValidationErrors.REGION_SIZE_OUT_OF_BOUNDS, true);
        } catch (CitySizeOutOfBoundsException e) {log.warn("City error");
            request.setAttribute(ValidationErrors.CITY_SIZE_OUT_OF_BOUNDS, true);
        } catch (PasswordNotMatchTemplateException e) {log.warn("Password error");
            request.setAttribute(ValidationErrors.PASSWORD_NOT_MATCH_TEMPLATE, true);
        } catch (EmailNotMatchTemplateException e) {log.warn("Email not match template Exception");
            request.setAttribute(ValidationErrors.EMAIL_NOT_MATCH_TEMPLATE, true);
        } catch (EmailSizeOutOfBoundsException e) {log.warn("Email error");
            request.setAttribute(ValidationErrors.EMAIL_SIZE_OUT_OF_BOUNDS, true);
        }
        return false;
    }

    private static void checkPasswordsIdentical(String password, String passwordCopy)
            throws PasswordsNotSameException {
        if (!password.equals(passwordCopy)) throw new PasswordsNotSameException();

    }

    private static void checkUsernameSize(String login) throws LoginSizeOutOfBoundsException {

        final int SIZE = login.length();
        if (SIZE < 4 || SIZE > 32) throw new LoginSizeOutOfBoundsException();
    }

    private static void checkEmailSize(String email) throws EmailSizeOutOfBoundsException {

        final int SIZE = email.length();
        if (SIZE < 8 || SIZE > 64) throw new EmailSizeOutOfBoundsException();
    }

    private static void checkPasswordSize(String password) throws PasswordSizeOutOfBoundsException {

        final int SIZE = password.length();
        if (SIZE < 8 || SIZE > 64) throw new PasswordSizeOutOfBoundsException();

    }

    private static void checkFirstNameSize(String firstName) throws FirstNameSizeOutOfBoundsException {

        if (firstName.length() > 32) throw new FirstNameSizeOutOfBoundsException();
    }

    private static void checkSecondNameSize(String secondName) throws SecondNameSizeOutOfBoundsException {

        if (secondName.length() > 32) throw new SecondNameSizeOutOfBoundsException();
    }

    private static void checkCitySize(String city) throws CitySizeOutOfBoundsException {

        if (city.length() > 32) throw new CitySizeOutOfBoundsException();
    }

    private static void checkRegionSize(String region) throws RegionSizeOutOfBoundsException {

        if (region.length() > 32) throw new RegionSizeOutOfBoundsException();
    }

    private static void checkInstitutionSize(String institution) throws InstitutionSizeOutOfBoundsException {

        if (institution.length() > 32) throw new InstitutionSizeOutOfBoundsException();
    }

    private static void checkForPasswordMatchTemplate(String password) throws PasswordNotMatchTemplateException {

        Pattern pattern = Pattern.compile(PASSWORD);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) throw new PasswordNotMatchTemplateException();
    }
    private static void checkForEmailMatchingTemplate(String email) throws EmailNotMatchTemplateException {

        Pattern pattern = Pattern.compile(EMAIL);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) throw new EmailNotMatchTemplateException();
    }
}
