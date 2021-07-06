package com.poli.hiv.service;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.poli.hiv.model.FieldData;
import com.poli.hiv.model.FormLab;
import com.poli.hiv.model.PoliHIV;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ExportService {
    @Autowired
    private ResourceLoader resourceLoader;
    private HashMap<String, FieldData> fieldCoordinateHashMap;
    private HashMap<String, FieldData> fieldCoordinateHashMapFormLab;

    public ExportService(){
        setupFieldCoordinateHashMap();
        setupFieldCoordinateHashMapFormLab();
    }

    private void setupFieldCoordinateHashMapFormLab() {
    }

    private void setupFieldCoordinateHashMap() {
        fieldCoordinateHashMap = new HashMap<String, FieldData>();

        FieldData noRekamMedis = new FieldData();
        noRekamMedis.setFontSize(10);
        noRekamMedis.setX(94);
        noRekamMedis.setY(737);
        noRekamMedis.setPage(1);
        fieldCoordinateHashMap.put("noRekamMedis", noRekamMedis);


        FieldData noRegister = new FieldData();
        noRegister.setFontSize(10);
        noRegister.setX(94);
        noRegister.setY(720);
        noRegister.setPage(1);
        fieldCoordinateHashMap.put("noRegister", noRegister);

        FieldData nik = new FieldData();
        nik.setFontSize(10);
        nik.setX(293);
        nik.setY(737);
        nik.setPage(1);
        fieldCoordinateHashMap.put("nik", nik);

        FieldData nama = new FieldData();
        nama.setX(19);
        nama.setY(680);
        nama.setMulti(true);
        nama.setPage(1);
        nama.setFontSize(10);
        fieldCoordinateHashMap.put("nama", nama);

        FieldData alamat = new FieldData();
        alamat.setX(19);
        alamat.setY(656);
        alamat.setMulti(true);
        alamat.setPage(1);
        alamat.setFontSize(10);
        fieldCoordinateHashMap.put("alamat", alamat);

        FieldData propinsi = new FieldData();
        propinsi.setX(21);
        propinsi.setY(632);
        propinsi.setMulti(true);
        propinsi.setPage(1);
        propinsi.setFontSize(10);
        fieldCoordinateHashMap.put("propinsi", propinsi);

        FieldData kabKota = new FieldData();
        kabKota.setX(20);
        kabKota.setY(608);
        kabKota.setMulti(true);
        kabKota.setPage(1);
        kabKota.setFontSize(10);
        fieldCoordinateHashMap.put("kabKota", kabKota);

        FieldData ibuKandung = new FieldData();
        ibuKandung.setX(20);
        ibuKandung.setY(582);
        ibuKandung.setMulti(true);
        ibuKandung.setPage(1);
        ibuKandung.setFontSize(10);
        fieldCoordinateHashMap.put("ibuKandung", ibuKandung);

        FieldData jenisKelamin = new FieldData();
        jenisKelamin.setX(21);
        jenisKelamin.setY(552);
        jenisKelamin.setPage(1);
        jenisKelamin.setFontSize(10);
        jenisKelamin.setType("checkbox");
        fieldCoordinateHashMap.put("jenisKelamin", jenisKelamin);

        FieldData statusPerkawinan = new FieldData();
        statusPerkawinan.setX(21);
        statusPerkawinan.setY(553);
        statusPerkawinan.setPage(1);
        statusPerkawinan.setFontSize(10);
        statusPerkawinan.setType("checkbox");
        fieldCoordinateHashMap.put("statusPerkawinan", statusPerkawinan);

        FieldData statusKehamilan = new FieldData();
        statusKehamilan.setX(21);
        statusKehamilan.setY(529);
        statusKehamilan.setPage(1);
        statusKehamilan.setFontSize(10);
        statusKehamilan.setType("checkbox");
        fieldCoordinateHashMap.put("statusKehamilan", statusKehamilan);

        FieldData pendidikanTerakhir = new FieldData();
        pendidikanTerakhir.setX(19);
        pendidikanTerakhir.setY(506);
        pendidikanTerakhir.setPage(1);
        pendidikanTerakhir.setFontSize(10);
        pendidikanTerakhir.setType("checkbox");
        fieldCoordinateHashMap.put("pendidikanTerakhir", pendidikanTerakhir);

        FieldData umurAnak = new FieldData();
        umurAnak.setX(294);
        umurAnak.setY(530);
        umurAnak.setPage(1);
        umurAnak.setFontSize(10);
        umurAnak.setMulti(true);
        fieldCoordinateHashMap.put("umurAnak", umurAnak);

        FieldData jumlahAnak = new FieldData();
        jumlahAnak.setX(416);
        jumlahAnak.setY(530);
        jumlahAnak.setPage(1);
        jumlahAnak.setFontSize(10);
        jumlahAnak.setMulti(true);
        fieldCoordinateHashMap.put("jumlahAnak", jumlahAnak);

        FieldData pekerjaan = new FieldData();
        pekerjaan.setX(61);
        pekerjaan.setY(479);
        pekerjaan.setPage(1);
        pekerjaan.setFontSize(10);
        pekerjaan.setType("checkbox");
        fieldCoordinateHashMap.put("pekerjaan", pekerjaan);

        FieldData tglLahir = new FieldData();
        tglLahir.setX(61);
        tglLahir.setY(479);
        tglLahir.setPage(1);
        tglLahir.setFontSize(10);
        tglLahir.setMulti(true);
        fieldCoordinateHashMap.put("tglLahir", tglLahir);


        FieldData kelompokResiko = new FieldData();
        kelompokResiko.setX(16);
        kelompokResiko.setY(437);
        kelompokResiko.setPage(1);
        kelompokResiko.setFontSize(10);
        kelompokResiko.setType("checkbox");
        fieldCoordinateHashMap.put("kelompokResiko", kelompokResiko);

        FieldData lamaResiko = new FieldData();
        lamaResiko.setX(52);
        lamaResiko.setY(407);
        lamaResiko.setPage(1);
        lamaResiko.setFontSize(10);
        lamaResiko.setMulti(true);
        fieldCoordinateHashMap.put("lamaResiko", lamaResiko);

        FieldData statusKunjungan = new FieldData();
        statusKunjungan.setX(52);
        statusKunjungan.setY(407);
        statusKunjungan.setPage(1);
        statusKunjungan.setFontSize(10);
        statusKunjungan.setType("checkbox");
        fieldCoordinateHashMap.put("statusKunjungan", statusKunjungan);

        FieldData statusRujukan = new FieldData();
        statusRujukan.setX(52);
        statusRujukan.setY(407);
        statusRujukan.setPage(1);
        statusRujukan.setFontSize(10);
        statusRujukan.setType("checkbox");
        fieldCoordinateHashMap.put("statusRujukan", statusRujukan);

        FieldData pasanganTetap = new FieldData();
        pasanganTetap.setX(367);
        pasanganTetap.setY(468);
        pasanganTetap.setPage(1);
        pasanganTetap.setFontSize(10);
        pasanganTetap.setType("checkbox");
        fieldCoordinateHashMap.put("pasanganTetap", pasanganTetap);

        FieldData pasanganWanita = new FieldData();
        pasanganWanita.setX(367);
        pasanganWanita.setY(468);
        pasanganWanita.setPage(1);
        pasanganWanita.setFontSize(10);
        pasanganWanita.setType("checkbox");
        fieldCoordinateHashMap.put("pasanganWanita", pasanganWanita);

        FieldData pasanganHamil = new FieldData();
        pasanganHamil.setX(367);
        pasanganHamil.setY(468);
        pasanganHamil.setPage(1);
        pasanganHamil.setFontSize(10);
        pasanganHamil.setType("checkbox");
        fieldCoordinateHashMap.put("pasanganHamil", pasanganHamil);

        FieldData tanggalLahirPasangan = new FieldData();
        tanggalLahirPasangan.setX(61);
        tanggalLahirPasangan.setY(479);
        tanggalLahirPasangan.setPage(1);
        tanggalLahirPasangan.setFontSize(10);
        tanggalLahirPasangan.setMulti(true);
        fieldCoordinateHashMap.put("tanggalLahirPasangan", tanggalLahirPasangan);

        FieldData statusPasangan = new FieldData();
        statusPasangan.setX(366);
        statusPasangan.setY(392);
        statusPasangan.setPage(1);
        statusPasangan.setFontSize(10);
        fieldCoordinateHashMap.put("statusPasangan", statusPasangan);

        FieldData tanggalTesTerakhirPasangan = new FieldData();
        tanggalTesTerakhirPasangan.setX(61);
        tanggalTesTerakhirPasangan.setY(479);
        tanggalTesTerakhirPasangan.setPage(1);
        tanggalTesTerakhirPasangan.setFontSize(10);
        tanggalTesTerakhirPasangan.setMulti(true);
        fieldCoordinateHashMap.put("tanggalTesTerakhirPasangan", tanggalTesTerakhirPasangan);

        FieldData populasiKhusus = new FieldData();
        populasiKhusus.setX(21);
        populasiKhusus.setY(553);
        populasiKhusus.setPage(1);
        populasiKhusus.setFontSize(10);
        populasiKhusus.setType("checkbox");
        fieldCoordinateHashMap.put("populasiKhusus", populasiKhusus);

        FieldData tanggalKonseling = new FieldData();
        tanggalKonseling.setX(61);
        tanggalKonseling.setY(479);
        tanggalKonseling.setPage(1);
        tanggalKonseling.setFontSize(10);
        tanggalKonseling.setMulti(true);
        fieldCoordinateHashMap.put("tanggalKonseling", tanggalKonseling);

        FieldData statusKlien = new FieldData();
        statusKlien.setX(366);
        statusKlien.setY(392);
        statusKlien.setPage(1);
        statusKlien.setFontSize(10);
        statusKlien.setType("checkbox");
        fieldCoordinateHashMap.put("statusKlien", statusKlien);

        FieldData alasanTes = new FieldData();
        alasanTes.setX(366);
        alasanTes.setY(392);
        alasanTes.setPage(1);
        alasanTes.setFontSize(10);
        alasanTes.setType("checkbox");
        fieldCoordinateHashMap.put("alasanTes", alasanTes);

        FieldData tahuDari = new FieldData();
        tahuDari.setX(366);
        tahuDari.setY(392);
        tahuDari.setPage(1);
        tahuDari.setFontSize(10);
        tahuDari.setType("checkbox");
        fieldCoordinateHashMap.put("tahuDari", tahuDari);

        FieldData hubSeksResiko = new FieldData();
        hubSeksResiko.setX(366);
        hubSeksResiko.setY(392);
        hubSeksResiko.setPage(1);
        hubSeksResiko.setFontSize(10);
        hubSeksResiko.setType("checkbox");
        fieldCoordinateHashMap.put("hubSeksResiko", hubSeksResiko);

        FieldData analSeksResiko = new FieldData();
        analSeksResiko.setX(366);
        analSeksResiko.setY(392);
        analSeksResiko.setPage(1);
        analSeksResiko.setFontSize(10);
        analSeksResiko.setType("checkbox");
        fieldCoordinateHashMap.put("analSeksResiko", analSeksResiko);

        FieldData bergantianPeralatanSuntik = new FieldData();
        bergantianPeralatanSuntik.setX(366);
        bergantianPeralatanSuntik.setY(392);
        bergantianPeralatanSuntik.setPage(1);
        bergantianPeralatanSuntik.setFontSize(10);
        bergantianPeralatanSuntik.setType("checkbox");
        fieldCoordinateHashMap.put("bergantianPeralatanSuntik", bergantianPeralatanSuntik);

        FieldData transfusiDarah = new FieldData();
        transfusiDarah.setX(366);
        transfusiDarah.setY(392);
        transfusiDarah.setPage(1);
        transfusiDarah.setFontSize(10);
        transfusiDarah.setType("checkbox");
        fieldCoordinateHashMap.put("transfusiDarah", transfusiDarah);

        FieldData transmisiIbuAnak = new FieldData();
        transmisiIbuAnak.setX(366);
        transmisiIbuAnak.setY(392);
        transmisiIbuAnak.setPage(1);
        transmisiIbuAnak.setFontSize(10);
        transmisiIbuAnak.setType("checkbox");
        fieldCoordinateHashMap.put("transmisiIbuAnak", transmisiIbuAnak);

        FieldData lainnya = new FieldData();
        lainnya.setX(366);
        lainnya.setY(392);
        lainnya.setPage(1);
        lainnya.setFontSize(10);
        lainnya.setType("checkbox");
        fieldCoordinateHashMap.put("lainnya", lainnya);

        FieldData periodeJendela = new FieldData();
        periodeJendela.setX(366);
        periodeJendela.setY(392);
        periodeJendela.setPage(1);
        periodeJendela.setFontSize(10);
        periodeJendela.setType("checkbox");
        fieldCoordinateHashMap.put("periodeJendela", periodeJendela);

        FieldData kesediaanTes = new FieldData();
        kesediaanTes.setX(366);
        kesediaanTes.setY(392);
        kesediaanTes.setPage(1);
        kesediaanTes.setFontSize(10);
        kesediaanTes.setType("checkbox");
        fieldCoordinateHashMap.put("kesediaanTes", kesediaanTes);

        FieldData pernahTesKts = new FieldData();
        pernahTesKts.setX(366);
        pernahTesKts.setY(392);
        pernahTesKts.setPage(1);
        pernahTesKts.setFontSize(10);
        pernahTesKts.setType("checkbox");
        fieldCoordinateHashMap.put("pernahTesKts", pernahTesKts);

        FieldData hasilTesKts = new FieldData();
        hasilTesKts.setX(366);
        hasilTesKts.setY(392);
        hasilTesKts.setPage(1);
        hasilTesKts.setFontSize(10);
        hasilTesKts.setType("checkbox");
        fieldCoordinateHashMap.put("hasilTesKts", hasilTesKts);

        FieldData pernahTesDimanaKts = new FieldData();
        pernahTesDimanaKts.setX(197);
        pernahTesDimanaKts.setY(113);
        pernahTesDimanaKts.setPage(1);
        pernahTesDimanaKts.setFontSize(10);
        pernahTesDimanaKts.setMulti(true);
        fieldCoordinateHashMap.put("pernahTesDimanaKts", pernahTesDimanaKts);


        FieldData pernahTesDimanaTipk = new FieldData();
        pernahTesDimanaTipk.setX(197);
        pernahTesDimanaTipk.setY(660);
        pernahTesDimanaTipk.setPage(1);
        pernahTesDimanaTipk.setFontSize(10);
        pernahTesDimanaTipk.setMulti(true);
        fieldCoordinateHashMap.put("pernahTesDimanaTipk", pernahTesDimanaTipk);

        FieldData pernahTesTipk = new FieldData();
        pernahTesTipk.setX(366);
        pernahTesTipk.setY(392);
        pernahTesTipk.setPage(2);
        pernahTesTipk.setFontSize(10);
        pernahTesTipk.setType("checkbox");
        fieldCoordinateHashMap.put("pernahTesTipk", pernahTesTipk);

        FieldData hasilTesTipk = new FieldData();
        hasilTesTipk.setX(366);
        hasilTesTipk.setY(392);
        hasilTesTipk.setPage(2);
        hasilTesTipk.setFontSize(10);
        hasilTesTipk.setType("checkbox");
        fieldCoordinateHashMap.put("hasilTesTipk", hasilTesTipk);

        FieldData penyakitTerkaitPasienTipk = new FieldData();
        penyakitTerkaitPasienTipk.setX(366);
        penyakitTerkaitPasienTipk.setY(392);
        penyakitTerkaitPasienTipk.setPage(2);
        penyakitTerkaitPasienTipk.setFontSize(10);
        penyakitTerkaitPasienTipk.setType("checkbox");
        fieldCoordinateHashMap.put("penyakitTerkaitPasienTipk", penyakitTerkaitPasienTipk);

        FieldData kesediaanTesTipk = new FieldData();
        kesediaanTesTipk.setX(366);
        kesediaanTesTipk.setY(392);
        kesediaanTesTipk.setPage(2);
        kesediaanTesTipk.setFontSize(10);
        kesediaanTesTipk.setType("checkbox");
        fieldCoordinateHashMap.put("kesediaanTesTipk", kesediaanTesTipk);

        FieldData hasilTesR1 = new FieldData();
        hasilTesR1.setX(366);
        hasilTesR1.setY(392);
        hasilTesR1.setPage(2);
        hasilTesR1.setFontSize(10);
        hasilTesR1.setType("checkbox");
        fieldCoordinateHashMap.put("hasilTesR1", hasilTesR1);

        FieldData hasilTesR2 = new FieldData();
        hasilTesR2.setX(366);
        hasilTesR2.setY(392);
        hasilTesR2.setPage(2);
        hasilTesR2.setFontSize(10);
        hasilTesR2.setType("checkbox");
        fieldCoordinateHashMap.put("hasilTesR2", hasilTesR2);

        FieldData hasilTesR3 = new FieldData();
        hasilTesR3.setX(366);
        hasilTesR3.setY(392);
        hasilTesR3.setPage(2);
        hasilTesR3.setFontSize(10);
        hasilTesR3.setType("checkbox");
        fieldCoordinateHashMap.put("hasilTesR3", hasilTesR3);

        FieldData kesimpulanHasil = new FieldData();
        kesimpulanHasil.setX(366);
        kesimpulanHasil.setY(392);
        kesimpulanHasil.setPage(2);
        kesimpulanHasil.setFontSize(10);
        kesimpulanHasil.setType("checkbox");
        fieldCoordinateHashMap.put("kesimpulanHasil", kesimpulanHasil);

        FieldData rujukKonseling = new FieldData();
        rujukKonseling.setX(366);
        rujukKonseling.setY(392);
        rujukKonseling.setPage(2);
        rujukKonseling.setFontSize(10);
        rujukKonseling.setType("checkbox");
        fieldCoordinateHashMap.put("rujukKonseling", rujukKonseling);

        FieldData rujukKe = new FieldData();
        rujukKe.setX(366);
        rujukKe.setY(392);
        rujukKe.setPage(2);
        rujukKe.setFontSize(10);
        rujukKe.setType("checkbox");
        fieldCoordinateHashMap.put("rujukKe", rujukKe);

        FieldData rujukKePdpDanPpia = new FieldData();
        rujukKePdpDanPpia.setX(366);
        rujukKePdpDanPpia.setY(392);
        rujukKePdpDanPpia.setPage(2);
        rujukKePdpDanPpia.setFontSize(10);
        rujukKePdpDanPpia.setType("checkbox");
        fieldCoordinateHashMap.put("rujukKePdpDanPpia", rujukKe);

        FieldData statusHivPasangan = new FieldData();
        statusHivPasangan.setX(366);
        statusHivPasangan.setY(392);
        statusHivPasangan.setPage(2);
        statusHivPasangan.setFontSize(10);
        statusHivPasangan.setType("checkbox");
        fieldCoordinateHashMap.put("statusHivPasangan", statusHivPasangan);

        FieldData tindakLanjutPascaTes = new FieldData();
        tindakLanjutPascaTes.setX(366);
        tindakLanjutPascaTes.setY(392);
        tindakLanjutPascaTes.setPage(2);
        tindakLanjutPascaTes.setFontSize(10);
        tindakLanjutPascaTes.setType("checkbox");
        fieldCoordinateHashMap.put("tindakLanjutPascaTes", tindakLanjutPascaTes);

        FieldData terimaHasil = new FieldData();
        terimaHasil.setX(366);
        terimaHasil.setY(392);
        terimaHasil.setPage(2);
        terimaHasil.setFontSize(10);
        terimaHasil.setType("checkbox");
        fieldCoordinateHashMap.put("terimaHasil", terimaHasil);


        FieldData kajiGelajaTb = new FieldData();
        kajiGelajaTb.setX(366);
        kajiGelajaTb.setY(392);
        kajiGelajaTb.setPage(2);
        kajiGelajaTb.setFontSize(10);
        kajiGelajaTb.setType("checkbox");
        fieldCoordinateHashMap.put("kajiGelajaTb", kajiGelajaTb);

        FieldData statusLayanan = new FieldData();
        statusLayanan.setX(366);
        statusLayanan.setY(392);
        statusLayanan.setPage(2);
        statusLayanan.setFontSize(10);
        statusLayanan.setType("checkbox");
        fieldCoordinateHashMap.put("statusLayanan", statusLayanan);

        FieldData jenisPelayanan = new FieldData();
        jenisPelayanan.setX(366);
        jenisPelayanan.setY(392);
        jenisPelayanan.setPage(2);
        jenisPelayanan.setFontSize(10);
        jenisPelayanan.setType("checkbox");
        fieldCoordinateHashMap.put("jenisPelayanan", jenisPelayanan);

    }

    public Resource exportPoli(PoliHIV data){
        try {
            //Create PdfReader instance.

            PdfReader pdfReader =
                    new PdfReader(resourceLoader.getResource("classpath:konseling.pdf").getInputStream());


            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            //Create PdfStamper instance.
            PdfStamper pdfStamper = new PdfStamper(pdfReader, byteArrayOutputStream);

            //Get the number of pages in pdf.
            int pages = pdfReader.getNumberOfPages();

            // Set text
            if(!StringUtils.isEmpty(data.getNoRekamMedis())) {
                setText("noRekamMedis", data.getNoRekamMedis(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getNoRegister())) {
                setText("noRegister", data.getNoRegister(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getNik())) {
                setText("nik", data.getNik(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getNama())) {
                setText("nama", data.getNama(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getNama())) {
                setText("alamat", data.getAlamat(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getProvinsi())) {
                setText("propinsi", data.getProvinsi(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getKabKota())) {
                setText("kabKota", data.getKabKota(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getIbuKandung())) {
                setText("ibuKandung", data.getIbuKandung(), pdfStamper);
            }

            // End Set text
            if(!StringUtils.isEmpty(data.getJenisKelamin())) {
                setText("jenisKelamin", data.getJenisKelamin(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getStatusPerkawinan())) {
                setText("statusPerkawinan", data.getStatusPerkawinan(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getStatusKehamilan())) {
                setText("statusKehamilan", data.getStatusKehamilan(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getPendidikanTerakhir())) {
                setText("pendidikanTerakhir", data.getPendidikanTerakhir(), pdfStamper);
            }
            if((!StringUtils.isEmpty(data.getPekerjaan()) && data.getPekerjaan().contentEquals("Bekerja")) && !StringUtils.isEmpty(data.getJenisPekerjaan())) {
                setText("pekerjaan", data.getJenisPekerjaan(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getUmurAnakTerakhir())) {
                setText("umurAnak", data.getUmurAnakTerakhir(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getJumlahAnak())) {
                setText("jumlahAnak", data.getJumlahAnak(), pdfStamper);
            }
            if(data.getTanggalLahir()!=null) {
                setText("tglLahir", data.getTanggalLahir(), pdfStamper);
            }


            if(!StringUtils.isEmpty(data.getKelompokResiko())) {
                setText("kelompokResiko", data.getKelompokResiko(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getLamaResiko())) {
                setText("lamaResiko", data.getLamaResiko(), pdfStamper);
            }

            if(!StringUtils.isEmpty(data.getStatusKunjungan())) {
                setText("statusKunjungan", data.getStatusKunjungan(), pdfStamper);
            }

            if(!StringUtils.isEmpty(data.getStatusRujukan())) {
                setText("statusRujukan", data.getStatusRujukan(), pdfStamper);
            }

            if(!StringUtils.isEmpty(data.getPasanganTetap())) {
                setText("pasanganTetap", data.getPasanganTetap(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getPasanganWanita())) {
                setText("pasanganWanita", data.getPasanganWanita(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getPasanganHamil())) {
                setText("pasanganHamil", data.getPasanganHamil(), pdfStamper);
            }

            if(!StringUtils.isEmpty(data.getTanggalLahirPasangan())) {
                setText("tanggalLahirPasangan", data.getTanggalLahirPasangan(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getStatusPasangan())) {
                setText("statusPasangan", data.getStatusPasangan(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getTanggalTesTerakhirPasangan())) {
                setText("tanggalTesTerakhirPasangan", data.getTanggalTesTerakhirPasangan(), pdfStamper);
            }

            if(!StringUtils.isEmpty(data.getPopulasiKhusus())) {
                setText("populasiKhusus", data.getPopulasiKhusus(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getTanggalKonseling())) {
                setText("tanggalKonseling", data.getTanggalKonseling(), pdfStamper);
            }

            if(!StringUtils.isEmpty(data.getStatusKlien())) {
                setText("statusKlien", data.getStatusKlien(), pdfStamper);
            }

            if(!StringUtils.isEmpty(data.getAlasanTes())) {
                setText("alasanTes", data.getAlasanTes(), pdfStamper);
            }

            if(!StringUtils.isEmpty(data.getTahuDari())) {
                setText("tahuDari", data.getTahuDari(), pdfStamper);
            }

            if(!StringUtils.isEmpty(data.getHubSeksResiko())) {
                setText("hubSeksResiko", data.getHubSeksResiko(), pdfStamper);
            }

//            if(!StringUtils.isEmpty(data.getKapanHubSeksResiko())) {
//                setText("kapanHubSeksResiko", data.getKapanHubSeksResiko(), pdfStamper);
//            }

            if(!StringUtils.isEmpty(data.getAnalSeksResiko())) {
                setText("analSeksResiko", data.getAnalSeksResiko(), pdfStamper);
            }

//            if(!StringUtils.isEmpty(data.getKapanAnalSeksResiko())) {
//                setText("kapanAnalSeksResiko", data.getKapanAnalSeksResiko(), pdfStamper);
//            }

            if(!StringUtils.isEmpty(data.getBergantianPeralatanSuntik())) {
                setText("bergantianPeralatanSuntik", data.getBergantianPeralatanSuntik(), pdfStamper);
            }

//            if(!StringUtils.isEmpty(data.getKapanBergantianPeralatanSuntik())) {
//                setText("kapanBergantianPeralatanSuntik", data.getKapanBergantianPeralatanSuntik(), pdfStamper);
//            }

            if(!StringUtils.isEmpty(data.getTransfusiDarah())) {
                setText("transfusiDarah", data.getTransfusiDarah(), pdfStamper);
            }

//            if(!StringUtils.isEmpty(data.getKapanTransfusiDarah())) {
//                setText("kapanTransfusiDarah", data.getKapanTransfusiDarah(), pdfStamper);
//            }

            if(!StringUtils.isEmpty(data.getTransmisiIbuAnak())) {
                setText("transmisiIbuAnak", data.getTransmisiIbuAnak(), pdfStamper);
            }

//            if(!StringUtils.isEmpty(data.getKapanTransmisiIbuAnak())) {
//                setText("kapanTransmisiIbuAnak", data.getKapanTransmisiIbuAnak(), pdfStamper);
//            }

            if(!StringUtils.isEmpty(data.getLainnya())) {
                setText("lainnya", data.getLainnya(), pdfStamper);
            }

//            if(!StringUtils.isEmpty(data.getKapanLainnya())) {
//                setText("kapanLainnya", data.getKapanLainnya(), pdfStamper);
//            }

            if(!StringUtils.isEmpty(data.getPeriodeJendela())) {
                setText("periodeJendela", data.getPeriodeJendela(), pdfStamper);
            }

//            if(!StringUtils.isEmpty(data.getKapanPeriodeJendela())) {
//                setText("kapanPeriodeJendela", data.getKapanPeriodeJendela(), pdfStamper);
//            }

            if(!StringUtils.isEmpty(data.getKesediaanTes())) {
                setText("kesediaanTes", data.getKesediaanTes(), pdfStamper);
            }

            if(!StringUtils.isEmpty(data.getPernahTesKts())) {
                setText("pernahTesKts", data.getPernahTesKts(), pdfStamper);
            }

//            if(!StringUtils.isEmpty(data.getPernahTesDimanaKts())) {
//                setText("pernahTesDimanaKts", data.getPernahTesDimanaKts(), pdfStamper);
//            }

//            if(!StringUtils.isEmpty(data.getPernahTesKapanKts())) {
//                setText("pernahTesKapanKts", data.getPernahTesKapanKts(), pdfStamper);
//            }

            if(!StringUtils.isEmpty(data.getHasilTesKts())) {
                setText("hasilTesKts", data.getHasilTesKts(), pdfStamper);
            }

            if(!StringUtils.isEmpty(data.getPernahTesDimanaKts())) {
                setText("pernahTesDimanaKts", data.getPernahTesDimanaKts(), pdfStamper);
            }

            // Page 2 TIPK
            if(!StringUtils.isEmpty(data.getPernahTesTipk())) {
                setText("pernahTesTipk", data.getPernahTesTipk(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getHasilTesTipk())) {
                setText("hasilTesTipk", data.getHasilTesTipk(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getPenyakitTerkaitPasienTipk())) {
                setText("penyakitTerkaitPasienTipk", data.getPenyakitTerkaitPasienTipk(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getKesediaanTesTipk())) {
                setText("kesediaanTesTipk", data.getKesediaanTesTipk(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getPernahTesDimanaTipk())) {
                setText("pernahTesDimanaTipk", data.getPernahTesDimanaTipk(), pdfStamper);
            }

            // Tes antibodi HIV
            if(!StringUtils.isEmpty(data.getHasilTesR1())) {
                setText("hasilTesR1", data.getHasilTesR1(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getHasilTesR2())) {
                setText("hasilTesR2", data.getHasilTesR2(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getHasilTesR3())) {
                setText("hasilTesR3", data.getHasilTesR3(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getKesimpulanHasil())) {
                setText("kesimpulanHasil", data.getKesimpulanHasil(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getTindakLanjutPascaTes())) {
                setText("tindakLanjutPascaTes", data.getTindakLanjutPascaTes(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getRujukKonseling())) {
                setText("rujukKonseling", data.getRujukKonseling(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getRujukKe())) {
                setText("rujukKe", data.getRujukKe(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getRujukKePdpDanPpia())) {
                setText("rujukKePdpDanPpia", data.getRujukKePdpDanPpia(), pdfStamper);
            }

            if(!StringUtils.isEmpty(data.getStatusHivPasangan())) {
                setText("statusHivPasangan", data.getStatusHivPasangan(), pdfStamper);
            }

            // pasca tes
            if(!StringUtils.isEmpty(data.getTerimaHasil())) {
                setText("terimaHasil", data.getTerimaHasil(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getKajiGejalaTb())) {
                setText("kajiGelajaTb", data.getKajiGejalaTb(), pdfStamper);
            }

            if(!StringUtils.isEmpty(data.getStatusLayanan())) {
                setText("statusLayanan", data.getStatusLayanan(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getJenisPelayanan())) {
                setText("jenisPelayanan", data.getJenisPelayanan(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getTindakLanjutPascaTes())) {
                setText("tindakLanjutPascaTes", data.getTindakLanjutPascaTes(), pdfStamper);
            }
            //Close the pdfStamper.
            pdfStamper.close();

            System.out.println("PDF modified successfully.");
            return new ByteArrayResource(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private void setText(String field, Object value, PdfStamper pdfStamper) throws IOException, DocumentException {
        FieldData fieldCoordinate = (FieldData)fieldCoordinateHashMap.get(field);
        PdfContentByte pageContentByte = pdfStamper.getOverContent(fieldCoordinate.getPage());


        byte[] data =IOUtils.toByteArray(resourceLoader.getResource("classpath:blackdot.png").getInputStream());
        Image image = Image.getInstance(data);
        BaseFont baseFont = BaseFont.createFont(
                BaseFont.TIMES_ROMAN,
                BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

        if(fieldCoordinate.getType().contentEquals("text")) {
            if (fieldCoordinate.isMulti()) {
                if(field.contentEquals("tglLahir")){
                    Date tglLahir = (Date) value;
                    SimpleDateFormat dateTgl = new SimpleDateFormat("dd");
                    String tgl = dateTgl.format(tglLahir);
                    for (int i = 0; i < tgl.toString().length(); i++) {
                        pageContentByte.beginText();
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        pageContentByte.setTextMatrix(395 + (i * 13), 555);
                        pageContentByte.showText(String.valueOf(tgl.toString().charAt(i)));
                        pageContentByte.endText();
                    }

                    SimpleDateFormat dateBln = new SimpleDateFormat("MM");
                    String bln = dateBln.format(tglLahir);
                    for (int i = 0; i < bln.toString().length(); i++) {
                        pageContentByte.beginText();
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        pageContentByte.setTextMatrix(424 + (i * 13), 555);
                        pageContentByte.showText(String.valueOf(bln.toString().charAt(i)));
                        pageContentByte.endText();
                    }

                    SimpleDateFormat dateThn = new SimpleDateFormat("yyyy");
                    String thn = dateThn.format(tglLahir);
                    for (int i = 0; i < thn.toString().length(); i++) {
                        pageContentByte.beginText();
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        pageContentByte.setTextMatrix(454 + (i * 13), 555);
                        pageContentByte.showText(String.valueOf(thn.toString().charAt(i)));
                        pageContentByte.endText();
                    }
                }
                else if(field.contentEquals("tanggalLahirPasangan")){
                    Date tglLahir = (Date) value;
                    SimpleDateFormat dateTgl = new SimpleDateFormat("dd");
                    String tgl = dateTgl.format(tglLahir);
                    for (int i = 0; i < tgl.toString().length(); i++) {
                        pageContentByte.beginText();
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        pageContentByte.setTextMatrix(346 + (i * 11), 407);
                        pageContentByte.showText(String.valueOf(tgl.toString().charAt(i)));
                        pageContentByte.endText();
                    }

                    SimpleDateFormat dateBln = new SimpleDateFormat("MM");
                    String bln = dateBln.format(tglLahir);
                    for (int i = 0; i < bln.toString().length(); i++) {
                        pageContentByte.beginText();
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        pageContentByte.setTextMatrix(369 + (i * 11), 407);
                        pageContentByte.showText(String.valueOf(bln.toString().charAt(i)));
                        pageContentByte.endText();
                    }

                    SimpleDateFormat dateThn = new SimpleDateFormat("yyyy");
                    String thn = dateThn.format(tglLahir);
                    for (int i = 0; i < thn.toString().length(); i++) {
                        pageContentByte.beginText();
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        pageContentByte.setTextMatrix(392 + (i * 11), 407);
                        pageContentByte.showText(String.valueOf(thn.toString().charAt(i)));
                        pageContentByte.endText();
                    }
                }
                else if(field.contentEquals("tanggalTesTerakhirPasangan")){
                    Date tglLahir = (Date) value;
                    SimpleDateFormat dateTgl = new SimpleDateFormat("dd");
                    String tgl = dateTgl.format(tglLahir);
                    for (int i = 0; i < tgl.toString().length(); i++) {
                        pageContentByte.beginText();
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        pageContentByte.setTextMatrix(384 + (i * 11), 378);
                        pageContentByte.showText(String.valueOf(tgl.toString().charAt(i)));
                        pageContentByte.endText();
                    }

                    SimpleDateFormat dateBln = new SimpleDateFormat("MM");
                    String bln = dateBln.format(tglLahir);
                    for (int i = 0; i < bln.toString().length(); i++) {
                        pageContentByte.beginText();
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        pageContentByte.setTextMatrix(406 + (i * 11), 378);
                        pageContentByte.showText(String.valueOf(bln.toString().charAt(i)));
                        pageContentByte.endText();
                    }

                    SimpleDateFormat dateThn = new SimpleDateFormat("yyyy");
                    String thn = dateThn.format(tglLahir);
                    for (int i = 0; i < thn.toString().length(); i++) {
                        pageContentByte.beginText();
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        pageContentByte.setTextMatrix(428 + (i * 11), 378);
                        pageContentByte.showText(String.valueOf(thn.toString().charAt(i)));
                        pageContentByte.endText();
                    }
                }
                else if(field.contentEquals("tanggalKonseling")){
                    Date tglLahir = (Date) value;
                    SimpleDateFormat dateTgl = new SimpleDateFormat("dd");
                    String tgl = dateTgl.format(tglLahir);
                    for (int i = 0; i < tgl.toString().length(); i++) {
                        pageContentByte.beginText();
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        pageContentByte.setTextMatrix(125 + (i * 11), 282);
                        pageContentByte.showText(String.valueOf(tgl.toString().charAt(i)));
                        pageContentByte.endText();
                    }

                    SimpleDateFormat dateBln = new SimpleDateFormat("MM");
                    String bln = dateBln.format(tglLahir);
                    for (int i = 0; i < bln.toString().length(); i++) {
                        pageContentByte.beginText();
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        pageContentByte.setTextMatrix(151 + (i * 11), 282);
                        pageContentByte.showText(String.valueOf(bln.toString().charAt(i)));
                        pageContentByte.endText();
                    }

                    SimpleDateFormat dateThn = new SimpleDateFormat("yyyy");
                    String thn = dateThn.format(tglLahir);
                    for (int i = 0; i < thn.toString().length(); i++) {
                        pageContentByte.beginText();
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        pageContentByte.setTextMatrix(176 + (i * 11), 282);
                        pageContentByte.showText(String.valueOf(thn.toString().charAt(i)));
                        pageContentByte.endText();
                    }
                }
                else {
                    for (int i = 0; i < value.toString().length(); i++) {
                        pageContentByte.beginText();
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        pageContentByte.setTextMatrix(fieldCoordinate.getX() + (i * 13), fieldCoordinate.getY());
                        pageContentByte.showText(String.valueOf(value.toString().charAt(i)));
                        pageContentByte.endText();
                    }
                }
            } else {
                pageContentByte.beginText();
                pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                pageContentByte.setTextMatrix(fieldCoordinate.getX(), fieldCoordinate.getY());
                pageContentByte.showText(value.toString());
                pageContentByte.endText();

                if(field.contentEquals("noRekamMedis") || field.contentEquals("nik") || field.contentEquals("noRegister")){
                    PdfContentByte pageContentByte2 = pdfStamper.getOverContent(2);
                    pageContentByte2.beginText();
                    pageContentByte2.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    pageContentByte2.setTextMatrix(fieldCoordinate.getX(), fieldCoordinate.getY());
                    pageContentByte2.showText(value.toString());
                    pageContentByte2.endText();
                }
            }
        }
        else if(fieldCoordinate.getType().contentEquals("checkbox")){
            if(field.contentEquals("jenisKelamin")){
                if(value.toString().contentEquals("Laki-laki")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(20, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                }
                else if(value.toString().contentEquals("Perempuan")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(72, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                }
            }
            else if(field.contentEquals("statusPerkawinan")){
                if(value.toString().contentEquals("Kawin")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(128, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                }
                else if(value.toString().contentEquals("Belum Kawin")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(164, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                } else if(value.toString().contentEquals("Cerai Hidup")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(233, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                } else if(value.toString().contentEquals("Cerai Mati")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(293, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                }
            }
            else if(field.contentEquals("statusKehamilan")){
                if(value.toString().contentEquals("Trimester I")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(21, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                } else if(value.toString().contentEquals("Trimester II")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(72, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                } else if(value.toString().contentEquals("Trimester III")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(124, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                } else if(value.toString().contentEquals("Tidak Hamil")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(178, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                } else if(value.toString().contentEquals("Tidak Tahu")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(232, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                }
            }
            else if(field.contentEquals("pendidikanTerakhir")){
                if(value.toString().contentEquals("Tidak pernah sekolah")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(20, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                } else if(value.toString().contentEquals("SD")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(114, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                } else if(value.toString().contentEquals("SMP")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(192, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                } else if(value.toString().contentEquals("SMA")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(277, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                } else if(value.toString().contentEquals("Akademi/Perguruan Tinggi")){
                    pageContentByte.beginText();
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(362, fieldCoordinate.getY());
                    image.setWidthPercentage(1);
                    pageContentByte.addImage(image);
                    pageContentByte.endText();
                }
            }
            else if(field.contentEquals("pekerjaan")){
                pageContentByte.beginText();

                if(!value.toString().contentEquals("")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    pageContentByte.setTextMatrix(135, 468);
                    pageContentByte.showText(value.toString());
                    image.setAbsolutePosition(120, 478);
                    image.setWidthPercentage(1);
                } else{
                    image.setAbsolutePosition(61, 478);
                    image.setWidthPercentage(1);
                }
                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("kelompokResiko")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("PS (Langsung)")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(16, 437);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("PS (Tidak Langsung)")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(48, 437);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Pelanggan PS")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(169, 437);
                    image.setWidthPercentage(1);
                }
                else if(value.toString().contentEquals("Waria")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(17, 421);
                    image.setWidthPercentage(1);
                }
                else if(value.toString().contentEquals("Pasangan Risti")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(58, 423);
                    image.setWidthPercentage(1);
                }
                else if(value.toString().contentEquals("Penasun")){
                    System.out.println("Masuk sini");
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(118, 423);
                    image.setWidthPercentage(1);
                }
                else if(value.toString().contentEquals("Gay/LSL")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(215, 423);
                    image.setWidthPercentage(1);
                }
                else if(value.toString().contentEquals("Lainnya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(169, 423);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("statusKunjungan")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Datang Sendiri")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(20, 380);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Dirujuk")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(20, 365);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("statusRujukan")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Tempat Kerja")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(138, 379);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Kader")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(196, 379);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Klp Dukungan")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(138, 364);
                    image.setWidthPercentage(1);
                }
                else if(value.toString().contentEquals("LSM")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(196, 363);
                    image.setWidthPercentage(1);
                }
                else if(value.toString().contentEquals("Pasangan")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(138, 348);
                    image.setWidthPercentage(1);
                }
                else if(value.toString().contentEquals("Lain-lain")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(196, 349);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("pasanganTetap")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(367, 469);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(385, 469);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("pasanganWanita")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(377, 433);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(395, 433);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("pasanganHamil")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(378, 423);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(396, 423);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak Tahu")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(423, 423);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("populasiKhusus")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(167, 316);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(198, 316);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("statusKlien")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Baru")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(355, 282);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Lama")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(400, 282);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("alasanTes")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ingin tahu saja")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(125, 266);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Merasa beresiko")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(222, 266);
                    image.setWidthPercentage(1);
                }else if(value.toString().contentEquals("Mumpung gratis")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(313, 266);
                    image.setWidthPercentage(1);
                }else if(value.toString().contentEquals("Tes ulang (window period)")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(410, 266);
                    image.setWidthPercentage(1);
                }else if(value.toString().contentEquals("Untuk bekerja")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(125, 250);
                    image.setWidthPercentage(1);
                }else if(value.toString().contentEquals("Ada gejala tertentu")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(312, 250);
                    image.setWidthPercentage(1);
                }else if(value.toString().contentEquals("Akan menikah")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(412, 250);
                    image.setWidthPercentage(1);
                }else if(value.toString().contentEquals("Lainnya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(220, 250);
                    image.setWidthPercentage(1);
                }


                pageContentByte.addImage(image);
                pageContentByte.endText();
            }else if(field.contentEquals("tahuDari")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Brosur")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(124, 233);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Koran")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(202, 233);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("TV")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(260, 233);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Petugas Kesehatan")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(339, 233);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Teman")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(397, 233);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Petugas Outreach")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(123, 218);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Poster")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(201, 218);
                    image.setWidthPercentage(1);
                }else if(value.toString().contentEquals("Lay Konselor")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(261, 218);
                    image.setWidthPercentage(1);
                }else if(value.toString().contentEquals("Lainnya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(339, 218);
                    image.setWidthPercentage(1);
                }
                pageContentByte.addImage(image);
                pageContentByte.endText();
            }else if(field.contentEquals("hubSeksResiko")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(123, 187);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(247, 187);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }else if(field.contentEquals("analSeksResiko")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(365, 187);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(489, 187);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("bergantianPeralatanSuntik")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(123, 168);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(248, 168);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("transfusiDarah")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(365, 169);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(489, 169);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("transmisiIbuAnak")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(125, 150);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(247, 150);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("lainnya")){
                pageContentByte.beginText();

//                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(364, 150);
                    image.setWidthPercentage(1);
//                } else if(value.toString().contentEquals("Tidak")){
//                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
//                    image.setAbsolutePosition(400, 150);
//                    image.setWidthPercentage(1);
//                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("periodeJendela")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(124, 131);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(247, 131);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("kesediaanTes")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(365, 131);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(417, 131);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("pernahTesKts")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(124, 112);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(124, 89);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("hasilTesKts")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Non Reaktif")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(195, 99);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Reaktif")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(260, 99);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak Tahu")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(312, 99);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("pernahTesTipk")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(125, 659);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(125, 631);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("hasilTesTipk")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Non Reaktif")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(197, 645);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Reaktif")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(262, 645);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak Tahu")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(314, 645);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("penyakitTerkaitPasienTipk")){
                pageContentByte.beginText();
                for(String d : ((List<String>)value)){
                    if(d.toString().contentEquals("TB")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(124, 613);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Diare")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(124, 598);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Kandidiasis oralesovagial")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(124, 584);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Dermatitis")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(234, 612);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("LGV")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(234, 598);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("PCP")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(234, 582);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Herpes")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(298, 612);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Toksoplasmosis")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(298, 599);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Wasting syndrome")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(298, 583);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Sifilis")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(390, 613);
                        image.setWidthPercentage(1);
                    }else if(d.toString().contentEquals("Hepatitis")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(458, 613);
                        image.setWidthPercentage(1);
                    }
                    else if(d.toString().contentEquals("IMS Lainnya")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(392, 598);
                        image.setWidthPercentage(1);
                    }
                    else if(d.toString().contentEquals("Lainnya")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(390, 583);
                        image.setWidthPercentage(1);
                    }


                    pageContentByte.addImage(image);
                }

                pageContentByte.endText();
            }
            else if(field.contentEquals("kesediaanTesTipk")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(124, 566);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(170, 566);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("hasilTesR1")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Non Reaktif")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(126, 518);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Reaktif")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(215, 518);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("hasilTesR2")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Non Reaktif")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(126, 500);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Reaktif")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(215, 500);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("hasilTesR3")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Non Reaktif")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(126, 482);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Reaktif")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(215, 482);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("kesimpulanHasil")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Non Reaktif")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(126, 464);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Reaktif")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(215, 464);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Indeterminate")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(277, 464);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("rujukKonseling")){
                pageContentByte.beginText();
                pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                image.setAbsolutePosition(127, 429);
                image.setWidthPercentage(1);
                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("rujukKe")){
                pageContentByte.beginText();
                pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                image.setAbsolutePosition(129, 415);
                image.setWidthPercentage(1);
                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("rujukKePdpDanPpia")){
                pageContentByte.beginText();
                pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                image.setAbsolutePosition(294, 429);
                image.setWidthPercentage(1);
                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("statusHivPasangan")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Non Reaktif")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(126, 464);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Reaktif")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(215, 464);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Indeterminate")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(277, 464);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("terimaHasil")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(126, 314);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(153, 314);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("kajiGelajaTb")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Ya")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(274, 314);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Tidak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(304, 314);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("statusLayanan")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Rumah Sakit")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(127, 203);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Puskesmas")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(275, 203);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Klinik")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(368, 203);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("jenisPelayanan")){
                pageContentByte.beginText();

                if(value.toString().contentEquals("Layanan Menetap")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(128, 187);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Layanan Bergerak")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(276, 187);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
                pageContentByte.endText();
            }
            else if(field.contentEquals("tindakLanjutPascaTes")){
                pageContentByte.beginText();
                for(String d : ((List<String>)value)){
                    if(d.toString().contentEquals("Tes Ulang")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(127, 294);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Rujuk ke PDP")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(127, 279);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Rujuk ke Layanan PRTM")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(127, 264);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Rujuk ke Layanan IMS")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(253, 292);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Rujuk ke PPIA")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(253, 276);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Rujuk ke Rehab")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(253, 263);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Rujuk ke Layanan LASS")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(253, 249);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Rujuk ke layanan TB")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(341, 292);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Rujuk ke Professional")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(341, 278);
                        image.setWidthPercentage(1);
                    } else if(d.toString().contentEquals("Rujuk ke petugas pendukung")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(340, 263);
                        image.setWidthPercentage(1);
                    }else if(d.toString().contentEquals("Konseling")){
                        pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                        image.setAbsolutePosition(424, 292);
                        image.setWidthPercentage(1);
                    }


                    pageContentByte.addImage(image);
                }

                pageContentByte.endText();
            }
        }
    }

    private void setTextFormLab(String field, Object value, PdfStamper pdfStamper) throws IOException, DocumentException{
        PdfContentByte pageContentByte = pdfStamper.getOverContent(1);

        BaseFont baseFont = BaseFont.createFont(
                BaseFont.TIMES_ROMAN,
                BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

        if(field.contentEquals("noRegistrasi")) {
            pageContentByte.beginText();
            pageContentByte.setFontAndSize(baseFont, 10);
            pageContentByte.setTextMatrix(403, 675);
            pageContentByte.showText(value.toString());
            pageContentByte.endText();
        }
        else if(field.contentEquals("nama")) {
            pageContentByte.beginText();
            pageContentByte.setFontAndSize(baseFont, 10);
            pageContentByte.setTextMatrix(115, 678);
            pageContentByte.showText(value.toString());
            pageContentByte.endText();
        }
        else if(field.contentEquals("createdDate")) {
            Date d = (Date)value;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
            pageContentByte.beginText();
            pageContentByte.setFontAndSize(baseFont, 10);
            pageContentByte.setTextMatrix(403, 158);
            pageContentByte.showText(dateFormat.format(d));
            pageContentByte.endText();
        }
        else if(field.contentEquals("tanggalLahir")) {

            Date d = (Date)value;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
            pageContentByte.beginText();
            pageContentByte.setFontAndSize(baseFont, 10);
            pageContentByte.setTextMatrix(115, 663);
            pageContentByte.showText(dateFormat.format(d));
            pageContentByte.endText();
        }
        else if(field.contentEquals("alamat")) {
            pageContentByte.beginText();
            pageContentByte.setFontAndSize(baseFont, 10);
            pageContentByte.setTextMatrix(115, 648);
            pageContentByte.showText(value.toString());
            pageContentByte.endText();
        }
    }

    public Resource downloadFormLab(PoliHIV data) {
        try {
            //Create PdfReader instance.

            PdfReader pdfReader =
                    new PdfReader(resourceLoader.getResource("classpath:formlab.pdf").getInputStream());


            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            //Create PdfStamper instance.
            PdfStamper pdfStamper = new PdfStamper(pdfReader, byteArrayOutputStream);

            //Get the number of pages in pdf.
            int pages = pdfReader.getNumberOfPages();

            // Set text
            if(!StringUtils.isEmpty(data.getNoRegister())) {
                setTextFormLab("noRekamMedis", data.getNoRekamMedis(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getCreatedDate())) {
                setTextFormLab("createdDate", data.getCreatedDate(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getNama())) {
                setTextFormLab("nama", data.getNama(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getAlamat())) {
                setTextFormLab("alamat", data.getAlamat(), pdfStamper);
            }
            if(!StringUtils.isEmpty(data.getTanggalLahir())) {
                setTextFormLab("tanggalLahir", data.getTanggalLahir(), pdfStamper);
            }
            //Close the pdfStamper.
            pdfStamper.close();

            System.out.println("PDF modified successfully.");
            return new ByteArrayResource(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
