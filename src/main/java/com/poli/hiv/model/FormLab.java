package com.poli.hiv.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "form_lab")
public class FormLab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "tanggal_lahir")
    private Date tanggalLahir;
    @Column(name = "nomor_registrasi")
    private String nomorRegistrasi;
    @Column(name = "tanggal_pemeriksaan")
    private Date tanggalPemeriksaan;
    @Column(name = "alamat")
    private String alamat;


    @Column(name = "hematologi_darah_lengkap")
    private String hematologiDarahLengkap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getNomorRegistrasi() {
        return nomorRegistrasi;
    }

    public void setNomorRegistrasi(String nomorRegistrasi) {
        this.nomorRegistrasi = nomorRegistrasi;
    }

    public Date getTanggalPemeriksaan() {
        return tanggalPemeriksaan;
    }

    public void setTanggalPemeriksaan(Date tanggalPemeriksaan) {
        this.tanggalPemeriksaan = tanggalPemeriksaan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getHematologiDarahLengkap() {
        return hematologiDarahLengkap;
    }

    public void setHematologiDarahLengkap(String hematologiDarahLengkap) {
        this.hematologiDarahLengkap = hematologiDarahLengkap;
    }
}
