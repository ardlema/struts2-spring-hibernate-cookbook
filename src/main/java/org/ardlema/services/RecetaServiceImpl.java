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
        try {
            recetaDao.save(receta);
        } catch (Exception e) {
           return ServiceResult.RESULT_ERROR;
        }
      return ServiceResult.RESULT_OK;
    }
}
