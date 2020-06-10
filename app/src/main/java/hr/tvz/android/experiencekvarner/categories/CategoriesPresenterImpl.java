package hr.tvz.android.experiencekvarner.categories;

import hr.tvz.android.experiencekvarner.categories.recycler.CategoriesViewHolder;
import hr.tvz.android.experiencekvarner.model.CategoryModel;
import hr.tvz.android.experiencekvarner.model.CityModel;

public class CategoriesPresenterImpl implements ICategoriesMVP.Presenter, ICategoriesMVP.Interactor.OnFinishedListener {

    private ICategoriesMVP.View view;
    private ICategoriesMVP.Interactor interactor;

    public CategoriesPresenterImpl(ICategoriesMVP.View view, CityModel city) {
        this.view = view;
        interactor = new CategoriesInteractorImpl(city);
    }

    @Override
    public void onResume() {
        interactor.findCategories(this);
    }

    @Override
    public void onFinished() {
        view.refreshRepositoriesList();
    }

    @Override
    public void onCategoryClicked(int position) {
        view.viewActivitiesOfCityAndCategory(interactor.getCity(), interactor.getCategory(position));
    }

    @Override
    public void onBindRepositoryRowViewAtPosition(int position, CategoriesViewHolder holder) {
        CategoryModel category = interactor.getCategory(position);
        holder.setName(category.getName());
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
