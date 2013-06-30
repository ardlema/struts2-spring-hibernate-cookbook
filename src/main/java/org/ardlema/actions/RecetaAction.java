package org.ardlema.actions;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.ardlema.enums.ServiceResult;
import org.ardlema.model.Receta;
import org.ardlema.services.RecetaService;

public class RecetaAction extends DefaultActionSupport {

    private String nombre;
    private String dificultad;
    private String elaboracion;

    public RecetaService getRecetaService() {
        return recetaService;
    }

    public void setRecetaService(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    private RecetaService recetaService;

    public String saveReceta() {
        Receta receta = new Receta(nombre,new Integer(dificultad),elaboracion);

        ServiceResult saveRecetaResult = recetaService.saveReceta(receta);

        String action;

        switch (saveRecetaResult) {
            case RESULT_OK:
                action = SUCCESS;
                break;
            case RESULT_ERROR:
                action = ERROR;
                break;
            default: action = ERROR;
        }

        return action;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(String elaboracion) {
        this.elaboracion = elaboracion;
    }


}