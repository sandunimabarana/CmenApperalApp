package com.example.cmenapperalapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ApperalListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Apperal> apperalList;

    public ApperalListAdapter(Context context, int layout, ArrayList<Apperal> apperalList) {
        this.context = context;
        this.layout = layout;
        this.apperalList = apperalList;
    }

    @Override
    public int getCount() {
        return apperalList.size();
    }

    @Override
    public Object getItem(int position) {
        return apperalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtPrice;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtPrice = (TextView) row.findViewById(R.id.txtPrice);
            holder.imageView = (ImageView) row.findViewById(R.id.imgApperal);
            row.setTag(holder);
        }else{
            holder = (ViewHolder) row.getTag();
        }
            Apperal apperal = apperalList.get(position);

            holder.txtName.setText(apperal.getName());
            holder.txtPrice.setText(apperal.getPrice());

            byte[] apperalImage = apperal.getImage();
            Bitmap bitmap = BitmapFactory.decodeByteArray(apperalImage, 0, apperalImage.length);
            holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
