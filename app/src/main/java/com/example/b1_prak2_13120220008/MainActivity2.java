package com.example.b1_prak2_13120220008;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView txtStb, txtNama, txtAngk, txtProdi, txtMinat;
    Button btnTutup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtStb = findViewById(R.id.txtStb);
        txtNama = findViewById(R.id.txtNama);
        txtAngk = findViewById(R.id.txtAngk);
        txtProdi = findViewById(R.id.txtPilProdi);
        txtMinat = findViewById(R.id.txtPilihMinat);
        btnTutup = findViewById(R.id.btnTutup);

        String stambuk = getIntent().getStringExtra("STAMBUK");
        String nama = getIntent().getStringExtra("NAMA");
        String programStudi = getIntent().getStringExtra("PROGRAM_STUDI");
        String angkatan = getIntent().getStringExtra("ANGKATAN");
        String minat = getIntent().getStringExtra("MINAT");

        txtStb.setText(stambuk);
        txtNama.setText(nama);
        txtAngk.setText(angkatan);
        txtProdi.setText(programStudi);
        txtMinat.setText(minat);

        btnTutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}