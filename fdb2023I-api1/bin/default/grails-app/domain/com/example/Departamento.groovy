package com.example

class Departamento {
    Long id
    String nome
    static hasMany = [empregados: Empregado]

    static constraints = {
        nome blank: false
    }
}
