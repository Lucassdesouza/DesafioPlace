package services;

import entities.Veiculo;
import repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo criarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public
    Veiculo buscarVeiculoPorId(Long id) {
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
        return veiculoOptional.orElse(null);
    }

    public List<Veiculo> listarTodosVeiculos() {
        return veiculoRepository.findAll();
    }

    public Veiculo atualizarVeiculo(Long id, Veiculo veiculoAtualizado) {
        Optional<Veiculo> veiculoExistenteOptional = veiculoRepository.findById(id);
        if (veiculoExistenteOptional.isPresent()) {
            Veiculo veiculoExistente = veiculoExistenteOptional.get();
            veiculoExistente.setNumeroGravame(veiculoAtualizado.getNumeroGravame());
            veiculoExistente.setNumeroRenavam(veiculoAtualizado.getNumeroRenavam());
            veiculoExistente.setPlaca(veiculoAtualizado.getPlaca());
            veiculoExistente.setNumeroChassi(veiculoAtualizado.getNumeroChassi());
            return veiculoRepository.save(veiculoExistente);
        } else {
            return null;
        }
    }

    public boolean deletarVeiculo(Long id) {
        if (veiculoRepository.existsById(id)) {
            veiculoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

