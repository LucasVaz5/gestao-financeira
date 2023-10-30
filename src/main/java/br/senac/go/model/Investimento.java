package br.senac.go.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "INVESTIMENTO")
public class Investimento
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "DESCRICAO", nullable = false)
    public String descricao;

    @Column(name = "VALOR_INICIAL", nullable = false)
    public BigDecimal valorInicial;

    @Column(name = "SALDO", nullable = false)
    public BigDecimal saldo;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDateTime dataFim;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<TipoInvestimento> tipoInvestimento = new ArrayList<>();
}
