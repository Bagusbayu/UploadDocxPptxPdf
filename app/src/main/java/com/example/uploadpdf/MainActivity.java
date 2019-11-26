package com.example.uploadpdf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button word, ppt, pdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        word = findViewById(R.id.word);
        ppt = findViewById(R.id.ppt);
        pdf = findViewById(R.id.pdf);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            word.setEnabled(false);
            ppt.setEnabled(false);
            pdf.setEnabled(false);
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
        } else {
            pdf.setEnabled(true);
            word.setEnabled(true);
            ppt.setEnabled(true);
        }
        word.setOnClickListener(this);
        ppt.setOnClickListener(this);
        pdf.setOnClickListener(this);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                word.setEnabled(true);
                ppt.setEnabled(true);
                pdf.setEnabled(true);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pdf:
                Intent intent1 = new Intent(this, PdfActivity.class);
                startActivity(intent1);
                break;
            case R.id.ppt:
                Intent intent2 = new Intent(this, PptActivity.class);
                startActivity(intent2);
                break;
            case R.id.word:
                Intent intent3 = new Intent(this, WordActivity.class);
                startActivity(intent3);
                break;
        }

    }
}
