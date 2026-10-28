package com.flores.denunciaservice.repository;

import com.flores.denunciaservice.entity.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DenunciaRepository
        extends JpaRepository<Denuncia, Integer> {

    List<Denuncia> findByDni(String dni);

}
