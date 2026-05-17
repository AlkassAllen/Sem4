package se.kth.iv1350.repairbike.startup;

import se.kth.iv1350.repairbike.controller.Controller;
import se.kth.iv1350.repairbike.integration.RepairOrderLogger;
import se.kth.iv1350.repairbike.view.RepairOrderView;
import se.kth.iv1350.repairbike.view.View;

public class Main {
    public static void main(String[] args) {
        Controller contr = new Controller();

        contr.addObserver(new RepairOrderView());
        contr.addObserver(new RepairOrderLogger());

        View view = new View(contr);
        view.start();
    }
}
