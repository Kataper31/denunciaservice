
package com.flores.denunciaservice.service;

import com.flores.denunciaservice.entity.Denuncia;
import com.flores.denunciaservice.repository.DenunciaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DenunciaService {

    private final DenunciaRepository repository;

    public DenunciaService(DenunciaRepository repository) {
        this.repository = repository;
    }

    // Registrar denuncia
    public Denuncia registrar(Denuncia denuncia) {
        denuncia.setId(null);
        denuncia.setEstado(1);
        return repository.save(denuncia);
    }

    // Obtener denuncias paginadas
    public List<Denuncia> listar(int offset, int limit) {
        if (offset < 0 || limit <= 0 || offset % limit != 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Paginacion invalida");
        }

        return repository.findAll(
                PageRequest.of(offset / limit, limit)
        ).getContent();
    }

    // Obtener denuncia por ID
    public Denuncia obtenerPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Denuncia no encontrada"));
    }

    // Buscar denuncias por DNI
    public List<Denuncia> buscarPorDni(String dni) {
        return repository.findByDni(dni);
    }

    // Atender denuncia
    public Denuncia atender(Integer id) {
        Denuncia denuncia = obtenerPorId(id);
        denuncia.setEstado(0);
        return repository.save(denuncia);
    }
}
