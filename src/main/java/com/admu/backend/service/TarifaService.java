package com.admu.backend.service;

import com.admu.backend.entity.Tarifa;
import com.admu.backend.repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarifaService {
    
    @Autowired
    private TarifaRepository tarifaRepository;
    
    // Obtener todas las tarifas
    public List<Tarifa> obtenerTodasLasTarifas() {
        return tarifaRepository.findAll();
    }
    
    // Obtener tarifa por ID
    public Optional<Tarifa> obtenerTarifaPorId(Long id) {
        return tarifaRepository.findById(id);
    }
    
    // Obtener tarifas por tipo
    public List<Tarifa> obtenerTarifasPorTipo(String tipo) {
        return tarifaRepository.findByTipo(tipo);
    }
    
    // Obtener tarifas por compañía
    public List<Tarifa> obtenerTarifasPorCompania(String nombreCompania) {
        return tarifaRepository.findByNombreCompania(nombreCompania);
    }
    
    // Obtener tarifas por ruta
    public List<Tarifa> obtenerTarifasPorRuta(String ruta) {
        return tarifaRepository.findByRuta(ruta);
    }
    
    // Crear nueva tarifa
    public Tarifa crearTarifa(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }
    
    // Actualizar tarifa
    public Tarifa actualizarTarifa(Long id, Tarifa tarifaActualizada) {
        Optional<Tarifa> tarifaExistente = tarifaRepository.findById(id);
        if (tarifaExistente.isPresent()) {
            Tarifa tarifa = tarifaExistente.get();
            tarifa.setNombreCompania(tarifaActualizada.getNombreCompania());
            tarifa.setRuta(tarifaActualizada.getRuta());
            tarifa.setTarifa(tarifaActualizada.getTarifa());
            tarifa.setTipo(tarifaActualizada.getTipo());
            tarifa.setCondicion(tarifaActualizada.getCondicion());
            tarifa.setDescripcion(tarifaActualizada.getDescripcion());
            return tarifaRepository.save(tarifa);
        }
        return null;
    }
    
    // Eliminar tarifa
    public boolean eliminarTarifa(Long id) {
        if (tarifaRepository.existsById(id)) {
            tarifaRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Inicializar datos de tarifas por defecto
    public void inicializarTarifas() {
        if (tarifaRepository.count() == 0) {
            // Crear tarifas basadas en los datos extraídos del ChatBot
            Tarifa tarifaGeneral = new Tarifa("ADMU", "Sistema General", "$2,900 pesos", "general", null, "Tarifa general del sistema ADMU");
            Tarifa tarifaEstudiantes = new Tarifa("ADMU", "Sistema General", "$1,800 pesos", "estudiantes", "con carné", "Tarifa especial para estudiantes con carné");
            
            tarifaRepository.save(tarifaGeneral);
            tarifaRepository.save(tarifaEstudiantes);
        }
    }
}

