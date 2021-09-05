package task.opgg.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "소환사 명을 입력해주세요.")
    private String username;
}
