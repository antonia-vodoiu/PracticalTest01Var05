package ro.pub.cs.systems.eim.practicaltest01var05;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var05SecondaryActivity extends AppCompatActivity {

    Button verifyButton, cancelButton;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);
        textView2 = findViewById(R.id.textView2);
        verifyButton = findViewById(R.id.verifyButton);
        cancelButton = findViewById(R.id.cancelButton);
        Intent intent = getIntent();
        String display = intent.getStringExtra(Constants.display);
        textView2.setText(display);
        verifyButton.setOnClickListener(v -> {
            Intent result = new Intent();
            setResult(RESULT_OK, result);
            finish();
        });
        cancelButton.setOnClickListener(v -> {
            Intent result = new Intent();
            setResult(RESULT_CANCELED, result);
            finish();
        });

    }
}