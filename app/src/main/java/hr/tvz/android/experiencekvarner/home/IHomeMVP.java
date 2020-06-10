package hr.tvz.android.experiencekvarner.home;

import hr.tvz.android.experiencekvarner.home.recycler.HomeViewHolder;
import hr.tvz.android.experiencekvarner.model.CityModel;

public interface IHomeMVP {

    /*
     * PRESENTER
     */
    interface Presenter {

        void onResume();

        void onCityClicked(int position);
        void onBindRepositoryRowViewAtPosition(int position, HomeViewHolder holder);
        int getRepositoriesRowsCount();

        void onDestroy();
    }


    /*
     * MODEL
     */
    interface Interactor {
        void findCities(OnFinishedListener listener);

        interface OnFinishedListener {

            void onFinished();
        }

        CityModel getCity(int position);
        int rowCount();

        void onDestroy();
    }


    /*
     * VIEW
     */
    interface View {
        void onResume();

        void viewCitysActivityCategories(CityModel city);
        void refreshRepositoriesList();

        void onDestroyView();
    }
}
