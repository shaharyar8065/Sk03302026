package org.example.entities;

import java.util.Objects;

public abstract class Person {

        private String id;
        private String name;

        public Person(String id, String name) {
                this.id   = id;
                this.name = name;
        }

        public abstract String getRole();

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        @Override
        public boolean equals(Object o) {
                if (!(o instanceof Person person)) return false;
            return Objects.equals(getId(), person.getId()) && Objects.equals(getName(), person.getName());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getId(), getName());
        }

        @Override
        public String toString() {
                return "Person{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        '}';
        }
}
