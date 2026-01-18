package com.example.demo;

import com.example.demo.Dao.produitDao;
import com.example.demo.Entity.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

      ApplicationContext ioc= SpringApplication.run(DemoApplication.class, args);
        produitDao prodao = ioc.getBean(produitDao.class);
        Produit p =new Produit("Rio",500.0);
        prodao.save(p);
        Produit pr = prodao.findById(1L).get();
        System.out.println("my name is "+ pr.getName());
	}

}
