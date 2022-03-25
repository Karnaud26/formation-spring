package fr.zaroumia.formation.spring;


import fr.zaroumia.formation.spring.dao.FormateurDao;
import fr.zaroumia.formation.spring.dao.FormateurDaoImpl;
import fr.zaroumia.formation.spring.service.FormateurService;
import fr.zaroumia.formation.spring.service.FormateurServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan("fr.zaroumia.formation.spring")
public class Configuration {

    @Bean
    public FormateurDao formateurDao(){
        return new FormateurDaoImpl();
    }
}
