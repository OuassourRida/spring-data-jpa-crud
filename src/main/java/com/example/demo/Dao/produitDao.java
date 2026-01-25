package com.example.demo.Dao;

import com.example.demo.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface produitDao extends JpaRepository<Produit,Long> {
    List<Produit> findByName(String name);
    List<Produit> findByNameAndDisponible(String nam ,boolean disponible);
    List<Produit> findByPriceGreaterThan(Double price);
    Produit findByRef(String ref);
    // Exemple de requête JPQL personnalisée
    @Query("select p from Produit p where p.price > :minprice ")
    List<Produit> fifi(double minprice);
    @Query("select p from Produit p where YEAR(p.date)= :year AND MONTH(p.date)= :month ")
    List<Produit> findProduitsByYearAndMonth(int year, int month);
    @Query("select p.categorie,AVG(p.price) from Produit p group by p.categorie")
    List<Object[]> findAveragePriceByCategorie();
    //QUERY without jpql just sql
    @Query(value="select * from produit  where DATE_FORMAT(date,'%Y-%m')= :yearmonth  ", nativeQuery = true)
    List<Produit> findProduitsByYearAndMonth2(String yearmonth);
}
