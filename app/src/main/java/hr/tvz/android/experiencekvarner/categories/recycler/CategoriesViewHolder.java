package hr.tvz.android.experiencekvarner.categories.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.tvz.android.experiencekvarner.R;
import hr.tvz.android.experiencekvarner.categories.ICategoriesMVP;

public class CategoriesViewHolder extends RecyclerView.ViewHolder implements ICategoriesRowView {

    @BindView(R.id.name_text)
    TextView nameTextView;

    public CategoriesViewHolder(final ICategoriesMVP.Presenter presenter, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(v -> presenter.onCategoryClicked(getAdapterPosition()));
    }


    @Override
    public void setName(String name) {
        nameTextView.setText(name);
    }
}
