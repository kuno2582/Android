package com.example.kuno.sqliteex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kuno on 2017-02-03.
 */
/*
Cursor (->JSP에서의 ResultSet역할)
 - 데이터 베이스의 데이터를 쿼리하여 가져올 때 사용하는 객체
 - DB에서 가져온 데이터를 쉽게 처리하기 위해서 Cursor를 사용합니다.
 - 결과값을 가지고 있는 포인터
 - Select 쿼리문으로 데이터를 읽으면 Cursor을 이용하여 데이터의 위치를 가리키고
    ArrayList같은 배열에 데이터베이스에서 읽은 데이터를 저장하는 역할
 - 데이터베이스 -> 데이터 추출
 - DB에서 값을 가져와서 마치 실제 Table의 한 행, 한 행을 참조하는 것처럼 사용할 수 있습니다.

ContentValues (->executeQuery 역할)
 - Cursor와 반대
 - 데이터를 데이터베이스에 입력하기 위해서 ContentValues객체를 사용합니다.
 - ContentValues객체에 데이터베이스 테이블에 맞게 자료를 입력한 후,
    SQLiteDatabase클래스의 insert()메소드를 사용해서 데이터베이스에 새로운 레코드를 추가해 줍니다.
 - 데이터베이스 <- 데이터 입력

*/


public class DatabaseAdapter {
    //==========================================상수 정의 시작
    static final String TAG = "DatabaseAdapter";
    static final String DB_NAME = "daily_memo.db";
    static final String TABLE_NAME = "memo";
    static final String MEMO_ID = "_id";    //프라이머리 키 칼럼인경우 언더바 붙이는 관례
    static final String MEMO_CONTENT = "content";
    static final int ID_INDEX = 0;
    static final int CONTENT_INDEX = 1;
    //칼럼 명세
    static final String[] PROJECTION = new String[]{MEMO_ID, MEMO_CONTENT};
    //테이블 생성 SQL
    static final String CREATA_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" + MEMO_ID+" integer PRIMARY KEY AUTOINCREMENT, "
            + MEMO_CONTENT + " text NOT NULL)";
    //테이블 삭제 SQL
    static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
    //==========================================상수 정의 끝

    private Context context;

    public DatabaseAdapter(Context context){
        this.context = context;
    }

    private SQLiteDatabase db;

    //SQL데이터베이스 생성메서드
    public void open(){
        try{
            db = new DatabaseHelper(context).getWritableDatabase();  //데이터베이스를 읽고 쓸수 있는 객체 호출
        }catch (SQLException e){
            db = new DatabaseHelper(context).getReadableDatabase(); //쓰기권한이 없을시 읽기권한으로 객체 호출
        }
    }

    public void close(){
        if(db!=null){
            db.close();
        }
    }

    public Cursor fetchAllMemo(){

        return db.query(TABLE_NAME,    //테이블 명
                PROJECTION, //컬럼명세
                null,   //WHERE 절
                null,   //WHERE절에 전달될 데이터
                null,   //groupby절
                null,   //having절 인자
                MEMO_ID + " DESC"   //ORDER BY절
        );
    }

    //추가버튼 DB이벤트메서드
    public String addMemo(String content){

        ContentValues values = new ContentValues();
        values.put(MEMO_CONTENT, content);

        // -1 error, 삽입된 row ID를 리턴
        long id = db.insert(TABLE_NAME, null, values);  //테이블명, 옵션, 데이터     null:모든 필드값을 모두 입력하지 않을때

        if(id<0)
            return "";
        return Long.toString(id);
    }

    public String searchMemo(String str){

        String where = MEMO_CONTENT + " LIKE ?";

        String param = str.substring(0, 1) + "%";

        Cursor cursor = db.query(TABLE_NAME,
                    PROJECTION,
                    where,
                    new String[]{param},
                    null,
                    null,
                    MEMO_ID + " DESC",
                    "10");  //limit설정

        StringBuffer stringBuffer = new StringBuffer();
        if(cursor.moveToFirst()){

            do{
                long id = cursor.getLong(ID_INDEX);
                String memo = cursor.getString(CONTENT_INDEX);

                stringBuffer.append("ID(");
                stringBuffer.append(id);
                stringBuffer.append(")");
                stringBuffer.append(memo);
                stringBuffer.append("\n");

            }while(cursor.moveToNext());

        }
        cursor.close();

        return stringBuffer.toString();
    }

    public void setMemo(String id, String content){
        ContentValues values = new ContentValues();

        values.put(MEMO_CONTENT, content);

        db.update(TABLE_NAME,   //테이블명
                values, //수정한 데이터
                MEMO_ID + "=?", //where 조건절
                new String[]{id});//where 파라미터
    }

    public void deleteMemo(String id){
        db.delete(
                TABLE_NAME,
                MEMO_ID + "=?",
                new String[]{id});
    }

    public class DatabaseHelper extends SQLiteOpenHelper{

        public DatabaseHelper(Context context){
            super(context, DB_NAME, null, 1);  //컨텍스트, db이름, 커서정보, 버전정보
        }

        @Override
        public void onCreate(SQLiteDatabase db) {   //처음 실행될때 한번 호출
            db.execSQL(CREATA_TABLE);   //테이블 생성 쿼리문 실행
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  //이후 db버전업할때 호출
            Log.w(TAG, "version mismath:" + oldVersion + " to " + newVersion);

            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
    }

}
