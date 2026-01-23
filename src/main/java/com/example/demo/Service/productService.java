package com.example.demo.Service;

import com.example.demo.Dao.produitDao;
import com.example.demo.Entity.Produit;
import org.springframework.stereotype.Service;

@Service
public class productService {
private final produitDao prodao;
public productService(produitDao prodao) {
    this.prodao = prodao;
}
    public int save(Produit p){
    if(p.getPrice()==0 || p.getName()==""){
        return 1;
    }
    else {
        prodao.save(p);
        return 0;}



    }
}
