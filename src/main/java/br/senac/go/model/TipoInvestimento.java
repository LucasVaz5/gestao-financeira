package br.senac.go.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TIPOINVESTIMENTO")
public class TipoInvestimento
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "RISCO", nullable = false)
    private boolean temRisco;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDateTime dataFim;

    @ManyToOne(fetch = FetchType.LAZY)
    private Investimento investimento;
}
