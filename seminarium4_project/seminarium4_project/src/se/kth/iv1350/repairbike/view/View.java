package se.kth.iv1350.repairbike.view;

import se.kth.iv1350.repairbike.controller.Controller;
import se.kth.iv1350.repairbike.exceptions.DatabaseFailureException;
import se.kth.iv1350.repairbike.exceptions.NoSuchCustomerException;
import se.kth.iv1350.repairbike.model.Customer;
import se.kth.iv1350.repairbike.model.RepairOrder;

public class View {
    private Controller contr;

    public View(Controller contr) {
        this.contr = contr;
    }

    public void start() {
        System.out.println("Startar system...\n");

        try {
            Customer cust = contr.findCustomer("0701234567");

            System.out.println("Kund hittad: " + cust.getName());

            contr.createRepairOrder("Motorn fungerar inte");

            contr.addDiagnostic("Batteriet är trasigt");

            contr.addRepairTask("Byt batteri", 1200);

            contr.acceptRepairOrder();

            RepairOrder order = contr.getCurrentOrder();

            System.out.println("\nSlutlig order:");
            System.out.println(order);

        } catch (NoSuchCustomerException exc) {
            System.out.println("Kunden kunde inte hittas.");

        } catch (DatabaseFailureException exc) {
            System.out.println("Databasen kunde inte nås.");
        }
    }
}
