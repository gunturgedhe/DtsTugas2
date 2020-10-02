package polinema.ac.id.dtsdesigntolayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static polinema.ac.id.dtsdesigntolayout.WelcomeBack.isValidEmail;

public class ForgotPassword extends AppCompatActivity {

    // Deklarasi EditText
    EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        editTextEmail = findViewById(R.id.edt_txt_email);
        // Binding EditText
    }

    public void postSendRequest(View view) {
        // Validasi email kosong
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }
            else if (!isValidEmail(editTextEmail.getText().toString().trim())) {
                Toast.makeText(view.getContext(), "Email tidak valid!", Toast.LENGTH_LONG).show();
            }
            else{
                    Intent i = new Intent(ForgotPassword.this, ResetPassword.class);
                    startActivity(i);
                }
            }
    private boolean isValidEmail(CharSequence email) {
        return(Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}


