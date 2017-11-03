package com.itdais.repay.data.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.itdais.repay.util.DateUtils;

import java.util.Date;

/**
 * @描述
 * @作者 丁军伟
 * @时间 2017/10/19
 */
public class RepayDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "repay";
    public static final int DB_VERSION = 1;
    //账单提醒记录
    public static final String TABLE_REMIND = "remind";
    //收入支出表
    public static final String TABLE_INCOME_EXPENSE = "income_expense";
    //银行卡记录表
    public static final String TABLE_BANK_CARD = "bank_card";

    public RepayDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String remindSql = "CREATE TABLE IF NOT EXISTS " + TABLE_REMIND + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, money TEXT,remind_date TEXT,remind_mode INTEGER,type INTEGER,type_extra TEXT,remarks TEXT,overdue INTEGER,bankCardId INTEGER,modifyTime Text);";
        db.execSQL(remindSql);

        String cardSql = "CREATE TABLE IF NOT EXISTS " + TABLE_BANK_CARD + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, bankId INTEGER,bank TEXT,cardTypeId INTEGER,cardType Text,cardNumber TEXT,userName TEXT,userIdCard TEXT,userMobile TEXT,);";
        db.execSQL(cardSql);

//        String verifySql = "CREATE TABLE IF NOT EXISTS " + TABLE_INCOME_EXPENSE + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, flag TEXT,plu TEXT,quantity INTEGER,extra TEXT,addDate TEXT);";
//        db.execSQL(verifySql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * 插入一条提醒记录
     */
    public void insertRemind(String money, String remindDate, int remindMode, int type, String typeExtra, String remark) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("insert into " + TABLE_REMIND + "(money,remind_date,remind_mode,type,type_extra,remarks,overdue,modifyTime) " +
                "values('" + money + "','" + remindDate + "'," + remindMode + "," + type + ",'" + typeExtra + "','" + remark + "',1" + DateUtils.DateToString(new Date(), DateUtils.DateStyle.YYYY_MM_DD_HH_MM_SS) + "')");
        db.close();
    }

    /**
     * 查询所有未失效的提醒记录
     */
    public void queryRemind() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from" + TABLE_REMIND + " where overdue = 1", null);
    }

}
