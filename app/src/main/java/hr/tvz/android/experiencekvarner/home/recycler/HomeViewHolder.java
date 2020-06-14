package hr.tvz.android.experiencekvarner.home.recycler;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.tvz.android.experiencekvarner.R;
import hr.tvz.android.experiencekvarner.Utils;
import hr.tvz.android.experiencekvarner.home.IHomeMVP;

public class HomeViewHolder extends RecyclerView.ViewHolder implements ICityRowView {

    @BindView(R.id.name_text)       TextView nameTextView;
    @BindView(R.id.city_thumbnail)  SimpleDraweeView thumbnail;

    public HomeViewHolder(final IHomeMVP.Presenter presenter, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(v -> presenter.onCityClicked(getAdapterPosition()));
    }

    @Override
    public void setName(String name) {
        nameTextView.setText(name.toUpperCase());
    }

    @Override
    public void setImage(String image) {
        thumbnail.setImageURI(Uri.parse(String.format("%s%s%s", Utils.baseUrl, "cities/", image)));
    }
}
