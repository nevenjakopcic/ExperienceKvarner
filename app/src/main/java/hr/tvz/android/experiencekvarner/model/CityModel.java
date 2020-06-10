package hr.tvz.android.experiencekvarner.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class CityModel {

    @SerializedName("id")   private final Long id;
    @SerializedName("name") private final String name;
}
