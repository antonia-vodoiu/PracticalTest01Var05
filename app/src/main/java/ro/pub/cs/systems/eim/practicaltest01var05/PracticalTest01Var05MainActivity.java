package ro.pub.cs.systems.eim.practicaltest01var05;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {
    Button navigateToSecondary, topLeft, topRight, center, bottomLeft, bottomRight;
    TextView textView;
    String pressedButtons = "";
    int count = 0;
    ActivityResultLauncher<Intent> activityResultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);
        navigateToSecondary = findViewById(R.id.navigate_to_secondary);
        topLeft = findViewById(R.id.top_left);
        topRight = findViewById(R.id.top_right);
        center = findViewById(R.id.center_button);
        bottomLeft = findViewById(R.id.bottom_left);
        bottomRight = findViewById(R.id.bottom_right);
        textView = findViewById(R.id.textView);

        if (savedInstanceState != null){
            count = savedInstanceState.getInt("count", 0);
            Toast.makeText(this, "Nr de apasari: " + count, Toast.LENGTH_LONG).show();
        }
        topLeft.setOnClickListener(v -> {
            if(!pressedButtons.isEmpty()){
                pressedButtons += ", ";
            }
            pressedButtons += "Top Left";
            textView.setText(pressedButtons);
            count++;
        });
        topRight.setOnClickListener(v -> {
            if(!pressedButtons.isEmpty()){
                pressedButtons += ", ";
            }
            pressedButtons += "Top Right";
            textView.setText(pressedButtons);
            count++;
        });
        bottomLeft.setOnClickListener(v -> {
            if(!pressedButtons.isEmpty()){
                pressedButtons += ", ";
            }
            pressedButtons += "Bottom Left";
            textView.setText(pressedButtons);
            count++;
        });
        bottomRight.setOnClickListener(v -> {
            if(!pressedButtons.isEmpty()){
                pressedButtons += ", ";
            }
            pressedButtons += "Bottom Right";
            textView.setText(pressedButtons);
            count++;
        });
        center.setOnClickListener(v -> {
            if(!pressedButtons.isEmpty()){
                pressedButtons += ", ";
            }
            pressedButtons += "Center";
            textView.setText(pressedButtons);
            count++;
        });
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK){
                Toast.makeText(this, "The activity returned with OK", Toast.LENGTH_LONG).show();
            }   else{
                Toast.makeText(this, "The activity returned with CANCEL", Toast.LENGTH_LONG).show();
            }
            count = 0;
            textView.setText("");
            pressedButtons = "";
        });
        navigateToSecondary.setOnClickListener(v -> {
            String display = textView.getText().toString();
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var05SecondaryActivity.class);
            intent.putExtra(Constants.display, display);
            activityResultLauncher.launch(intent);
        });





    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            count = savedInstanceState.getInt("count");
            Toast.makeText(this, "Nr apasari: " + count, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){

        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }
}