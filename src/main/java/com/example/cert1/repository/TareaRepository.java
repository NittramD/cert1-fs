package com.example.cert1.repository;

import com.example.cert1.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TareaRepository {//

    private List<Tarea> listaTareas = new ArrayList<>();

    public TareaRepository() {
        listaTareas.add(new Tarea(1, "Diseñar base de datos", "Crear el modelo relacional del sistema", "COMPLETADA", "ALTA", "Juan Pérez", "2024-01-10", true));
        listaTareas.add(new Tarea(2, "Implementar login", "Desarrollar autenticación de usuarios", "EN_PROGRESO", "ALTA", "María González", "2024-01-12", true));
        listaTareas.add(new Tarea(3, "Crear API REST", "Exponer endpoints del microservicio", "EN_PROGRESO", "ALTA", "Pedro Soto", "2024-01-15", true));
        listaTareas.add(new Tarea(4, "Documentar endpoints", "Escribir documentación de la API", "PENDIENTE", "MEDIA", "Ana Torres", "2024-01-16", true));
        listaTareas.add(new Tarea(5, "Pruebas unitarias", "Implementar tests con JUnit", "PENDIENTE", "MEDIA", "Juan Pérez", "2024-01-17", true));
        listaTareas.add(new Tarea(6, "Deploy en servidor", "Subir la app al servidor de producción", "PENDIENTE", "BAJA", "María González", "2024-01-18", false));
    }

    public List<Tarea> obtenerTareas() {
        return listaTareas;
    }

    public Tarea buscarPorId(int id) {
        for (Tarea t : listaTareas) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    public List<Tarea> obtenerPorEstado(String estado) {
        List<Tarea> resultado = new ArrayList<>();
        for (Tarea t : listaTareas) {
            if (t.getEstado().equalsIgnoreCase(estado)) resultado.add(t);
        }
        return resultado;
    }

    public List<Tarea> obtenerPorPrioridad(String prioridad) {
        List<Tarea> resultado = new ArrayList<>();
        for (Tarea t : listaTareas) {
            if (t.getPrioridad().equalsIgnoreCase(prioridad)) resultado.add(t);
        }
        return resultado;
    }

    public List<Tarea> obtenerPorResponsable(String responsable) {
        List<Tarea> resultado = new ArrayList<>();
        for (Tarea t : listaTareas) {
            if (t.getResponsable().equalsIgnoreCase(responsable)) resultado.add(t);
        }
        return resultado;
    }

    public List<Tarea> obtenerActivas() {
        List<Tarea> activas = new ArrayList<>();
        for (Tarea t : listaTareas) {
            if (t.isActivo()) activas.add(t);
        }
        return activas;
    }

    public Tarea guardar(Tarea tarea) {
        listaTareas.add(tarea);
        return tarea;
    }

    public Tarea actualizar(Tarea tarea) {
        int idPosicion = 0;
        for (int i = 0; i < listaTareas.size(); i++) {
            if (listaTareas.get(i).getId() == tarea.getId()) {
                idPosicion = i;
            }
        }
        listaTareas.set(idPosicion, tarea);
        return tarea;
    }

    public void eliminar(int id) {
        listaTareas.removeIf(t -> t.getId() == id);
    }

    public int totalTareas() {
        return listaTareas.size();
    }
}
