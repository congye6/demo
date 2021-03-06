package cn.edu.nju.congye6.demo.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.nju.congye6.demo.dao.user.UserMapper;
import cn.edu.nju.congye6.demo.po.UserPO;
import cn.edu.nju.congye6.demo.test.ConfigFile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ConfigFile.SPRING_MVC,ConfigFile.SPRING_MYBATIS
		,ConfigFile.SPRING_REDIS,ConfigFile.SPRING_SERVICE})
public class UserDataRedisTest {

	@Autowired
	@Qualifier("user_redis")
	private UserMapper userData;
	
	@Test
	public void addUser(){
		UserPO user=new UserPO("congye6", "n", "cc");
		boolean result=userData.addUser(user);
		System.out.println("add data result:"+result);
	}
	
	@Test
	public void getUser(){
		UserPO user=userData.getUser("congye6");
		if(user!=null){
			System.out.println(user.getName()+" "+user.getPassword());
		}
		
		System.out.println("get user? "+(userData.getUser("hhh")!=null));
	}
	
	@Test
	public void updateUser(){
		UserPO user=new UserPO("congye", "999", "99");
		userData.updateUser(user);
	}
	
	@Test
	public void deleteUser(){
		userData.deleteUser("congye");
	}
	
}
