package com.cingu.laptop.apaaja.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserOrder {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "harga")
    private int harga;

    @ColumnInfo(name = "gambar")
    private String gambar;

    @ColumnInfo(name = "minuman")
    private String minuman;

    public UserOrder(int harga, String gambar, String minuman, String makanan, int jumlah) {
        this.harga = harga;
        this.gambar = gambar;
        this.minuman = minuman;
        this.makanan = makanan;
        this.jumlah = jumlah;
    }

    public UserOrder() {
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getMinuman() {
        return minuman;
    }

    public void setMinuman(String minuman) {
        this.minuman = minuman;
    }

    public String getMakanan() {
        return makanan;
    }

    public void setMakanan(String makanan) {
        this.makanan = makanan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    @ColumnInfo(name = "makanan")
    private String makanan;

    @ColumnInfo(name = "jumlah")
    private int jumlah;

}
