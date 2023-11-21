package com.PruebaServidor.Planificador.proyectos.application;

import com.PruebaServidor.Planificador.proyectos.domain.Proyecto;
import com.PruebaServidor.Planificador.proyectos.domain.ProyectoRepository;
import com.PruebaServidor.Planificador.tareas.domain.Tarea;

import java.util.List;

public class ProyectoUseCases {

    private ProyectoRepository proyectoRepository;


    public ProyectoUseCases(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public List<Proyecto> getAll(){
        List<Proyecto> list = this.proyectoRepository.getAll();
        return list;
    }

    public List<Tarea> getTareasFromID(Integer id){
        List<Tarea> tareas = this.proyectoRepository.getTareasFromID(id);
        return tareas;
    }

    public void deleteProyecto(Integer id){
        this.proyectoRepository.deleteProyecto(id);
    }
}
