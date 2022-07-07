package com.cashFlowAuditor.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.cashFlowAuditor.Models.Stock;
import com.cashFlowAuditor.R;

import java.util.List;

import io.realm.Realm;

public class StockAdapter extends BaseAdapter {

    private Context context;
    private List<Stock> stockList;
    private int layout;
    private Realm realm;

    public StockAdapter(Context _context, List<Stock> _stockList, int _layout){
        context = _context;
        stockList =_stockList;
        layout = _layout;
        realm = Realm.getDefaultInstance();
    }

    @Override
    public int getCount() {
        return stockList.size();
    }

    @Override
    public Object getItem(int position) {
        return stockList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return stockList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.Name = convertView.findViewById(R.id.name_text);
            vh.Amount = convertView.findViewById(R.id.amount_text);
            vh.Value = convertView.findViewById(R.id.value_text);
            vh.Delete = convertView.findViewById(R.id.delete_stock);
            convertView.setTag(vh);
        }
        else {
            vh = (ViewHolder) convertView.getTag();
        }

        final Stock stock = stockList.get(position);
        vh.Name.setText(stock.getName());
        vh.Amount.setText(Integer.toString(stock.getAmount()));
        vh.Value.setText(Integer.toString(stock.getValue()));

        vh.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                stock.deleteFromRealm();
                realm.commitTransaction();

            }
        });

        return convertView;
    }

    static class ViewHolder{
        private TextView Name;
        private TextView Amount;
        private TextView Value;
        private Button Delete;
    }
}
