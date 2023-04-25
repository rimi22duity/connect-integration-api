package net.therap.Connect.integration.api.service;

import net.therap.Connect.integration.api.db.User;
import net.therap.Connect.integration.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author duity
 * @since 4/19/23
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }
}
