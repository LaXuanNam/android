package com.example.de1;

import static android.app.ProgressDialog.show;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtdn = findViewById(R.id.txtDN);
        EditText txtpass = findViewById(R.id.txtPass);
        Button btnin = findViewById(R.id.btnDN);
        Button btnout = findViewById(R.id.btnthoat);
        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtdn.getText().toString();
                String pass = txtpass.getText().toString();
                if(username.isEmpty() || pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Mời bạn nhập  đầy đủ", Toast.LENGTH_SHORT).show();
                }else
                if(username.equals("cnttk15") && pass.equals("123456")){
                    Intent intent =new Intent(MainActivity.this,mh2.class);
                    startActivity(intent);
                }else{
                    AlertDialog.Builder al = new AlertDialog.Builder(MainActivity.this);
                    al.setTitle("Thông báo")
                    .setMessage("Tên đăng nhập hoặc mật khẩu sai")
                    .setCancelable(false)
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                        }
                    });
                    AlertDialog alertDialog = al.create();
                    alertDialog.show();
                }
            }
        });
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}