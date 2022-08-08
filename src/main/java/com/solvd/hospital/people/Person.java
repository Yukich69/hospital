package com.solvd.hospital.people;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Person {
    private static final Logger log = LogManager.getLogger(com.solvd.hospital.people.Person.class);
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age)  {

        if(ageLimit(age)) {
            try {
                throw new AgeEnterException();
            } catch (AgeEnterException e) {
                log.error(e.getMessage());
                log.info("Wrong age");
            }
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if(ageLimit(age)) {
            try {
                throw new AgeEnterException();
            } catch (AgeEnterException e) {
                log.error(e.getMessage());
                log.info("Wrong age");
            }
        }

        this.age = age;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + getName() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName().hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return hashCode() == person.hashCode();
    }

    private boolean ageLimit(int age) {
        return age <= 0;
    }
}
