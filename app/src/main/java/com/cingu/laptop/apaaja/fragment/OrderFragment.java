package com.cingu.laptop.apaaja.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.cingu.laptop.apaaja.R;
import com.cingu.laptop.apaaja.adapter.RvAdapterMenu;
import com.cingu.laptop.apaaja.adapter.RvAdapterOrder;
import com.cingu.laptop.apaaja.dao.OrderDAO;
import com.cingu.laptop.apaaja.model.Response;
import com.cingu.laptop.apaaja.model.UserOrder;
import com.cingu.laptop.apaaja.room.AppDatabase;


public class OrderFragment extends Fragment {

    List<UserOrder> list = new ArrayList<UserOrder>();
    int total_hrg;
    TextView tv_total;
    private RecyclerView rv;
    private RvAdapterOrder rvAdapterOrder;
    OrderDAO orderDAO;

    public OrderFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order, container, false);

        rvAdapterOrder = new RvAdapterOrder(getActivity());

        findView(v);
        initView();

        tv_total.setText("Total Harga: "+total_hrg);
        return v;
    }

    private void findView(View v) {
        rv = v.findViewById(R.id.rv_order);
        tv_total = v.findViewById(R.id.tv_total);
    }


    private void initView() {
        orderDAO = AppDatabase.db(getContext()).orderDAO();

        rv.setHasFixedSize(true);
        rv.setAdapter(rvAdapterOrder);

        list = orderDAO.selectAll();

        rvAdapterOrder.setData(list);
        rvAdapterOrder.notifyDataSetChanged();

        for(int i=0; i < list.size();i++){
            total_hrg += list.get(i).getHarga();
        }
    }
    
}
