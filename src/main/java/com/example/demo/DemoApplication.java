package com.example.demo;

import com.example.demo.Dao.produitDao;
import com.example.demo.Entity.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
// Démarrer le conteneur IoC de Spring Boot
      ApplicationContext ioc= SpringApplication.run(DemoApplication.class, args);
        // Récupérer le bean produitDao depuis le conteneur IoC
        produitDao prodao = ioc.getBean(produitDao.class);
        // save()
        Produit p =new Produit("Rio",500.0,true, LocalDate.now());
        Produit pp =new Produit("Youssef",5000.0,false,LocalDate.of(2023,5,20));
        Produit ppp =new Produit("hamza",50.0,true,LocalDate.of(2026,1,15));
        prodao.save(p);
        prodao.save(pp);
        prodao.save(ppp);
        // findById()
        try{
        Produit pr = prodao.findById(1L).get();
        System.out.println(pr.toString());}
        catch (NoSuchElementException e){
            System.out.println("Produit avec id 1 n'existe pas.");
        }
        // findAll()
        List<Produit> produits = prodao.findAll();
        for (Produit pro : produits){
            System.out.println(pro.toString());
        }
        // deleteById()
//        try{
//        prodao.deleteById(2L);
//        System.out.println("Produit avec id 2 supprimé.");}
//        catch (NoSuchElementException e){
//            System.out.println("Produit avec id 2 n'existe pas.");
//        }

        // findAll() après suppression
        List<Produit> produitsAfterDeletion = prodao.findAll();
        for (Produit pro : produitsAfterDeletion){
            System.out.println(pro.toString());
        }
        //delete()
//        try{
//        Produit produitToDelete = prodao.findById(1L).get();
//        prodao.delete(produitToDelete);
//        System.out.println("Produit avec id 1 supprimé.");}
//        catch (NoSuchElementException e){
//            System.out.println("Produit avec id 1 n'existe pas.");
//        }
        // count()
        Long number =prodao.count();
        System.out.println("Nombre total des produits: "+number);
        //existsById()
        boolean exists = prodao.existsById(52L);
        System.out.println("Produit avec id 52 existe: "+exists);
//findByName()

        List<Produit> produitsByName = prodao.findByName("hamza");
        for (Produit pro : produitsByName) {
            System.out.println(pro.toString());
        }
        //findByNameAndDisponible()

        List<Produit> produitsByNameAndDisponible = prodao.findByNameAndDisponible("hamza", true);
        for (Produit pro : produitsByNameAndDisponible) {
            System.out.println(pro.toString());}
        //findByPriceGreaterThan()
        System.out.println("Produits avec prix > 100.0:");
        List<Produit> produitsByPriceGreaterThan = prodao.findByPriceGreaterThan(100.0);
        for(Produit pro : produitsByPriceGreaterThan){
            System.out.println(pro.toString());
        }

        //Querry Methods
        List<Produit> produitsQuery = prodao.fifi(100.0);
        System.out.println("Produits avec prix > 100.0 (via Query):");
        for(Produit pro : produitsQuery){
            System.out.println(pro.toString());
        }
//Querry Methods
        List<Produit> produitsQ = prodao.findProduitsByYearAndMonth(2026,1);
        System.out.println("Produits ajoutés en Janvier 2026:");
        for(Produit pro : produitsQ){
            System.out.println(pro.toString());}




    }

}
