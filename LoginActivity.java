package com.example.project_15; import android.content.Intent;
import android.os.Bundle; import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity; 
public class LoginActivity extends AppCompatActivity {
EditText editTextUsername; Button buttonLogin;
SessionManager sessionManager; @Override
protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
setContentView(R.layout.activity_login); sessionManager = new SessionManager(this); if (sessionManager.isLoggedIn()) {
navigateToMainActivity();
}
editTextUsername =
findViewById(R.id.editTextUsername);
buttonLogin = findViewById(R.id.buttonLogin); buttonLogin.setOnClickListener(new
View.OnClickListener() { @Override
public void onClick(View v) { String username =
editTextUsername.getText().toString().trim(); if (!username.isEmpty()) {
sessionManager.createSession(username); navigateToMainActivity();
} else {
Toast.makeText(LoginActivity.this, "Enter Username", Toast.LENGTH_SHORT).show();
}
}
});
}
private void navigateToMainActivity() {
Intent intent = new Intent(LoginActivity.this, MainActivity.class);
startActivity(intent); finish();
}
}
