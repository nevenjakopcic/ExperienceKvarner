package hr.tvz.android.experiencekvarner.activities;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import hr.tvz.android.experiencekvarner.ServiceGenerator;
import hr.tvz.android.experiencekvarner.Utils;
import hr.tvz.android.experiencekvarner.model.ActivityModel;
import hr.tvz.android.experiencekvarner.model.CategoryModel;
import hr.tvz.android.experiencekvarner.model.CityModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitiesInteractorImpl implements IActivitiesMVP.Interactor {

    IActivitiesService client = ServiceGenerator.createService(IActivitiesService.class, Utils.baseUrl);

    private final CityModel city;
    private final CategoryModel category;
    private List<ActivityModel> activities = new ArrayList<>();

    public ActivitiesInteractorImpl(CityModel city, CategoryModel category) {
        this.city = city;
        this.category = category;
    }

    @Override
    public void findActivities(OnFinishedListener listener) {
        client.getActivitiesOfCityAndCategory(city.getId(), category.getId()).enqueue(new Callback<List<ActivityModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<ActivityModel>> call,
                                   @NonNull Response<List<ActivityModel>> response) {
                if (response.isSuccessful() && response.code() != 204 ) {
                    activities = response.body();
                    listener.onFinished();
                } else
                    System.err.println(response.errorBody());
            }

            @Override
            public void onFailure(@NonNull Call<List<ActivityModel>> call,
                                  @NonNull Throwable t) {
                t.printStackTrace(System.err);
            }
        });
    }

    @Override
    public ActivityModel getActivity(int position) {
        return activities.get(position);
    }

    @Override
    public CityModel getCity() {
        return city;
    }

    @Override
    public CategoryModel getCategory() {
        return category;
    }

    @Override
    public int rowCount() {
        return activities.size();
    }

    @Override
    public void onDestroy() {
        activities = null;
    }
}
