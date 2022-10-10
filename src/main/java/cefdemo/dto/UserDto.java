package cefdemo.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String login;
    private String IIN;
    private String BIN;
    private String password;
    private String date_of_registration;
    private String full_name;
}
