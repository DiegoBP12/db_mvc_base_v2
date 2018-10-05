/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelAgenda;
import views.ViewAgenda;

/**
 *
 * @author Zeo
 */
public class ControllerAgenda {

    ModelAgenda modelAgenda;
    ViewAgenda viewAgenda;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAgenda.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            } else if (e.getSource() == viewAgenda.jb_nuevo){
                jbtn_nuevo_actionPerformed();
            } else if (e.getSource() == viewAgenda.jb_insertar){
                jbtn_insertar_actionPerformed();
            } else if (e.getSource() == viewAgenda.jb_modificar){
                jbtn_modificar_actionPerformed();
            } else if (e.getSource() == viewAgenda.jb_guardar){
                jbtn_guardar_actionPerformed();
            }

        }

    };

    /**
     * Constructor de Controlador para unir el ModelAgenda y ViewAgenda
     *
     * @param modelAgenda objeto de tipo ModelAgenda
     * @param viewAgenda objeto de tipo ViewAgenda
     */
    public ControllerAgenda(ModelAgenda modelAgenda, ViewAgenda viewAgenda) {
        this.modelAgenda = modelAgenda;
        this.viewAgenda = viewAgenda;
        initComponents();
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y muestra el nombre y
     * email del primer registro en las cajas de texto de ViewAgenda.
     */
    public void initDB(){
        modelAgenda.conectarDB();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
    }
    /**
     * Metodo para inicializar la ViewAgenda
     */
    public void initComponents() {
        viewAgenda.setLocationRelativeTo(null);
        viewAgenda.setTitle("Agenda MVC");
        viewAgenda.setVisible(true);
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewAgenda.jbtn_primero.addActionListener(actionListener);
        viewAgenda.jbtn_anterior.addActionListener(actionListener);
        viewAgenda.jbtn_siguiente.addActionListener(actionListener);
        viewAgenda.jbtn_ultimo.addActionListener(actionListener);
        viewAgenda.jb_nuevo.addActionListener(actionListener);
        viewAgenda.jb_insertar.addActionListener(actionListener);
        viewAgenda.jb_modificar.addActionListener(actionListener);
        viewAgenda.jb_guardar.addActionListener(actionListener);
    }

    /**
     * Método que obtiene los valores de los JTextField nombre y email y los manda al modelo.
     */
    private void obtener_Datos(){
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText());
        modelAgenda.setEmail(viewAgenda.jtf_email.getText());
    }
    
    /**
     * Método que muestra los valores de las variables nombre y email del modelo a la vista.
     */
    private void mostrar_Datos(){
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
    }
    
    /**
     * Método que modifica la propiedad editable a True de los JTextField nombre y email.
     */
    private void editable(){
        viewAgenda.jtf_nombre.setEditable(true);
        viewAgenda.jtf_email.setEditable(true);
    }
    
    /**
     * Método que modifica la propiedad editable a False de los JTextField nombre y email.
     */
    private void editableF(){
        viewAgenda.jtf_nombre.setEditable(false);
        viewAgenda.jtf_email.setEditable(false);
    }
    
    /**
     * Método para ver el primer registro de la tabla contactos
     */
    private void jbtn_primero_actionPerformed() {
        modelAgenda.moverPrimerRegistro();
        mostrar_Datos();
        //invocar al metodo moverPrimerRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el registro anterior de la tabla contactos
     */
    private void jbtn_anterior_actionPerformed() {
        modelAgenda.moverAnteriorRegistro();
        mostrar_Datos();
        //invocar al metodo moverAnteriorRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el último registro de la tabla contactos
     */
    private void jbtn_ultimo_actionPerformed() {
        modelAgenda.moverUltimoRegistro();
        mostrar_Datos();
        //invocar al metodo moverUltimoRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el siguiente registro de la tabla contactos
     */
    private void jbtn_siguiente_actionPerformed() {
        modelAgenda.moverSiguienteRegistro();
        mostrar_Datos();
        //invocar al metodo moverSiguienteRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }
    
    /**
     * Método que limpia los JTextField nombre y email, manda a llamar al método editable.
     */
    private void jbtn_nuevo_actionPerformed(){
        viewAgenda.jtf_nombre.setText("");
        viewAgenda.jtf_email.setText("");
        editable();
    }
    
    /**
     * Método que manda los valores de los JTextField nombre y email y  manda a llamar al método insertarRegistro del modelo. 
     */
    
    private void jbtn_insertar_actionPerformed(){
        obtener_Datos();
        modelAgenda.insertarRegistro();
        editableF();
        mostrar_Datos();
    }
    
    /**
     * Método que habilita los JTextField nombre y email para ser editables.
     */
    private void jbtn_modificar_actionPerformed(){
        editable();
    }
    
    /**
     * Método que manda los valores de los JTextField nombre y email y  manda a llamar al método actualizarRegistro del modelo. 
     */
    private void jbtn_guardar_actionPerformed(){
        obtener_Datos();
        modelAgenda.guardarRegistro();
        editableF();
        mostrar_Datos();
    }
}
