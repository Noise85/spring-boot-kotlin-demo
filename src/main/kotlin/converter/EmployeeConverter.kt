package ch.iceage.demo.converter

import ch.iceage.demo.dto.EmployeeDto
import ch.iceage.demo.model.Employee
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class EmployeeConverter : Converter<EmployeeDto, Employee> {
    override fun convert(source: EmployeeDto): Employee? {
        val employee = Employee()
        employee.id = source.id
        employee.firstName = source.firstName
        employee.lastName = source.lastName
        employee.email = source.email
        return employee
    }
}