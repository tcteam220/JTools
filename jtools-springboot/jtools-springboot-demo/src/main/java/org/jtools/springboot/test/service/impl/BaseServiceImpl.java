package org.jtools.springboot.test.service.impl;

import java.util.List;
import java.util.Map;

import org.jtools.springboot.test.dao.IBaseDAO;
import org.jtools.springboot.test.service.IBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl<Entity> implements IBaseService<Entity> {
	private static Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	@Autowired
	private IBaseDAO baseDAO; 

	public void saveEntity(Entity entity) {
		// TODO Auto-generated method stub
		baseDAO.saveEntity(entity);
	}

	public void deleteEntity(int id) {
		// TODO Auto-generated method stub
		baseDAO.deleteEntity(id);
	}

	public void updateEntity(Entity entity) {
		// TODO Auto-generated method stub
		baseDAO.updateEntity(entity);
	}

	public List<Entity> findAll() {
		// TODO Auto-generated method stub
		return baseDAO.findAll();
	}

	public Entity findEntityByCondition(Map<Object, Object> paramsMap) {
		// TODO Auto-generated method stub
		return (Entity) baseDAO.findEntityByCondition(paramsMap);
	}

}
