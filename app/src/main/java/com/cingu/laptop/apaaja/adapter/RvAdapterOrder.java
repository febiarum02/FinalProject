package com.cingu.laptop.apaaja.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cingu.laptop.apaaja.R;
import com.cingu.laptop.apaaja.dao.OrderDAO;
import com.cingu.laptop.apaaja.model.KategoriItem;
import com.cingu.laptop.apaaja.model.UserOrder;
import com.cingu.laptop.apaaja.room.AppDatabase;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RvAdapterOrder extends RecyclerView.Adapter<RvAdapterOrder.MyViewHolder> {

    private Context context;
    private List<UserOrder> list = new ArrayList<>();
    private OrderDAO orderDAO;


    public RvAdapterOrder(Context context) {
        this.context = context;
        orderDAO = AppDatabase.db(context).orderDAO();
    }

    public void setData(List<UserOrder> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.order, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UserOrder userOrder = list.get(position);
        holder.bind(userOrder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private UserOrder userOrder;
        int position;
        private ImageView iv_foto_menu;
        private TextView tv_nama_menu;
        private TextView tv_harga_menu;
        private TextView tv_order;
        Button bt_delete;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_foto_menu = itemView.findViewById(R.id.iv_foto_menu);
            tv_nama_menu = itemView.findViewById(R.id.tv_nama_menu);
            tv_harga_menu = itemView.findViewById(R.id.tv_harga_menu);
            tv_order = itemView.findViewById(R.id.user_order);
            bt_delete = itemView.findViewById(R.id.dlt_order);
        }

        void bind(UserOrder userOrder, int position) {
            this.userOrder = userOrder;
            this.position = position;
            initView();
        }

        private void initView() {

            Glide.with(context).load(userOrder.getGambar()).into(iv_foto_menu);

            if (userOrder.getMakanan()!=null){
                tv_nama_menu.setText(userOrder.getMakanan());
            }else{
                tv_nama_menu.setText(userOrder.getMinuman());
            }
            tv_harga_menu.setText(String.valueOf(userOrder.getHarga()));
            tv_order.setText(String.valueOf(userOrder.getJumlah()));

            bt_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    orderDAO.delete(userOrder);
                    list.remove(position);
                    notifyDataSetChanged();
                    Toast.makeText(context, userOrder.getMakanan() + ", " + userOrder.getMinuman() + " Dihapus", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
