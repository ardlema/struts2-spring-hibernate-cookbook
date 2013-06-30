package org.ardlema.services;

import org.ardlema.dao.RecetaDao;
import org.ardlema.enums.ServiceResult;
import org.ardlema.model.Receta;

public class RecetaServiceImpl implements RecetaService {

    private RecetaDao recetaDao;

    public RecetaDao getRecetaDao() {
        return recetaDao;
    }

    public void setRecetaDao(RecetaDao recetaDao) {
        this.recetaDao = recetaDao;
    }

    public ServiceResult saveReceta(Receta receta) {
        ServiceResult serviceResult;
        try {
            recetaDao.save(receta);
            serviceResult = ServiceResult.RESULT_OK;
        } catch (Exception e) {
           //TODO: Logear la excepcion
           serviceResult = ServiceResult.RESULT_ERROR;
        }

      return serviceResult;
    }
}
