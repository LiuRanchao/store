package com.lrchao.store.database;

import android.database.sqlite.SQLiteDatabase;


import com.lrchao.store.database.dao.AccountDao;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

/**
 * Description: TODO
 *
 * @author liuranchao
 * @date 15/12/22 下午3:50
 */
public class DaoSession extends AbstractDaoSession {

    /**
     *
     */
    private final DaoConfig mAccountDaoConfig;

    private final AccountDao mAccountDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);
        mAccountDaoConfig = daoConfigMap.get(AccountDao.class);
        mAccountDaoConfig.initIdentityScope(type);

        mAccountDao = new AccountDao(mAccountDaoConfig, this);
    }

    public void clear() {
        mAccountDaoConfig.getIdentityScope().clear();
    }

    public AccountDao getAccountDao() {
        return mAccountDao;
    }
}
