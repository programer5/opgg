package task.opgg.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import task.opgg.domain.entity.Rank;
import task.opgg.domain.entity.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Long id;
    private String username;
    private int score;
    private Rank rank;

    public UserResponseDto(Long id, String username, Rank rank) {
        this.id = id;
        this.username = username;
        this.rank = rank;
    }

    public UserResponseDto(User user) {
        this.rank = user.getRank();
    }

}
