package hr.tvz.android.experiencekvarner.activities;

import java.util.List;

import hr.tvz.android.experiencekvarner.model.ActivityModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IActivitiesService {
    @GET("cities/{cityID}/activities/{categoryID}")
    Call<List<ActivityModel>> getActivitiesOfCityAndCategory(@Path("cityID") Long cityID,
                                                             @Path("categoryID") Long categoryID);
}
