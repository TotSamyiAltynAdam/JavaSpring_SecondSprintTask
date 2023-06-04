package kz.springboot.secondSprintTask.controllers;

import kz.springboot.secondSprintTask.entities.ApplicationRequest;
import kz.springboot.secondSprintTask.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private ApplicationService applicationService;

    @GetMapping(value="/")
    public String index(Model model){
        List<ApplicationRequest> applications = applicationService.getAllApplications();
        model.addAttribute("applications",applications);
        return "index";
    }

    @GetMapping(value="/newAppliationsPage")
    public String newApplicationsPage(Model model){
        List<ApplicationRequest> applications = applicationService.getAllApplicationsByHandledIsFalse();
        model.addAttribute("applications",applications);
        return "index";
    }

    @GetMapping(value="/handledApplicationsPage")
    public String handledApplicationsPage(Model model){
        List<ApplicationRequest> applications = applicationService.getAllApplicationsByHandledIsTrue();
        model.addAttribute("applications",applications);
        return "index";
    }

    @GetMapping(value="/addApplicationPage")
    public String addApplicationPage(){
        return "addApplicationPage";
    }

    @GetMapping(value="/details/{id}")
    public String details(Model model, @PathVariable(name="id") Long id){
        ApplicationRequest application = applicationService.getApplication(id);
        model.addAttribute("detailedApplication",application);
        return "details";
    }

    @PostMapping(value="/addApplication")
    public String addApplication(@RequestParam(name="fullName", defaultValue = "No Name") String fullName,
                                 @RequestParam(name="course", defaultValue = "No course") String course,
                                 @RequestParam(name="phone", defaultValue = "0") String phoneNumber,
                                 @RequestParam(name="commentary", defaultValue = "No comment") String commentary){
        applicationService.addApplication(new ApplicationRequest(null,fullName,course,commentary,phoneNumber,false));
        return "redirect:/";
    }
    @PostMapping(value="/saveApplication")
    public String saveApplication(@RequestParam(name="id") Long id){
        ApplicationRequest application = applicationService.getApplication(id);
        if(application!=null) {
            application.setHandled(true);
            applicationService.saveApplication(application);
        }
        return "redirect:/";
    }
    @PostMapping(value="/deleteApplication")
    public String deleteApplication(@RequestParam(name="id", defaultValue = "0") Long id){
        System.out.println();
        System.out.println();
        System.out.println("afnenfjenfjenfjenfkenefnekfe");
        System.out.println();
        System.out.println();
        ApplicationRequest application = applicationService.getApplication(id);
        if(application!=null) {
            applicationService.deleteApplication(application);
        }
        return "redirect:/";
    }

}
