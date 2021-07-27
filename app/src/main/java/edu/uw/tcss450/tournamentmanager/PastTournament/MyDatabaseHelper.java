
package edu.uw.tcss450.tournamentmanager.PastTournament;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Tour2.db";
    private static final int DATABASE_VERSION = 1;

    // Table
    private static final String TOURNAMENT_TABLE = "tournament_table";

    // Columns
    private static final String TOURNAMENT_NAME = "tournament_name";
    private static final String TOURNAMENT_YEAR = "tournament_year";
    private static final String TOURNAMENT_CATEGORY = "tournament_category";
    private static final String TOURNAMENT_WINNER = "tournament_winner";
    private static final String TOURNAMENT_FINALIST = "tournament_finalist";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " +TOURNAMENT_TABLE+
                        " ("
                        +TOURNAMENT_YEAR+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        +TOURNAMENT_NAME+ " TEXT, "
                        +TOURNAMENT_CATEGORY+ " TEXT, "
                        +TOURNAMENT_WINNER+ " TEXT, "
                        +TOURNAMENT_FINALIST+ " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {
        db.execSQL("DROP TABLE IF EXISTS "+TOURNAMENT_TABLE);
        onCreate(db);
    }

    void addTournament(int year, String name, String category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TOURNAMENT_YEAR, year);
        cv.put(TOURNAMENT_NAME, name);
        cv.put(TOURNAMENT_CATEGORY, category);

        long result = db.insert(TOURNAMENT_TABLE, null, cv);

        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TOURNAMENT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

//    void updateTournament(int year, String name, String category) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(TOURNAMENT_YEAR, year);
//        cv.put(TOURNAMENT_NAME, name);
//        cv.put(TOURNAMENT_CATEGORY, category);
//
//        long result = db.update(TOURNAMENT_TABLE, cv, "TOURNAMENT_YEAR = ?", new String[] {""+year});
//        if (result == -1) {
//            Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(context, "Successfully updated", Toast.LENGTH_SHORT).show();
//        }
//    }

    void updateTournament(int year, String name, String category, String winner, String finalist) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TOURNAMENT_YEAR, year);
        cv.put(TOURNAMENT_NAME, name);
        cv.put(TOURNAMENT_CATEGORY, category);
        cv.put(TOURNAMENT_WINNER, winner);
        cv.put(TOURNAMENT_FINALIST, finalist);

        long result = db.update(TOURNAMENT_TABLE, cv, "TOURNAMENT_YEAR = ?", new String[] {""+year});
        if (result == -1) {
            Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully updated", Toast.LENGTH_SHORT).show();
        }
    }
}














