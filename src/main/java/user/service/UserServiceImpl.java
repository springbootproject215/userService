package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import user.common.DataDefine;
import user.common.FileUtils;
import user.dto.BoardFileDto;
import user.dto.UserDto;
import user.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
    @Autowired
	private FileUtils fileUtils;
    
	@Override
	public Map<String,String> selectUser(UserDto user) throws Exception {
		Map<String,String> rtnMap = new HashMap<String,String>();
		UserDto resultUser = userMapper.selectUser( user );
		if( resultUser == null ) {
			rtnMap.put( "code" , DataDefine.getInstance().USER_LOGIN_STATE_NONE_EMAIL);
		}else {

			if( user.getPwd().equals(resultUser.getPwd())) {
				rtnMap.put( "code" , DataDefine.getInstance().USER_LOGIN_STATE_SUCCESS);
			}else {
				rtnMap.put( "code" , DataDefine.getInstance().USER_LOGIN_STATE_WRONG_PWD);
			}
		}
		return rtnMap;
	}
    
    @Override
    public void insertUser(UserDto user, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
    	userMapper.insertUser(user);
		List<BoardFileDto> list = fileUtils.parseFileInfo(user.getUserIdx(), multipartHttpServletRequest);
		if(CollectionUtils.isEmpty(list) == false){
			userMapper.insertFileList(list);
		}
	}
	
}	

