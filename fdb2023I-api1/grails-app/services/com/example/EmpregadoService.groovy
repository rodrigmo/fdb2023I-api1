package com.example

import grails.gorm.transactions.Transactional
import java.time.LocalDate
import java.time.format.DateTimeFormatter;

@Transactional
class EmpregadoService {
    
    private EmpregadoDTO toDTO(Empregado empregado) {
        return new EmpregadoDTO(
            id: empregado.id,
            nome: empregado.nome,
            dataNascimento: empregado.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            matricula: empregado.matricula,
            departamento: empregado.departamento
        )
    }

    def getAll() {
        Empregado.list().collect {
            return toDTO(it)
        }
    }

    def get(Long id) {
        Empregado e = Empregado.get(id)
        if (e) {
            return toDTO(e)
        }
        return null
    }
    

    def save(Empregado empregado) {
        empregado.save(flush: true)
    }

    def update(Long id, Map params) {
        Empregado e = Empregado.get(id)
        if (e) {
            if (params.containsKey('nome')) {
                e.nome = params.nome
            }
            if (params.containsKey('dataNascimento')) {
                LocalDate newDate = LocalDate.parse(params.dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                e.dataNascimento = newDate
            }
            if (params.containsKey('matricula')) {
                e.matricula = params.matricula
            }
            if (params.containsKey('departamento')) {
                Departamento d = Departamento.get(params.departamento)
                if (d) {
                    e.departamento = d
                } else {
                    throw new IllegalArgumentException("Departamento inválido.")
                }
            }
            e.save(flush: true)
        }
    }

    def delete(Long id) {
        Empregado e = Empregado.get(id)
        println("Empregado que será deletado: "+e.id+', '+e.nome)
        if (e) {
            e.delete(flush: true)
        }
    }
}
