package hr.tvz.android.experiencekvarner.categories;

import hr.tvz.android.experiencekvarner.categories.recycler.CategoriesViewHolder;
import hr.tvz.android.experiencekvarner.model.CategoryModel;
import hr.tvz.android.experiencekvarner.model.CityModel;

public interface ICategoriesMVP {

    /*
     * PRESENTER
     */
    interface Presenter {

        void onResume();

        void onCategoryClicked(int position);
        void onBindRepositoryRowViewAtPosition(int position, CategoriesViewHolder holder);

        int getRepositoriesRowsCount();

        void onDestroy();
    }


    /*
     * MODEL
     */
    interface Interactor {
        void findCategories(ICategoriesMVP.Interactor.OnFinishedListener listener);

        interface OnFinishedListener {

            void onFinished();

        }

        CityModel getCity();
        CategoryModel getCategory(int position);
        int rowCount();

        void onDestroy();
    }


    /*
     * VIEW
     */
    interface View {
        void onResume();

        void viewActivitiesOfCityAndCategory(CityModel city, CategoryModel category);
        void refreshRepositoriesList();

        void onDestroyView();
    }
}
