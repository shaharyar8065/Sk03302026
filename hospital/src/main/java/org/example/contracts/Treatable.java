package org.example.contracts;
import org.example.entities.Patient;


public interface Treatable {

    public void treat(Patient patient);
    public void prescribe(Patient patient, String medicine);
}
