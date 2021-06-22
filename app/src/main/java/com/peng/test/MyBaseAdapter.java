package com.peng.test;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyBaseAdapter extends BaseAdapter {

    private Context myContext;
    private List<ResolveInfo> MyAppList;
    private PackageManager myPackageManager;



    MyBaseAdapter(Context c, List<ResolveInfo> l ,PackageManager m){
        myContext = c;
        MyAppList = l;
        myPackageManager = m;
    }



    @Override
    public int getCount() {
        return MyAppList.size();
    }

    @Override
    public Object getItem(int position) {
        return MyAppList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater)myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item,parent,false);
        }

        ImageView image = convertView.findViewById(R.id.image);
        TextView text = convertView.findViewById(R.id.app_name);
        ResolveInfo resolveInfo = MyAppList.get(position);
        image.setImageDrawable(resolveInfo.loadIcon(myPackageManager));
        text.setText(resolveInfo.loadLabel(myPackageManager));
        return convertView;

    }

}