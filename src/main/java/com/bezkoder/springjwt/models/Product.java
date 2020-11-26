package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "barang")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nama")
    private String nama;
    @Column(name = "kategori")
    private  String kategori;
    @Column(name = "harga")
    private String harga;
    @Column(name = "gambar")
    private String gambar;

    public Product() {

    }

    public Product(String nama, String kategori, String harga, String gambar) {
        super();


        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.gambar = gambar;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getGambar() { return gambar; }

    public void setGambar(String gambar) { this.gambar = gambar; }
}
