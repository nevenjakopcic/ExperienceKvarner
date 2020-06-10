package hr.tvz.android.experiencekvarner.categories;

import java.util.List;

import hr.tvz.android.experiencekvarner.model.CategoryModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ICategoriesService {
    @GET("cities/{cityID}/activity-categories")
    Call<List<CategoryModel>> getActivityCategoriesOfCity(@Path("cityID") Long cityID);
}
