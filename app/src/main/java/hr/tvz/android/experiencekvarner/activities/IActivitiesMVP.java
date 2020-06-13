package hr.tvz.android.experiencekvarner.activities;

import hr.tvz.android.experiencekvarner.activities.recycler.ActivitiesViewHolder;
import hr.tvz.android.experiencekvarner.model.ActivityModel;
import hr.tvz.android.experiencekvarner.model.CategoryModel;
import hr.tvz.android.experiencekvarner.model.CityModel;

public interface IActivitiesMVP {

    /*
     * PRESENTER
     */
    interface Presenter {

        void onResume();

        void onActivityClicked(int position);
        void onBindRepositoryRowViewAtPosition(int position, ActivitiesViewHolder holder);

        int getRepositoriesRowsCount();

        void onDestroy();
    }


    /*
     * MODEL
     */
    interface Interactor {
        void findActivities(IActivitiesMVP.Interactor.OnFinishedListener listener);

        interface OnFinishedListener {

            void onFinished();

        }

        CityModel getCity();
        CategoryModel getCategory();
        ActivityModel getActivity(int position);
        int rowCount();

        void onDestroy();
    }


    /*
     * VIEW
     */
    interface View {
        void onResume();

        void viewActivityDetails(ActivityModel activity);
        void refreshRepositoriesList();

        void onDestroyView();
    }
}
