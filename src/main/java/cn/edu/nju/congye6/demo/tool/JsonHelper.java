package cn.edu.nju.congye6.demo.tool;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

@Component
public class JsonHelper {

	/**
	 * 根據json字符串和class獲取對象
	 * @param json
	 * @param clazz
	 * @return
	 */
	public <T> T getObject(String json,Class<T> clazz){
		JSONObject jsonObj = new JSONObject().fromObject(json);//将json字符串转换为json对象
		T obj = (T)JSONObject.toBean(jsonObj,clazz);//将建json对象转换为Person对象
		return obj;
	}
	
	/**
	 * 根據對象獲取json字符串
	 * @param obj
	 * @return
	 */
	public <T> String getJson(T obj){
		JSONObject json = JSONObject.fromObject(obj);//将java对象转换为json对象
		String str = json.toString();//将json对象转换为字符串
		return str;
	}
	
}
