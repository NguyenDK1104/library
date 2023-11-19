package com.nguyendk.employeeservice.command.controller;

import com.nguyendk.employeeservice.command.command.CreateEmployeeCommand;
import com.nguyendk.employeeservice.command.command.DeleteEmployeeCommand;
import com.nguyendk.employeeservice.command.command.UpdateemployeeCommand;
import com.nguyendk.employeeservice.command.model.EmployeeRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeCommandController {
    @Autowired
    private CommandGateway commandGateway;
    @PostMapping("/create-Employee")
    public String addEmployee(@RequestBody EmployeeRequestModel model) {
        CreateEmployeeCommand command =
                new CreateEmployeeCommand(UUID.randomUUID().toString(), model.getFirstName(), model.getLastName(), model.getSkin(), false);
        commandGateway.sendAndWait(command);
        return "employee added!";
    }
    @PutMapping("/update-Employee")
    public String updateEmployee(@RequestBody EmployeeRequestModel model) {
        UpdateemployeeCommand command =
                new UpdateemployeeCommand(model.getEmployeeId(), model.getFirstName(), model.getLastName(), model.getSkin(), model.getIsDiscriplined());
        commandGateway.sendAndWait(command);
        return "Update success!";
    }

    @DeleteMapping("/delete-employee/{employeeId}")
    public String deleteEmplyee(@PathVariable String employeeId) {
        DeleteEmployeeCommand command = new DeleteEmployeeCommand(employeeId);
        commandGateway.sendAndWait(command);
        return "deleted empployee!";
    }
}
