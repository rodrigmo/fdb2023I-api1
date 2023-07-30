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

    def save() {
        
        String tId = request.JSON.id
        String tNome = request.JSON.nome
        String tMatricula = request.JSON.matricula
        String tDataNascimento = request.JSON.dataNascimento
        String tDepartamentoId = request.JSON.departamentoId

        if ((!tId) || (!tNome) || (!tMatricula) || (!tDataNascimento) || (!tDepartamentoId)) {
            
            respond(status: 400, message: "Todos os parâmetros devem ser informados")
         
         } else {

            try {
                empregadoService.save(request.JSON.id, request.JSON.nome, request.JSON.matricula, request.JSON.dataNascimento, request.JSON.departamentoId)
                respond(status: 200, message: "Empregado criado com sucesso.")
            } catch (IllegalArgumentException e) {
                respond(status: 400, message: e.message)
            } 

         }
         
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
        try {
            empregadoService.delete(id)
            respond(status: 200, message: "Empregado removido com sucesso.")
        } catch (Exception e) {
            respond(status: 204, message: e.message)
        }
    }
}
