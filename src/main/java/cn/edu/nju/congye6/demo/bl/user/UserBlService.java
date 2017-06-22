package cn.edu.nju.congye6.demo.bl.user;

import cn.edu.nju.congye6.demo.po.UserPO;

public interface UserBlService {

	
	public boolean addUser(UserPO user);
	
	public UserPO getUser(String username);
	
	public boolean updateUser(UserPO user);
	
	public boolean deleteUser(String username);	
	
	
	
}
