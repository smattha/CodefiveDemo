package com.skyroof.model;

public class Employee {
    String firstName;
    String lastName;
    Long id; //to Long einai wrapper, anti na pigainei sti mnimi pigainei sto heap (sto JVM)
    //boxing-unboxing: i diadikasia toy na pigainw apo wrapper se primitive type kai to antistrofo
    public Employee(Long id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID=" + id +
                '}';
    }
}
