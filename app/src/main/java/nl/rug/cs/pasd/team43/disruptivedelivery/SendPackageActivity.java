package nl.rug.cs.pasd.team43.disruptivedelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import nl.rug.cs.pasd.team43.disruptivedelivery.model.AddressInfo;
import nl.rug.cs.pasd.team43.disruptivedelivery.model.Order;

public class SendPackageActivity extends AppCompatActivity implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {
//    private AddressInfo senderAddressInfo;
//    private AddressInfo receiverAddressInfo;
//    private Order order;


    private TextInputLayout tilStreetAndNumberReceiver;
    private TextInputLayout tilZipcodeReceiver;
    private TextInputLayout tilCityReceiver;
    private TextInputLayout tilCountryReceiver;
    private EditText etStreetAndNumberReceiver;
    private EditText etZipCodeReceiver;
    private EditText etCityReceiver;
    private EditText etCountryReceiver;

    private NumberPicker numPickerWidth;
    private NumberPicker numPickerDepth;
    private NumberPicker numPickerHeight;

    private SwitchCompat switchBreakable;
    private SwitchCompat switchPerishable;
    private SwitchCompat switchPrickUpOption;


    private TextInputLayout tilStreetAndNumberSender;
    private TextInputLayout tilZipcodeSender;
    private TextInputLayout tilCitySender;
    private TextInputLayout tilCountrySender;
    private EditText etStreetAndNumberSender;
    private EditText etZipCodeSender;
    private EditText etCitySender;
    private EditText etCountrySender;

    private Button btnOrderAndPay;


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_package);


        Toolbar toolbar = findViewById(R.id.toolbar_send_package);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        ConstraintLayout cl = findViewById(R.id.destination_address_form);
        tilStreetAndNumberReceiver = cl.findViewById(R.id.til_street_and_number);
        tilZipcodeReceiver = cl.findViewById(R.id.til_zipcode);
        tilCityReceiver = cl.findViewById(R.id.til_city);
        tilCountryReceiver = cl.findViewById(R.id.til_country);


        etStreetAndNumberReceiver = cl.findViewById(R.id.et_street_and_number);
        etZipCodeReceiver = cl.findViewById(R.id.et_zipcode);
        etCityReceiver = cl.findViewById(R.id.et_city);
        etCountryReceiver = cl.findViewById(R.id.et_country);

        cl = findViewById(R.id.sender_address_form);

        tilStreetAndNumberSender = cl.findViewById(R.id.til_street_and_number);
        tilZipcodeSender = cl.findViewById(R.id.til_zipcode);
        tilCitySender = cl.findViewById(R.id.til_city);
        tilCountrySender = cl.findViewById(R.id.til_country);

        etStreetAndNumberSender = cl.findViewById(R.id.et_street_and_number);
        etZipCodeSender = cl.findViewById(R.id.et_zipcode);
        etCitySender = cl.findViewById(R.id.et_city);
        etCountrySender = cl.findViewById(R.id.et_country);

        numPickerWidth = findViewById(R.id.numberPickerWidth);
        numPickerDepth = findViewById(R.id.numberPickerDepth);
        numPickerHeight = findViewById(R.id.numberPickerHeight);

        numPickerWidth.setMinValue(1);
        numPickerWidth.setMaxValue(300);
        numPickerDepth.setMinValue(1);
        numPickerDepth.setMaxValue(300);
        numPickerHeight.setMinValue(1);
        numPickerHeight.setMaxValue(300);


        switchBreakable = findViewById(R.id.switch_breakable);
        switchPerishable = findViewById(R.id.switch_perishable);
        switchPrickUpOption = findViewById(R.id.switch_pick_up_option);
        switchPrickUpOption.setChecked(true);
        switchPrickUpOption.setOnCheckedChangeListener(this);


        btnOrderAndPay = findViewById(R.id.btn_order_and_pay);
        btnOrderAndPay.setOnClickListener(this);
    }


