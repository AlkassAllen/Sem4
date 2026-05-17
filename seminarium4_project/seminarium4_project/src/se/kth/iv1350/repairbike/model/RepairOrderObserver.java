package se.kth.iv1350.repairbike.model;

public interface RepairOrderObserver {
    void newRepairOrderUpdate(RepairOrder order);
}
