package cn.edu.nju.congye6.demo.bl.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.nju.congye6.demo.bl.user.UserBlService;
import cn.edu.nju.congye6.demo.dao.user.UserMapper;
import cn.edu.nju.congye6.demo.po.UserPO;
@Service
@Transactional
public class UserBl implements UserBlService{
	
	@Autowired
	@Qualifier("userMapper")
	private UserMapper dbMapper;
	
	@Autowired
	@Qualifier("user_redis")
	private UserMapper cacheMapper;

	@Override
	public boolean addUser(UserPO user) {
		dbMapper.addUser(user);
		cacheMapper.addUser(user);
		return true;
	}

	@Override
	public UserPO getUser(String username) {
		UserPO result=cacheMapper.getUser(username);
		if(result!=null)
			return result;
		System.out.println("no cache");
		return dbMapper.getUser(username);
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
