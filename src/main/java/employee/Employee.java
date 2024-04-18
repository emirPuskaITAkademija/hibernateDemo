package employee;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public non-sealed class Employee extends AbstractEmployee implements Serializable {
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;

    private Boolean employed;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Employee setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Boolean getEmployed() {
        return employed;
    }

    public Employee setEmployed(Boolean employed) {
        this.employed = employed;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createdAt=" + createdAt +
                ", employed=" + employed +
                '}';
    }
}
