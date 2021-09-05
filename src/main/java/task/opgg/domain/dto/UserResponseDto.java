package task.opgg.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import task.opgg.domain.entity.Rank;
import task.opgg.domain.entity.User;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Long id;
    private String username;
    private Rank rank;

    public UserResponseDto(User user) {
        this.rank = user.getRank();
    }
}
