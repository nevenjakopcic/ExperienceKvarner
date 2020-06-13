package hr.tvz.android.experiencekvarner.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.tvz.android.experiencekvarner.R;
import hr.tvz.android.experiencekvarner.activities.recycler.ActivitiesRecyclerAdapter;
import hr.tvz.android.experiencekvarner.model.ActivityModel;
import hr.tvz.android.experiencekvarner.model.CategoryModel;
import hr.tvz.android.experiencekvarner.model.CityModel;

public class ActivitiesFragment extends Fragment implements IActivitiesMVP.View {

    private IActivitiesMVP.Presenter presenter;

    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_activities, container, false);
        CityModel city = ActivitiesFragmentArgs.fromBundle(requireArguments()).getCity();
        CategoryModel category = ActivitiesFragmentArgs.fromBundle(requireArguments()).getCategory();
        presenter = new ActivitiesPresenterImpl(this, city, category);
        ButterKnife.bind(this, view);

        recyclerView.setAdapter(new ActivitiesRecyclerAdapter(presenter));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void viewActivityDetails(ActivityModel activity) {
        System.out.println(activity);
        ActivitiesFragmentDirections.ActionActivitiesFragmentToDetailsFragment action = ActivitiesFragmentDirections.actionActivitiesFragmentToDetailsFragment(activity);
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