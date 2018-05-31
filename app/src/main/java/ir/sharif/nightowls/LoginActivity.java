package ir.sharif.nightowls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ir.sharif.nightowls.utils.MyConstants;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();

        loginButton.setOnClickListener(this);

    }

    private void initUI() {
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);
    }

    @Override
    public void onClick(View v) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (email.equals(MyConstants.LOGIN_EMAIL) && password.equals(MyConstants.LOGIN_PASS)){

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else {
            Toast loginToast = Toast.makeText(this, R.string.login_error, Toast.LENGTH_SHORT);
            loginToast.show();
        }

    }
}
