package QLSV.Lab03QLSV.controller;

import QLSV.Lab03QLSV.entity.Lop;
import QLSV.Lab03QLSV.repository.ILopRepository;
import QLSV.Lab03QLSV.service.LopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/add")
public class LopController {

    @Autowired
    private LopService lopService;

    @GetMapping
    public String showAlllop(Model model) {
        List<Lop> dsLop = lopService.getAllLop();
        model.addAttribute("dslop",dsLop);
        return "list";
    }

    @GetMapping("/add")
    public String showAddFrom(Model model) {
        model.addAttribute("lop", new Lop());
        return "add";
    }
    @PostMapping ("/add")
    public String AddLop(@ModelAttribute("lop") Lop lop) {
        lopService.addLop(lop);
        return "redirect:/";
    }
    @GetMapping("/add/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Lop lop = LopService.getAllLop(id)
                .orElseThrow(() -> new IllegalArgumentException("Id danh mục không hợp lệ"
                        + id));
        model.addAttribute("Lop", lop);
        return "/add/update-category";
    }

    @PostMapping("/add/update/{id}")
    public String updateLop(@PathVariable("id") Long id, @Valid Lop lop,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            lop.setMaLop(lop.getMaLop());
            lop.setTenLop(lop.getTenLop());
            return "/add/update";
        }
        LopService.updateLop(lop);
        model.addAttribute("categories", LopService.getAllLop());
        return "redirect:/";
    }
    // GET request for deleting category
    @GetMapping("/categories/delete/{id}")
    public String deleteLop(@PathVariable("id") Long id, Model model) {
        Lop lop = LopService.getAllLop(id)
                .orElseThrow(() -> new IllegalArgumentException("Id danh mục không hợp lệ:"
                        + id));
        LopService.deleteLop(id);
        model.addAttribute("lop", LopService.getAllLop());
        return "redirect:";
    }
}
