package com.sutikshan.bullstreet.services;

import com.sutikshan.bullstreet.config.JwtProvider;
import com.sutikshan.bullstreet.domain.VerificationType;
import com.sutikshan.bullstreet.models.TwoFactorAuth;
import com.sutikshan.bullstreet.models.User;
import com.sutikshan.bullstreet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByJwt(String jwt) throws Exception {
        String email = JwtProvider.getEmailFromJwtToken(jwt);
        User user = userRepository.findByEmail(email);
        if(user==null){
            throw new Exception("User not found");
        }
        return user;
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user==null){
            throw new Exception("User not found");
        }
        return user;
    }

    @Override
    public User findUserById(String Id) throws Exception {
        Optional<User> user = userRepository.findById(Id);
        if(user.isEmpty()){
            throw new Exception("User not found");
        }
        return user.get();
    }

    @Override
    public User enableTwoFactorAuthentication(VerificationType verificationType, String sendTo, User user) {
        TwoFactorAuth twoFactorAuth =  new TwoFactorAuth();
        twoFactorAuth.setEnabled(true);
        twoFactorAuth.setSendTo(verificationType);

        user.setTwoFactorAuth(twoFactorAuth);

        return userRepository.save(user);
    }

    @Override
    public User updatePassword(User user, String NewPassword) {
        user.setPassword(NewPassword);
        return userRepository.save(user);
    }
}
