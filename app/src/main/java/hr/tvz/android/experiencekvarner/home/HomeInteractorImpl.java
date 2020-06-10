package hr.tvz.android.experiencekvarner.home;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import hr.tvz.android.experiencekvarner.ServiceGenerator;
import hr.tvz.android.experiencekvarner.Utils;
import hr.tvz.android.experiencekvarner.model.CityModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeInteractorImpl implements IHomeMVP.Interactor {

    ICityService client = ServiceGenerator.createService(ICityService.class, Utils.baseUrl);

    private List<CityModel> cities = new ArrayList<>();

    @Override
    public void findCities(IHomeMVP.Interactor.OnFinishedListener listener) {
        client.getAllCities().enqueue(new Callback<List<CityModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<CityModel>> call,
                                   @NonNull Response<List<CityModel>> response) {
                if (response.isSuccessful()) {
                    cities = response.body();
                    listener.onFinished();
                } else
                    System.err.println(response.errorBody());
            }

            @Override
            public void onFailure(@NonNull Call<List<CityModel>> call,
                                  @NonNull Throwable t) {
                t.printStackTrace(System.err);
            }
        });
    }

    @Override
    public CityModel getCity(int position) {
        return cities.get(position);
    }

    @Override
    public int rowCount() {
        return cities.size();
    }

    @Override
    public void onDestroy() {
        cities = null;
    }
}
