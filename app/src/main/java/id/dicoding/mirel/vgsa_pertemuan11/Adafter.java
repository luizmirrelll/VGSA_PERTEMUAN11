package id.dicoding.mirel.vgsa_pertemuan11;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adafter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> items;

    public Adafter(Activity activity, List<Data> items){
        this.activity = activity;
        this.items = items;

    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.tambah_baris,null);
        }

        TextView id_list = (TextView) convertView.findViewById(R.id.id_text);
        TextView nama_list = (TextView) convertView.findViewById(R.id.nama_text);
        TextView alamat_list = (TextView) convertView.findViewById(R.id.alamat_text);

        Data data = items.get(position);
        id_list.setText(data.getId());
        nama_list.setText(data.getName());
        alamat_list.setText(data.getAddress());
        return convertView;
    }
}
