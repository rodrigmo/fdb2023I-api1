package com.example

import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class EmpregadoServiceSpec extends Specification implements DomainUnitTest<Empregado>, ServiceUnitTest<EmpregadoService> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"To Do"
        true == true
    }
}
