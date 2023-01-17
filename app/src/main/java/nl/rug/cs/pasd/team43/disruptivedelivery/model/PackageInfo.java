package nl.rug.cs.pasd.team43.disruptivedelivery.model;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
public class PackageInfo {
    private final int xInMm;
    private final int yInMm;
    private final int zInMm;
    private final boolean perishable;
    private final boolean breakable;
    private final String id;

    public PackageInfo(int xInCm, int yInCm, int zInCm, boolean perishable, boolean breakable) {
        this.xInMm = xInCm;
        this.yInMm = yInCm;
        this.zInMm = zInCm;
        this.breakable = breakable;
        this.perishable = perishable;

        RandomStringGenerator randomStringGenerator =
                new RandomStringGenerator.Builder()
                        .withinRange('0', 'z')
                        .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                        .build();
        id = randomStringGenerator.generate(12); // toUpperCase() if you want
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

    public String getId(){
        return id;
    }
}
