package org.jtools.springboot.test.dao.impl;

import java.util.List;
import java.util.Map;

import org.jtools.springboot.test.dao.IBaseDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
	
@Repository
public class BaseDAOImpl<Entity> implements IBaseDAO<Entity> {
	private static Logger log = LoggerFactory.getLogger(BaseDAOImpl.class);
	
//	private InitLevelDB db;

	public void saveEntity(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	public void deleteEntity(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateEntity(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	public List<Entity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Entity findEntityByCondition(Map<Object, Object> paramsMap) {
		// TODO Auto-generated method stub
		for (Object object : paramsMap.keySet()) {
//			if(object instanceof String){
//				paramsMap.get(object);
//			}
		}
		return null;
	}

}
