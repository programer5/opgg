package task.opgg.web.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.opgg.domain.dto.UserResponseDto;
import task.opgg.domain.service.UserService;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserResponseDto> user(@PathVariable String username) {
        UserResponseDto users = userService.findByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

}
