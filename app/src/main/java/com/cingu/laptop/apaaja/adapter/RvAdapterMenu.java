package com.cingu.laptop.apaaja.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cingu.laptop.apaaja.R;
import com.cingu.laptop.apaaja.activity.HomeActivity;
import com.cingu.laptop.apaaja.dao.OrderDAO;
import com.cingu.laptop.apaaja.model.KategoriItem;
import com.cingu.laptop.apaaja.model.UserOrder;
import com.cingu.laptop.apaaja.room.AppDatabase;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class RvAdapterMenu extends RecyclerView.Adapter<RvAdapterMenu.MyViewHolder> {

    private Context context;
    private List<KategoriItem> list = new ArrayList<>();
    private OrderDAO orderDAO;


    public RvAdapterMenu(Context context) {
        this.context = context;
        orderDAO = AppDatabase.db(context).orderDAO();
    }

    public void setData(List<KategoriItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        KategoriItem kategoriItem = list.get(position);
        holder.bind(kategoriItem, orderDAO);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private KategoriItem kategoriItem;
        private ImageView iv_foto_menu;
        private TextView tv_nama_menu;
        private TextView tv_harga_menu;
        private Button btnOrder;
        private OrderDAO orderDAO;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_foto_menu = itemView.findViewById(R.id.iv_foto_menu);
            tv_nama_menu = itemView.findViewById(R.id.tv_nama_menu);
            tv_harga_menu = itemView.findViewById(R.id.tv_harga_menu);
            btnOrder = itemView.findViewById(R.id.btn_order);
        }

        void bind(KategoriItem kategoriItem, OrderDAO orderDAO) {
            this.kategoriItem = kategoriItem;
            this.orderDAO = orderDAO;
            initView();
        }

        private void initView() {

            Glide
                    .with(context)
                    .load(kategoriItem.getGambar())
                    .into(iv_foto_menu);


            if (kategoriItem.getMakanan()!=null){
                tv_nama_menu.setText(kategoriItem.getMakanan());
            }else{
                tv_nama_menu.setText(kategoriItem.getMinuman());
            }
            tv_harga_menu.setText(String.valueOf(kategoriItem.getHarga()));

            btnOrder.setOnClickListener(v -> {

                UserOrder userOrder = new UserOrder();

                userOrder.setHarga(kategoriItem.getHarga());
                userOrder.setGambar(kategoriItem.getGambar());
                userOrder.setJumlah(1);
                userOrder.setMakanan(kategoriItem.getMakanan());
                userOrder.setMinuman(kategoriItem.getMinuman());

                orderDAO.insert(userOrder);
//                context.startActivity(new Intent(context, Order.class))

                Toast.makeText(context, "berhasil order", Toast.LENGTH_SHORT).show();
            });
        }
    }
}