package task.opgg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import task.opgg.domain.dto.UserResponseDto;
import task.opgg.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select new task.opgg.domain.dto.UserResponseDto(u.id, u.username, u.rank) from User u where u.username = :username")
    UserResponseDto findByUsername(@Param("username") String username);

}
