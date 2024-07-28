package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import entities.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

}