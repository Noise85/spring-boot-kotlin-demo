package ch.iceage.demo.controller

import ch.iceage.demo.dto.EmployeeDto
import ch.iceage.demo.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/employees")
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping
    fun getAllEmployees(): ResponseEntity<List<EmployeeDto>> =
        ResponseEntity.ok(employeeService.findAll())

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: String): ResponseEntity<EmployeeDto> =
        employeeService.findById(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createEmployee(@RequestBody employeeDto: EmployeeDto): ResponseEntity<EmployeeDto> =
        ResponseEntity.ok(employeeService.save(employeeDto))

    @PutMapping
    fun updateEmployee(@RequestBody employeeDto: EmployeeDto): ResponseEntity<EmployeeDto> =
        employeeService.update(employeeDto)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: String): ResponseEntity<Void> =
        if (employeeService.delete(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }

}