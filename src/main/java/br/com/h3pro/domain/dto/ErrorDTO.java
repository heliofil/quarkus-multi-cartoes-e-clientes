package br.com.h3pro.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {

    //Pode ser mais estruturado com codigos internos para facilitar o backtrace;
    private String descrisao;

}
