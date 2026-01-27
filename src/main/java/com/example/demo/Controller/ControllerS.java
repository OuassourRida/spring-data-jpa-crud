package com.example.demo.Controller;

import com.example.demo.Entity.Produit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produits")
public class ControllerS {
    @GetMapping("/{test}")
    public Produit produitcontroller (@PathVariable String test){
        return new Produit("test",100.0,true,null,"testcat");
    }
}