//    private boolean isDestinationAddressValid() {
//        String streetAndNumText = etStreetAndNumberReceiver.getText().toString();
//        String zipcodeText = etZipCodeReceiver.getText().toString();
//        String cityText = etCityReceiver.getText().toString();
//        String countryText = etCountryReceiver.getText().toString();
//
//        boolean errorOccurred = false;
//
//        if (streetAndNumText.isEmpty()) {
//            tilStreetAndNumberReceiver.setError("Needs to be filled");
//            tilStreetAndNumberReceiver.setErrorEnabled(true);
//            errorOccurred = true;
//        } else if (!isStreetAndNumberValid(streetAndNumText)) {
//            tilStreetAndNumberReceiver.setError("Invalid Street and Number");
//            tilStreetAndNumberReceiver.setErrorEnabled(true);
//            errorOccurred = true;
//        } else {
//            tilStreetAndNumberReceiver.setErrorEnabled(false);
//        }
//
//
//        return !errorOccurred;
//    }


    private boolean isAddressValid(TextInputLayout tilStreetAndNumber,
                                   TextInputLayout tilZipcode,
                                   TextInputLayout tilCity,
                                   TextInputLayout tilCountry,
                                   EditText etStreetAndNumber,
                                   EditText etZipCode,
                                   EditText etCity,
                                   EditText etCountry) {


        String streetAndNumText = etStreetAndNumber.getText().toString();
        String zipcodeText = etZipCode.getText().toString();
        String cityText = etCity.getText().toString();
        String countryText = etCountry.getText().toString();

        boolean errorOccurred = false;

        if (streetAndNumText.isEmpty()) {
            tilStreetAndNumber.setError("Needs to be filled");
            tilStreetAndNumber.setErrorEnabled(true);
            errorOccurred = true;
        } else if (!isStreetAndNumberValid(streetAndNumText)) {
            tilStreetAndNumber.setError("Invalid Street and Number");
            tilStreetAndNumber.setErrorEnabled(true);
            errorOccurred = true;
        } else {
            tilStreetAndNumber.setErrorEnabled(false);
        }

        if (zipcodeText.isEmpty()) {
            tilZipcode.setError("Needs to be filled");
            tilZipcode.setErrorEnabled(true);
            errorOccurred = true;
        } else {
            tilZipcode.setErrorEnabled(false);
        }

        if (cityText.isEmpty()) {
            tilCity.setError("Needs to be filled");
            tilCity.setErrorEnabled(true);
            errorOccurred = true;
        } else {
            tilCity.setErrorEnabled(false);
        }

        if (countryText.isEmpty()) {
            tilCountry.setError("Needs to be filled");
            tilCountry.setErrorEnabled(true);
            errorOccurred = true;
        } else {
            tilCountry.setErrorEnabled(false);
        }
        return !errorOccurred;
    }


    private static boolean isInt(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean isStreetAndNumberValid(String streetAndNumber) {
        String[] sp = streetAndNumber.split("");
        if (sp.length < 2)
            return false;
        for (int i = 0; i < sp.length - 1; i++) {
            if (isInt(sp[i])) {
                return false;
            }
        }
        if (!isInt(sp[sp.length - 1])) {
            return false;
        }

        return true;
    }


    private boolean isFormCorrectlyFilled() {
        boolean errorOccurred = false;
        if (!isAddressValid(tilStreetAndNumberReceiver,
                tilZipcodeReceiver,
                tilCityReceiver,
                tilCountryReceiver,
                etStreetAndNumberReceiver,
                etZipCodeReceiver,
                etCityReceiver,
                etCountryReceiver)) {
            errorOccurred = true;
        }

        if (switchPrickUpOption.isChecked()) {
            if (!isAddressValid(tilStreetAndNumberSender,
                    tilZipcodeSender,
                    tilCitySender,
                    tilCountrySender,
                    etStreetAndNumberSender,
                    etZipCodeSender,
                    etCitySender,
                    etCountrySender)) {
                errorOccurred = true;
            }
        }
        return !errorOccurred;
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_order_and_pay) {
            // When "Order and Pay" Button is clicked we check if the form is filled correctly and
            // if so we send them to the payment activity
            if (isFormCorrectlyFilled()) {
                Intent intent = new Intent(this, PaymentActivity.class);
                startActivity(intent);
            } else {
                ScrollView scrollView = findViewById(R.id.scroll_view_send_package);
                scrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int id = compoundButton.getId();
        if (id == R.id.switch_breakable) {
            return;
        }

        if (id == R.id.switch_perishable) {
            return;
        }

        if (id == R.id.switch_pick_up_option) {
            Toast.makeText(SendPackageActivity.this, "Pick Up Option Switched", Toast.LENGTH_SHORT).show();
            View senderAddressForm = findViewById(R.id.sender_address_form);
            if (b) {
                senderAddressForm.setVisibility(View.VISIBLE);
            } else {
                senderAddressForm.setVisibility(View.GONE);
            }
            return;
        }
    }
}