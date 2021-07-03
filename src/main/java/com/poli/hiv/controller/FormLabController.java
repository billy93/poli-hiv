package com.poli.hiv.controller;

import com.poli.hiv.model.FormLab;
import com.poli.hiv.repository.FormLabRepository;
import com.poli.hiv.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
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
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class FormLabController {
    @Autowired
    private FormLabRepository formLabRepository;
    @Autowired
    private ExportService exportService;

    @GetMapping("/form-lab/export/{id}")
    public ResponseEntity<Resource> exportPoli(@PathVariable Long id) throws IOException {
        FormLab formLab = formLabRepository.findById(id).get();

        return null;
//        Resource file = exportService.exportFormLab(formLab);

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        String filename = "FormLab_"+formLab.getNama()+"_"+sdf.format(new Date())+".pdf";
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION,
//                        "attachment; filename=\""+filename+"\"")
////                .contentType(MediaType.parseMediaType("application/pdf"))
//                .contentType(MediaType.APPLICATION_PDF)
//                .contentLength(file.contentLength())
//                .body(file);
    }

    @GetMapping("/form-lab/form")
    public String index(Model model){
        model.addAttribute("form", new FormLab());
        return "form-lab/form-lab";
    }

    @GetMapping("/form-lab/edit/{id}")
    public String edit(Model model, @PathVariable Long id){
        Optional<FormLab> data = formLabRepository.findById(id);
        model.addAttribute("form", data.get());
        return "form-lab/form-lab";
    }

    @PostMapping("/form-lab/form")
    public String index(Model model, @ModelAttribute FormLab formLab){
        formLabRepository.save(formLab);
        return "redirect:/form-lab/list";
    }

    @GetMapping("/form-lab/list")
    public String list(Model model){
        List<FormLab> data = formLabRepository.findAll();
        model.addAttribute("data", data);
        return "form-lab/list";
    }

    @GetMapping("/form-lab/delete/{id}")
    public String delete(Model model, @PathVariable Long id){
        formLabRepository.deleteById(id);
        return "redirect:/form-lab/list";
    }
}
