package com.poli.hiv.controller;

import com.poli.hiv.model.PoliHIV;
import com.poli.hiv.repository.PoliHIVRepository;
import com.poli.hiv.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class PoliHIVController {

    @Autowired
    private PoliHIVRepository poliHIVRepository;
    @Autowired
    private ExportService exportService;

    @GetMapping("/poli-hiv/export/{id}")
    public ResponseEntity<Resource> exportPoli(@PathVariable Long id) throws IOException {
        PoliHIV poliHIV = poliHIVRepository.findById(id).get();

        Resource file = exportService.exportPoli(poliHIV);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String filename = "PoliHIV_"+poliHIV.getNama()+"_"+sdf.format(new Date())+".pdf";
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\""+filename+"\"")
//                .contentType(MediaType.parseMediaType("application/pdf"))
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(file.contentLength())
                .body(file);
    }

    @GetMapping("/poli-hiv/download/{id}")
    public ResponseEntity<Resource> downloadFormLab(@PathVariable Long id) throws IOException {
        PoliHIV poliHIV = poliHIVRepository.findById(id).get();

        Resource file = exportService.downloadFormLab(poliHIV);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String filename = "FormLab_"+poliHIV.getNama()+"_"+sdf.format(new Date())+".pdf";
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\""+filename+"\"")
//                .contentType(MediaType.parseMediaType("application/pdf"))
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(file.contentLength())
                .body(file);
    }

    @GetMapping("/poli-hiv/form")
    public String index(Model model){
        model.addAttribute("form", new PoliHIV());
        return "poli-hiv/poli-hiv";
    }

    @GetMapping("/poli-hiv/edit/{id}")
    public String edit(Model model, @PathVariable Long id){
        Optional<PoliHIV> data = poliHIVRepository.findById(id);
        model.addAttribute("form", data.get());
        return "poli-hiv/poli-hiv";
    }

    @PostMapping("/poli-hiv/form")
    public String index(Model model, @ModelAttribute PoliHIV poliHIV){
        if(poliHIV.getId() != null){
            Optional<PoliHIV> poliHIV1 = poliHIVRepository.findById(poliHIV.getId());
            poliHIV.setCreatedDate(poliHIV1.get().getCreatedDate());
        }
        else {
            poliHIV.setCreatedDate(Instant.now());
        }
        poliHIVRepository.save(poliHIV);
        return "redirect:/poli-hiv/list";
    }

    @GetMapping("/poli-hiv/list")
    public String list(Model model){
        List<PoliHIV> data = poliHIVRepository.findAll();
        model.addAttribute("data", data);
        return "poli-hiv/list";
    }

    @GetMapping("/poli-hiv/delete/{id}")
    public String delete(Model model, @PathVariable Long id){
        poliHIVRepository.deleteById(id);
        return "redirect:/poli-hiv/list";
    }

    @GetMapping("/poli-hiv/view")
    public String view(){
        return "poli-hiv/view";
    }

    public static class ViewPoliHIVForm{
        public String noRegister;

        public String getNoRegister() {
            return noRegister;
        }

        public void setNoRegister(String noRegister) {
            this.noRegister = noRegister;
        }
    }

    @PostMapping("/poli-hiv/view")
    public String viewPoliHiv(@ModelAttribute ViewPoliHIVForm viewPoliHIVForm){
        return "redirect:/poli-hiv/edit/"+viewPoliHIVForm.getNoRegister();
    }
}
