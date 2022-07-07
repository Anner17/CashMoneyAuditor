package com.cashFlowAuditor.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cashFlowAuditor.Models.Description;
import com.cashFlowAuditor.R;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private List<Description> descriptions;
    private int layout;

    public ListAdapter(Context context, List<Description> descriptions, int layout){
        this.context = context;
        this.descriptions = descriptions;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return descriptions.size();
    }

    @Override
    public Object getItem(int position) {
        return descriptions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.descriptionText = convertView.findViewById(R.id.description_text);
            viewHolder.valueText = convertView.findViewById(R.id.value_text);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Description description = descriptions.get(position);
        viewHolder.descriptionText.setText(description.description);
        viewHolder.valueText.setText(Integer.toString(description.value));

        if(description.isBold()){
            viewHolder.descriptionText.setTypeface(null, Typeface.BOLD);
            viewHolder.valueText.setTypeface(null, Typeface.BOLD);
        }

        return convertView;
    }

    static class ViewHolder{
        private TextView descriptionText;
        private TextView valueText;
    }
}
