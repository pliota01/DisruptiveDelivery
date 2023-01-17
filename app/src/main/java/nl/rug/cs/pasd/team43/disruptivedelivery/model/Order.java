package nl.rug.cs.pasd.team43.disruptivedelivery.model;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

import java.util.Date;

public class Order {
    private final Date sendDate;
    private final int xInMm;
    private final int yInMm;
    private final int zInMm;
    private final boolean breakable;
    private final boolean perishable;

    private final AddressInfo senderInfo;
    private final AddressInfo receiverInfo;

    private Delivery lastDelivery;

    private final String id;

    public Order(int xInCm, int yInCm, int zInCm, boolean breakable, boolean perishable, AddressInfo senderInfo, AddressInfo receiverInfo) {
        sendDate = new Date();
        this.xInMm = xInCm;
        this.yInMm = yInCm;
        this.zInMm = zInCm;
        this.breakable = breakable;
        this.perishable = perishable;

        
        
        this.senderInfo = senderInfo;
        this.receiverInfo = receiverInfo;


        RandomStringGenerator randomStringGenerator =
                new RandomStringGenerator.Builder()
                        .withinRange('0', 'z')
                        .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                        .build();
        
        id = randomStringGenerator.generate(12); // toUpperCase() if you want

    }
    
    public Date getSendDate() {
        return sendDate;
    }
    public int getXInMm() {
        return xInMm;
    }

    public int getYInMm() {
        return yInMm;
    }

    public int getZInMm() {
        return zInMm;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public boolean isBreakable() {
        return breakable;
    }

    public AddressInfo getSenderInfo() {
        return senderInfo;
    }
    
    public AddressInfo getReceiverInfo() {
        return receiverInfo;
    }
    public Delivery getLastDelivery() {
        return lastDelivery;
    }
    
    public String getId(){
        return id;
    }
}
