package com.example.renthouseapplication.persistences;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.renthouseapplication.data.vos.RentVO;
import com.example.renthouseapplication.persistences.daos.RentDaO;
import com.example.renthouseapplication.utils.RentConstants;

@Database(entities = {RentVO.class},version = 1,exportSchema = false)
public abstract class RentDataBase extends RoomDatabase {

    public abstract RentDaO rentDaO();
    public static RentDataBase objInstance;

   public static RentDataBase getObjInstance(Context context)
   {
       if (objInstance==null)
       {
            objInstance=Room.databaseBuilder(context,RentDataBase.class, RentConstants.EVENT_DR)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
       }
       return objInstance;
   }
   public boolean areRentExitInDB(){
       return !rentDaO().getAllRentFromDB().isEmpty();
   }
}
