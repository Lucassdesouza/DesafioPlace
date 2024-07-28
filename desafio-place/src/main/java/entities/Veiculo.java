package entities;

import jakarta.persistence.*;

import java.util.Optional;


@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroGravame;
    private String numeroRenavam;
    private String placa;
    private String numeroChassi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrato_id")
    private Optional<Contrato> contrato;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroGravame() {
        return numeroGravame;
    }

    public void setNumeroGravame(String numeroGravame) {
        this.numeroGravame = numeroGravame;
    }

    public String getNumeroRenavam() {
        return numeroRenavam;
    }

    public void setNumeroRenavam(String numeroRenavam) {
        this.numeroRenavam = numeroRenavam;
    }

    public String getPlaca()
    {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNumeroChassi() {
        return numeroChassi;
    }

    public void setNumeroChassi(String numeroChassi) {
        this.numeroChassi
 = numeroChassi;
    }

    public Optional<Contrato> getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = Optional.ofNullable(contrato);
    }
}
