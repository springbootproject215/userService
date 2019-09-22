package user.dto;

import lombok.Data;

@Data
public class UserDto {
	private int userIdx;
	private String id;
	private String pwd;
	private String userName;
    private String email;

}
