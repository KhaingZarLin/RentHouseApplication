package com.example.renthouseapplication.network.response;

import com.example.renthouseapplication.data.vos.RentVO;
import com.example.renthouseapplication.utils.RentConstants;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetRentResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<RentVO> rentVOList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<RentVO> getRentVOList() {
        return rentVOList;
    }

    public void setRentVOList(List<RentVO> rentVOList) {
        this.rentVOList = rentVOList;
    }
    public Boolean isResponseOk()
    {
        return code == RentConstants.CODE_RESPONSE_OK && rentVOList!=null;
    }
}
