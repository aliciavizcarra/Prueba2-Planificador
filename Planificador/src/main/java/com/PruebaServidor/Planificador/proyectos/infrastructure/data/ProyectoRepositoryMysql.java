package com.PruebaServidor.Planificador.proyectos.infrastructure.data;

import com.PruebaServidor.Planificador.conexionBD.ConexionBD;
import com.PruebaServidor.Planificador.proyectos.domain.Proyecto;
import com.PruebaServidor.Planificador.proyectos.domain.ProyectoRepository;
import com.PruebaServidor.Planificador.tareas.domain.Tarea;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProyectoRepositoryMysql implements ProyectoRepository {

    Connection con= ConexionBD.getCon();

    @Override
    public List<Proyecto> getAll() {

        List<Proyecto> list = new ArrayList<>();

        String consulta = "SELECT * FROM `proyectos`";

        try {
            Statement stm = con.createStatement();
            ResultSet rs= stm.executeQuery(consulta);

            while (rs.next()){
                Integer id = rs.getInt("id");
                String nombre = rs.getString("nombre");

                List<Tarea> tareas = new ArrayList<>();

                Proyecto proyecto = new Proyecto(id,nombre);
                proyecto.setList(tareas);
                list.add(proyecto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Proyecto> getProyectoEntero() {
        return null;
    }

    @Override
    public List<Tarea> getTareasFromID(Integer id) {

        List<Tarea> listaTareas = new ArrayList<>();

        String consulta = "SELECT * FROM `tareas` where proyecto=" + id +";";

        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(consulta);

            while(rs.next()){
                String codigo= rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String especialidad = rs.getString("especialidad");
                Integer especialista= rs.getInt("especialista");

                Tarea tarea= new Tarea(codigo,nombre,null,especialidad,especialista);

                listaTareas.add(tarea);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTareas;

    }

    @Override
    public void deleteProyecto(Integer id) {

        String consulta= "DELETE FROM `proyectos` WHERE id="+ id +";";

        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(consulta);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void saveProyecto(String nombre) {

        String consulta = "INSERT INTO `proyectos`(nombre) VALUES ('" + nombre + "')";
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(consulta);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Proyecto getProyectoFromID(Integer id) {
        Proyecto proyecto = null;

        String consulta = "SELECT * FROM `proyectos` WHERE id =" + id + ";";

        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(consulta);

            while (rs.next()){
                Integer idProyecto = rs.getInt("id");
                String nombre= rs.getString("nombre");

                proyecto= new Proyecto(idProyecto,nombre);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return proyecto;
    }


}
