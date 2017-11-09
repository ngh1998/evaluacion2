/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import views.ViewPeliculas;
import views.ViewClientes;
import views.ViewPrincipal;
import controllers.ControllerPeliculas;
import controllers.ControllerClientes;
import controllers.ControllerPrincipal;
import models.ModelPeliculas;
import models.ModelClientes;
import models.ModelPrincipal;

public class Main {

    public static void main(String[] mla) {
        ModelPeliculas model_peliculas = new ModelPeliculas();
        ViewPeliculas view_peliculas = new ViewPeliculas();
        ControllerPeliculas controller_peliculas = new ControllerPeliculas(model_peliculas, view_peliculas);
        
        ModelClientes model_clientes = new ModelClientes();
        ViewClientes view_clientes = new ViewClientes();
        ControllerClientes controller_clientes = new ControllerClientes(model_clientes, view_clientes);

        ModelPrincipal model_principal = new ModelPrincipal();
        ViewPrincipal view_principal = new ViewPrincipal();
        
        Object views[] = new Object[3];
        views[0] = view_peliculas;
        views[1] = view_principal;
        views[2] = view_clientes;
        ControllerPrincipal controller_principal = new ControllerPrincipal(model_principal, views);
    }
}
