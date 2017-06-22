package cn.edu.nju.congye6.demo.tool.redis;

import java.util.concurrent.locks.ReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
/**
 * TODO實現mybatis緩存
 * @author cong
 *
 */
public class RedisCache implements Cache{

	@Autowired
	private StringRedisTemplate redis;
	
	@Override
	public void clear() {
		redis.execute(new RedisCallback<String>() {    
			public String doInRedis(RedisConnection connection) throws DataAccessException {    
				connection.flushDb();    
			   return "ok";    
			}    
		});
		
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void putObject(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object removeObject(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*public static void main(String[] args) {
		Object o=new UserBl();
		System.out.println(o.getClass());
	}*/

}
