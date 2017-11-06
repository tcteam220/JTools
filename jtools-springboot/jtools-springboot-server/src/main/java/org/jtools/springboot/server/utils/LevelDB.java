package org.jtools.springboot.server.utils;

import java.io.IOException;

import org.iq80.leveldb.DB;
import org.jtools.db.leveldb.InitLevelDB;

/**
 * 
 * @author julyme
 *
 */
public class LevelDB {
	
	private static DB db = null;
	static{
		InitLevelDB initLevelDB = new InitLevelDB();
		try {
			db = initLevelDB.openDatabase();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void put(byte[] key, byte[] value){
		db.put(key, value);
	}
	
	public static byte[] get(byte[] key){
		return db.get(key);
	}
	
}
