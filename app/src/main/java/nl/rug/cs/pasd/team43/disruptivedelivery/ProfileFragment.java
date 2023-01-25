package nl.rug.cs.pasd.team43.disruptivedelivery;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        SharedPreferences sharedPreferences = requireActivity()
                .getSharedPreferences(getString(R.string.preferences_profile), Context.MODE_PRIVATE);

        String firstName = sharedPreferences.getString(getString(R.string.preference_first_name), "---");
        String lastName = sharedPreferences.getString(getString(R.string.preference_last_name), "---");
        String email = sharedPreferences.getString(getString(R.string.preference_email), "---");
        String phoneNumber = sharedPreferences.getString(getString(R.string.preference_phone_number), "---");
        String streetAndNumber = sharedPreferences.getString(getString(R.string.preference_street_and_number), "---");
        String zipcode = sharedPreferences.getString(getString(R.string.preference_zipcode), "---");
        String city = sharedPreferences.getString(getString(R.string.preference_city), "---");
        String country = sharedPreferences.getString(getString(R.string.preference_country), "---");

        LinearLayout ll = view.findViewById(R.id.profile_item_form_first_name);
        TextView tvType = ll.findViewById(R.id.tv_profile_type);
        TextView tvContent = ll.findViewById(R.id.tv_profile_content);
        tvType.setText(getString(R.string.first_name));
        tvContent.setText(firstName);

        ll = view.findViewById(R.id.profile_item_form_last_name);
        tvType = ll.findViewById(R.id.tv_profile_type);
        tvContent = ll.findViewById(R.id.tv_profile_content);
        tvType.setText(getString(R.string.last_name));
        tvContent.setText(lastName);


        ll = view.findViewById(R.id.profile_item_form_email);
        tvType = ll.findViewById(R.id.tv_profile_type);
        tvContent = ll.findViewById(R.id.tv_profile_content);
        tvType.setText(getString(R.string.email));
        tvContent.setText(email);

        ll = view.findViewById(R.id.profile_item_form_phone_number);
        tvType = ll.findViewById(R.id.tv_profile_type);
        tvContent = ll.findViewById(R.id.tv_profile_content);
        tvType.setText(getString(R.string.phone_number));
        tvContent.setText(phoneNumber);

        ll = view.findViewById(R.id.profile_item_form_street_and_number);
        tvType = ll.findViewById(R.id.tv_profile_type);
        tvContent = ll.findViewById(R.id.tv_profile_content);
        tvType.setText(getString(R.string.street_and_number));
        tvContent.setText(streetAndNumber);

        ll = view.findViewById(R.id.profile_item_form_zipcode);
        tvType = ll.findViewById(R.id.tv_profile_type);
        tvContent = ll.findViewById(R.id.tv_profile_content);
        tvType.setText(getString(R.string.zipcode));
        tvContent.setText(zipcode);

        ll = view.findViewById(R.id.profile_item_form_city);
        tvType = ll.findViewById(R.id.tv_profile_type);
        tvContent = ll.findViewById(R.id.tv_profile_content);
        tvType.setText(getString(R.string.city));
        tvContent.setText(city);

        ll = view.findViewById(R.id.profile_item_form_country);
        tvType = ll.findViewById(R.id.tv_profile_type);
        tvContent = ll.findViewById(R.id.tv_profile_content);
        tvType.setText(getString(R.string.country));
        tvContent.setText(country);

        return view;
    }
}