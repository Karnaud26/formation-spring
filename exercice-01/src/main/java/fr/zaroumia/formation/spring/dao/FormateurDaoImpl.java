package fr.zaroumia.formation.spring.dao;

import fr.zaroumia.formation.spring.model.Formateur;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FormateurDaoImpl implements FormateurDao {

    private final Set<Formateur> dataFormateur = new HashSet<>();

    @Override
    public void create(final Formateur f) {
        dataFormateur.add(f);
    }

    @Override
    public void update(final Formateur f) {
        Formateur formateur = find(f.getId());
        formateur.setAge(f.getAge());
        formateur.setNom(f.getNom());
        formateur.setPrenom(f.getPrenom());
    }

    @Override
    public void delete(final Formateur f) {
        dataFormateur.remove(f);
    }

    @Override
    public Collection<Formateur> findAll() {
        return new HashSet<>(dataFormateur); //dataFormateur.stream().collect(Collectors.toList());
    }

    @Override
    public Formateur find(final Long id) {
        return dataFormateur.stream().filter(x -> id.equals(x.getId())).findFirst().orElseThrow(() -> new IllegalArgumentException("Formateur introuvable"));
    }
}
