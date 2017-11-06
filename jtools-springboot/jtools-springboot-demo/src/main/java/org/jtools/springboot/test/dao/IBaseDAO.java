package org.jtools.springboot.test.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDAO<Entity> {
	
	public void saveEntity(Entity entity);

	public void deleteEntity(int id);

	public void updateEntity(Entity entity);

	public List<Entity> findAll();

	public Entity findEntityByCondition(Map<Object, Object> paramsMap);
}
