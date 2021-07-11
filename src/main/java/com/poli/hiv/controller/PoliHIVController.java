package com.poli.hiv.controller;

import com.poli.hiv.model.PoliHIV;
import com.poli.hiv.model.dto.SearchPoliHIVListDTO;
import com.poli.hiv.model.dto.SearchPoliHIVListNonOptionalDTO;
import com.poli.hiv.repository.PoliHIVRepository;
import com.poli.hiv.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public String index(Model model, @ModelAttribute PoliHIV poliHIV, RedirectAttributes redirectAttributes){
        if(poliHIV.getId() != null){
            Optional<PoliHIV> poliHIV1 = poliHIVRepository.findById(poliHIV.getId());
            poliHIV.setCreatedDate(poliHIV1.get().getCreatedDate());
            poliHIVRepository.save(poliHIV);
        }
        else {
            poliHIV.setCreatedDate(Instant.now());
        }
        poliHIVRepository.save(poliHIV);

        // redirect to list if admin
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            return "redirect:/poli-hiv/list";
        }
        else{
            redirectAttributes.addFlashAttribute("registerId", poliHIV.getId());
            return "redirect:/poli-hiv/view";
        }
        // redirect to view if user
    }

    @PostMapping("/poli-hiv/list")
    public String listSearch(SearchPoliHIVListDTO searchPoliHivListDTO, Model model){
        return list(searchPoliHivListDTO, model);
    }

    @GetMapping("/poli-hiv/list")
    public String list(SearchPoliHIVListDTO searchPoliHivListDTO, Model model){
//        List<PoliHIV> data = poliHIVRepository.findAll(sort);
//        model.addAttribute("data", data);

        Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
        Pageable page = PageRequest.of(searchPoliHivListDTO.getPage().get(), searchPoliHivListDTO.getSize().get(), sort);
        Page<PoliHIV> poliHIVPage = poliHIVRepository.findAll(page);
        List<PoliHIV> data = poliHIVPage.getContent();
        model.addAttribute("data", data);

        SearchPoliHIVListNonOptionalDTO searchPoliHivListNonOptionalDTO = new SearchPoliHIVListNonOptionalDTO();
        searchPoliHivListNonOptionalDTO.setPage(searchPoliHivListDTO.getPage().get());
        model.addAttribute("searchParam", searchPoliHivListNonOptionalDTO);

        int totalData = Integer.parseInt((poliHIVPage.getTotalElements())+"");

        int currentPage = searchPoliHivListDTO.getPage().get();
        int max = 5;
        double total = totalData;
        double size = searchPoliHivListDTO.getSize().get();
        int totalPages = (int)Math.ceil(total/size);
        if (totalPages > 0) {
            List<Integer> pageNumbers = new ArrayList<Integer>();
            int cPage = currentPage+1;
            if(cPage-2 > 0 && totalPages > max) {
                int startPage = ((cPage+2) > totalPages ? (cPage+1) > totalPages ? (cPage-4) : (cPage-3) : (cPage-2));
                int endPage = ((cPage+2) > totalPages ? totalPages : (cPage+2));
                for(int i=startPage; i<=endPage; i++) {
                    pageNumbers.add(i);
                }
            }
            else {
                pageNumbers.addAll(IntStream.rangeClosed(1, totalPages > max ? max : totalPages).boxed().collect(Collectors.toList()));
            }
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalData", totalData);

        int itemPerPage = 10;
        int to =  ((searchPoliHivListDTO.getPage().get()+1) * itemPerPage) > totalData ? totalData : ((searchPoliHivListDTO.getPage().get()+1) * itemPerPage);
        int from = ((searchPoliHivListDTO.getPage().get()) * itemPerPage + 1);
        String showingData = from + "-" + to;
        model.addAttribute("showingData", showingData);
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
