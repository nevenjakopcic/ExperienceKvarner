package hr.tvz.android.experiencekvarner.categories;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import hr.tvz.android.experiencekvarner.ServiceGenerator;
import hr.tvz.android.experiencekvarner.Utils;
import hr.tvz.android.experiencekvarner.model.CategoryModel;
import hr.tvz.android.experiencekvarner.model.CityModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesInteractorImpl implements ICategoriesMVP.Interactor {

    ICategoriesService client = ServiceGenerator.createService(ICategoriesService.class, Utils.baseUrl);

    private final CityModel city;
    private List<CategoryModel> categories = new ArrayList<>();

    public CategoriesInteractorImpl(CityModel city) {
        this.city = city;
    }

    @Override
    public void findCategories(ICategoriesMVP.Interactor.OnFinishedListener listener) {
        client.getActivityCategoriesOfCity(city.getId()).enqueue(new Callback<List<CategoryModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<CategoryModel>> call,
                                   @NonNull Response<List<CategoryModel>> response) {
                // TODO: remove 204 check
                if (response.isSuccessful() && response.code() != 204 ) {
                    categories = response.body();
                    listener.onFinished();
                } else
                    System.err.println(response.errorBody());
            }

            @Override
            public void onFailure(@NonNull Call<List<CategoryModel>> call,
                                  @NonNull Throwable t) {
                t.printStackTrace(System.err);
            }
        });
    }

    @Override
    public CityModel getCity() {
        return city;
    }

    @Override
    public CategoryModel getCategory(int position) {
        return categories.get(position);
    }

    @Override
    public int rowCount() {
        return categories.size();
    }

    @Override
    public void onDestroy() {
        categories = null;
    }
}
