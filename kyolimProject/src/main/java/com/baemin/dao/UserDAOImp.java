package com.baemin.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.baemin.dto.Join;



@Repository
public class UserDAOImp implements UserDAO {
 
	@Autowired
	private SqlSessionTemplate sql;
	
	@Override
	public void join(Join join) {
		//sql.insert("user.join" , join);
		//sql.insert("user.join",join);
	}
	
	@Override
	public int overlapCheck(String value, String valueType) {
		Map<String, String> map = new HashMap<>();
		map.put("value", value);
		map.put("valueType", valueType);
		
		//return sql.selectOne("user.overlapCheck" ,map);
		return 0;
	}
 
}
