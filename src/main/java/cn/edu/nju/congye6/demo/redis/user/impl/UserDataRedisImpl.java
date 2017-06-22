package cn.edu.nju.congye6.demo.redis.user.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.nju.congye6.demo.dao.user.UserMapper;
import cn.edu.nju.congye6.demo.po.UserPO;
import cn.edu.nju.congye6.demo.tool.JsonHelper;

@Repository("user_redis")
public class UserDataRedisImpl implements UserMapper{

	@Autowired
	protected StringRedisTemplate redisTemplate;
	
	@Autowired
	private JsonHelper jsonHelper;
	
	private static final String USER_KEY="users";
	
	@Override
	public boolean addUser(final UserPO user) {
		redisTemplate.opsForHash().put(USER_KEY, user.getUsername(), jsonHelper.getJson(user));
        return true;  
	}

	@Override
	public UserPO getUser(final String username) {
		String json=(String) redisTemplate.opsForHash().get(USER_KEY, username);
		UserPO po=jsonHelper.getObject(json, UserPO.class); 
        return po; 
	}

	@Override
	public boolean updateUser(final UserPO user) {
		if(!redisTemplate.opsForHash().hasKey(USER_KEY, user.getUsername()))
			return false;
		
		redisTemplate.opsForHash().put(USER_KEY, user.getUsername(),jsonHelper.getJson(user));
		
        return true; 
	}

	@Override
	public boolean deleteUser(String username) {
		redisTemplate.opsForHash().delete(USER_KEY,username);;
		return true;
	}

}
