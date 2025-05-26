package com.example.project_15; import android.content.Intent;
import android.os.Bundle; import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity; public class MainActivity extends AppCompatActivity {
TextView textViewWelcome; Button buttonLogout; SessionManager sessionManager; @Override
protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main); sessionManager = new SessionManager(this); if (!sessionManager.isLoggedIn()) {
navigateToLogin();
}
textViewWelcome =
findViewById(R.id.textViewWelcome);
buttonLogout = findViewById(R.id.buttonLogout);
String username = sessionManager.getUsername();
textViewWelcome.setText("Welcome, " + username); buttonLogout.setOnClickListener(new
View.OnClickListener() { @Override
public void onClick(View v) { sessionManager.logout(); navigateToLogin();
}
});
}
private void navigateToLogin() {
Intent intent = new Intent(MainActivity.this, LoginActivity.class);
startActivity(intent); finish();
}
}
