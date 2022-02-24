package co.edu.eam.service;

import co.edu.eam.domain.Persona;

import java.util.List;

public interface PersonaService {

    public List<Persona> listar();

    public Persona buscarPorId(Persona persona);

    public void guardar(Persona persona);

    public void eliminar(Persona persona);

}
