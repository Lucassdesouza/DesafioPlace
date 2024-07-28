package entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDevedor;
    private LocalDate dataNascimentoDevedor;
    private String numeroRegistroEletronico;

    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Veiculo> veiculos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDevedor() {
        return nomeDevedor;
    }

    public void setNomeDevedor(String nomeDevedor) {
        this.nomeDevedor = nomeDevedor;

    }

    public LocalDate getDataNascimentoDevedor() {
        return dataNascimentoDevedor;
    }

    public void setDataNascimentoDevedor(LocalDate dataNascimentoDevedor) {
        this.dataNascimentoDevedor = dataNascimentoDevedor;
    }

    public String getNumeroRegistroEletronico() {
        return numeroRegistroEletronico;
    }

    public void setNumeroRegistroEletronico(String numeroRegistroEletronico) {
        this.numeroRegistroEletronico = numeroRegistroEletronico;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
