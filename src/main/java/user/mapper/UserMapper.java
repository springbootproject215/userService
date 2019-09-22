package user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import user.dto.BoardFileDto;
import org.apache.ibatis.annotations.Param;
import user.dto.UserDto;

@Mapper
public interface UserMapper {
	UserDto selectUser(UserDto userDto) throws Exception;
	void insertUser(UserDto userDto) throws Exception;
    void insertFileList(List<BoardFileDto> list) throws Exception;
	List<BoardFileDto> selectFileList(int boardIdx) throws Exception;
	BoardFileDto selectFileInformation(@Param("idx") int idx, @Param("boardIdx" )int boardIdx);
}