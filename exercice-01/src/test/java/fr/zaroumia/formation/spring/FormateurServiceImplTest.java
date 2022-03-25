package fr.zaroumia.formation.spring;

import fr.zaroumia.formation.spring.dao.FormateurDao;
import fr.zaroumia.formation.spring.model.Formateur;
import fr.zaroumia.formation.spring.service.FormateurServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FormateurServiceImplTest {

    @InjectMocks
    private FormateurServiceImpl classUnderTest;

    @Mock
    private FormateurDao formateurDao;

    @Test
    public void shouldFindAllReturnEmptyList(){

        //Given : definit le comportement de formationDao
        when(formateurDao.findAll()).thenReturn(new ArrayList<>());

        // When  appele la méthode findAll de formationService
        List<Formateur> result = (List<Formateur>) formateurDao.findAll();

        //then valider le resultat optenu
        assertThat(result).isEmpty();

    }

    @Test
    public void shouldFindAllReturnNotEmptyList(){

        // Given
        Formateur formateur = new Formateur();
        formateur.setPrenom("Baba");
        formateur.setId(2L);
        formateur.setNom("Lorm");
        formateur.setAge(25);

        List<Formateur> formateurList = new ArrayList<>();
        formateurList.add(formateur);
        when(formateurDao.findAll()).thenReturn(formateurList);

        // When
        List<Formateur> results = (List<Formateur>)formateurDao.findAll();

        //Then
        assertThat(results).isEqualTo(formateurList);
    }
}
