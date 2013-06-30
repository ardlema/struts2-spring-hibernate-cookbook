package org.ardlema.services;

import org.ardlema.enums.ServiceResult;
import org.ardlema.model.Receta;

public interface RecetaService {

    public ServiceResult saveReceta(Receta receta);
}
