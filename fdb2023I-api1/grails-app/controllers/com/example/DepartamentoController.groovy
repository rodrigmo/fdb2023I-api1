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

    //def save(Departamento departamento) {
    def save() {
        respond departamentoService.save(request.JSON.id, request.JSON.nome)
    }

    def update(Long id, Departamento departamento) {
        respond departamentoService.update(id, departamento)
    }

    def delete(Long id) {
        respond departamentoService.delete(id)
    }
}
