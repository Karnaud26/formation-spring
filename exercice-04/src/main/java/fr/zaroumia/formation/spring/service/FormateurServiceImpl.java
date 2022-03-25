package fr.zaroumia.formation.spring.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.zaroumia.formation.spring.dao.FormateurDao;
import fr.zaroumia.formation.spring.model.Formateur;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FormateurServiceImpl implements FormateurService {

	private FormateurDao formateurDao;

	public FormateurServiceImpl(final FormateurDao formateurDao) {
		super();
		this.formateurDao = formateurDao;
	}

	@Override
	public void create(final Formateur f) {
		formateurDao.create(f);
	}

	@Override
	public void update(final Formateur f) {
		formateurDao.update(f);
	}

	@Override
	public void delete(final Formateur f) {
		formateurDao.delete(f);
	}

	@Override
	public Collection<Formateur> findAll() {
		return formateurDao.findAll();
	}

	@Override
	public Formateur find(final Long id) {
		return formateurDao.find(id);
	}

	public void setFormateurDao(final FormateurDao formateurDao) {
		this.formateurDao = formateurDao;
	}

	@Override
	@Transactional
	public void create(final Collection<Formateur> formateurs) throws IllegalArgumentException {
		if (formateurs.parallelStream().collect(Collectors.toList()).size()>0){
			formateurs.parallelStream().forEach(formateur -> {
				if (formateur.getId() == null)
					new IllegalArgumentException("I'idenditifant ne peut etre null");
				formateurDao.create(formateur);
			});
		}
	}
}
