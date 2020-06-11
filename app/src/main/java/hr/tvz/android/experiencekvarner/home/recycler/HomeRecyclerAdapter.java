package hr.tvz.android.experiencekvarner.home.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import hr.tvz.android.experiencekvarner.R;
import hr.tvz.android.experiencekvarner.home.IHomeMVP;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private final IHomeMVP.Presenter presenter;

    public HomeRecyclerAdapter(IHomeMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(presenter, LayoutInflater.from(parent.getContext())
                                    .inflate(R.layout.city_cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getRepositoriesRowsCount();
    }
}
