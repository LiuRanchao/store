package com.lrchao.store.database;

import android.database.sqlite.SQLiteDatabase;

import com.lrchao.store.App;
import com.lrchao.store.database.dao.AccountDao;

/**
 * Description: 操作数据库的帮助类
 *
 * @author liuranchao
 * @date 15/12/22 下午4:12
 */
public class DBManager {

    private static DBManager sInstance;

    private DaoSession daoSession;

    private DBManager(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(App.get(), "douban_read_pro", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();


    }

    public static DBManager get() {
        synchronized (DBManager.class){
            if (sInstance == null) {
                sInstance = new DBManager();
            }
        }
        return sInstance;
    }

    public AccountDao getAccountDao() {
        return daoSession.getAccountDao();
    }
}
