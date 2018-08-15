package cn.edu.ldu.myrestaurant;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    public static final String EMAIL_KEY = "email_key";
    private EditText etEmail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = (EditText) findViewById(R.id.email);
        etPassword = (EditText) findViewById(R.id.password);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        SharedPreferences prefs = getSharedPreferences(MainActivity.MY_GLOBAL_PREFS, MODE_PRIVATE);
        String email = prefs.getString(EMAIL_KEY, "");
        if (!TextUtils.isEmpty(email)) {
            etEmail.setText(email);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etEmail.setError(null);
                etPassword.setError(null);
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                boolean cancel = false;
                View focusView = null;

                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("邮箱地址不能为空！");
                    focusView = etEmail;
                    cancel = true;
                } else if (!isEmailValid(email)) {
                    etEmail.setError("邮箱地址格式不对！");
                    focusView = etEmail;
                    cancel = true;
                }
                if (TextUtils.isEmpty(password) || !isPasswordValid(password)) {
                    etPassword.setError("密码长度不够5位！");
                    focusView = etPassword;
                    cancel = true;
                }
                if (cancel) {
                    focusView.requestFocus();
                } else { //登录成功
                    getIntent().putExtra(EMAIL_KEY, email);
                    setResult(RESULT_OK, getIntent());
                    finish();
                }
            }
        });
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }
}
