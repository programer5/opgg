package task.opgg.web.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import task.opgg.domain.dto.ErrorResponse;
import task.opgg.domain.dto.UserResponseDto;
import task.opgg.domain.service.UserService;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @GetMapping("/search")
    public ResponseEntity user(@RequestParam("username") String username) {

        UserResponseDto users = userService.findByUsername(username);

        if (!StringUtils.hasText(username)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponse("소환사 명을 입력해 주세요!"));
        } else if (!users.getUsername().equals(username)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponse("입력하신 소환사명은 존재하지 않습니다"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
