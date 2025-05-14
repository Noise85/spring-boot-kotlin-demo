package ch.iceage.demo.converter

import ch.iceage.demo.model.Employee
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class EmployeeDtoConverter : Converter<Employee, ch.iceage.demo.dto.EmployeeDto> {
    override fun convert(source: Employee): ch.iceage.demo.dto.EmployeeDto {
        return ch.iceage.demo.dto.EmployeeDto(
            id = source.id ?: "",
            firstName = source.firstName ?: "",
            lastName = source.lastName ?: "",
            email = source.email ?: ""
        )
    }
}