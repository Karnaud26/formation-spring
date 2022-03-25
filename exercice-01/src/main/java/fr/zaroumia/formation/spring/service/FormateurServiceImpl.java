package fr.zaroumia.formation.spring.service;

import fr.zaroumia.formation.spring.dao.FormateurDao;
import fr.zaroumia.formation.spring.dao.FormateurDaoImpl;
import fr.zaroumia.formation.spring.model.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FormateurServiceImpl implements FormateurService {

    @Autowired
    private FormateurDao formateurDao;

    @Override
    public void create(Formateur f) {
        formateurDao.create(f);
    }

    @Override
    public void update(Formateur f) {
        formateurDao.update(f);
    }

    @Override
    public void delete(Formateur f) {
        formateurDao.delete(f);
    }

    @Override
    public Collection<Formateur> findAll() {
        return formateurDao.findAll();
    }

    @Override
    public Formateur find(Long id) {
        return formateurDao.find(id);
    }
}
