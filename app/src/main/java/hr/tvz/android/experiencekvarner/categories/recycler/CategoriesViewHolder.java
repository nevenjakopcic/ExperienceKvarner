package hr.tvz.android.experiencekvarner.categories.recycler;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.tvz.android.experiencekvarner.R;
import hr.tvz.android.experiencekvarner.Utils;
import hr.tvz.android.experiencekvarner.categories.ICategoriesMVP;

public class CategoriesViewHolder extends RecyclerView.ViewHolder implements ICategoriesRowView {

    @BindView(R.id.name_text)
    TextView nameTextView;
    @BindView(R.id.category_thumbnail)
    SimpleDraweeView thumbnail;

    public CategoriesViewHolder(final ICategoriesMVP.Presenter presenter, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(v -> presenter.onCategoryClicked(getAdapterPosition()));
    }


    @Override
    public void setName(String name) {
        nameTextView.setText(name);
    }

    @Override
    public void setImage(String image) {
        thumbnail.setImageURI(Uri.parse(String.format("%s%s%s", Utils.baseUrl, "logo/", image)));
    }
}
