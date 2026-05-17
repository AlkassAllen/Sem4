package se.kth.iv1350.repairbike.view;

import se.kth.iv1350.repairbike.model.RepairOrder;
import se.kth.iv1350.repairbike.model.RepairOrderObserver;

public class RepairOrderView implements RepairOrderObserver {

    @Override
    public void newRepairOrderUpdate(RepairOrder order) {
        System.out.println("\nOrder uppdaterad:");
        System.out.println(order);
    }
}
