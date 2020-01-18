package com.cingu.laptop.apaaja.model;

import com.google.gson.annotations.SerializedName;

public class KategoriItem{

	@SerializedName("harga")
	private int harga;

	@SerializedName("gambar")
	private String gambar;

	@SerializedName("minuman")
	private String minuman;

	@SerializedName("makanan")
	private String makanan;

	public void setHarga(int harga){
		this.harga = harga;
	}

	public int getHarga(){
		return harga;
	}

	public void setGambar(String gambar){
		this.gambar = gambar;
	}

	public String getGambar(){
		return gambar;
	}

	public void setMinuman(String minuman){
		this.minuman = minuman;
	}

	public String getMinuman(){
		return minuman;
	}

	public void setMakanan(String makanan){
		this.makanan = makanan;
	}

	public String getMakanan(){
		return makanan;
	}

	@Override
 	public String toString(){
		return 
			"KategoriItem{" + 
			"harga = '" + harga + '\'' + 
			",gambar = '" + gambar + '\'' + 
			",minuman = '" + minuman + '\'' + 
			",makanan = '" + makanan + '\'' + 
			"}";
		}
}