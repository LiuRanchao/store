package com.lrchao.store.database.dao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.lrchao.store.model.user.AccountModel;
import com.lrchao.store.util.LogUtils;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/**
 * Description: 用户表的DAO
 *
 * @author liuranchao
 * @date 15/12/22 下午3:37
 */
public class AccountDao extends AbstractDao<AccountModel, Long> {

    /**
     * 表名
     */
    public static final String TABLENAME = "account";

    /**
     * 字段
     */
    private static final String COLUMN_USER_ID = "_user_id"; // 用户的ID
    private static final String COLUMN_USER_NAME = "_user_name"; // 账号的名称
    private static final String COLUMN_ACCESS_TOKEN = "_access_token"; // 账号的AccessToken
    private static final String COLUMN_EXPIRES_IN = "_expires_in"; // 超时时长
    private static final String COLUMN_REFRESH_TOKEN = "_refresh_token"; // 刷新的token

    /**
     * Properties of entity Customer.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, COLUMN_USER_ID);
        public final static Property Name = new Property(1, String.class, "name", false, COLUMN_USER_NAME);
        public final static Property AccessToken = new Property(2, String.class, "access_token", false, COLUMN_ACCESS_TOKEN);
        public final static Property ExpiresIn = new Property(3, Long.class, "expires_in", false, COLUMN_EXPIRES_IN);
        public final static Property RefreshToken = new Property(4, String.class, "refresh_token", false, COLUMN_REFRESH_TOKEN);
    }


    private AbstractDaoSession mDaoSession;

    public AccountDao(DaoConfig config) {
        super(config);
    }

    public AccountDao(DaoConfig config, AbstractDaoSession daoSession) {
        super(config, daoSession);
        mDaoSession = daoSession;
    }

    @Override
    protected AccountModel readEntity(Cursor cursor, int offset) {
        AccountModel entity = new AccountModel();
        entity.setDouban_user_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDouban_user_name(cursor.getString(offset + 1));
        entity.setAccess_token(cursor.getString(offset + 2));
        entity.setExpires_in(cursor.getLong(offset + 3));
        entity.setRefresh_token(cursor.getString(offset + 4));
        return entity;
    }

    @Override
    protected Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    @Override
    protected void readEntity(Cursor cursor, AccountModel entity, int offset) {
        entity.setDouban_user_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDouban_user_name(cursor.getString(offset + 1));
        entity.setAccess_token(cursor.getString(offset + 2));
        entity.setExpires_in(cursor.getLong(offset + 3));
        entity.setRefresh_token(cursor.getString(offset + 4));
    }

    @Override
    protected void bindValues(SQLiteStatement stmt, AccountModel entity) {
        stmt.clearBindings();

        long id = entity.getDouban_user_id();

        if (id > 0) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getDouban_user_name());
        stmt.bindString(3, entity.getAccess_token());
        stmt.bindLong(4, entity.getExpires_in());
        stmt.bindString(5, entity.getRefresh_token());
    }

    @Override
    protected Long updateKeyAfterInsert(AccountModel entity, long rowId) {
        return rowId;
    }

    @Override
    protected Long getKey(AccountModel entity) {
        if(entity != null) {
            return entity.getDouban_user_id();
        } else {
            return null;
        }
    }


    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {

        StringBuilder createTable = new StringBuilder();
        createTable.append("CREATE TABLE IF NOT EXISTS ");
        createTable.append(TABLENAME);
        createTable.append(" (");
        createTable.append(COLUMN_USER_ID);
        createTable.append(" INTEGER NOT NULL,");
        createTable.append(COLUMN_USER_NAME);
        createTable.append(" TEXT NOT NULL,");
        createTable.append(COLUMN_ACCESS_TOKEN);
        createTable.append(" TEXT,");
        createTable.append(COLUMN_EXPIRES_IN);
        createTable.append(" INTEGER,");
        createTable.append(COLUMN_REFRESH_TOKEN);
        createTable.append(" TEXT,");
        createTable.append(" UNIQUE (");
        createTable.append(COLUMN_USER_ID);
        createTable.append(" ) ON CONFLICT REPLACE");
        createTable.append(");");

        try {
            db.execSQL(createTable.toString());
        } catch (SQLException ex) {
            LogUtils.E("couldn't create table " + TABLENAME);
        }
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + TABLENAME;
        db.execSQL(sql);
    }


}
