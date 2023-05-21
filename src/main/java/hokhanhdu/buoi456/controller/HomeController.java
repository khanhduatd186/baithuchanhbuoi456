package hokhanhdu.buoi456.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home(){
        return "home/index";
    }
    @GetMapping("/contact")
    public String contact(){return "home/contact";}
//    @GetMapping("/contact")
//    public String showContactForm(Model model) {
//        model.addAttribute("contact", new Contact());
//        return "home/contact";
//    }
//    @PostMapping("/contact")
//    public String submitContactForm(@ModelAttribute("contact") Contact contact, Model model) {
//        // Thêm đối tượng Contact vào Model để truyền dữ liệu sang trang result
//        model.addAttribute("contact", contact);
//        return "home/result";
//    }
}
