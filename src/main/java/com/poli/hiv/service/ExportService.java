package com.poli.hiv.service;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.poli.hiv.model.FieldData;
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

    public ExportService(){
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
        }
    }
}
