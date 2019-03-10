package com.github.mcortegana.usecases.validator;

import com.github.mcortegana.core.entity.User;
import com.github.mcortegana.core.exception.UserValidationException;
import org.apache.commons.lang.StringUtils;

public class UserValidator {

    public static void validateCreateUser(final User user) {
        if (user == null)
            throw new UserValidationException("User must not be null");
        if (isBlank(user.getEmail()))
            throw new UserValidationException("Email must not be null");
        if (isBlank(user.getFirstName()))
            throw new UserValidationException("First name must not be null");
        if (isBlank(user.getLastName()))
            throw new UserValidationException("Last name must not be null");
    }

    private static Boolean isBlank(final String str) {
        return StringUtils.isBlank(str);
    }

}
