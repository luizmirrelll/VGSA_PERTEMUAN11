package id.dicoding.mirel.vgsa_pertemuan11;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list_add;
    AlertDialog.Builder alertdialog;
    List<Data> listItem = new ArrayList<Data>();
    Adafter adafter;
    DbHelper SQLite = new DbHelper(this);

    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_ADRRESS = "address";

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLite = new DbHelper(getApplicationContext());
        list_add = (ListView) findViewById(R.id.list_add);
        fab = (FloatingActionButton) findViewById(R.id.floating);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EditTambahActivity.class);
                startActivity(intent);
            }
        });

        adafter = new Adafter(MainActivity.this,listItem);
        list_add.setAdapter(adafter);

        list_add.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final String idx = listItem.get(position).getId();
                final String name = listItem.get(position).getName();
                final String address = listItem.get(position).getAddress();

                final CharSequence[] dialogitem = {"Edit", "Delete"};
                alertdialog = new AlertDialog.Builder(MainActivity.this);
                alertdialog.setCancelable(true);
                alertdialog.setItems(dialogitem,new DialogInterface.OnClickListener(){


                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                Intent intent = new Intent(MainActivity.this,EditTambahActivity.class);
                                intent.putExtra(TAG_ID,idx);
                                intent.putExtra(TAG_NAME,name);
                                intent.putExtra(TAG_ADRRESS,address);
                                startActivity(intent);
                                break;
                            case 1:
                                SQLite.delete(Integer.parseInt(idx));
                                listItem.clear();
                                getAllData();
                                break;
                        }
                    }
                }).show();
                return false;
            }
        });
        getAllData();

    }

    private void getAllData() {
        ArrayList<HashMap<String,String>> row = SQLite.getAlldata();
        for (int i = 0; i<row.size();i++){
            String id = row.get(i).get(TAG_ID);
            String poster = row.get(i).get(TAG_NAME);
            String title = row.get(i).get(TAG_ADRRESS);

            Data data = new Data();
            data.setId(id);
            data.setName(poster);
            data.setAddress(title);
            listItem.add(data);

        }
        adafter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        listItem.clear();
        getAllData();
    }
}