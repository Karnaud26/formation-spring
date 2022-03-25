package fr.zaroumia.formation.spring;

import fr.zaroumia.formation.spring.model.Formateur;
import fr.zaroumia.formation.spring.service.FormateurService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collection;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(final String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configuration.class);
		FormateurService formateurService = applicationContext.getBean(FormateurService.class);

		// TODO Créer un formateur
		Formateur f = new Formateur();
		f.setPrenom("Arnaud");
		f.setNom("Kemgouo");
		f.setAge(25);
		f.setId(1L);
		formateurService.create(f);
		Collection<Formateur> formateurCollection = formateurService.findAll();
		formateurCollection.stream().forEach(formateur -> System.out.println(formateur.toString()));
		// TODO Modifier un formateur
		f.setPrenom("KTA");
		formateurService.update(f);
		// TODO R�cup�rer le formateur par son ID
		formateurService.find(f.getId());

		// TODO Supprimer le formateur
		formateurService.delete(f);

		// TODO R�cup�rer tous les formateurs
		Collection<Formateur> formateurCollection1 = formateurService.findAll();
		formateurCollection1.stream().forEach(formateur -> System.out.println(formateur.toString()));
	}
}
