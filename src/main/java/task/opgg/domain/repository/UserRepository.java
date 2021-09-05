package task.opgg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import task.opgg.domain.dto.UserRequestDto;
import task.opgg.domain.dto.UserResponseDto;
import task.opgg.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select new task.opgg.domain.dto.UserResponseDto(u.id, u.username, u.rank) from User u")
    UserResponseDto findByUsername(String username);
}
