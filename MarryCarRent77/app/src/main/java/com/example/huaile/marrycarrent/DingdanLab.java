package com.example.huaile.marrycarrent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.huaile.marrycarrent.datebase.DingdanBaseHelper;
import com.example.huaile.marrycarrent.datebase.DingdanDbSchema;
import com.example.huaile.marrycarrent.datebase.DingdanCursorWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by 屹强 on 2017/5/5.
 */
public class DingdanLab {
    private static DingdanLab sDingdanLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static DingdanLab get(Context context) {
        if (sDingdanLab == null) {
            sDingdanLab = new DingdanLab(context);
        }
        return sDingdanLab;
    }

    private DingdanLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DingdanBaseHelper(mContext)
                .getWritableDatabase();
    }

    private static ContentValues getContentValues(Dingdan dingdan) {
        ContentValues values = new ContentValues();
        values.put(DingdanDbSchema.DingdanTable.Cols.UUID, dingdan.getId().toString());
        values.put(DingdanDbSchema.DingdanTable.Cols.TITLE, dingdan.getTitle());
        values.put(DingdanDbSchema.DingdanTable.Cols.DATE, dingdan.getDate().getTime());
        values.put(DingdanDbSchema.DingdanTable.Cols.SOLVED, dingdan.isSolved() ? 1 : 0);

        return values;
    }

    public void addDingdan(Dingdan c) {
        ContentValues values = getContentValues(c);

        mDatabase.insert(DingdanDbSchema.DingdanTable.NAME, null, values);
    }

    public void updateDingdan(Dingdan dingdan) {
        String uuidString = dingdan.getId().toString();
        ContentValues values = getContentValues(dingdan);

        mDatabase.update(DingdanDbSchema.DingdanTable.NAME, values,
               DingdanDbSchema.DingdanTable.Cols.UUID + " = ?",
                new String[] { uuidString });
    }

    private DingdanCursorWrapper queryDingdans(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
               DingdanDbSchema.DingdanTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );

        return new DingdanCursorWrapper(cursor);
    }


    public List<Dingdan> getDingdans() {
        List<Dingdan> dingdans = new ArrayList<>();

       DingdanCursorWrapper cursor = queryDingdans(null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            dingdans.add(cursor.getDingdan());
            cursor.moveToNext();
        }
        cursor.close();

        return dingdans;
    }

    public Dingdan getDingdan(UUID id) {
        DingdanCursorWrapper cursor =queryDingdans(DingdanDbSchema.DingdanTable.Cols.UUID + " = ?",
                new String[] { id.toString() }
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getDingdan();
        } finally {
            cursor.close();
        }
    }
}


