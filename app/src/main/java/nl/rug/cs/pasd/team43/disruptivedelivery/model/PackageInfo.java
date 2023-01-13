package nl.rug.cs.pasd.team43.disruptivedelivery.model;

public class PackageInfo {
    private int xInMm;
    private int yInMm;
    private int zInMm;
    private boolean perishable;
    private boolean breakable;

    public PackageInfo(int xInCm, int yInCm, int zInCm, boolean perishable, boolean breakable) {
        this.xInMm = xInCm;
        this.yInMm = yInCm;
        this.zInMm = zInCm;
        this.breakable = breakable;
        this.perishable = perishable;
    }

    public int getxInMm() {
        return 10 * xInMm;
    }

    public int getyInMm() {
        return 10 * yInMm;
    }

    public int getzInMm() {
        return 10 * zInMm;
    }
}
