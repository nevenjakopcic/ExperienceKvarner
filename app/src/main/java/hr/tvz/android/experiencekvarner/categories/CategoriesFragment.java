package hr.tvz.android.experiencekvarner.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.tvz.android.experiencekvarner.R;
import hr.tvz.android.experiencekvarner.categories.recycler.CategoriesRecyclerAdapter;
import hr.tvz.android.experiencekvarner.model.CategoryModel;
import hr.tvz.android.experiencekvarner.model.CityModel;

public class CategoriesFragment extends Fragment implements ICategoriesMVP.View {

    private ICategoriesMVP.Presenter presenter;

    @BindView(R.id.city_text) MaterialTextView cityTextView;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        CityModel city = CategoriesFragmentArgs.fromBundle(requireArguments()).getCity();
        presenter = new CategoriesPresenterImpl(this, city);
        ButterKnife.bind(this, view);

        recyclerView.setAdapter(new CategoriesRecyclerAdapter(presenter));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        cityTextView.setText(city.getName());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void viewActivitiesOfCityAndCategory(CityModel city, CategoryModel category) {
        System.out.println(city);
        System.out.println(category);
        CategoriesFragmentDirections.ActionCategoriesFragmentToActivitiesFragment action = CategoriesFragmentDirections.actionCategoriesFragmentToActivitiesFragment(city, category);
        Navigation.findNavController(requireView()).navigate(action);
    }

    @Override
    public void refreshRepositoriesList() {
        if (recyclerView.getAdapter() != null) {
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        presenter = null;
        super.onDestroy();
    }
}