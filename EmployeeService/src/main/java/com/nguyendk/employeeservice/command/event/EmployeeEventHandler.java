package com.nguyendk.employeeservice.command.event;

import com.nguyendk.employeeservice.command.data.Employee;
import com.nguyendk.employeeservice.command.data.EmployeeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEventHandler {
    @Autowired
    private EmployeeRepository employeeRepository;
    @EventHandler
    public void on(EmployeeCreatedEvent event) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(event, employee);
        employeeRepository.save(employee);
    }
    @EventHandler
    public void on(EmployeeUpdatedEvent event) {
        Employee employee = employeeRepository.getReferenceById(event.getEmployeeId());
        employee.setFirstName(event.getFirstName());
        employee.setLastName(event.getLastName());
        employee.setSkin(event.getSkin());
        employee.setIsDiscriplined(event.getIsDiscriplined());
        employeeRepository.save(employee);
    }
    @EventHandler
    public void on(EmployeeDeletedEvent event) {
        employeeRepository.deleteById(event.getEmployeeId());
    }
}
