package cn.edu.nju.congye6.demo.dao.user;

import cn.edu.nju.congye6.demo.po.UserPO;

public interface UserMapper {

	public void addUser(UserPO user);
	
	public UserPO getUser(String username);
	
	public void updateUser(UserPO user);
	
	public void deleteUser(String username);
}
