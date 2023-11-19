package com.nguyendk.employeeservice.query.projection;

import com.nguyendk.employeeservice.command.data.Employee;
import com.nguyendk.employeeservice.command.data.EmployeeRepository;
import com.nguyendk.employeeservice.command.model.EmployeeRequestModel;
import com.nguyendk.employeeservice.query.model.EmployeeResponseModel;
import com.nguyendk.employeeservice.query.queries.GetAllEmployeeQuery;
import com.nguyendk.employeeservice.query.queries.GetEmployeesQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProjection {
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeProjection(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @QueryHandler
    public EmployeeResponseModel handle(GetEmployeesQuery getEmployeesQuery) {
        EmployeeResponseModel model = new EmployeeResponseModel();
        Employee employee = employeeRepository.getReferenceById(getEmployeesQuery.getEmployeeId());
        BeanUtils.copyProperties(employee, model);
        return model;
    }
    @QueryHandler
    public List<EmployeeResponseModel> handle(GetAllEmployeeQuery getEmployeesQuery) {
        List<EmployeeResponseModel> listModel = new ArrayList<>();
        List<Employee> listEntity = employeeRepository.findAll();
        listEntity.forEach(a -> {
            EmployeeResponseModel model = new EmployeeResponseModel();
            BeanUtils.copyProperties(a, model);
            listModel.add(model);
        });
        return listModel;
    }
}
