package  com.kotlind.demo.controllers

import com.kotlind.demo.models.Employee
import com.kotlind.demo.models.User
import com.kotlind.demo.models.UserC
import com.kotlind.demo.models.vendedor.Vendedor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("play")
class PlaygroundController {

    @GetMapping
    fun index(): ResponseEntity<Any> {
        val user1 = UserC("Peter");
        val user2 = UserC();
        var employee: Employee = Employee("Jack", 328.1)
        employee.salary = 325.17
        user2.name = "Steve";
        val resl = listOf(user1, user2)
        val res = mapOf("usersc" to resl, "employee" to employee)
        var vend = Vendedor()
        val a = 1
        Vendedor.test()
        if (a.equals(1)) {
            throw Exception("Dev test exception")
        }
        return ResponseEntity.ok().body(res);

    }
}
