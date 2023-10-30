package br.senac.go.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "CONTA")
public class Conta
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDateTime dataFim;

    @Column(name = "LIMITE_CONTA", nullable = false)
    public BigDecimal limiteConta;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<TipoConta> tipoConta = new ArrayList<>();
}
