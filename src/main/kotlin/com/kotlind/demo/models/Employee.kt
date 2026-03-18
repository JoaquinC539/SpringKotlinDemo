package com.kotlind.demo.models

class Employee(name: String, var salary: Double) : User(name) {

    override fun presentarse() {
        println("Soy el empleado $name y gano $salary")
    }
}
