package com.PruebaServidor.Planificador.proyectos.domain;

import com.PruebaServidor.Planificador.tareas.domain.Tarea;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Proyecto {

    private Integer id;

    private String nombre;


    private List<Tarea> listaTareas;


    public Proyecto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listaTareas= new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void addTarea(Tarea tarea){
        this.listaTareas.add(tarea);
    }

    public void setList(List<Tarea> tareas){
        this.listaTareas=tareas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
