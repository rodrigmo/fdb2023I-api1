package com.example

import grails.rest.*
import grails.converters.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter;

class EmpregadoController {
    EmpregadoService empregadoService

    def index() {
        respond empregadoService.getAll()
    }

    def show(Long id) {
        respond empregadoService.get(id)
    }

    def save(Empregado empregado) {
        respond empregadoService.save(empregado)
    }

    def update(Long id) {
        try {
            empregadoService.update(id, params)
            respond(status: 200, message: "Empregado atualizado com sucesso.")
        } catch (IllegalArgumentException e) {
            respond(status: 400, message: e.message)
        }
    }

    def delete(Long id) {
        respond empregadoService.delete(id)
    }
}
