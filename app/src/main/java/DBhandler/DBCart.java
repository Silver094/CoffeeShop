package DBhandler;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import modal.DatabaseModal;
public class DBCart extends SQLiteOpenHelper{

        // Database Version
        private static final int DATABASE_VERSION = 1;

        // Database Name
        private static final String DATABASE_NAME = "cartManager.db";

        // User table name
        private static final String TABLE_NAME = "Cart";

        // User Table Columns names
        private static final String COLUMN_IMAGEID = "image_id";
        private static final String COLUMN_IMAGENAME = "image_name";
        private static final String COLUMN_QUANTITY = "quantity";
        private static final String COLUMN_PRICE = "price";


        // create table sql query
        private String CREATE_CART_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_IMAGEID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_IMAGENAME + " TEXT,"
                + COLUMN_QUANTITY + " TEXT," + COLUMN_PRICE + " TEXT" + ")";

        // drop table sql query
        private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        public DBCart(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_CART_TABLE);
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
        
        public void addItem(DatabaseModal item) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_IMAGENAME, item.getName());
            values.put(COLUMN_IMAGEID, item.getImage());
            values.put(COLUMN_QUANTITY, item.getQuantity());
            values.put(COLUMN_PRICE,item.getPrice());

            // Inserting Row
            db.insert(TABLE_NAME, null, values);
            db.close();
        }

        
    public ArrayList<DatabaseModal> getAllItem() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_IMAGEID,
                COLUMN_IMAGENAME,
                COLUMN_QUANTITY,
                COLUMN_PRICE
        };
        ArrayList<DatabaseModal> List = new ArrayList<DatabaseModal>();
        
        SQLiteDatabase db = this.getReadableDatabase();
        
        Cursor cursor =db.rawQuery("Select image_id,image_name,quantity,price from "+TABLE_NAME,null);
        
        if (cursor.moveToFirst()) {
            do {
                DatabaseModal item =new DatabaseModal();
                item.setImage(cursor.getInt(0));
                item.setName(cursor.getString(1));
                item.setQuantity(cursor.getString(2));
                item.setPrice(cursor.getString(3));
                List.add(item);
            } while (cursor.moveToNext());
        }
        return List;
    }

    public void updateCart(DatabaseModal item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_IMAGENAME, item.getName());
        values.put(COLUMN_QUANTITY, item.getQuantity());

        // updating row
        db.update(TABLE_NAME, values, COLUMN_IMAGENAME + " = ?",
                new String[]{String.valueOf(item.getQuantity())});
        db.close();
    }

    public void deleteItem(DatabaseModal item) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_NAME, COLUMN_IMAGEID + " = ?",
                new String[]{String.valueOf(item.getImage())});
        db.close();
    }
    public void deleteAllItem() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME);
        db.close();

    }
}
