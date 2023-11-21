package com.PruebaServidor.Planificador.tareas.domain;

public class Tarea {

    private String codigo, nombre,especialidad;

    private Integer proyecto, especialista;


    public Tarea(String codigo, String nombre, Integer proyecto, String especialidad, Integer especialista) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.proyecto = proyecto;
        this.especialidad = especialidad;
        this.especialista = especialista;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getProyecto() {
        return proyecto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public Integer getEspecialista() {
        return especialista;
    }
}
