package com.PruebaServidor.Planificador.proyectos.infrastructure.web;

import com.PruebaServidor.Planificador.proyectos.application.ProyectoUseCases;
import com.PruebaServidor.Planificador.proyectos.domain.Proyecto;
import com.PruebaServidor.Planificador.proyectos.infrastructure.data.ProyectoRepositoryMysql;
import com.PruebaServidor.Planificador.tareas.domain.Tarea;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProyectoRestController {

    private ProyectoUseCases proyectoUseCases;

    public ProyectoRestController() {
        this.proyectoUseCases = new ProyectoUseCases(new ProyectoRepositoryMysql());
    }

    @GetMapping("/api/proyectos")
    List<Proyecto> ListaProyectos(){
        List<Proyecto> lista = this.proyectoUseCases.getAll();
        return lista;
    }

    @PostMapping(path="/api/proyecto/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Proyecto getProyecto(@PathVariable Integer id, @RequestBody Tarea tarea){

        Proyecto proyecto = this.proyectoUseCases.getProyectoFromID(id);
        proyecto.addTarea(tarea);

        return proyecto;

    }


}
