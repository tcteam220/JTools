package org.jtools.db.leveldb;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.fusesource.leveldbjni.JniDBFactory;
import org.iq80.leveldb.DB;
import org.iq80.leveldb.DBException;
import org.iq80.leveldb.Options;
import org.jtools.common.utils.PropertiesUtils;
import org.jtools.db.leveldb.common.LevelDbCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Julyme
 *
 */
public class InitLevelDB {

	private static Logger log = LoggerFactory.getLogger(InitLevelDB.class);
	
	private DB db;
	private File dbFile;
	
	
	
	public InitLevelDB(){
		String dbPath = PropertiesUtils.getString(LevelDbCommon.KEY_DB_PATH, LevelDbCommon.DEFAULT_DB_PATH);
		dbFile = new File(dbPath);
		if(!dbFile.exists()){
			log.info("levelDB path is not exists,auto create path={}",dbPath);
			dbFile.mkdirs();
		}
	}
	
	
	
	public DB openDatabase() throws IOException {
		Options options = new Options();
		options.createIfMissing(false);
		try {
			db = JniDBFactory.factory.open(dbFile, options);
		} catch (IOException e) {
			e.printStackTrace();
			options.createIfMissing(true);
			try {
				db = JniDBFactory.factory.open(dbFile, options);
			} catch (DBException dbErr) {
				dbErr.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return db;
	}
	
}
