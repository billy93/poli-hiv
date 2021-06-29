package com.poli.hiv.model;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "umur_anak_terakhir")
    private String umurAnakTerakhir;
    @Column(name = "tanggal_lahir")
    private Date tanggalLahir;
    @Column(name = "jumlah_anak")
    private String jumlahAnak;

    // jika wanita
    @Column(name = "pasangan_tetap")
    private String pasanganTetap;

    // jika pria
    @Column(name = "pasangan_wanita")
    private String pasanganWanita;
    @Column(name = "pasangan_hamil")
    private String pasanganHamil;
    @Column(name = "tanggal_lahir_pasangan")
    private Date tanggalLahirPasangan;
    @Column(name = "status_pasangan")
    private String statusPasangan;
    @Column(name = "tanggal_tes_terakhir_pasangan")
    private Date tanggalTesTerakhirPasangan;
    // end data klien

    // populasi khusus
    @Column(name = "populasi_khusus")
    private String populasiKhusus;
    // end populasi khusus

    // konseling pra test
    @Column(name = "tanggal_konseling")
    private Date tanggalKonseling;
    @Column(name = "status_klien")
    private String statusKlien;
    @Column(name = "alasan_tes")
    private String alasanTes;
    @Column(name = "tahu_dari")
    private String tahuDari;
    @Column(name = "hub_seks_resiko")
    private String hubSeksResiko;
    @Column(name = "kapan_hub_seks_resiko")
    private Date kapanHubSeksResiko;
    @Column(name = "anal_seks_resiko")
    private String analSeksResiko;
    @Column(name = "kapan_anal_seks_resiko")
    private Date kapanAnalSeksResiko;
    @Column(name = "transfusi_darah")
    private String transfusiDarah;
    @Column(name = "kapan_transfusi_darah")
    private Date kapanTransfusiDarah;
    @Column(name = "transmisi_ibu_anak")
    private String transmisiIbuAnak;
    @Column(name = "kapan_transmisi_ibu_anak")
    private Date kapanTransmisiIbuAnak;
    @Column(name = "lainnya")
    private String lainnya;
    @Column(name = "kapan_lainnya")
    private Date kapanLainnya;
    @Column(name = "periode_jendela")
    private String periodeJendela;
    @Column(name = "kapan_periode_jendela")
    private Date kapanPeriodeJendela;
    @Column(name = "kesediaan_tes")
    private String kesediaanTes;

    @Column(name = "pernah_tes_kts")
    private String pernahTesKts;
    @Column(name = "pernah_tes_dimana_kts")
    private String pernahTesDimanaKts;
    @Column(name = "pernah_tes_kapan_kts")
    private Date pernahTesKapanKts;
    @Column(name = "hasil_tes_kts")
    private String hasilTesKts;

    // end konseling pra test

    // pemberian informasi
    @Column(name = "tanggal_pemberian_informasi")
    private Date tanggalPemberianInformasi;
    @Column(name = "pernah_tes_tipk")
    private String pernahTesTipk;
    @Column(name = "pernah_tes_dimana_tipk")
    private String pernahTesDimanaTipk;
    @Column(name = "pernah_tes_kapan_tipk")
    private Date pernahTesKapanTipk;
    @Column(name = "hasil_tes_tipk")
    private String hasilTesTipk;

    @Column(name = "penyakit_terkait_pasien_tipk")
    private String penyakiTerkaitPasienTipk;
    @Column(name = "kesediaan_tes_tipk")
    private String kesediaanTesTipk;
    // end pemberian informasi

    // tes antibodi hiv
    @Column(name = "tanggal_tes_hiv")
    private Date tanggalTesHiv;

    @Column(name = "jenis_tes_hiv_rapid")
    private String jenisTesHivRapid;
    @Column(name = "jenis_tes_hiv_elisa")
    private String jenisTesHivElisa;

    @Column(name = "hasil_tes_r1")
    private String hasilTesR1;
    @Column(name = "hasil_tes_r1_reagen")
    private String hasilTesR1Reagen;
    @Column(name = "hasil_tes_r2")
    private String hasilTesR2;
    @Column(name = "hasil_tes_r2_reagen")
    private String hasilTesR2Reagen;
    @Column(name = "hasil_tes_r3")
    private String hasilTesR3;
    @Column(name = "hasil_tes_r3_reagen")
    private String hasilTesR3Reagen;
    @Column(name = "kesimpulan_hasil")
    private String kesimpulanHasil;
    @Column(name = "nomor_registrasi_nasional_pdp")
    private String nomorRegistrasiNasionalPdp;
    @Column(name = "tanggal_masuk_pdp")
    private Date tanggalMasukPdp;

    @Column(name = "tindak_lanjut")
    private String tindakLanjut;
    @Column(name = "rujuk_konseling")
    private String rujukKonseling;
    @Column(name = "rujuk_ke")
    private String rujukKe;
    @Column(name = "rujuk_ke_pdp_dan_ppia")
    private String rujukKePdpDanPpia;


    @Column(name = "status_hiv_pasangan")
    private String statusHivPasangan;
    // end tes antibodi hiv

    // konseling pasca test
    @Column(name = "tanggal_konseling_pasca_tes")
    private Date tanggalKonselingPascaTes;
    @Column(name = "terima_hasil")
    private String terimaHasil;
    @Column(name = "kaji_gejala_tb")
    private String kajiGejalaTb;
    @Column(name = "jumlah_kondom")
    private String jumlahKondom;

    @Column(name = "tindak_lanjut_pasca_tes")
    private String tindakLanjutPascaTes;
    @Column(name = "tindak_lanjut_lainnya")
    private String tindakLanjutLainnya;
    @Column(name = "nama_konselor")
    private String namaKonselor;
    @Column(name = "status_layanan")
    private String statusLayanan;
    @Column(name = "jenis_pelayanan")
    private String jenisPelayanan;
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

    public String getUmurAnakTerakhir() {
        return umurAnakTerakhir;
    }

    public void setUmurAnakTerakhir(String umurAnakTerakhir) {
        this.umurAnakTerakhir = umurAnakTerakhir;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJumlahAnak() {
        return jumlahAnak;
    }

    public void setJumlahAnak(String jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public String getPasanganTetap() {
        return pasanganTetap;
    }

    public void setPasanganTetap(String pasanganTetap) {
        this.pasanganTetap = pasanganTetap;
    }

    public String getPasanganWanita() {
        return pasanganWanita;
    }

    public void setPasanganWanita(String pasanganWanita) {
        this.pasanganWanita = pasanganWanita;
    }

    public String getPasanganHamil() {
        return pasanganHamil;
    }

    public void setPasanganHamil(String pasanganHamil) {
        this.pasanganHamil = pasanganHamil;
    }

    public Date getTanggalLahirPasangan() {
        return tanggalLahirPasangan;
    }

    public void setTanggalLahirPasangan(Date tanggalLahirPasangan) {
        this.tanggalLahirPasangan = tanggalLahirPasangan;
    }

    public String getStatusPasangan() {
        return statusPasangan;
    }

    public void setStatusPasangan(String statusPasangan) {
        this.statusPasangan = statusPasangan;
    }

    public Date getTanggalTesTerakhirPasangan() {
        return tanggalTesTerakhirPasangan;
    }

    public void setTanggalTesTerakhirPasangan(Date tanggalTesTerakhirPasangan) {
        this.tanggalTesTerakhirPasangan = tanggalTesTerakhirPasangan;
    }

    public Date getTanggalKonseling() {
        return tanggalKonseling;
    }

    public void setTanggalKonseling(Date tanggalKonseling) {
        this.tanggalKonseling = tanggalKonseling;
    }

    public String getStatusKlien() {
        return statusKlien;
    }

    public void setStatusKlien(String statusKlien) {
        this.statusKlien = statusKlien;
    }

    public String getAlasanTes() {
        return alasanTes;
    }

    public void setAlasanTes(String alasanTes) {
        this.alasanTes = alasanTes;
    }

    public String getTahuDari() {
        return tahuDari;
    }

    public void setTahuDari(String tahuDari) {
        this.tahuDari = tahuDari;
    }

    public String getHubSeksResiko() {
        return hubSeksResiko;
    }

    public void setHubSeksResiko(String hubSeksResiko) {
        this.hubSeksResiko = hubSeksResiko;
    }

    public Date getKapanHubSeksResiko() {
        return kapanHubSeksResiko;
    }

    public void setKapanHubSeksResiko(Date kapanHubSeksResiko) {
        this.kapanHubSeksResiko = kapanHubSeksResiko;
    }

    public String getAnalSeksResiko() {
        return analSeksResiko;
    }

    public void setAnalSeksResiko(String analSeksResiko) {
        this.analSeksResiko = analSeksResiko;
    }

    public Date getKapanAnalSeksResiko() {
        return kapanAnalSeksResiko;
    }

    public void setKapanAnalSeksResiko(Date kapanAnalSeksResiko) {
        this.kapanAnalSeksResiko = kapanAnalSeksResiko;
    }

    public String getTransfusiDarah() {
        return transfusiDarah;
    }

    public void setTransfusiDarah(String transfusiDarah) {
        this.transfusiDarah = transfusiDarah;
    }

    public Date getKapanTransfusiDarah() {
        return kapanTransfusiDarah;
    }

    public void setKapanTransfusiDarah(Date kapanTransfusiDarah) {
        this.kapanTransfusiDarah = kapanTransfusiDarah;
    }

    public String getTransmisiIbuAnak() {
        return transmisiIbuAnak;
    }

    public void setTransmisiIbuAnak(String transmisiIbuAnak) {
        this.transmisiIbuAnak = transmisiIbuAnak;
    }

    public Date getKapanTransmisiIbuAnak() {
        return kapanTransmisiIbuAnak;
    }

    public void setKapanTransmisiIbuAnak(Date kapanTransmisiIbuAnak) {
        this.kapanTransmisiIbuAnak = kapanTransmisiIbuAnak;
    }

    public String getLainnya() {
        return lainnya;
    }

    public void setLainnya(String lainnya) {
        this.lainnya = lainnya;
    }

    public Date getKapanLainnya() {
        return kapanLainnya;
    }

    public void setKapanLainnya(Date kapanLainnya) {
        this.kapanLainnya = kapanLainnya;
    }

    public String getPeriodeJendela() {
        return periodeJendela;
    }

    public void setPeriodeJendela(String periodeJendela) {
        this.periodeJendela = periodeJendela;
    }

    public Date getKapanPeriodeJendela() {
        return kapanPeriodeJendela;
    }

    public void setKapanPeriodeJendela(Date kapanPeriodeJendela) {
        this.kapanPeriodeJendela = kapanPeriodeJendela;
    }

    public String getKesediaanTes() {
        return kesediaanTes;
    }

    public void setKesediaanTes(String kesediaanTes) {
        this.kesediaanTes = kesediaanTes;
    }

    public String getPernahTesKts() {
        return pernahTesKts;
    }

    public void setPernahTesKts(String pernahTesKts) {
        this.pernahTesKts = pernahTesKts;
    }

    public String getPernahTesDimanaKts() {
        return pernahTesDimanaKts;
    }

    public void setPernahTesDimanaKts(String pernahTesDimanaKts) {
        this.pernahTesDimanaKts = pernahTesDimanaKts;
    }

    public Date getPernahTesKapanKts() {
        return pernahTesKapanKts;
    }

    public void setPernahTesKapanKts(Date pernahTesKapanKts) {
        this.pernahTesKapanKts = pernahTesKapanKts;
    }

    public String getHasilTesKts() {
        return hasilTesKts;
    }

    public void setHasilTesKts(String hasilTesKts) {
        this.hasilTesKts = hasilTesKts;
    }

    public Date getTanggalPemberianInformasi() {
        return tanggalPemberianInformasi;
    }

    public void setTanggalPemberianInformasi(Date tanggalPemberianInformasi) {
        this.tanggalPemberianInformasi = tanggalPemberianInformasi;
    }

    public String getPernahTesTipk() {
        return pernahTesTipk;
    }

    public void setPernahTesTipk(String pernahTesTipk) {
        this.pernahTesTipk = pernahTesTipk;
    }

    public String getPernahTesDimanaTipk() {
        return pernahTesDimanaTipk;
    }

    public void setPernahTesDimanaTipk(String pernahTesDimanaTipk) {
        this.pernahTesDimanaTipk = pernahTesDimanaTipk;
    }

    public Date getPernahTesKapanTipk() {
        return pernahTesKapanTipk;
    }

    public void setPernahTesKapanTipk(Date pernahTesKapanTipk) {
        this.pernahTesKapanTipk = pernahTesKapanTipk;
    }

    public String getHasilTesTipk() {
        return hasilTesTipk;
    }

    public void setHasilTesTipk(String hasilTesTipk) {
        this.hasilTesTipk = hasilTesTipk;
    }

    public String getPenyakiTerkaitPasienTipk() {
        return penyakiTerkaitPasienTipk;
    }

    public void setPenyakiTerkaitPasienTipk(String penyakiTerkaitPasienTipk) {
        this.penyakiTerkaitPasienTipk = penyakiTerkaitPasienTipk;
    }

    public String getKesediaanTesTipk() {
        return kesediaanTesTipk;
    }

    public void setKesediaanTesTipk(String kesediaanTesTipk) {
        this.kesediaanTesTipk = kesediaanTesTipk;
    }

    public Date getTanggalTesHiv() {
        return tanggalTesHiv;
    }

    public void setTanggalTesHiv(Date tanggalTesHiv) {
        this.tanggalTesHiv = tanggalTesHiv;
    }

    public String getJenisTesHivRapid() {
        return jenisTesHivRapid;
    }

    public void setJenisTesHivRapid(String jenisTesHivRapid) {
        this.jenisTesHivRapid = jenisTesHivRapid;
    }

    public String getJenisTesHivElisa() {
        return jenisTesHivElisa;
    }

    public void setJenisTesHivElisa(String jenisTesHivElisa) {
        this.jenisTesHivElisa = jenisTesHivElisa;
    }

    public String getHasilTesR1() {
        return hasilTesR1;
    }

    public void setHasilTesR1(String hasilTesR1) {
        this.hasilTesR1 = hasilTesR1;
    }

    public String getHasilTesR1Reagen() {
        return hasilTesR1Reagen;
    }

    public void setHasilTesR1Reagen(String hasilTesR1Reagen) {
        this.hasilTesR1Reagen = hasilTesR1Reagen;
    }

    public String getHasilTesR2() {
        return hasilTesR2;
    }

    public void setHasilTesR2(String hasilTesR2) {
        this.hasilTesR2 = hasilTesR2;
    }

    public String getHasilTesR2Reagen() {
        return hasilTesR2Reagen;
    }

    public void setHasilTesR2Reagen(String hasilTesR2Reagen) {
        this.hasilTesR2Reagen = hasilTesR2Reagen;
    }

    public String getHasilTesR3() {
        return hasilTesR3;
    }

    public void setHasilTesR3(String hasilTesR3) {
        this.hasilTesR3 = hasilTesR3;
    }

    public String getHasilTesR3Reagen() {
        return hasilTesR3Reagen;
    }

    public void setHasilTesR3Reagen(String hasilTesR3Reagen) {
        this.hasilTesR3Reagen = hasilTesR3Reagen;
    }

    public String getKesimpulanHasil() {
        return kesimpulanHasil;
    }

    public void setKesimpulanHasil(String kesimpulanHasil) {
        this.kesimpulanHasil = kesimpulanHasil;
    }

    public String getNomorRegistrasiNasionalPdp() {
        return nomorRegistrasiNasionalPdp;
    }

    public void setNomorRegistrasiNasionalPdp(String nomorRegistrasiNasionalPdp) {
        this.nomorRegistrasiNasionalPdp = nomorRegistrasiNasionalPdp;
    }

    public Date getTanggalMasukPdp() {
        return tanggalMasukPdp;
    }

    public void setTanggalMasukPdp(Date tanggalMasukPdp) {
        this.tanggalMasukPdp = tanggalMasukPdp;
    }

    public String getTindakLanjut() {
        return tindakLanjut;
    }

    public void setTindakLanjut(String tindakLanjut) {
        this.tindakLanjut = tindakLanjut;
    }

    public String getRujukKonseling() {
        return rujukKonseling;
    }

    public void setRujukKonseling(String rujukKonseling) {
        this.rujukKonseling = rujukKonseling;
    }

    public String getRujukKe() {
        return rujukKe;
    }

    public void setRujukKe(String rujukKe) {
        this.rujukKe = rujukKe;
    }

    public String getRujukKePdpDanPpia() {
        return rujukKePdpDanPpia;
    }

    public void setRujukKePdpDanPpia(String rujukKePdpDanPpia) {
        this.rujukKePdpDanPpia = rujukKePdpDanPpia;
    }

    public String getStatusHivPasangan() {
        return statusHivPasangan;
    }

    public void setStatusHivPasangan(String statusHivPasangan) {
        this.statusHivPasangan = statusHivPasangan;
    }

    public Date getTanggalKonselingPascaTes() {
        return tanggalKonselingPascaTes;
    }

    public void setTanggalKonselingPascaTes(Date tanggalKonselingPascaTes) {
        this.tanggalKonselingPascaTes = tanggalKonselingPascaTes;
    }

    public String getTerimaHasil() {
        return terimaHasil;
    }

    public void setTerimaHasil(String terimaHasil) {
        this.terimaHasil = terimaHasil;
    }

    public String getKajiGejalaTb() {
        return kajiGejalaTb;
    }

    public void setKajiGejalaTb(String kajiGejalaTb) {
        this.kajiGejalaTb = kajiGejalaTb;
    }

    public String getJumlahKondom() {
        return jumlahKondom;
    }

    public void setJumlahKondom(String jumlahKondom) {
        this.jumlahKondom = jumlahKondom;
    }

    public String getTindakLanjutPascaTes() {
        return tindakLanjutPascaTes;
    }

    public void setTindakLanjutPascaTes(String tindakLanjutPascaTes) {
        this.tindakLanjutPascaTes = tindakLanjutPascaTes;
    }

    public String getTindakLanjutLainnya() {
        return tindakLanjutLainnya;
    }

    public void setTindakLanjutLainnya(String tindakLanjutLainnya) {
        this.tindakLanjutLainnya = tindakLanjutLainnya;
    }

    public String getNamaKonselor() {
        return namaKonselor;
    }

    public void setNamaKonselor(String namaKonselor) {
        this.namaKonselor = namaKonselor;
    }

    public String getStatusLayanan() {
        return statusLayanan;
    }

    public void setStatusLayanan(String statusLayanan) {
        this.statusLayanan = statusLayanan;
    }

    public String getJenisPelayanan() {
        return jenisPelayanan;
    }

    public void setJenisPelayanan(String jenisPelayanan) {
        this.jenisPelayanan = jenisPelayanan;
    }
}

