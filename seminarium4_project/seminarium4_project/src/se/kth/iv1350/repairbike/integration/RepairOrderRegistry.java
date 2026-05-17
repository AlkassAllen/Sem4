package se.kth.iv1350.repairbike.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.repairbike.model.RepairOrder;

public class RepairOrderRegistry {

    private List<RepairOrder> orders = new ArrayList<>();

    public void addOrder(RepairOrder order) {
        orders.add(order);
    }
}
