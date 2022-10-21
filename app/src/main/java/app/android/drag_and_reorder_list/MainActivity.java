package app.android.drag_and_reorder_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        goDRnoHandle();
        goDRHandle();
    }

    private void goDRnoHandle() {
        button1 = findViewById(R.id.btn1);
        button1.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, DRnoHandle.class);
            startActivity(i);
        });
    }

    private void goDRHandle() {
        button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, DRHandle.class);
            startActivity(i);
        });
    }
}