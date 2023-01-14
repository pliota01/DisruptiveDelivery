package nl.rug.cs.pasd.team43.disruptivedelivery.model;

public class PackageInfo {
    private final int xInMm;
    private final int yInMm;
    private final int zInMm;
    private final boolean perishable;
    private final boolean breakable;

    public PackageInfo(int xInCm, int yInCm, int zInCm, boolean perishable, boolean breakable) {
        this.xInMm = xInCm;
        this.yInMm = yInCm;
        this.zInMm = zInCm;
        this.breakable = breakable;
        this.perishable = perishable;
    }

    public int getXInMm() {
        return 10 * xInMm;
    }

    public int getYInMm() {
        return 10 * yInMm;
    }

    public int getZInMm() {
        return 10 * zInMm;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public boolean isBreakable() {
        return breakable;
    }
}
