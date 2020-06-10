package hr.tvz.android.experiencekvarner.home;

import hr.tvz.android.experiencekvarner.home.recycler.HomeViewHolder;
import hr.tvz.android.experiencekvarner.model.CityModel;

public class HomePresenterImpl implements IHomeMVP.Presenter, IHomeMVP.Interactor.OnFinishedListener {

    private IHomeMVP.View view;
    private IHomeMVP.Interactor interactor;

    public HomePresenterImpl(IHomeMVP.View homeView) {
        this.view = homeView;
        interactor = new HomeInteractorImpl();
    }

    @Override
    public void onResume() {
        interactor.findCities(this);
    }

    @Override
    public void onFinished() {
        view.refreshRepositoriesList();
    }

    @Override
    public void onCityClicked(int position) {
        view.viewCitysActivityCategories(interactor.getCity(position));
    }

    @Override
    public void onBindRepositoryRowViewAtPosition(int position, HomeViewHolder holder) {
        CityModel city = interactor.getCity(position);
        holder.setTitle(city.getName());
    }

    @Override
    public int getRepositoriesRowsCount() {
        return interactor.rowCount();
    }

    @Override
    public void onDestroy() {
        interactor.onDestroy();
        view = null;
    }
}
