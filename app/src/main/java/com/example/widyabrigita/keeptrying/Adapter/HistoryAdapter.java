package com.example.widyabrigita.keeptrying.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.widyabrigita.keeptrying.Model.GasFiltered;
import com.example.widyabrigita.keeptrying.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BRI on 3/1/2018.
 */

public class HistoryAdapter extends ArrayAdapter<GasFiltered> {
    private LayoutInflater mInflater;
    private Context cont;
    private GasFiltered item;
    private List<GasFiltered> mItems;

    public HistoryAdapter(Context context, List<GasFiltered> items) {
        super(context, 0, items);
        cont = context;
        mItems = items;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.activity_history, parent, false);
            holder = new ViewHolder();
            holder.sta_name = (TextView) convertView.findViewById(R.id.sta_name);
            holder.gas_type = (TextView) convertView.findViewById(R.id.gas_type);
            holder.created_date = (TextView) convertView.findViewById(R.id.tgl);
            holder.amount_rp = (TextView) convertView.findViewById(R.id.amount);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        item = mItems.get(position);
        holder.sta_name.setText(item.getStationName());
        holder.gas_type.setText(item.getGasType());
        holder.created_date.setText(item.getCreatedDate());
        holder.amount_rp.setText(item.getAmountRp().toString());
        return convertView;
    }

    private static class ViewHolder {
        public TextView sta_name;
        public TextView gas_type;
        public TextView created_date;
        public TextView amount_rp;
    }

}
