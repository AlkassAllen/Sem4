package se.kth.iv1350.repairbike.model;

import java.util.ArrayList;
import java.util.List;

public class RepairOrder {

    private String description;
    private Customer customer;
    private DiagnosticReport report;

    private List<RepairTask> tasks = new ArrayList<>();

    private String state = "NEW";

    public RepairOrder(String description, Customer customer) {
        this.description = description;
        this.customer = customer;
    }

    public void addDiagnostic(DiagnosticReport report) {
        this.report = report;
    }

    public void addRepairTask(RepairTask task) {
        tasks.add(task);
    }

    public void accept() {
        state = "ACCEPTED";
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Problem: " + description +
                ", Status: " + state;
    }
}
