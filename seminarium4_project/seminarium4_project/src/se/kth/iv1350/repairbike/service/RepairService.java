package se.kth.iv1350.repairbike.service;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.repairbike.exceptions.DatabaseFailureException;
import se.kth.iv1350.repairbike.exceptions.NoSuchCustomerException;
import se.kth.iv1350.repairbike.integration.CustomerRegistry;
import se.kth.iv1350.repairbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairbike.model.Customer;
import se.kth.iv1350.repairbike.model.DiagnosticReport;
import se.kth.iv1350.repairbike.model.RepairOrder;
import se.kth.iv1350.repairbike.model.RepairOrderObserver;
import se.kth.iv1350.repairbike.model.RepairTask;

public class RepairService {

    private CustomerRegistry custReg = new CustomerRegistry();
    private RepairOrderRegistry orderReg = new RepairOrderRegistry();

    private List<RepairOrderObserver> observers = new ArrayList<>();

    private Customer currentCustomer;
    private RepairOrder currentOrder;

    public Customer findCustomer(String phone)
            throws NoSuchCustomerException,
            DatabaseFailureException {

        currentCustomer = custReg.findCustomer(phone);

        return currentCustomer;
    }

    public void createRepairOrder(String desc) {
        currentOrder = new RepairOrder(desc, currentCustomer);

        orderReg.addOrder(currentOrder);

        notifyObservers();
    }

    public void addDiagnostic(String text) {
        currentOrder.addDiagnostic(new DiagnosticReport(text));

        notifyObservers();
    }

    public void addRepairTask(String desc, int cost) {
        currentOrder.addRepairTask(new RepairTask(desc, cost));

        notifyObservers();
    }

    public void acceptRepairOrder() {
        currentOrder.accept();

        notifyObservers();
    }

    public RepairOrder getCurrentOrder() {
        return currentOrder;
    }

    public void addObserver(RepairOrderObserver obs) {
        observers.add(obs);
    }

    private void notifyObservers() {
        for (RepairOrderObserver obs : observers) {
            obs.newRepairOrderUpdate(currentOrder);
        }
    }
}
