package com.gct.tp3.controllers;

import com.gct.tp3.forms.ClientForm;
import com.gct.tp3.forms.EmpruntLivreForm;
import com.gct.tp3.forms.LivreForm;
import com.gct.tp3.modele.Client;
import com.gct.tp3.modele.Emprunt;
import com.gct.tp3.modele.Livre;
import com.gct.tp3.service.BiblioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BiblioController {
    Logger logger = LoggerFactory.getLogger(BiblioController.class);

    private BiblioService service;

    public BiblioController(BiblioService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getRootRequest(Model model) {
        model.addAttribute("pageTitle", "Biblio");
        model.addAttribute("h1Text", "Biblio JavaTown");
        return "index";
    }

    @GetMapping("/clientcreate")
    public String getClientCreate(@ModelAttribute ClientForm clientForm,
                                  Model model,
                                  RedirectAttributes redirectAttributes) {
        clientForm = new ClientForm(new Client());
        model.addAttribute("clientForm", clientForm);
        return "clientedit";
    }

    @PostMapping("/clientcreate")
    public String clientPost(@ModelAttribute ClientForm clientForm,
                             BindingResult errors,
                             Model model,
                             RedirectAttributes redirectAttributes) {
        logger.info("client: " + clientForm);
        service.saveClient(clientForm.toClient());
        redirectAttributes.addFlashAttribute("clientForm", clientForm);
        model.addAttribute("pageTitle", "Client");
        model.addAttribute("clientForm", clientForm);
        return "redirect:clientedit/" + clientForm.getId();
    }

    @GetMapping("/livrecreate")
    public String getLivreCreate(@ModelAttribute LivreForm livreForm,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        livreForm = new LivreForm(new Livre());
        model.addAttribute("livreForm", livreForm);
        return "livreedit";
    }

    @PostMapping("/livrecreate")
    public String livrePost(@ModelAttribute LivreForm livreForm,
                            BindingResult errors,
                            Model model,
                            RedirectAttributes redirectAttributes) {
        logger.info("livre: " + livreForm);
        service.saveLivre(livreForm.toLivre());
        redirectAttributes.addFlashAttribute("livreForm", livreForm);
        model.addAttribute("pageTitle", "Livre");
        model.addAttribute("livreForm", livreForm);
        return "redirect:livreedit/" + livreForm.getId();
    }

    /*@GetMapping("/empruntcreate")
    public String getEmpruntCreate(@ModelAttribute EmpruntLivreForm empruntLivreForm,
                                   Model model,
                                   RedirectAttributes redirectAttributes) {
        empruntLivreForm = new EmpruntLivreForm(new Emprunt());
        model.addAttribute("empruntLivreForm", empruntLivreForm);
        return "empruntedit";
    }

    @PostMapping("/empruntcreate")
    public String empruntLivrePost(@ModelAttribute EmpruntLivreForm empruntLivreForm,
                                   BindingResult errors,
                                   Model model,
                                   RedirectAttributes redirectAttributes) {
        logger.info(("emprunt: " + empruntLivreForm));
        service.saveEmprunt(empruntLivreForm.toEmprunt());
        redirectAttributes.addFlashAttribute("empruntLivreForm", empruntLivreForm);
        model.addAttribute("pageTitle", "Emprunt Livre");
        model.addAttribute("empruntLivreForm", empruntLivreForm);
        return "redirect:empruntedit/" + empruntLivreForm.getId();
    }*/
}
