package com.example.demo.Model.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jobCategory")
public class JobCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_jobCategory")
    private int id;
    @Column(name ="name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "jobCategory",fetch= FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Employee> employeeList;

    public int getId() {
        return id;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }


    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JobCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
