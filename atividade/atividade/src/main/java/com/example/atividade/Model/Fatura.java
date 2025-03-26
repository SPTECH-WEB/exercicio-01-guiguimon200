package com.example.atividade.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="faturas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Fatura {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O numero do cartão não pode estar em branco")
    @Pattern(regexp = "\\d{16}", message = "O numero do cartão tem que ter 16 digitos")
    private String numeroCartao;

    @NotBlank(message = "O nome do titular não pode estar em branco")
    @Size(min = 3, max = 100, message = "O nome deve possuir entre 3 e 100 caracteres")
    private String nomeTitular;

    @NotNull(message = "O valor não pode estar em branco")
    @DecimalMin(value = "10.00", message = "O valor minimo é R$10.00")
    @DecimalMax(value = "5000.00", message = "O valor maximo é R$5000.00")
    private Double valor;

    @NotNull(message = "A data do pagamento não pode estar em branco")
    @FutureOrPresent(message = "A data de pagamento deve ser a data atual ou futura")
    private LocalDate dataPagamento;

    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "O email precisa ser válido")
    private String emailContato;

}
