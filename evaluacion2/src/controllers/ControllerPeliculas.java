/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.sql.SQLException;
import models.ModelPeliculas;
import views.ViewPeliculas;

public class ControllerPeliculas {

    private ModelPeliculas model_peliculas;
    private ViewPeliculas view_peliculas;

    public ControllerPeliculas(ModelPeliculas model_peliculas, ViewPeliculas view_peliculas) {
        this.model_peliculas = model_peliculas;
        this.view_peliculas = view_peliculas;
        this.view_peliculas.jbtn_primero.addActionListener(e -> jbtn_primero_clic());
        this.view_peliculas.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_clic());
        this.view_peliculas.jbtn_anterior.addActionListener(e -> jbtn_anterior_clic());
        this.view_peliculas.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_clic());
        this.view_peliculas.jbtn_agregar.addActionListener(e -> jbtn_agregar_clic());
        this.view_peliculas.jbtn_eliminar.addActionListener(e -> jbtn_borrar_clic());
        this.view_peliculas.jbtn_actualizar.addActionListener(e -> jbtn_actualizar_clic());
        initView();
    }

    public void getValores() {

        view_peliculas.jtf_idpelicula.setText(" " + model_peliculas.getId_pelicula());
        view_peliculas.jtf_nombre.setText(model_peliculas.getNombre());
        view_peliculas.jtf_formato.setText(model_peliculas.getFormato());
        view_peliculas.jtf_duracion.setText(model_peliculas.getDuracion());
        view_peliculas.jtf_descripcion.setText(model_peliculas.getDescripcion());
    }

    public void setValores() {
        //model_peliculas.setId_pelicula(Integer.parseInt(view_peliculas.jtf_idpelicula.getText()));
        model_peliculas.setNombre(view_peliculas.jtf_nombre.getText());
        model_peliculas.setFormato(view_peliculas.jtf_formato.getText());
        model_peliculas.setDuracion(view_peliculas.jtf_duracion.getText());
        model_peliculas.setDescripcion(view_peliculas.jtf_descripcion.getText());

    }

    public void jbtn_nuevo_clic() {
        view_peliculas.jtf_idpelicula.setText(" ");
        view_peliculas.jtf_nombre.setText(" ");
        view_peliculas.jtf_formato.setText(" ");
        view_peliculas.jtf_duracion.setText(" ");
        view_peliculas.jtf_descripcion.setText(" ");

    }

    public void jbtn_agregar_clic() {
        setValores();
        model_peliculas.insertar();
        getValores();

    }

    public void jbtn_actualizar_clic() {
        setValores();
        model_peliculas.actualizar();
        getValores();

    }

    public void jbtn_borrar_clic() {
        setValores();
        model_peliculas.borrar();
        getValores();
    }

    public void jbtn_primero_clic() {
        model_peliculas.moverPrimero();
        getValores();
    }

    public void jbtn_ultimo_clic() {
        model_peliculas.moverUltimo();
        getValores();
    }

    public void jbtn_siguiente_clic() {
        model_peliculas.moverSiguiente();
        getValores();
    }

    public void jbtn_anterior_clic() {
        model_peliculas.moverAnterior();
        getValores();
    }

    public void initView() {
        view_peliculas.setVisible(true);
        model_peliculas.Conectar();
        model_peliculas.moverPrimero();
        getValores();
    }
}
