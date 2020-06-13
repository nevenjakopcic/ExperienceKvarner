package hr.tvz.android.experiencekvarner.activities.recycler;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.tvz.android.experiencekvarner.R;
import hr.tvz.android.experiencekvarner.Utils;
import hr.tvz.android.experiencekvarner.activities.IActivitiesMVP;
import hr.tvz.android.experiencekvarner.model.CategoryModel;

public class ActivitiesViewHolder extends RecyclerView.ViewHolder implements IActivitiesRowView {

    @BindView(R.id.name_text)           TextView nameTextView;
    @BindView(R.id.activity_thumbnail)  SimpleDraweeView thumbnail;

    public ActivitiesViewHolder(final IActivitiesMVP.Presenter presenter, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(v -> presenter.onActivityClicked(getAdapterPosition()));
    }

    @Override
    public void setName(String name) {
        nameTextView.setText(name);
    }

    @Override
    public void setImage(CategoryModel category, String image) {
        String categorySubdomain;
        switch (category.getName()) {
            case "beach": categorySubdomain = "beaches/"; break;
            case "event": categorySubdomain = "events/"; break;
            case "boat": categorySubdomain = "boats/"; break;
            case "apartment": categorySubdomain = "apartments/"; break;
            default:
                throw new IllegalStateException("Unexpected value: " + category.getName());
        }
        thumbnail.setImageURI(Uri.parse(String.format("%s%s%s%s", Utils.baseUrl, "activities/", categorySubdomain, image)));
    }
}
