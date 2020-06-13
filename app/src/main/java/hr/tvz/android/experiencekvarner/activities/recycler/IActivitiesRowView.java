package hr.tvz.android.experiencekvarner.activities.recycler;

import hr.tvz.android.experiencekvarner.model.CategoryModel;

public interface IActivitiesRowView {

    void setName(String name);
    void setImage(CategoryModel category, String image);
}
