package com.example.apirest.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

                                // Não receber valores vazios para a String e não receber
                                // valores nulos para o bigdecimal.
public record ProdutoRecordDTO(@NotBlank String nome,@NotNull BigDecimal valor) {

}
