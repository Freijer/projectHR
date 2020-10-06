package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "profile";
    public static final String TABLE_NAME = "myProfile";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_TEAM = "отдел";
    public static final String KEY_WORK = "должность";
    public static final String KEY_NUMBER = "номер";
    public static final String KEY_SELFINFO = "осебе";

    SQLiteDatabase database;
    ContentValues contentValues = new ContentValues();

    String valueName;
    String valueTeam;
    String valueWork;
    String valueNumber;
    String valueSelfinfo;

    public String getValueName() {
        return valueName;
    }
    public void setValueName(String valueName) {
        this.valueName = valueName;
    }
    public String getValueTeam() {
        return valueTeam;
    }
    public void setValueTeam(String valueTeam) {
        this.valueTeam = valueTeam;
    }
    public String getValueWork() {
        return valueWork;
    }
    public void setValueWork(String valueWork) {
        this.valueWork = valueWork;
    }
    public String getValueNumber() {
        return valueNumber;
    }
    public void setValueNumber(String valueNumber) {
        this.valueNumber = valueNumber;
    }
    public String getValueSelfinfo() {
        return valueSelfinfo;
    }
    public void setValueSelfinfo(String valueSelfinfo) {
        this.valueSelfinfo = valueSelfinfo;
    }





    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" + KEY_ID
                + " integer primary key," + KEY_NAME + " text," +  KEY_TEAM + " text," + KEY_WORK + " text," + KEY_NUMBER+ " text," +  KEY_SELFINFO + " text" +  ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public void WriteDB(String name, String team, String work, String number, String selfinfo){
        database = this.getWritableDatabase();
        contentValues.put(KEY_NAME, name);
        contentValues.put(KEY_TEAM, team);
        contentValues.put(KEY_WORK, work);
        contentValues.put(KEY_NUMBER, number);
        contentValues.put(KEY_SELFINFO, selfinfo);

        database.insert(TABLE_NAME, null, contentValues);

    }


    public void ReadDB(){
        database = this.getWritableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(KEY_ID);
            int nameIndex = cursor.getColumnIndex(KEY_NAME);
            int teanIndex = cursor.getColumnIndex(KEY_TEAM);
            int workIndex = cursor.getColumnIndex(KEY_WORK);
            int numberIndex = cursor.getColumnIndex(KEY_NUMBER);
            int selfIndex = cursor.getColumnIndex(KEY_SELFINFO);
            do {
                Log.d("myLogs", "ID = " + cursor.getInt(idIndex) +
                        ", имя = " + cursor.getString(nameIndex) +
                        ", команда = " + cursor.getString(teanIndex) +
                        ", должность = " + cursor.getString(workIndex) +
                        ", номер = " + cursor.getString(numberIndex) +
                        ", инфа = " + cursor.getString(selfIndex));
                setValueName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                setValueTeam(cursor.getString(cursor.getColumnIndex(KEY_TEAM)));
                setValueWork(cursor.getString(cursor.getColumnIndex(KEY_WORK)));
                setValueNumber(cursor.getString(cursor.getColumnIndex(KEY_NUMBER)));
                setValueSelfinfo(cursor.getString(cursor.getColumnIndex(KEY_SELFINFO)));

            } while (cursor.moveToNext());
        } else
            Log.d("myLogs","0 rows");
        cursor.close();
    }

    public void DeleteDB(){
        database = this.getWritableDatabase();
        database.delete(TABLE_NAME, null, null);
        database.close();
    }

    public void UpdateDB(String name, String team, String work, String number, String selfinfo){
        database = this.getWritableDatabase();
        contentValues.put(KEY_NAME, name);
        contentValues.put(KEY_TEAM, team);
        contentValues.put(KEY_WORK, work);
        contentValues.put(KEY_NUMBER, number);
        contentValues.put(KEY_SELFINFO, selfinfo);

        String id = "1";
        int updCount  = database.update(TABLE_NAME, contentValues, KEY_ID + "= ?" , new String[] {id});
        Log.d("myLogs", "updated rows count = " + updCount);
    }

}