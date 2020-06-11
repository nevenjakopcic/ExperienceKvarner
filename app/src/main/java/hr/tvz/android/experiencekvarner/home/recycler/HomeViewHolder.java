package hr.tvz.android.experiencekvarner.home.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.tvz.android.experiencekvarner.R;
import hr.tvz.android.experiencekvarner.home.IHomeMVP;

public class HomeViewHolder extends RecyclerView.ViewHolder implements ICityRowView {

    @BindView(R.id.name_text)
    TextView nameTextView;

    public HomeViewHolder(final IHomeMVP.Presenter presenter, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(v -> presenter.onCityClicked(getAdapterPosition()));
    }

    @Override
    public void setName(String name) {
        nameTextView.setText(name);
    }
}
