package com.example.demo.Service;

import com.example.demo.Dao.produitDao;
import com.example.demo.Entity.Produit;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return 0;}}
    public int findAllProduits(){
            List<Produit> pr= prodao.findAll();
            if (pr.isEmpty()){
                return 1;
            }
            else {
                for (Produit produit : pr) {
                    System.out.println(produit.toString());
                }
                return 0;
            }

        }
public int  findByName (String name ){
    if(name.isEmpty() || name==null){
        throw new RuntimeException("Le nom du produit ne peut pas être vide.");

    }
    else {
         List <Produit>pro=prodao.findByName(name);
            if (pro.isEmpty()){
             throw new IllegalArgumentException("Aucun produit trouvé avec le nom spécifié.");
            }
            else {
                for (Produit produit : pro) {
                    System.out.println(produit.toString());
                }
                return 0;
    }

}
}

    }

