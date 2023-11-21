package com.PruebaServidor.Planificador.proyectos.infrastructure.web;

import com.PruebaServidor.Planificador.proyectos.application.ProyectoUseCases;
import com.PruebaServidor.Planificador.proyectos.domain.Proyecto;
import com.PruebaServidor.Planificador.proyectos.infrastructure.data.ProyectoRepositoryMysql;
import com.PruebaServidor.Planificador.tareas.domain.Tarea;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProyectoController {

    private ProyectoUseCases proyectoUseCases;

    public ProyectoController() {
        this.proyectoUseCases = new ProyectoUseCases(new ProyectoRepositoryMysql());
    }

    @GetMapping("/proyectos")
    String proyectos(Model model){
        List<Proyecto> lista = this.proyectoUseCases.getAll();
        model.addAttribute("lista",lista);
        return "proyectos";
    }

    @GetMapping("/proyecto/{id}")
    String proyectoconID(@PathVariable Integer id, Model model){

        Proyecto proyecto = this.proyectoUseCases.getProyectoFromID(id);
        model.addAttribute("lista",this.proyectoUseCases.getTareasFromID(id));
        model.addAttribute("id",id);
        model.addAttribute("proyecto",proyecto);

        return "proyectoBuscado";
    }

    //Falta por probar//
    @PostMapping("/proyecto/borrar")
    String borrar(Integer id){
        this.proyectoUseCases.deleteProyecto(id);
        return "redirect:/proyectos";
    }

    @GetMapping("/proyecto/nuevo")
    String nuevo(){
        return "nuevo";
    }

    @PostMapping("/proyecto/save")
    String addProyect(String nombre){
        this.proyectoUseCases.saveProyecto(nombre);
        return "redirect:/proyectos";
    }

}
