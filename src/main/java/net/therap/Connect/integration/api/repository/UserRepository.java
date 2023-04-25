package net.therap.Connect.integration.api.repository;

import net.therap.Connect.integration.api.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author duity
 * @since 4/19/23
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
