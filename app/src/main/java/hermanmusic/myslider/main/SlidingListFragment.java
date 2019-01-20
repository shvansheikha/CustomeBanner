package hermanmusic.myslider.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



import hermanmusic.myslider.R;

public class SlidingListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sliding_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button=view.findViewById(R.id.close_fragment);
        button.setOnClickListener(v -> ((message) (getContext())).hide_version());
    }

    public interface message {
        void hide_version();
    }
}
