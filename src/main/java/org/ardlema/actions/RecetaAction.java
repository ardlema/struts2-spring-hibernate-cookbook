package org.ardlema.actions;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.ardlema.enums.ServiceResult;
import org.ardlema.model.Receta;
import org.ardlema.services.RecetaService;

public class RecetaAction extends DefaultActionSupport {

    public RecetaService getRecetaService() {
        return recetaService;
    }

    public void setRecetaService(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    private RecetaService recetaService;

    public String saveReceta() {
        Receta receta = new Receta();

        ServiceResult saveRecetaResult = recetaService.saveReceta(receta);

        switch (saveRecetaResult) {
            case RESULT_OK:
                return SUCCESS;
            case RESULT_ERROR:
                return ERROR;
            default: return ERROR;
        }
    }


}