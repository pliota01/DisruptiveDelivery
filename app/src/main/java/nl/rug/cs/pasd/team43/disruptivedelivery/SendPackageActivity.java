package nl.rug.cs.pasd.team43.disruptivedelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import nl.rug.cs.pasd.team43.disruptivedelivery.model.AddressInfo;
import nl.rug.cs.pasd.team43.disruptivedelivery.model.PackageInfo;

public class SendPackageActivity extends AppCompatActivity implements View.OnClickListener {
    private AddressInfo senderAddressInfo;
    private AddressInfo receiverAddressInfo;
    private PackageInfo packageInfo;


    private EditText etStreetAndNumber;
    private EditText etZipCode;
    private EditText etCity;
    private EditText etCountry;

    private NumberPicker numPickerWidth;
    private NumberPicker numPickerDepth;
    private NumberPicker numPickerHeight;

    private SwitchCompat switchBreakable;
    private SwitchCompat switchPerishable;
    private SwitchCompat switchPrickUpOption;

    private Button btnOrderAndPay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_package);

        etStreetAndNumber = findViewById(R.id.et_street_and_number);
        etZipCode = findViewById(R.id.et_zipcode);
        etCity = findViewById(R.id.et_city);
        etCountry = findViewById(R.id.et_country);

        numPickerWidth = findViewById(R.id.numberPickerWidth);
        numPickerDepth = findViewById(R.id.numberPickerDepth);
        numPickerHeight = findViewById(R.id.numberPickerHeight);

        switchBreakable = findViewById(R.id.switch_breakable);
        switchPerishable = findViewById(R.id.switch_perishable);
        switchPrickUpOption = findViewById(R.id.switch_pick_up_option);
        switchPrickUpOption.setChecked(true);


        btnOrderAndPay = findViewById(R.id.btn_order_and_pay);


        numPickerWidth.setMinValue(1);
        numPickerWidth.setMaxValue(300);
        numPickerDepth.setMinValue(1);
        numPickerDepth.setMaxValue(300);
        numPickerHeight.setMinValue(1);
        numPickerHeight.setMaxValue(300);


        btnOrderAndPay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_order_and_pay) {
            Intent intent = new Intent(this, PaymentActivity.class);
            startActivity(intent);
        }
    }
}