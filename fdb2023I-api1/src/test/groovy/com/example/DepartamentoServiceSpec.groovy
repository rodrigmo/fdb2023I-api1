package com.example

import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class DepartamentoServiceSpec extends Specification implements DomainUnitTest<Departamento>, ServiceUnitTest<DepartamentoService> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"To Do"
        true == true
    }
}
