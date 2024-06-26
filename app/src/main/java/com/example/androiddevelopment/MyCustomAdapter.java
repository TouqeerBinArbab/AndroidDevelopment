package com.example.androiddevelopment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyCustomAdapter extends BaseAdapter {
    private Context context;
    private String[] items;
    public MyCustomAdapter(Context context, String[] items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length; // Returns count the data items
    }

    @Override
    public Object getItem(int position) {
        return items[position]; // Returns the data item at the given position
    }

    @Override
    public long getItemId(int position) {
        return position; // Returns a unique Identifier for the item at given position
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // Reusing the View (that's recycled)
        if(convertView == null) {
            // convertView : is a recycler view that you can reuse to
            //               improve the performance of your list.
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.my_list_item, parent, false);

            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.textView1);
            convertView.setTag(holder);
        } else {
         // Reusing the view (That's recycled);
            holder = (ViewHolder) convertView.getTag();
        }
        // Set the data to the view
        holder.textView.setText(items[position]);

        // Binding data to view within the convertView
        return convertView; // Displays the data at a position in the data set
    }
    static  class ViewHolder {
        //  references to the views within an item layout.
        TextView textView;
    }
}