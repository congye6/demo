package cn.edu.nju.congye6.demo.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.nju.congye6.demo.dao.user.UserMapper;
import cn.edu.nju.congye6.demo.po.UserPO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-redis.xml","classpath:spring-mvc.xml"})
public class UserDataRedisTest {

	/*@Autowired
	private UserDataMapper userData;
	
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
	}*/
	
}
