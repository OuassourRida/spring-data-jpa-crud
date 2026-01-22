package com.example.demo.Dao;

import com.example.demo.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface produitDao extends JpaRepository<Produit,Long> {
    List<Produit> findByName(String name);
    List<Produit> findByNameAndDisponible(String nam ,boolean disponible);
    List<Produit> findByPriceGreaterThan(Double price);
    // Exemple de requête JPQL personnalisée
    @Query("select p from Produit p where p.price > :minprice ")
    List<Produit> fifi(double minprice);
    @Query("select p from Produit p where YEAR(p.date)= :year AND MONTH(p.date)= :month ")
    List<Produit> findProduitsByYearAndMonth(int year, int month);
}
