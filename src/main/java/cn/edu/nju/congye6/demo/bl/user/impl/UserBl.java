package cn.edu.nju.congye6.demo.bl.user.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.nju.congye6.demo.bl.user.UserBlService;
import cn.edu.nju.congye6.demo.po.UserPO;
@Service
@Transactional
public class UserBl implements UserBlService{
	
	

	@Override
	public boolean addUser(UserPO user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserPO getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(UserPO user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
