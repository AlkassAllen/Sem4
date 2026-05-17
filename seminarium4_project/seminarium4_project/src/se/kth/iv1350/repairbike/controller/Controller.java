package se.kth.iv1350.repairbike.controller;

import se.kth.iv1350.repairbike.exceptions.DatabaseFailureException;
import se.kth.iv1350.repairbike.exceptions.NoSuchCustomerException;
import se.kth.iv1350.repairbike.model.Customer;
import se.kth.iv1350.repairbike.model.RepairOrder;
import se.kth.iv1350.repairbike.model.RepairOrderObserver;
import se.kth.iv1350.repairbike.service.RepairService;

public class Controller {
    private RepairService service;

    public Controller() {
        service = new RepairService();
    }

    public Customer findCustomer(String phone)
            throws NoSuchCustomerException,
            DatabaseFailureException {

        return service.findCustomer(phone);
    }

    public void createRepairOrder(String desc) {
        service.createRepairOrder(desc);
    }

    public void addDiagnostic(String text) {
        service.addDiagnostic(text);
    }

    public void addRepairTask(String desc, int cost) {
        service.addRepairTask(desc, cost);
    }

    public void acceptRepairOrder() {
        service.acceptRepairOrder();
    }

    public RepairOrder getCurrentOrder() {
        return service.getCurrentOrder();
    }

    public void addObserver(RepairOrderObserver obs) {
        service.addObserver(obs);
    }
}
