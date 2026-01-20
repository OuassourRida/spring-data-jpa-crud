package com.example.demo.Dao;

import com.example.demo.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface produitDao extends JpaRepository<Produit,Long> {
    List<Produit> findByName(String name);
    List<Produit> findByNameAndDisponible(String nam ,boolean disponible);
    List<Produit> findByPriceGreaterThan(Double price);
}
