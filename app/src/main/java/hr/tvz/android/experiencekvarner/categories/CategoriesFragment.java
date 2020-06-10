package hr.tvz.android.experiencekvarner.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.textview.MaterialTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.tvz.android.experiencekvarner.R;

public class CategoriesFragment extends Fragment {

    @BindView(R.id.city_text)
    MaterialTextView cityTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        ButterKnife.bind(this, view);

        cityTextView.setText(CategoriesFragmentArgs.fromBundle(requireArguments()).getCity().getName());

        return view;
    }
}