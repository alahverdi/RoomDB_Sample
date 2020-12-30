package ir.allahverdi.roomexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ir.allahverdi.roomexample.R;
import ir.allahverdi.roomexample.entity.User;

public class AdapterListview extends BaseAdapter {

    private Context context;
    private ArrayList<User> list;

    public AdapterListview(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listview_items, null);
        }

        User user = this.list.get(position);

        TextView tv_id = view.findViewById(R.id.tv_id);
        TextView tv_firstName = view.findViewById(R.id.tv_firstName);
        TextView tv_lastName = view.findViewById(R.id.tv_lastName);
        TextView tv_email = view.findViewById(R.id.tv_email);
        TextView tv_phoneNumber = view.findViewById(R.id.tv_phoneNumber);

        tv_id.setText(String.valueOf(user.getId()));
        tv_firstName.setText(String.valueOf(user.getFirstName()));
        tv_lastName.setText(String.valueOf(user.getLastName()));
        tv_email.setText(String.valueOf(user.getEmail()));
        tv_phoneNumber.setText(String.valueOf(user.getPhoneNumber()));

        return view;
    }
}
