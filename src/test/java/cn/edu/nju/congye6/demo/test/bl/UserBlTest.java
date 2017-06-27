package cn.edu.nju.congye6.demo.test.bl;

import java.util.Calendar;

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
		long start=Calendar.getInstance().getTimeInMillis();
		UserPO po;
		for(int i=0;i<1000;i++){
			po=userBl.getUser("congye7");
		}
		po=userBl.getUser("congye7");
		long end=Calendar.getInstance().getTimeInMillis();
		long cache=end-start;
		
		
		start=Calendar.getInstance().getTimeInMillis();
		for(int i=0;i<1000;i++){
			po=userBl.getUser("congye8");
		}
		end=Calendar.getInstance().getTimeInMillis();
		
		System.out.println((end-start));
		System.out.println(cache);
		
	}
	
}
