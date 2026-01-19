package com.example.demo;

import com.example.demo.Dao.produitDao;
import com.example.demo.Entity.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
// Démarrer le conteneur IoC de Spring Boot
      ApplicationContext ioc= SpringApplication.run(DemoApplication.class, args);
        // Récupérer le bean produitDao depuis le conteneur IoC
        produitDao prodao = ioc.getBean(produitDao.class);
        // save()
        Produit p =new Produit("Rio",500.0);
        Produit pp =new Produit("Youssef",50.0);
        prodao.save(p);
        prodao.save(pp);
        // findById()
        Produit pr = prodao.findById(1L).get();
        System.out.println(pr.toString());
        // findAll()
        List<Produit> produits = prodao.findAll();
        for (Produit pro : produits){
            System.out.println(pro.toString());
        }
	}

}
