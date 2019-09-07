package com.example.renthouseapplication.data.models;

import com.example.renthouseapplication.data.vos.RentVO;
import com.example.renthouseapplication.network.dataagents.RentDataAgent;
import com.example.renthouseapplication.utils.RentConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RentModelImpl extends BaseModel implements RentModel{

    private Map<Integer, RentVO> eventsDataRepository;

    private static RentModelImpl objInstance;

    private RentModelImpl(){
        eventsDataRepository = new HashMap<>();
    }

    public static RentModelImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new RentModelImpl();
        }
        return objInstance;
    }




    @Override
    public void getEvents(final GetRentFromNetworkDelegate delegate) {
        rentDataAgent.getRent(RentConstants.DUAMY_ACCESS_TOKEN, new RentDataAgent.GetRentFromNetworkDelegate() {
            @Override
            public void onSuccess(List<RentVO> events) {
                for (RentVO event:events)
                {
                    eventsDataRepository.put(event.getId(),event);
                }
                delegate.onSuccess(events);
            }

            @Override
            public void onFailure(String errorMessage) {
                delegate.onFailure(errorMessage);
            }
        });
    }

    @Override
    public RentVO findRentById(int hotelId) {
        RentVO rentVO = eventsDataRepository.get(hotelId);
        return rentVO;
    }
}
