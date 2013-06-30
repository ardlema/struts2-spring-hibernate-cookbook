package org.ardlema.service;

import org.ardlema.dao.RecetaDao;
import org.ardlema.enums.ServiceResult;
import org.ardlema.model.Receta;
import org.ardlema.services.RecetaService;
import org.ardlema.services.RecetaServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-dao-clean-test.xml"})
public class RecetaServiceTest {

    @Autowired
    private RecetaService recetaService;

    @Autowired
    private RecetaDao recetaDao;

    @Test
    public void shouldReturnServiceResultOKWhenTheDaoDoesnotThrowAnException() {
      Receta recetaToSave = new Receta("Macarrones", 1, "Hacer los macarrones.");
      ServiceResult serviceResult = recetaService.saveReceta(recetaToSave);
      assertThat(serviceResult, is(equalTo(ServiceResult.RESULT_OK)));
    }

    @Test
    public void shouldReturnServiceResultERRORWhenTheDaoThrowsAnException() throws Exception {
        RecetaServiceImpl recetaSvc = new RecetaServiceImpl();
        Receta recetaToSave = new Receta("Macarrones", 1, "Hacer los macarrones.");
        RecetaDao mockRecetaDao =  mock(RecetaDao.class);
        recetaSvc.setRecetaDao(mockRecetaDao);
        doThrow(new Exception()).when(mockRecetaDao).save(recetaToSave);
        ServiceResult serviceResult = recetaSvc.saveReceta(recetaToSave);
        assertThat(serviceResult, is(equalTo(ServiceResult.RESULT_ERROR)));
    }


}
