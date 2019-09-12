package com.example.renthouseapplication.persistences.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.renthouseapplication.data.vos.RentVO;

import java.util.List;

@Dao
public interface RentDaO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long[]  insertRent(List<RentVO> rentVOS);

    @Query("SELECT * FROM rent")
    List<RentVO> getAllRentFromDB();

    @Query("Select * from rent where id=:id")
    public abstract RentVO getRentById(int id);

}
