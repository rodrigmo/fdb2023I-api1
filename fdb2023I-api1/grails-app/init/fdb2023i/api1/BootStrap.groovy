package fdb2023i.api1

import com.example.DatabaseSeederService

class BootStrap {

    DatabaseSeederService databaseSeederService

    def init = { servletContext ->
        databaseSeederService.seedData()
    }
    def destroy = {
    }
}
