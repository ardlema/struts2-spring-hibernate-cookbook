package org.ardlema.unit;

import org.ardlema.actions.RecetaAction;
import org.ardlema.enums.ServiceResult;
import org.ardlema.model.Receta;
import org.ardlema.model.User;
import org.ardlema.services.RecetaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RecetaTest extends ConfigTest {

    RecetaAction receta = new RecetaAction();

    @Mock
    RecetaService mockRecetaService;

    @Before
    public void setup() {
       receta.setRecetaService(mockRecetaService);
    }

    @Test
    public void shouldReturnOKWhenTheRecetaHasBeenSaved() {
        when(mockRecetaService.saveReceta(any(Receta.class))).thenReturn(ServiceResult.RESULT_OK);
        String result = receta.saveReceta();
        assertSuccess(result);
    }

    @Test
    public void shouldReturnERRORWhenTheRecetaHasNotBeenSaved() {
        when(mockRecetaService.saveReceta(any(Receta.class))).thenReturn(ServiceResult.RESULT_ERROR);
        String result = receta.saveReceta();
        assertError(result);
    }
}
