package com.example.b1_prak2_13120220008;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.ArrayAdapter;


public class MainActivity extends AppCompatActivity {
    EditText editStb, editNama;
    Spinner spinner;
    RadioGroup Rg;
    RadioButton btnTi, btnSi;
    CheckBox cbBEM, cbKir, cbPkw, cbSeni, cbJurnal, cbOlgar;
    Button button2;
    TextView txtProdi, txtMinat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editStb = findViewById(R.id.editStb);
        editNama = findViewById(R.id.editNama);
        spinner = findViewById(R.id.spinner);
        Rg = findViewById(R.id.Rg);
        btnTi = findViewById(R.id.btnTi);
        btnSi = findViewById(R.id.btnSi);
        cbBEM = findViewById(R.id.cbBEM);
        cbKir = findViewById(R.id.cbKir);
        cbPkw = findViewById(R.id.cbPkw);
        cbSeni = findViewById(R.id.cbSeni);
        cbJurnal = findViewById(R.id.cbJurnal);
        cbOlgar = findViewById(R.id.cbOlgar);
        button2 = findViewById(R.id.button2);
        txtProdi = findViewById(R.id.txtProdi);
        txtMinat = findViewById(R.id.txtMinat);

        String[] item = new String[]{"-Pilih Angkatan-","2022", "2021", "2020", "2019", "2018", "2017",
                "2016", "2015", "2014"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, item);
        spinner.setAdapter(adapter);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stambuk = editStb.getText().toString();
                String nama = editNama.getText().toString();
                String programStudi = getProgramStudi();
                String angkatan = spinner.getSelectedItem().toString();
                String minat = getMinat();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("STAMBUK", stambuk);
                intent.putExtra("NAMA", nama);
                intent.putExtra("PROGRAM_STUDI", programStudi);
                intent.putExtra("ANGKATAN", angkatan);
                intent.putExtra("MINAT", minat);

                startActivity(intent);
            }
        });
    }
    private String getProgramStudi() {
        int selectedId = Rg.getCheckedRadioButtonId();
        if (selectedId == R.id.btnTi) {
            return "Teknik Informatika";
        }
        else if (selectedId == R.id.btnSi) {
            return "Sistem Informasi";
        }
        else {
            return "";}
    }

    private String getMinat() {
        StringBuilder minat = new StringBuilder();
        if (cbBEM.isChecked()) {
            minat.append("- ").append(cbBEM.getText()).append("\n");
        }
        if (cbKir.isChecked()) {
            minat.append("- ").append(cbKir.getText()).append("\n");
        }
        if (cbPkw.isChecked()) {
            minat.append("- ").append(cbPkw.getText()).append("\n");
        }
        if (cbSeni.isChecked()) {
            minat.append("- ").append(cbSeni.getText()).append("\n");
        }
        if (cbJurnal.isChecked()) {
            minat.append("- ").append(cbJurnal.getText()).append("\n");
        }
        if (cbOlgar.isChecked()) {
            minat.append("- ").append(cbOlgar.getText()).append("\n");
        }
        return minat.toString();
    }



}