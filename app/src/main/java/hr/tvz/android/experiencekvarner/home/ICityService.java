package hr.tvz.android.experiencekvarner.home;

import java.util.List;

import hr.tvz.android.experiencekvarner.model.CityModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ICityService {
    @GET("cities")
    Call<List<CityModel>> getAllCities();
}
