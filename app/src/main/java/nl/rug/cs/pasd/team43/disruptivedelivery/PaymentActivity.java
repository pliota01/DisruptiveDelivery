package nl.rug.cs.pasd.team43.disruptivedelivery;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.braintreepayments.cardform.view.CardForm;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

    private CardForm cardForm;
    private Button btnCompletePayment;
    private AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btnCompletePayment = findViewById(R.id.btn_complete_payment);
        cardForm = findViewById(R.id.card_form);

        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .mobileNumberExplanation("SMS is required on this number")
                .setup(PaymentActivity.this);
        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

        btnCompletePayment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_complete_payment) {
            if (cardForm.isValid()) {
                alertBuilder = new AlertDialog.Builder(PaymentActivity.this);
                alertBuilder.setTitle("Confirm before purchase");
                alertBuilder.setMessage("Card number: " + cardForm.getCardNumber() + "\n" +
                        "Card expiry date: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                        "Card CVV: " + cardForm.getCvv() + "\n" +
                        "Postal code: " + cardForm.getPostalCode() + "\n" +
                        "Phone number: " + cardForm.getMobileNumber());
                alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Toast.makeText(PaymentActivity.this, "Thank you for purchase", Toast.LENGTH_LONG).show();
                    }
                });
                alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = alertBuilder.create();
                alertDialog.show();
            }else {
                Toast.makeText(PaymentActivity.this, "Please complete the form", Toast.LENGTH_LONG).show();
            }
        }
    }
}
