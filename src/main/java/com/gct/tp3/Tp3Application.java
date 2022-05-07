package com.gct.tp3;

import com.gct.tp3.modele.*;
import com.gct.tp3.service.BiblioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Tp3Application implements CommandLineRunner {

    @Autowired
    private BiblioService service;

    public static void main(String[] args) {
        SpringApplication.run(Tp3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        final Client client1 = service.saveClient("Gabriel", "Caron-Tawil", "GCT",
                "password", "gct@gmail.com",
                "(514) 704-1694", "Alexis-Carrel", "J6K 4L5", "104");
        final Client client2 = service.saveClient("Michael", "Caron-Tawil", "MCT",
                "password", "mct@gmail.com",
                "(514) 704-1694", "Alexis-Carrel", "J6K 4L5", "104");

        final Livre livre1 = service.saveLivre("Math 101", "Paul Laroche", 1999, "Roman", 2, "Éditions Soleil");

        final Livre livre2 = service.saveLivre("Le Lion", "Denis Tremblay", 2007, "Roman", 3, "Éditions Lune");

        final Dvd dvd1 = service.saveDvd("Star Wars 1", "George Lucas", 2000, "Science-fiction", 4, "2h00", "Science-Fiction");

        final Cd cd1 = service.saveCd("Discovery", "Daft Punk", 2001, "Electronique", 1, "1h01", "Warner Music France");

        System.out.println(service.findByAuteur("Paul Laroche"));
        System.out.println(service.findByAnnee(2001));
        System.out.println(service.findByTitre("Math 101"));
        System.out.println(service.findByTitre("Star"));
        System.out.println(service.findByCategorie("Roman"));

        service.emprunterDocument(client1, livre1);
        service.emprunterDocument(client1, dvd1);
        service.emprunterDocument(client1, cd1);

        final Emprunt emprunt3 = client1.getEmprunts().get(2);
        service.retournerDocument(emprunt3);

        System.out.println(service.getAllEmpruntsOfClient(1L));
    }
}
