
package edu.ccrm.domain;

import java.util.Objects;

public class Instructor {
    private final String id;
    private final String firstName;
    private final String lastName;
    
    public Instructor(String id, String firstName, String lastName) {
        this.id = Objects.requireNonNull(id, "ID cannot be null");
        this.firstName = Objects.requireNonNull(firstName, "First name cannot be null");
        this.lastName = Objects.requireNonNull(lastName, "Last name cannot be null");
    }
    
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getFullName() { return firstName + " " + lastName; }
    
    @Override
    public String toString() {
        return "Instructor{id='" + id + "', firstName='" + firstName + "', lastName='" + lastName + "'}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() { return Objects.hash(id); }
}