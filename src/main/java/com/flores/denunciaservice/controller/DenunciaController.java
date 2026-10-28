
package com.flores.denunciaservice.controller;

import com.flores.denunciaservice.entity.Denuncia;
import com.flores.denunciaservice.service.DenunciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    private final DenunciaService service;

    public DenunciaController(DenunciaService service) {
        this.service = service;
    }

    // 1. Registrar una denuncia
    @PostMapping({"", "/"})
    public ResponseEntity<Denuncia> registrar(
            @RequestBody Denuncia denuncia) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.registrar(denuncia));
    }

    // 2. Listar denuncias con paginacion
    @GetMapping({"", "/"})
    public List<Denuncia> listar(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "5") int limit) {

        return service.listar(offset, limit);
    }

    // 3. Consultar denuncia por ID
    @GetMapping("/{id}")
    public Denuncia obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }

    // 4. Buscar denuncias por DNI
    @GetMapping("/ciudadano/{dni}")
    public List<Denuncia> buscarPorDni(
            @PathVariable String dni) {

        return service.buscarPorDni(dni);
    }

    // 5. Atender una denuncia
    @PutMapping("/{id}")
    public Denuncia atender(@PathVariable Integer id) {
        return service.atender(id);
    }
}
