package com.example

import java.time.LocalDate
import java.time.format.DateTimeFormatter;

class Empregado {
    Long id
    String nome
    LocalDate dataNascimento
    Integer matricula
    Departamento departamento

    static belongsTo = [departamento: Departamento]

    static constraints = {
        nome blank: false
        dataNascimento nullable: false
        matricula nullable: false, unique: true, validator: { val, obj ->
            if (!(val instanceof Integer)) {
                return 'matricula.integer'
            }
        }
        departamento nullable: false, validator: { val, obj ->
            if (!Departamento.get(val.id)) {
                return 'departamento.invalid'
            }
        }
    }
}
