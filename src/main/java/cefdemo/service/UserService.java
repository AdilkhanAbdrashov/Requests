package cefdemo.service;

import cefdemo.dto.UserDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    UserDto createUser(UserDto userDto);
}
