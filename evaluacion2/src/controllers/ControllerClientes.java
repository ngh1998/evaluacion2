/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;
import models.ModelClientes;
import views.ViewClientes;

public class ControllerClientes {

    private ModelClientes model_clientes;
    private ViewClientes view_clientes;

    public ControllerClientes(ModelClientes model_clientes, ViewClientes view_clientes) {
        this.model_clientes = model_clientes;
        this.view_clientes = view_clientes;
        this.view_clientes.jbtn_primero.addActionListener(e -> jbtn_primero_clic());
        this.view_clientes.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_clic());
        this.view_clientes.jbtn_anterior.addActionListener(e -> jbtn_anterior_clic());
        this.view_clientes.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_clic());
        this.view_clientes.jbtn_agregar.addActionListener(e -> jbtn_agregar_clic());
        this.view_clientes.jbtn_eliminar.addActionListener(e -> jbtn_borrar_clic());
        this.view_clientes.jbtn_actualizar.addActionListener(e -> jbtn_actualizar_clic());
        initView();
    }

    public void getValores() {

        view_clientes.jtf_idcliente.setText(" " + model_clientes.getId_cliente());
        view_clientes.jtf_nombre.setText(model_clientes.getNombre());
        view_clientes.jtf_telefono.setText(model_clientes.getTelefono());
        view_clientes.jtf_email.setText(model_clientes.getEmail());
        view_clientes.jtf_direccion.setText(model_clientes.getDireccion());
    }

    public void setValores() {
        //model_clientes.setId_cliente(Integer.parseInt(view_clientes.jtf_idcliente.getText()));
        model_clientes.setNombre(view_clientes.jtf_nombre.getText());
        model_clientes.setTelefono(view_clientes.jtf_telefono.getText());
        model_clientes.setEmail(view_clientes.jtf_email.getText());
        model_clientes.setDireccion(view_clientes.jtf_direccion.getText());
    }

    public void jbtn_nuevo_clic() {
        view_clientes.jtf_idcliente.setText(" ");
        view_clientes.jtf_nombre.setText(" ");
        view_clientes.jtf_telefono.setText(" ");
        view_clientes.jtf_email.setText(" ");
        view_clientes.jtf_direccion.setText(" ");

    }

    public void jbtn_agregar_clic() {
        setValores();
        model_clientes.insertar();
        getValores();

    }

    public void jbtn_actualizar_clic() {
        setValores();
        model_clientes.actualizar();
        getValores();

    }

    public void jbtn_borrar_clic() {
        setValores();
        model_clientes.borrar();
        getValores();
    }

    public void jbtn_primero_clic() {
        model_clientes.moverPrimero();
        getValores();
    }

    public void jbtn_ultimo_clic() {
        model_clientes.moverUltimo();
        getValores();
    }

    public void jbtn_siguiente_clic() {
        model_clientes.moverSiguiente();
        getValores();
    }

    public void jbtn_anterior_clic() {
        model_clientes.moverAnterior();
        getValores();
    }

    public void initView() {
        view_clientes.setVisible(true);
        model_clientes.Conectar();
        model_clientes.moverPrimero();
        getValores();
    }
}

