package com.example.myy.day02zuoye;

import com.example.myy.day02zuoye.dao.DaoMaster;
import com.example.myy.day02zuoye.dao.DaoSession;
import com.example.myy.day02zuoye.dao.DbBeanDao;

import java.util.List;

public class DbUtil {

    private final DbBeanDao dbBeanDao;

    public DbUtil() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getApp(), "a.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        dbBeanDao = daoSession.getDbBeanDao();
    }
    public static DbUtil dbUtil;

    public static DbUtil getDbUtil() {
        if (dbUtil==null){
            synchronized (DbUtil.class){
                if (dbUtil==null){
                    dbUtil = new DbUtil();
                }
            }
        }
        return dbUtil;
    }
    public boolean has(DbBean dbBean){
        List<DbBean> list = dbBeanDao.queryBuilder().where(DbBeanDao.Properties.Name.eq(dbBean.getName())).list();
        if (list.size()>0&&list!=null){
            return true;
        }
        return false;
    }
    public void insert(DbBean dbBean){
        if (has(dbBean)){
            return;
        }
        dbBeanDao.insertOrReplace(dbBean);
    }
    public List<DbBean> query(){
        List<DbBean> list = dbBeanDao.queryBuilder().list();
        return list;
    }

}
