package com.example

import grails.gorm.transactions.Transactional
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import com.example.Departamento

@Transactional
class EmpregadoService {
    
    private EmpregadoDTO toDTO(Empregado empregado) {
        return new EmpregadoDTO(
            id: empregado.id,
            nome: empregado.nome,
            dataNascimento: empregado.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            matricula: empregado.matricula,
            idDepartamento: empregado.departamento.id,
            nomeDepartamento: empregado.departamento.nome,
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
    

    def save(Long id, String nome, int matricula, String dataNascimento, Long departamentoId) {
        
        Empregado e = Empregado.get(id)
        if (e) throw new IllegalArgumentException("Já existe um empregado com este ID.")
        Empregado novoEmpregado = new Empregado()
        
        if (!id) throw new IllegalArgumentException("ID inválido para criação de um novo empregado.")
        novoEmpregado.setId(id)
        if (!nome) throw new IllegalArgumentException("NOME inválido para criação de um novo empregado.")
        novoEmpregado.setNome(nome)
        if (!matricula) throw new IllegalArgumentException("MATRICULA inválida para criação de um novo empregado.")
        novoEmpregado.setMatricula(matricula)
        if (!dataNascimento) throw new IllegalArgumentException("DATA NASCIMENTO inválida para criação de um novo empregado.")
        LocalDate newDate = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        novoEmpregado.setDataNascimento(newDate)
        
        Departamento departamento = Departamento.get(departamentoId)
        if (!departamento) throw new IllegalArgumentException("Departamento inválido.")
        novoEmpregado.setDepartamento(departamento)

        novoEmpregado.save(flush: true)
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
        if (e) {
            e.delete(flush: true)
        } else {
            throw new IllegalArgumentException("Empregado solicitado para exclusão não existe.")
        }
    }
}
