package hr.tvz.android.experiencekvarner.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import hr.tvz.android.experiencekvarner.R;

public class AboutFragment extends Fragment {

    private hr.tvz.android.experiencekvarner.about.AboutViewModel aboutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutViewModel =
                ViewModelProviders.of(this).get(hr.tvz.android.experiencekvarner.about.AboutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        final TextView textView = root.findViewById(R.id.title1);
        final TextView opis = root.findViewById(R.id.opis);
        aboutViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(getString(R.string.wiki1));
                opis.setText(getString(R.string.wiki2));
            }
        });
        return root;
    }
}