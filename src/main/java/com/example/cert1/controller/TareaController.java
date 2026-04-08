package com.example.cert1.controller;

import com.example.cert1.model.Tarea;
import com.example.cert1.service.TareaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public ResponseEntity<List<Tarea>> listarTareas() {
        return ResponseEntity.ok(tareaService.getTareas());
    }

    @GetMapping("{id}")
    public ResponseEntity<Tarea> buscarTarea(@PathVariable int id) {
        return ResponseEntity.ok(tareaService.getTareaPorId(id));
    }

    @GetMapping("/activas")
    public ResponseEntity<List<Tarea>> listarActivas() {
        return ResponseEntity.ok(tareaService.getTareasActivas());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Tarea>> listarPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(tareaService.getTareasPorEstado(estado));
    }

    @GetMapping("/prioridad/{prioridad}")
    public ResponseEntity<List<Tarea>> listarPorPrioridad(@PathVariable String prioridad) {
        return ResponseEntity.ok(tareaService.getTareasPorPrioridad(prioridad));
    }

    @GetMapping("/responsable/{responsable}")
    public ResponseEntity<List<Tarea>> listarPorResponsable(@PathVariable String responsable) {
        return ResponseEntity.ok(tareaService.getTareasPorResponsable(responsable));
    }

    @GetMapping("/total")
    public ResponseEntity<Integer> totalTareas() {
        return ResponseEntity.ok(tareaService.totalTareas());
    }

    @PostMapping
    public ResponseEntity<Tarea> agregarTarea(@Valid @RequestBody Tarea tarea) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaService.saveTarea(tarea));
    }

    @PutMapping("{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable int id, @Valid @RequestBody Tarea tarea) {
        return ResponseEntity.ok(tareaService.updateTarea(id, tarea));
    }

    @PutMapping("{id}/estado")
    public ResponseEntity<Tarea> cambiarEstado(@PathVariable int id, @RequestBody Map<String, String> body) {
        return ResponseEntity.ok(tareaService.cambiarEstado(id, body.get("estado")));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable int id) {
        tareaService.deleteTarea(id);
        return ResponseEntity.noContent().build();
    }
}