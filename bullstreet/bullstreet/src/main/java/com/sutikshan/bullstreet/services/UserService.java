package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.domain.VerificationType;
import com.sutikshan.bullstreet.models.User;

public interface UserService {
    public User findUserByJwt(String jwt) throws Exception;

    public User findUserByEmail(String email) throws Exception;

    public User findUserById(String Id) throws Exception;

    public User enableTwoFactorAuthentication(VerificationType verificationType, String sendTo, User user);

    User updatePassword(User user, String NewPassword);
}
