package com.poli.hiv.model;

import javax.persistence.*;

@Entity
@Table(name = "poli_hiv")
public class PoliHIV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "no_rekam_medis")
    private String noRekamMedis;

    @Column(name = "no_register")
    private String noRegister;

    @Column(name = "nik")
    private String nik;

    // data klien
    @Column(name = "nama")
    private String nama;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "provinsi")
    private String provinsi;

    @Column(name = "kab_kota")
    private String kabKota;

    @Column(name = "ibu_kandung")
    private String ibuKandung;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

    @Column(name = "status_perkawinan")
    private String statusPerkawinan;

    @Column(name = "status_kehamilan")
    private String statusKehamilan;

    @Column(name = "pendidikan_terakhir")
    private String pendidikanTerakhir;

    @Column(name = "pekerjaan")
    private String pekerjaan;

    @Column(name = "jenis_pekerjaan")
    private String jenisPekerjaan;

    @Column(name = "kelompok_resiko")
    private String kelompokResiko;

    @Column(name = "lama_resiko")
    private String lamaResiko;

    @Column(name = "status_kunjungan")
    private String statusKunjungan;

    @Column(name = "status_rujukan")
    private String statusRujukan;
    // end data klien

    // populasi khusus
    @Column(name = "populasi_khusus")
    private String populasiKhusus;
    // end populasi khusus

    // konseling pra test
    // end konseling pra test

    // pemberian informasi
    // end pemberian informasi

    // tes antibodi hiv
    // end tes antibodi hiv

    // konseling pasca test
    // end konseling pasca test


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoRekamMedis() {
        return noRekamMedis;
    }

    public void setNoRekamMedis(String noRekamMedis) {
        this.noRekamMedis = noRekamMedis;
    }

    public String getNoRegister() {
        return noRegister;
    }

    public void setNoRegister(String noRegister) {
        this.noRegister = noRegister;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKabKota() {
        return kabKota;
    }

    public void setKabKota(String kabKota) {
        this.kabKota = kabKota;
    }

    public String getIbuKandung() {
        return ibuKandung;
    }

    public void setIbuKandung(String ibuKandung) {
        this.ibuKandung = ibuKandung;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getStatusPerkawinan() {
        return statusPerkawinan;
    }

    public void setStatusPerkawinan(String statusPerkawinan) {
        this.statusPerkawinan = statusPerkawinan;
    }

    public String getStatusKehamilan() {
        return statusKehamilan;
    }

    public void setStatusKehamilan(String statusKehamilan) {
        this.statusKehamilan = statusKehamilan;
    }

    public String getPendidikanTerakhir() {
        return pendidikanTerakhir;
    }

    public void setPendidikanTerakhir(String pendidikanTerakhir) {
        this.pendidikanTerakhir = pendidikanTerakhir;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getKelompokResiko() {
        return kelompokResiko;
    }

    public void setKelompokResiko(String kelompokResiko) {
        this.kelompokResiko = kelompokResiko;
    }

    public String getLamaResiko() {
        return lamaResiko;
    }

    public void setLamaResiko(String lamaResiko) {
        this.lamaResiko = lamaResiko;
    }

    public String getStatusKunjungan() {
        return statusKunjungan;
    }

    public void setStatusKunjungan(String statusKunjungan) {
        this.statusKunjungan = statusKunjungan;
    }

    public String getStatusRujukan() {
        return statusRujukan;
    }

    public void setStatusRujukan(String statusRujukan) {
        this.statusRujukan = statusRujukan;
    }

    public String getPopulasiKhusus() {
        return populasiKhusus;
    }

    public void setPopulasiKhusus(String populasiKhusus) {
        this.populasiKhusus = populasiKhusus;
    }

    public String getJenisPekerjaan() {
        return jenisPekerjaan;
    }

    public void setJenisPekerjaan(String jenisPekerjaan) {
        this.jenisPekerjaan = jenisPekerjaan;
    }
}

