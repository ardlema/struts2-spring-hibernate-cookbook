package org.ardlema.dao;

import org.ardlema.model.Receta;
import org.ardlema.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-dao-clean-test.xml"})
public final class RecetaDaoTest {

    @Autowired
    private RecetaDao recetaDao;


    @Test
    public void shouldSaveRecetas() throws Exception {
        Receta macarronesConChorizo = new Receta("Macarrones con chorizo", 1, "Cocer los macarrones y echarles chori.");
        Receta bocadilloDeJamon = new Receta("Bocadillo de jamon", 1, "Cortar el pan y meterle jamon.");
        recetaDao.save(macarronesConChorizo);
        recetaDao.save(bocadilloDeJamon);
        List<Receta> recetas = recetaDao.findAll();
        assertThat(recetas.size(), is(equalTo(2)));
    }

}