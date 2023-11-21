package com.PruebaServidor.Planificador.proyectos.domain;

import com.PruebaServidor.Planificador.tareas.domain.Tarea;

import java.util.List;

public interface ProyectoRepository {

    public List<Proyecto> getAll();

    public List<Proyecto> getProyectoEntero();

    public List<Tarea> getTareasFromID(Integer id);

    public void deleteProyecto(Integer id);

    public void saveProyecto(String nombre);

    public Proyecto getProyectoFromID(Integer id);

}
