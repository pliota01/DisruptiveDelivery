package nl.rug.cs.pasd.team43.disruptivedelivery.model;

import java.util.Calendar;
import java.util.Date;

public class Delivery {

    private Calendar expectedDeliverDateTime = null;
    private Calendar actualDeliverDateTime = null;
    private final String orderId;
    private final int costInCents;
    private Status status;
    private final String id;

    public Delivery(String orderId, int costInCents, String id) {
        this.orderId = orderId;
        this.costInCents = costInCents;
        this.id = id;
        this.status = Status.EXP;
    }

    public Calendar getExpectedDeliverDateTime() {
        return expectedDeliverDateTime;
    }

    public Calendar getActualDeliverDateTime() {
        return actualDeliverDateTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getCostInCents() {
        return costInCents;
    }

    public Status getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }
}
