package fr.zaroumia.formation.spring.dao;

import java.util.Collection;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.zaroumia.formation.spring.model.Formateur;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FormateurDaoImpl implements FormateurDao {

	//private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(final Formateur f) {
		entityManager.persist(f);
	}

	@Override
	public void update(final Formateur f) {
		Formateur oldFormeteur = entityManager.find(Formateur.class,f.getId());
		oldFormeteur.setAge(f.getAge());
		oldFormeteur.setNom(f.getNom());
		oldFormeteur.setPrenom(f.getPrenom());
		entityManager.persist(oldFormeteur);
	}

	@Override
	public void delete(final Formateur f) {
		Formateur oldFormeteur = entityManager.find(Formateur.class,f.getId());
		entityManager.remove(oldFormeteur);
	}

	@Override
	public Formateur find(final Long id) {
		Formateur frmeteur = entityManager.find(Formateur.class,id);
		return frmeteur;
	}

	@Override
	public Collection<Formateur> findAll() {
		final String q = "From Formateur";
		return entityManager.createQuery(q,Formateur.class).getResultList();
	}
}
