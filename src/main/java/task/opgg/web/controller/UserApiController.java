package task.opgg.web.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import task.opgg.common.errormessage.ErrorResponse;
import task.opgg.domain.dto.UserRequestDto;
import task.opgg.domain.dto.UserResponseDto;
import task.opgg.domain.entity.User;
import task.opgg.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostConstruct
    public void save() {
        User user = new User();
        user.setUsername("opgg");
        user.setScore(500);
        user.setRank(user.MyRank(user));

        userService.save(user);
    }

    @GetMapping("/search")
    public ResponseEntity findUser(@RequestParam("username") String username) {

        UserResponseDto users = userService.findByUsername(username);

        if (!StringUtils.hasText(username)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponse("소환사 명을 입력해 주세요!"));
        } else if (users == null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ErrorResponse("입력하신 소환사명은 존재하지 않습니다!"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/search/{userId}")
    public ResponseEntity refreshUser(@PathVariable("userId") Long userId) {

        Optional<User> user = userService.findById(userId);
        System.out.println("user = " + user);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
