package  com.kotlind.demo.models


class UserC {
    var name: String = "";

    constructor()

    constructor(name: String) {
        this.name = name
    }

    fun sayHello() {
        println("Hola, soy $name");
    }
}
