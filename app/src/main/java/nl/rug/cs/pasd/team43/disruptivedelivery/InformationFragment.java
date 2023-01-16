package nl.rug.cs.pasd.team43.disruptivedelivery;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class InformationFragment extends Fragment {
    public InformationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_information, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar_info);
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back);
        toolbar.setNavigationOnClickListener(v -> requireActivity().onBackPressed());

        return view;
    }
}