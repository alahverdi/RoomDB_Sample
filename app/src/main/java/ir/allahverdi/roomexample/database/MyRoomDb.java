package ir.allahverdi.roomexample.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ir.allahverdi.roomexample.entity.User;

@Database(entities = {User.class} , version = 1)
public abstract class MyRoomDb extends RoomDatabase {
    public abstract UserDAO userDAO();

    private static volatile MyRoomDb INSTANCE;

    static MyRoomDb getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MyRoomDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(),
                                    MyRoomDb.class,
                                    "DB_NAME")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
