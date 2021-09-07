package task.opgg.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.opgg.domain.dto.UserResponseDto;
import task.opgg.domain.entity.User;
import task.opgg.domain.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public Optional<User> findById(Long userId) {

        Optional<User> user = userRepository.findById(userId);
        user.get().setScore(700);
        user.get().setRank(user.get().MyRank(user.get()));

        System.out.println(user.get().getRank());

        return user;
    }
}
