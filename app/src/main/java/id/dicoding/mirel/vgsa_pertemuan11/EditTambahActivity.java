package id.dicoding.mirel.vgsa_pertemuan11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTambahActivity extends AppCompatActivity {
    EditText edt_id ,edt_nama,edt_alamat;
    Button Simpan,Cancel;
    DbHelper SQLite = new DbHelper(this);
    String id_list,nama_list,alamat_list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tambah);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edt_id = findViewById(R.id.txt_id);
        edt_nama = findViewById(R.id.edt_nama);
        edt_alamat = findViewById(R.id.edt_alamat);
        Simpan = findViewById(R.id.btn_simpan);
        Cancel = findViewById(R.id.btn_batal);

        id_list = getIntent().getStringExtra(MainActivity.TAG_ID);
        nama_list = getIntent().getStringExtra(MainActivity.TAG_NAME);
        alamat_list = getIntent().getStringExtra(MainActivity.TAG_ADRRESS);
        Log.d("debug", "data : " + id_list + " " + nama_list + " " + alamat_list);
        if(id_list == null || id_list.equals("")){
            setTitle("Tambah Data");

        }else {
            setTitle("Edit Data");
            edt_id.setText(id_list);
            edt_nama.setText(nama_list);
            edt_alamat.setText(alamat_list);
        }

        Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (edt_id.getText().toString().equals("")) {
                        save();
                    }else {
                        edit();
                    }
                }
                catch (Exception e){
                    Log.e("btn_simpan ", "instance initializer: "  + e.toString() );
                }
            }

        });
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blank();
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                blank();
                this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void blank() {
        edt_nama.requestFocus();
        edt_id.setText(null);
        edt_nama.setText(null);
        edt_alamat.setText(null);
    }
    private void save(){
        if(String.valueOf(edt_nama.getText()).equals(null)|| String.valueOf(edt_nama.getText()).equals("")
                || String.valueOf(edt_alamat.getText()).equals(null)||String.valueOf(edt_alamat.getText()).equals("")){
            Toast.makeText(getApplicationContext(),"Data jangan dikosongkan!!!",Toast.LENGTH_SHORT).show();
        }else {
            SQLite.insert(edt_nama.getText().toString().trim(),edt_alamat.getText().toString().trim());
            blank();
            finish();
        }
    }
    private void edit(){
        if(String.valueOf(edt_nama.getText()).equals(null)|| String.valueOf(edt_nama.getText()).equals("")
                || String.valueOf(edt_alamat.getText()).equals(null)||String.valueOf(edt_alamat.getText()).equals("")){
            Toast.makeText(getApplicationContext(),"TIDAK BOLEH KOSONG!!!",Toast.LENGTH_SHORT).show();
        }else {
            SQLite.update(Integer.parseInt(edt_id.getText().toString().trim()) ,edt_nama.getText().toString().trim(),edt_alamat.getText().toString().trim());
            blank();
            finish();
        }
    }
}