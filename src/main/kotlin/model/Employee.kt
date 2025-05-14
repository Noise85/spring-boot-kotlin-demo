package ch.iceage.demo.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Employee {

    @Id
    var id: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var email: String? = null

    constructor() {}

    constructor(id: String?, firstName: String?, lastName: String?, email: String?) {
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
    }

    override fun toString(): String {
        return "Employee(id=$id, firstName=$firstName, lastName=$lastName, email=$email)"
    }

}