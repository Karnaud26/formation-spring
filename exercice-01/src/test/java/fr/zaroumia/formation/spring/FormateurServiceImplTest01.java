package fr.zaroumia.formation.spring;

import fr.zaroumia.formation.spring.model.Formateur;
import fr.zaroumia.formation.spring.service.FormateurService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuration.class)
public class FormateurServiceImplTest01 {

    @Autowired
    private FormateurService formateurService;

    @Test
    public void shouldFindAllResturn(){
        List<Formateur> formateurList = (List<Formateur>) formateurService.findAll();
        assertThat(formateurList).hasSize(1);
    }
}
