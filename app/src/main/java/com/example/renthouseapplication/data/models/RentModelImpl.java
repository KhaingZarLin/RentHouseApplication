package com.example.renthouseapplication.data.models;

import android.content.Context;

import com.example.renthouseapplication.data.vos.RentVO;
import com.example.renthouseapplication.network.dataagents.RentDataAgent;
import com.example.renthouseapplication.utils.RentConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RentModelImpl extends BaseModel implements RentModel{

    private Map<Integer, RentVO> eventsDataRepository;

    private static RentModelImpl objInstance;

    public RentModelImpl(Context context) {
        super(context);
        eventsDataRepository = new HashMap<>();
    }
    public static void initializeRentModel(Context context)
    {
        objInstance=new RentModelImpl(context);
    }
    public static RentModelImpl getObjInstance(){
        if(objInstance == null){
            //objInstance = new RentModelImpl();
            throw new RuntimeException(RentConstants.EM_EVENT_MODEL_NOT_INITIALIZE);
        }
        return objInstance;
    }

    @Override
    public void getEvents(final GetRentFromNetworkDelegate delegate) {
        if (rentDataBase.areRentExitInDB())
        {
            List<RentVO> rentFromDb=rentDataBase.rentDaO().getAllRentFromDB();
            delegate.onSuccess(rentFromDb);
        }
        else {
            rentDataAgent.getRent(RentConstants.DUAMY_ACCESS_TOKEN, new RentDataAgent.GetRentFromNetworkDelegate() {
                @Override
                public void onSuccess(List<RentVO> rents) {
               /* for (RentVO event:events)
                {
                    eventsDataRepository.put(event.getId(),event);
                }*/
                    Long id[] = rentDataBase.rentDaO().insertRent(rents);
                    delegate.onSuccess(rents);
                }

                @Override
                public void onFailure(String errorMessage) {
                    delegate.onFailure(errorMessage);
                }
            });
        }
    }

    @Override
    public RentVO findRentById(int hotelId) {
        //RentVO rentVO = eventsDataRepository.get(hotelId);
        RentVO rentVO=rentDataBase.rentDaO().getRentById(hotelId);
        return rentVO;
    }
}
