package com.ini_package_heryadi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class layout2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2);
        Button btnExit = findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(layout2.this);
                builder.setTitle("Keluar");
                builder.setMessage("Anda mau tutup aplikasinya ya?");
                builder.setPositiveButton("Yoi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Untuk masuk ke Dialog form
                        showExitReasonDialog();
                    }
                });
                builder.setNegativeButton("Ngga", null);
                builder.show();
            }
        });


    }

    private void showExitReasonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Kenapa di tutup?");
        final EditText input = new EditText(this);
        builder.setView(input);
        builder.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String exitReason = input.getText().toString();
                // simpan alasan keluar
                saveExitReason(exitReason);
                // keluar dari aplikasi
                finishAffinity();
            }
        });
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    private void saveExitReason(String exitReason) {
        // kode untuk menyimpan alasan keluar
    }


}