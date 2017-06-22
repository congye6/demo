package cn.edu.nju.congye6.demo.redis.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.JsonObject;

import cn.edu.nju.congye6.demo.dao.user.UserMapper;
import cn.edu.nju.congye6.demo.po.UserPO;
import cn.edu.nju.congye6.demo.tool.JsonHelper;


public class UserDataRedisImpl{

	@Autowired
	protected StringRedisTemplate redisTemplate;
	
	@Autowired
	private JsonHelper jsonHelper;
	
	private static final String USER_KEY="users";
	
	
	public boolean addUser(final UserPO user) {
		redisTemplate.opsForHash().put(USER_KEY, user.getUsername(), jsonHelper.getJson(user));
		
        return true;  
	}

	
	public UserPO getUser(final String username) {
		String json=(String) redisTemplate.opsForHash().get(USER_KEY, username);
		UserPO po=jsonHelper.getObject(json, UserPO.class); 
        return po; 
	}

	
	public boolean updateUser(final UserPO user) {
		if(!redisTemplate.opsForHash().hasKey(USER_KEY, user.getUsername()))
			return false;
		
		redisTemplate.opsForHash().put(USER_KEY, user.getUsername(),jsonHelper.getJson(user));
		
        return true; 
	}

	
	public boolean deleteUser(String username) {
		redisTemplate.opsForHash().delete(USER_KEY,username);;
		return true;
	}

}
