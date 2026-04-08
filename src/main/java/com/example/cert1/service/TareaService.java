package com.example.cert1.service;

import com.example.cert1.exception.TareaNotFoundException;
import com.example.cert1.model.Tarea;
import com.example.cert1.repository.TareaRepository;//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> getTareas() {
        return tareaRepository.obtenerTareas();
    }

    public Tarea getTareaPorId(int id) {
        Tarea obj = tareaRepository.buscarPorId(id);
        if (obj == null) throw new TareaNotFoundException(id);
        return obj;
    }

    public List<Tarea> getTareasPorEstado(String estado) {
        return tareaRepository.obtenerPorEstado(estado);
    }

    public List<Tarea> getTareasPorPrioridad(String prioridad) {
        return tareaRepository.obtenerPorPrioridad(prioridad);
    }

    public List<Tarea> getTareasPorResponsable(String responsable) {
        return tareaRepository.obtenerPorResponsable(responsable);
    }

    public List<Tarea> getTareasActivas() {
        return tareaRepository.obtenerActivas();
    }

    public Tarea saveTarea(Tarea tarea) {
        return tareaRepository.guardar(tarea);
    }

    public Tarea updateTarea(int id, Tarea tarea) {
        if (tareaRepository.buscarPorId(id) == null) throw new TareaNotFoundException(id);
        return tareaRepository.actualizar(tarea);
    }

    public Tarea cambiarEstado(int id, String nuevoEstado) {
        Tarea obj = tareaRepository.buscarPorId(id);
        if (obj == null) throw new TareaNotFoundException(id);
        obj.setEstado(nuevoEstado);
        return tareaRepository.actualizar(obj);
    }

    public String deleteTarea(int id) {
        if (tareaRepository.buscarPorId(id) == null) throw new TareaNotFoundException(id);
        tareaRepository.eliminar(id);
        return "tarea eliminada";
    }

    public int totalTareas() {
        return tareaRepository.totalTareas();
    }
}
