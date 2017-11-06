package org.jtools.db.leveldb;

import java.io.IOException;
import java.nio.charset.Charset;

import org.iq80.leveldb.DB;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Julyme
 *
 */
public class InitLevelDBTest {
	
	private Charset charset = Charset.forName("utf-8");
	
	@Test
	public void testInitLevelDb(){
		
		String key = "key1";
		String value = "value1";
		InitLevelDB initLevelDB = new InitLevelDB();
		DB db = null;
		try {
			db = initLevelDB.openDatabase();
		} catch (IOException e) {
			e.printStackTrace();
		}
		db.put(key.getBytes(charset), value.getBytes(charset));
		Assert.assertEquals(value, new String(db.get(key.getBytes(charset)),charset));
	}
	
}
