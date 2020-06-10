package hr.tvz.android.experiencekvarner.categories.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import hr.tvz.android.experiencekvarner.R;
import hr.tvz.android.experiencekvarner.categories.ICategoriesMVP;

public class CategoriesRecyclerAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {

    private final ICategoriesMVP.Presenter presenter;

    public CategoriesRecyclerAdapter(ICategoriesMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoriesViewHolder(presenter, LayoutInflater.from(parent.getContext())
                                            .inflate(R.layout.category_cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getRepositoriesRowsCount();
    }
}
