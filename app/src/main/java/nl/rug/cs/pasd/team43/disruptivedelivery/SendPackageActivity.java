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
import android.widget.Toast;

import com.google.android.material.slider.Slider;

import java.util.Objects;

import nl.rug.cs.pasd.team43.disruptivedelivery.model.AddressInfo;
import nl.rug.cs.pasd.team43.disruptivedelivery.model.PackageInfo;

public class SendPackageActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private AddressInfo senderAddressInfo;
    private AddressInfo receiverAddressInfo;
    private PackageInfo packageInfo;


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
        etStreetAndNumberReceiver = cl.findViewById(R.id.et_street_and_number);
        etZipCodeReceiver = cl.findViewById(R.id.et_zipcode);
        etCityReceiver = cl.findViewById(R.id.et_city);
        etCountryReceiver = cl.findViewById(R.id.et_country);

        cl = findViewById(R.id.destination_address_form);

        etStreetAndNumberSender = cl.findViewById(R.id.et_street_and_number);
        etZipCodeSender = cl.findViewById(R.id.et_zipcode);
        etCitySender = cl.findViewById(R.id.et_city);
        etCountrySender = cl.findViewById(R.id.et_country);

        numPickerWidth = findViewById(R.id.numberPickerWidth);
        numPickerDepth = findViewById(R.id.numberPickerDepth);
        numPickerHeight = findViewById(R.id.numberPickerHeight);

        switchBreakable = findViewById(R.id.switch_breakable);
        switchPerishable = findViewById(R.id.switch_perishable);
        switchPrickUpOption = findViewById(R.id.switch_pick_up_option);
        switchPrickUpOption.setChecked(true);
        switchPrickUpOption.setOnCheckedChangeListener(this);


        btnOrderAndPay = findViewById(R.id.btn_order_and_pay);


        numPickerWidth.setMinValue(1);
        numPickerWidth.setMaxValue(300);
        numPickerDepth.setMinValue(1);
        numPickerDepth.setMaxValue(300);
        numPickerHeight.setMinValue(1);
        numPickerHeight.setMaxValue(300);


        btnOrderAndPay.setOnClickListener(this);
    }


    private boolean isDestinationAddressValid() {
        return true;
    }

    private boolean isSenderAddressValid() {
        return true;
    }


    private boolean isFormCorrectlyFilled() {

        if (!isDestinationAddressValid()) {
            return false;
        }

        if (switchPrickUpOption.isChecked()) {
            if (!isSenderAddressValid())
                return false;
        }
        return true;
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_order_and_pay) {

            if (isFormCorrectlyFilled()) {
                Intent intent = new Intent(this, PaymentActivity.class);
                startActivity(intent);
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