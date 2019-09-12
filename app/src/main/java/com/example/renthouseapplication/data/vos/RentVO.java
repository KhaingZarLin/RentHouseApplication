package com.example.renthouseapplication.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "rent",
indices = {@Index(value = "id",unique = true)})
public class RentVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "rentIdPK")
    private int rentIdPK;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;

    @ColumnInfo(name = "house_image_url")
    @SerializedName("house_image_url")
    private String image;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "description")
    @SerializedName("description")
    private String description;

    @ColumnInfo(name = "price")
    @SerializedName("price")
    private long price;

    @ColumnInfo(name = "address")
    @SerializedName("address")
    private String address;

    @ColumnInfo(name = "square_feet")
    @SerializedName("square_feet")
    private long square_feet;

    @ColumnInfo(name = "latitude")
    @SerializedName("latitude")
    private double latitude;

    @ColumnInfo(name = "longitude")
    @SerializedName("longitude")
    private double longitude;

    public int getRentIdPK() {
        return rentIdPK;
    }

    public void setRentIdPK(int rentIdPK) {
        this.rentIdPK = rentIdPK;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getSquare_feet() {
        return square_feet;
    }

    public void setSquare_feet(long square_feet) {
        this.square_feet = square_feet;
    }

    public double getLattitude() {
        return latitude;
    }

    public void setLattitude(double lattitude) {
        this.latitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
