package task.opgg.domain.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import task.opgg.domain.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class UserTest {

    @Autowired private UserRepository userRepository;

    @Test
    public void save() {
        User user = new User();
        user.setUsername("구리빵");
        user.setRank(user.MyRank(user));

        userRepository.save(user);
    }
}