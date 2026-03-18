package  com.kotlind.demo.models

open class User(var name: String) {
    open fun presentarse() {
        println("Hello my name is $name")
    }
}
