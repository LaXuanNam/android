package com.example.de1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class mh4 extends AppCompatActivity {
    private ListView listView;
    private Button buttonShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mh4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.listView);
        buttonShow = findViewById(R.id.buttonShow);

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    showTeachers();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void showTeachers() throws JSONException {
        String jsonString = "[{\"hoten\":\"Nguyen Van A\",\"gpa\":\"3.7\"}," +
                "{\"hoten\":\"Le Van C\",\"gpa\":\"3.4\"}]";

        JSONArray jsonArray = new JSONArray(jsonString);
        ArrayList<String> teacherList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject tc = jsonArray.getJSONObject(i);
            String sv = "Họ tên: " + tc.getString("hoten") + "\nGPA: " + tc.getString("gpa");
            teacherList.add(sv);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, teacherList);
        listView.setAdapter(adapter);
    }
}