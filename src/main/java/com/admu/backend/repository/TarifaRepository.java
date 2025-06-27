package com.admu.backend.repository;

import com.admu.backend.entity.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
    
    // Buscar tarifas por tipo (general, estudiantes, etc.)
    List<Tarifa> findByTipo(String tipo);
    
    // Buscar tarifas por nombre de compañía
    List<Tarifa> findByNombreCompania(String nombreCompania);
    
    // Buscar tarifas por ruta
    List<Tarifa> findByRuta(String ruta);
    
    // Buscar tarifas por compañía y ruta
    List<Tarifa> findByNombreCompaniaAndRuta(String nombreCompania, String ruta);
    
    // Consulta personalizada para buscar tarifas por tipo y compañía
    @Query("SELECT t FROM Tarifa t WHERE t.tipo = :tipo AND t.nombreCompania = :nombreCompania")
    List<Tarifa> findByTipoAndCompania(@Param("tipo") String tipo, @Param("nombreCompania") String nombreCompania);
}

