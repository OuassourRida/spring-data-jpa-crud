package com.example.demo.Dao;

import com.example.demo.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface produitDao extends JpaRepository<Produit,Long> {

}
