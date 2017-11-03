package com.itdais.repay;

import android.app.Application;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;

import com.itdais.repay.data.bean.DaoMaster;
import com.itdais.repay.data.bean.DaoSession;

/**
 * @描述
 * @作者 丁军伟
 * @时间 2017/10/19
 */
public class AppApplication extends Application {
    private static AppApplication instance;

    public static AppApplication getInstance() {
        return instance;
    }

    @Override
    public Resources getResources() {
        return instance.getResources();
    }

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mHelper = new DaoMaster.DevOpenHelper(this, "itdais", null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
