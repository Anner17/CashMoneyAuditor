package com.cashFlowAuditor.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.cashFlowAuditor.Models.Business;
import com.cashFlowAuditor.R;

import java.util.List;

import io.realm.Realm;

public class BusinessAdapter extends BaseAdapter {
    private Context context;
    private List<Business> businessList;
    private int layout;
    private Realm realm;

    public BusinessAdapter(Context _context, List<Business> _businessList, int _layout){
        context = _context;
        businessList = _businessList;
        layout = _layout;
        realm = Realm.getDefaultInstance();
    }

    @Override
    public int getCount() {
        return businessList.size();
    }

    @Override
    public Object getItem(int position) {
        return businessList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return businessList.get(position).getId();
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

        final Business business = businessList.get(position);
        vh.Name.setText(business.getName());
        vh.Amount.setText(Integer.toString(business.getCost()));
        vh.Value.setText(Integer.toString(business.getDownPay()));

        vh.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                business.deleteFromRealm();
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
