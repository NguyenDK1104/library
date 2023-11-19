package com.nguyendk.employeeservice.command.aggregate;

import com.nguyendk.employeeservice.command.command.CreateEmployeeCommand;
import com.nguyendk.employeeservice.command.command.DeleteEmployeeCommand;
import com.nguyendk.employeeservice.command.command.UpdateemployeeCommand;
import com.nguyendk.employeeservice.command.event.EmployeeCreatedEvent;
import com.nguyendk.employeeservice.command.event.EmployeeDeletedEvent;
import com.nguyendk.employeeservice.command.event.EmployeeUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class EmployeeAggregate {
    @AggregateIdentifier
    private String employeeId;
    private String firstName;
    private String lastName;
    private String skin;
    private Boolean isDiscriplined;

    public EmployeeAggregate() {
    }

    @CommandHandler
    public EmployeeAggregate (CreateEmployeeCommand command) {
        EmployeeCreatedEvent event = new EmployeeCreatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }
    @CommandHandler
    public void handle (UpdateemployeeCommand command) {
        EmployeeUpdatedEvent event = new EmployeeUpdatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }
    @CommandHandler
    public void handle (DeleteEmployeeCommand command) {
        EmployeeDeletedEvent event = new EmployeeDeletedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }
    @EventSourcingHandler
    public void on(EmployeeCreatedEvent event) {
        this.employeeId = event.getEmployeeId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.skin = event.getSkin();
        this.isDiscriplined = event.getIsDiscriplined();
    }
    @EventSourcingHandler
    public void on(EmployeeUpdatedEvent event) {
        this.employeeId = event.getEmployeeId();
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.skin = event.getSkin();
        this.isDiscriplined = event.getIsDiscriplined();
    }
    @EventSourcingHandler
    public void on(EmployeeDeletedEvent event) {
        this.employeeId = event.getEmployeeId();
    }
}
