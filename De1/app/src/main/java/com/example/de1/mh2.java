package com.example.de1;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mh2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mh2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RadioGroup rangu = findViewById(R.id.radPN);
        RadioButton ngu1 = findViewById(R.id.rd1);
        RadioButton ngu2 = findViewById(R.id.rd2);
        RadioButton ngu3 = findViewById(R.id.rd3);
        RadioButton ngu4 = findViewById(R.id.rd4);
        CheckBox cboxe = findViewById(R.id.cbxe);
        CheckBox cbowifi = findViewById(R.id.cbwifi);
        Button btnchoose = findViewById(R.id.btnchon);
        Button btnexit = findViewById(R.id.btnexit);
        Button btnnext = findViewById(R.id.btnNext);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = rangu.getCheckedRadioButtonId();
                String phong = "Loại phòng: ";
                if(i == ngu1.getId()) {
                    phong += "phòng 1";
                }
                else if(i == ngu2.getId()){
                    phong += "phòng 2";
                }else if(i == ngu3.getId()){
                    phong += "phòng 3";
                }else {
                    phong += "phòng 4";
                }
                String dv = "Dịch vụ: ";
                if(cboxe.isChecked() && cbowifi.isChecked()){
                    dv += "Bãi đỗ xe và wifi";
                } else if (cboxe.isChecked()) {
                    dv += "Bãi đỗ xe";
                } else if (cbowifi.isChecked()) {
                    dv += "Wifi";
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(mh2.this);
                builder.setTitle("Thông tin đã chọn")
                        .setMessage(phong + "\n" + dv)
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mh2.this, mh3.class);
                startActivity(intent);
            }
        });
    }
}