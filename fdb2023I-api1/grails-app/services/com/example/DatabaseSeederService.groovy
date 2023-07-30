package com.example

import grails.gorm.transactions.Transactional
import java.time.LocalDate

@Transactional
class DatabaseSeederService {

    void seedData() {
        if (!Departamento.count()) {
            Departamento d1 = new Departamento(nome: 'Departamento 1').save(flush: true)
            Departamento d2 = new Departamento(nome: 'Departamento 2').save(flush: true)

            new Empregado(nome: 'Empregado 1', dataNascimento: LocalDate.now(), matricula: 1, departamento: d1).save(flush: true)
            new Empregado(nome: 'Empregado 2', dataNascimento: LocalDate.now(), matricula: 2, departamento: d1).save(flush: true)
            new Empregado(nome: 'Empregado 3', dataNascimento: LocalDate.now(), matricula: 3, departamento: d2).save(flush: true)
            new Empregado(nome: 'Empregado 4', dataNascimento: LocalDate.now(), matricula: 4, departamento: d2).save(flush: true)
            new Empregado(nome: 'Empregado 5', dataNascimento: LocalDate.now(), matricula: 5, departamento: d2).save(flush: true)
        }
    }
}
