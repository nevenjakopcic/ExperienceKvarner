package hr.tvz.android.experiencekvarner.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import hr.tvz.android.experiencekvarner.R;

public class AboutFragment extends Fragment {

    @BindView(R.id.title1)
    TextView title;

    @BindView(R.id.opis)
    TextView opis;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, view);

        title.setText(R.string.wiki1);
        opis.setText(R.string.wiki2);

        return view;
    }
}