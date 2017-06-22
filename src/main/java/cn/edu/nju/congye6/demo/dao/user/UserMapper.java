package cn.edu.nju.congye6.demo.dao.user;

import cn.edu.nju.congye6.demo.po.UserPO;

public interface UserMapper {

	public boolean addUser(UserPO user);
	
	public UserPO getUser(String username);
	
	public boolean updateUser(UserPO user);
	
	public boolean deleteUser(String username);
}
