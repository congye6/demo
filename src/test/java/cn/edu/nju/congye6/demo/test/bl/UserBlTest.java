package cn.edu.nju.congye6.demo.test.bl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.nju.congye6.demo.bl.user.UserBlService;
import cn.edu.nju.congye6.demo.po.UserPO;
import cn.edu.nju.congye6.demo.test.ConfigFile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ConfigFile.SPRING_MVC,ConfigFile.SPRING_REDIS,ConfigFile.SPRING_MYBATIS
		,ConfigFile.SPRING_SERVICE})
public class UserBlTest {

	@Autowired
	private UserBlService userBl;
	
	@Test
	public void addUser(){
		try{
			userBl.addUser(new UserPO("congye8", "666", "cc"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void getUser(){
		UserPO po=userBl.getUser("congye7");
		System.out.println(po.getPassword());
		po=userBl.getUser("congye8");
		po=userBl.getUser("congye9");
		System.out.println(po==null);
	}
	
}
