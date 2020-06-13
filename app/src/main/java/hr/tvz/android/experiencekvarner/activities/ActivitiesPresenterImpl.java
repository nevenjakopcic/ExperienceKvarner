package hr.tvz.android.experiencekvarner.activities;

import hr.tvz.android.experiencekvarner.activities.recycler.ActivitiesViewHolder;
import hr.tvz.android.experiencekvarner.model.ActivityModel;
import hr.tvz.android.experiencekvarner.model.CategoryModel;
import hr.tvz.android.experiencekvarner.model.CityModel;

public class ActivitiesPresenterImpl implements IActivitiesMVP.Presenter, IActivitiesMVP.Interactor.OnFinishedListener {

    private IActivitiesMVP.View view;
    private IActivitiesMVP.Interactor interactor;

    public ActivitiesPresenterImpl(IActivitiesMVP.View view, CityModel city, CategoryModel category) {
        this.view = view;
        interactor = new ActivitiesInteractorImpl(city, category);
    }


    @Override
    public void onResume() {
        interactor.findActivities(this);
    }

    @Override
    public void onFinished() {
        view.refreshRepositoriesList();
    }

    @Override
    public void onActivityClicked(int position) {
        view.viewActivityDetails(interactor.getActivity(position));
    }

    @Override
    public void onBindRepositoryRowViewAtPosition(int position, ActivitiesViewHolder holder) {
        ActivityModel activity = interactor.getActivity(position);
        holder.setName(activity.getName());
        holder.setImage(interactor.getCategory(), activity.getImage());
    }

    @Override
    public int getRepositoriesRowsCount() {
        return interactor.rowCount();
    }

    @Override
    public void onDestroy() {
        interactor.onDestroy();
        interactor = null;
        view = null;
    }
}
