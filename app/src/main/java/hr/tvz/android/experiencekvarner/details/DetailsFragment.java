package hr.tvz.android.experiencekvarner.details;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.tvz.android.experiencekvarner.R;
import hr.tvz.android.experiencekvarner.Utils;
import hr.tvz.android.experiencekvarner.model.ActivityModel;

public class DetailsFragment extends Fragment {

    @BindView(R.id.text_name)           TextView nameTextView;
    @BindView(R.id.text_description)    TextView descriptionTextView;
    @BindView(R.id.image)               SimpleDraweeView imageView;
    @BindView(R.id.score)               RatingBar ratingBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ActivityModel activity = DetailsFragmentArgs.fromBundle(requireArguments()).getActivity();
        ((Toolbar) requireActivity().requireViewById(R.id.toolbar)).setTitle(activity.getName());
        ButterKnife.bind(this, view);

        nameTextView.setText(activity.getName());
        descriptionTextView.setText(activity.getDescription());
        imageView.setImageURI(Uri.parse(String.format("%s%s%s", Utils.baseUrl, "activities/", activity.getImage())));
        ratingBar.setRating(activity.getScore());

        return view;
    }
}
