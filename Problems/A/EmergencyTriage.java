package A;

import java.util.*;

public class EmergencyTriage {

    static class Patient {
        String id;
        int priority;
        Patient prev;
        Patient next;

        Patient(String id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    static class PriorityList {
        Patient head;
        Patient tail;

        void add(Patient patient) {

            if (head == null) {
                head = tail = patient;
            } else {
                tail.next = patient;
                patient.prev = tail;
                tail = patient;
            }
        }

        void remove(Patient patient) {

            if (patient.prev != null) {
                patient.prev.next = patient.next;
            } else {
                head = patient.next;
            }

            if (patient.next != null) {
                patient.next.prev = patient.prev;
            } else {
                tail = patient.prev;
            }

            patient.prev = null;
            patient.next = null;
        }

        Patient removeHighest() {

            if (head == null) {
                return null;
            }

            Patient patient = head;
            remove(patient);

            return patient;
        }
    }

    private PriorityList[] priorityLists;
    private HashMap<String, Patient> patients;
    private int highestPriority;

    public EmergencyTriage(int maxPriority) {

        if (maxPriority <= 0) {
            throw new IllegalArgumentException();
        }

        priorityLists = new PriorityList[maxPriority + 1];
        patients = new HashMap<>();
        highestPriority = maxPriority;

        for (int i = 0; i <= maxPriority; i++) {
            priorityLists[i] = new PriorityList();
        }
    }

    public void addPatient(String id, int priority) {

        if (id == null || priority < 0 ||
                priority > highestPriority ||
                patients.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        Patient patient = new Patient(id, priority);

        priorityLists[priority].add(patient);
        patients.put(id, patient);
    }

    public void escalateToEmergency(String id) {

        Patient patient = patients.get(id);

        if (patient == null) {
            return;
        }

        priorityLists[patient.priority].remove(patient);

        patient.priority = highestPriority;

        priorityLists[highestPriority].add(patient);
    }

    public String popNextCritical() {

        for (int priority = highestPriority;
             priority >= 0;
             priority--) {

            Patient patient = priorityLists[priority].removeHighest();

            if (patient != null) {
                patients.remove(patient.id);
                return patient.id;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        EmergencyTriage system = new EmergencyTriage(5);

        system.addPatient("P99", 3);
        system.addPatient("P100", 1);

        system.escalateToEmergency("P100");

        System.out.println(system.popNextCritical());
    }
}