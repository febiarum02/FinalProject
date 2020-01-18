package com.cingu.laptop.apaaja.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("kategori")
	private List<KategoriItem> kategori;

	public void setKategori(List<KategoriItem> kategori){
		this.kategori = kategori;
	}

	public List<KategoriItem> getKategori(){
		return kategori;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"kategori = '" + kategori + '\'' + 
			"}";
		}
}