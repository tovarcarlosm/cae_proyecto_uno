package co.edu.eam.service;

import co.edu.eam.dao.PersonaDao;
import co.edu.eam.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImplementation implements PersonaService{
    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listar() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona buscarPorId(Persona persona) {
        return personaDao.findById(persona.getId()).orElse(null);
    }

    @Override
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }
}
