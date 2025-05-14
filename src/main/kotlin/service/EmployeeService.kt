package ch.iceage.demo.service

import ch.iceage.demo.converter.EmployeeConverter
import ch.iceage.demo.converter.EmployeeDtoConverter
import ch.iceage.demo.dto.EmployeeDto
import ch.iceage.demo.persistence.EmployeeRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
open class EmployeeService(
    private val employeeRepository: EmployeeRepository,
    private val employeeDtoConverter: EmployeeDtoConverter,
    private val employeeConverter: EmployeeConverter
) {
    fun findAll(): List<EmployeeDto> =
        employeeRepository.findAll().map { employeeDtoConverter.convert(it) }

    fun findById(id: String): EmployeeDto? =
        employeeRepository.findById(id).map { employeeDtoConverter.convert(it) }.orElse(null)

    @Transactional
    fun save(employee: EmployeeDto): EmployeeDto {
        val entity = employeeConverter.convert(employee)
            ?: throw IllegalArgumentException("Employee conversion failed")
        val savedEntity = employeeRepository.save(entity)
        return employeeDtoConverter.convert(savedEntity)
    }

    @Transactional
    fun update(employee: EmployeeDto): EmployeeDto? {
        if (!employeeRepository.existsById(employee.id)) return null
        val entity = employeeConverter.convert(employee)
            ?: throw IllegalArgumentException("Employee conversion failed")
        val updatedEntity = employeeRepository.save(entity)
        return employeeDtoConverter.convert(updatedEntity)
    }

    @Transactional
    fun delete(id: String): Boolean =
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id)
            true
        } else {
            false
        }
}