package com.PruebaServidor.Planificador.proyectos.application;

import com.PruebaServidor.Planificador.proyectos.infrastructure.data.ProyectoRepositoryMysql;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

class ProyectoUseCasesTest {

    private ProyectoUseCases proyectoUseCases;


    public ProyectoUseCasesTest() {
        this.proyectoUseCases = new ProyectoUseCases(new ProyectoRepositoryMysql());
    }

    @AfterEach
    void deleteAllProyectos(){

    }
}