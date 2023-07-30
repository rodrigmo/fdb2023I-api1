package com.example


import grails.rest.*
import grails.converters.*

class DepartamentoController {
    DepartamentoService departamentoService

    def index() {
        respond departamentoService.getAll()
    }

    def show(Long id) {
        respond departamentoService.get(id)
    }

    def save(Departamento departamento) {
        respond departamentoService.save(departamento)
    }

    def update(Long id, Departamento departamento) {
        respond departamentoService.update(id, departamento)
    }

    def delete(Long id) {
        respond departamentoService.delete(id)
    }
}
