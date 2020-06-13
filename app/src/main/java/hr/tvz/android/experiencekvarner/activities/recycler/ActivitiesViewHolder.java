package hr.tvz.android.experiencekvarner.activities.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.tvz.android.experiencekvarner.R;
import hr.tvz.android.experiencekvarner.activities.IActivitiesMVP;

public class ActivitiesViewHolder extends RecyclerView.ViewHolder implements IActivitiesRowView {

    @BindView(R.id.name_text)
    TextView nameTextView;

    public ActivitiesViewHolder(final IActivitiesMVP.Presenter presenter, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(v -> presenter.onActivityClicked(getAdapterPosition()));
    }

    @Override
    public void setName(String name) {
        nameTextView.setText(name);
    }
}
