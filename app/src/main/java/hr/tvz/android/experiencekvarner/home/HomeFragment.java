package hr.tvz.android.experiencekvarner.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.tvz.android.experiencekvarner.R;
import hr.tvz.android.experiencekvarner.home.recycler.HomeRecyclerAdapter;
import hr.tvz.android.experiencekvarner.model.CityModel;

public class HomeFragment extends Fragment implements IHomeMVP.View {

    private IHomeMVP.Presenter presenter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        presenter = new HomePresenterImpl(this);
        ButterKnife.bind(this, view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setAdapter(new HomeRecyclerAdapter(presenter));
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void viewCitysActivityCategories(CityModel city) {
        System.out.println(city);
        HomeFragmentDirections.ActionNavHomeToCategoriesFragment action = HomeFragmentDirections.actionNavHomeToCategoriesFragment(city);
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