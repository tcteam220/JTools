package org.jtools.springboot.test.service;

import java.util.List;
import java.util.Map;

public interface IBaseService<Entity> {
	public void saveEntity(Entity entity);

	public void deleteEntity(int id);

	public void updateEntity(Entity entity);

	public List<Entity> findAll();

	public Entity findEntityByCondition(Map<Object, Object> paramsMap);
}
