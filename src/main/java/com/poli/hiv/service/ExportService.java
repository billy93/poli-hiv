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
        fieldCoordinateHashMap.put("statusKlien", statusKlien);

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
                    image.setAbsolutePosition(356, 282);
                    image.setWidthPercentage(1);
                } else if(value.toString().contentEquals("Lama")){
                    pageContentByte.setFontAndSize(baseFont, fieldCoordinate.getFontSize());
                    image.setAbsolutePosition(400, 282);
                    image.setWidthPercentage(1);
                }

                pageContentByte.addImage(image);
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
