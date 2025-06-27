package com.admu.backend.controller;

import com.admu.backend.entity.Tarifa;
import com.admu.backend.service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tarifas")
@CrossOrigin(origins = "*")
public class TarifaController {
    
    @Autowired
    private TarifaService tarifaService;
    
    // GET /api/tarifas - Obtener todas las tarifas
    @GetMapping
    public ResponseEntity<List<Tarifa>> obtenerTodasLasTarifas() {
        List<Tarifa> tarifas = tarifaService.obtenerTodasLasTarifas();
        return ResponseEntity.ok(tarifas);
    }
    
    // GET /api/tarifas/{id} - Obtener tarifa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarifa> obtenerTarifaPorId(@PathVariable Long id) {
        Optional<Tarifa> tarifa = tarifaService.obtenerTarifaPorId(id);
        return tarifa.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
    
    // GET /api/tarifas/tipo/{tipo} - Obtener tarifas por tipo
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Tarifa>> obtenerTarifasPorTipo(@PathVariable String tipo) {
        List<Tarifa> tarifas = tarifaService.obtenerTarifasPorTipo(tipo);
        return ResponseEntity.ok(tarifas);
    }
    
    // GET /api/tarifas/compania/{nombreCompania} - Obtener tarifas por compañía
    @GetMapping("/compania/{nombreCompania}")
    public ResponseEntity<List<Tarifa>> obtenerTarifasPorCompania(@PathVariable String nombreCompania) {
        List<Tarifa> tarifas = tarifaService.obtenerTarifasPorCompania(nombreCompania);
        return ResponseEntity.ok(tarifas);
    }
    
    // GET /api/tarifas/ruta/{ruta} - Obtener tarifas por ruta
    @GetMapping("/ruta/{ruta}")
    public ResponseEntity<List<Tarifa>> obtenerTarifasPorRuta(@PathVariable String ruta) {
        List<Tarifa> tarifas = tarifaService.obtenerTarifasPorRuta(ruta);
        return ResponseEntity.ok(tarifas);
    }
    
    // POST /api/tarifas - Crear nueva tarifa
    @PostMapping
    public ResponseEntity<Tarifa> crearTarifa(@RequestBody Tarifa tarifa) {
        try {
            Tarifa nuevaTarifa = tarifaService.crearTarifa(tarifa);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTarifa);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    // PUT /api/tarifas/{id} - Actualizar tarifa
    @PutMapping("/{id}")
    public ResponseEntity<Tarifa> actualizarTarifa(@PathVariable Long id, @RequestBody Tarifa tarifa) {
        Tarifa tarifaActualizada = tarifaService.actualizarTarifa(id, tarifa);
        if (tarifaActualizada != null) {
            return ResponseEntity.ok(tarifaActualizada);
        }
        return ResponseEntity.notFound().build();
    }
    
    // DELETE /api/tarifas/{id} - Eliminar tarifa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarifa(@PathVariable Long id) {
        boolean eliminada = tarifaService.eliminarTarifa(id);
        if (eliminada) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    // POST /api/tarifas/inicializar - Inicializar datos por defecto
    @PostMapping("/inicializar")
    public ResponseEntity<String> inicializarTarifas() {
        tarifaService.inicializarTarifas();
        return ResponseEntity.ok("Tarifas inicializadas correctamente");
    }
}

