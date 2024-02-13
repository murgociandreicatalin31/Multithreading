package ro.ctrln.java.concurrency.model;

import java.util.Objects;

public class Teacher {

    private String firstName;
    private String lastName;
    private Integer age;
    private String domain;

    public Teacher(String firstName, String lastName, Integer age, String domain) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.domain = domain;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return firstName.equals(teacher.firstName) && lastName.equals(teacher.lastName) && age.equals(teacher.age) && domain.equals(teacher.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, domain);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", domain='" + domain + '\'' +
                '}';
    }
}
