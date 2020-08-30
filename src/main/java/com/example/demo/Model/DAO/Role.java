package com.example.demo.Model.DAO;

import javax.persistence.*;

@Entity
@Table(name = "roluri")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String Name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
