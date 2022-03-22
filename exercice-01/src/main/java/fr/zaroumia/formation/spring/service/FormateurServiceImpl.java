package fr.zaroumia.formation.spring.service;

import fr.zaroumia.formation.spring.dao.FormateurDaoImpl;
import fr.zaroumia.formation.spring.model.Formateur;

import java.util.Collection;

public class FormateurServiceImpl implements FormateurService {

    private FormateurDaoImpl formateurDao;

    public void setFormateurDao(FormateurDaoImpl formateurDao) {
        this.formateurDao = formateurDao;
    }

    /*public FormateurServiceImpl (final FormateurDaoImpl formateurDao){
        this.formateurDao = formateurDao;
    }*/

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
