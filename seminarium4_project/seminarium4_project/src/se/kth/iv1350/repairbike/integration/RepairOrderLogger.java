package se.kth.iv1350.repairbike.integration;

import se.kth.iv1350.repairbike.model.RepairOrder;
import se.kth.iv1350.repairbike.model.RepairOrderObserver;
import se.kth.iv1350.repairbike.util.FileLogger;

public class RepairOrderLogger implements RepairOrderObserver {

    private FileLogger logger = new FileLogger();

    @Override
    public void newRepairOrderUpdate(RepairOrder order) {
        logger.log(order.toString());
    }
}
