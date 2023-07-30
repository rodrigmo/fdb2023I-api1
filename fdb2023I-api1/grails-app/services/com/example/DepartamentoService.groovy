package com.example

import grails.gorm.transactions.Transactional

@Transactional
class DepartamentoService {
    def getAll() {
        Departamento.list()
    }

    def get(Long id) {
        Departamento.get(id)
    }

    def save(Long id, String nome) {
        Departamento novoDepartamento = new Departamento()

        novoDepartamento.setId(id)
        novoDepartamento.setNome(nome)

        novoDepartamento.save(flush: true)
    }

    def update(Long id, Departamento departamento) {
        Departamento d = Departamento.get(id)
        if (d) {
            d.properties = departamento.properties
            d.save(flush: true)
        }
    }

    def delete(Long id) {
        Departamento d = Departamento.get(id)
        if (d) {
            d.delete(flush: true)
        }
    }
}
