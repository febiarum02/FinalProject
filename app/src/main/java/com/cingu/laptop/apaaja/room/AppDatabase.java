package com.cingu.laptop.apaaja.room;

import android.content.Context;

import com.cingu.laptop.apaaja.dao.OrderDAO;
import com.cingu.laptop.apaaja.model.UserOrder;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserOrder.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase db(Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class, "order")
                .allowMainThreadQueries().build();
    }

    public abstract OrderDAO orderDAO();
}
