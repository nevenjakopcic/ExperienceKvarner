package hr.tvz.android.experiencekvarner.activities.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import hr.tvz.android.experiencekvarner.R;
import hr.tvz.android.experiencekvarner.activities.IActivitiesMVP;

public class ActivitiesRecyclerAdapter extends RecyclerView.Adapter<ActivitiesViewHolder> {

    private final IActivitiesMVP.Presenter presenter;

    public ActivitiesRecyclerAdapter(IActivitiesMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ActivitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ActivitiesViewHolder(presenter, LayoutInflater.from(parent.getContext())
                                            .inflate(R.layout.activity_cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ActivitiesViewHolder holder, int position) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getRepositoriesRowsCount();
    }
}
