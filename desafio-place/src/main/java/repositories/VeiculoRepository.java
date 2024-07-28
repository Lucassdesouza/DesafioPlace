package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import entities.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
