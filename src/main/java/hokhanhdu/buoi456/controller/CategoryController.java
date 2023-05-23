package hokhanhdu.buoi456.controller;

import hokhanhdu.buoi456.entity.Book;
import hokhanhdu.buoi456.entity.Category;
import hokhanhdu.buoi456.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public String showAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        return "category/list";
    }
    @GetMapping("/add")
    public String addCategoryForm(Model model) {

        model.addAttribute("category", new Category());
        return "category/add";
    }

    @GetMapping("/edit/{id}")
    public String EditCategoryFrom(@PathVariable("id") Long id , Model model){
        Category editCategory = null;
        for(Category category : categoryService.getAllCategories()){
            if(category.getId().equals(id)){
                editCategory = category;
            }
        }
        if(editCategory !=null ){
            model.addAttribute("category",editCategory);

            return  "category/edit";
        }
        else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editCategory(@Valid @ModelAttribute("category")Category updateCategory, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){

            return "category/edit";
        }
        categoryService.getAllCategories().stream()
                .filter(book -> book.getId() == updateCategory.getId())
                .findFirst()
                .ifPresent(book -> {
                    categoryService.saveCateogry(updateCategory);
                });
        return "redirect:/categories";
    }
    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            //model.addAttribute("book", new Book());
            model.addAttribute("categories", categoryService.getAllCategories());
            return "category/add";
        }
        categoryService.addCategory(category);
        return "redirect:/categories";
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") long id){
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}
