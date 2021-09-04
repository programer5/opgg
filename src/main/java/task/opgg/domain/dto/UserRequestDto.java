package task.opgg.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UserRequestDto {

    @NotNull(message = "소환사 명을 입력해주세요.")
    private String username;
}
