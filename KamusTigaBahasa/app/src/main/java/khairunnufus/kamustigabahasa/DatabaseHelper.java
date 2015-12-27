package khairunnufus.kamustigabahasa;

/**
 * Created by hairuns on 12/20/2015.
 */ import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "dbkamus";
    public static final String INGGRIS= "inggris";
    public static final String INDONESIA = "indonesia";
    public static final String SUNDA = "SUNDA";
    private final Activity myContext;

    public DatabaseHelper(Activity activity) {
        super(activity, DATABASE_NAME, null,1);
        this.myContext = activity;
    }


    public void createTable(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS kamus");
        db.execSQL("CREATE TABLE if not exists kamus (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "inggris TEXT, indonesia TEXT, sunda TEXT);");
    }
    //method generateData untuk mengisikan data ke kamus.
    public void generateData(SQLiteDatabase db){
        ContentValues cv=new ContentValues();
        cv.put(INGGRIS, "i");
        cv.put(INDONESIA, "saya");
        cv.put(SUNDA, "abdi");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "walk");
        cv.put(INDONESIA, "jalan");
        cv.put(SUNDA, "leumpang");
        db.insert("kamus", INDONESIA, cv);
        cv.put(INGGRIS, "read");
        cv.put(INDONESIA, "membaca");
        cv.put(SUNDA, "maca");
        db.insert("kamus", SUNDA, cv);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
        createTable(db);
        generateData(db);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub

        createTable(db);
        generateData(db);
    }

}
