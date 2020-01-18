package com.cingu.laptop.apaaja.dao;

import com.cingu.laptop.apaaja.model.UserOrder;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface OrderDAO {

    @Query("SELECT * FROM userorder WHERE id = :id")
    UserOrder select(int id);

    @Query("SELECT * FROM userorder")
    List<UserOrder> selectAll();

    @Insert
    void insert(UserOrder userOrder);

    @Update
    void update(UserOrder userOrder);

    @Delete
    void delete(UserOrder userOrder);
}
