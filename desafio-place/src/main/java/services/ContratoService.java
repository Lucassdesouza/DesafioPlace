package services;

import entities.Contrato;
import entities.Veiculo;
import repositories.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ContratoService {
    @Autowired
    private ContratoRepository contratoRepository;

    public Contrato criarContrato(Contrato contrato) {
        contrato.setNumeroRegistroEletronico(gerarNumeroRegistroEletronico());
        return contratoRepository.save(contrato);
    }

    public Contrato buscarContratoPorId(Long id) {
        Optional<Contrato> contratoOptional = contratoRepository.findById(id);
        return contratoOptional.orElse(null);
    }

    public List<Contrato> listarTodosContratos() {
        return contratoRepository.findAll();
    }

    public Contrato atualizarContrato(Long id, Contrato contratoAtualizado) {
        Optional<Contrato> contratoExistenteOptional = contratoRepository.findById(id);
        if (contratoExistenteOptional.isPresent()) {
            Contrato contratoExistente = contratoExistenteOptional.get();
            contratoExistente.setNomeDevedor(contratoAtualizado.getNomeDevedor());
            contratoExistente.setDataNascimentoDevedor(contratoAtualizado.getDataNascimentoDevedor());
            // Atualize outros campos conforme necessário
            return contratoRepository.save(contratoExistente);
        } else {
            return null;
        }
    }

    public boolean deletarContrato(Long id) {
        if (contratoRepository.existsById(id)) {
            contratoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private String gerarNumeroRegistroEletronico() {
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String anoCorrente = dataAtual.format(formatter);

        Random random = new Random();
        int numeroAleatorio = 100000 + random.nextInt(900000); // Gera um número entre 100000 e 999999

        return anoCorrente + "-" + String.format("%06d", numeroAleatorio);
    }
}
