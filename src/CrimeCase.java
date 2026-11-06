import java.util.Objects;

// Abstract base class
public abstract class CrimeCase implements Comparable<CrimeCase> {

    private int caseId;
    private String title;
    private String location;
    private String investigator;
    private int daysOpen;

    // Composition
    private CaseFile caseFile;

    public CrimeCase(int caseId, String title, String location,
                     String investigator, int daysOpen) {
        setCaseId(caseId);
        setTitle(title);
        setLocation(location);
        setInvestigator(investigator);
        setDaysOpen(daysOpen);
        this.caseFile = new CaseFile();
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        if (caseId > 0) {
            this.caseId = caseId;
        } else {
            System.out.println("Error: case id must be positive.");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Error: title cannot be empty.");
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location != null && !location.isEmpty()) {
            this.location = location;
        } else {
            System.out.println("Error: location cannot be empty.");
        }
    }

    public String getInvestigator() {
        return investigator;
    }

    public void setInvestigator(String investigator) {
        if (investigator != null && !investigator.isEmpty()) {
            this.investigator = investigator;
        } else {
            System.out.println("Error: investigator name cannot be empty.");
        }
    }

    public int getDaysOpen() {
        return daysOpen;
    }

    public void setDaysOpen(int daysOpen) {
        if (daysOpen >= 0) {
            this.daysOpen = daysOpen;
        } else {
            System.out.println("Error: days open cannot be negative.");
        }
    }

    public CaseFile getCaseFile() {
        return caseFile;
    }

    public void addNote(String note) {
        caseFile.addNote(note);
    }

    public abstract String getCaseType();

    public abstract double calculatePriority();

    public void displayInfo() {
        System.out.println("Case ID: " + caseId);
        System.out.println("Title: " + title);
        System.out.println("Location: " + location);
        System.out.println("Investigator: " + investigator);
        System.out.println("Days open: " + daysOpen);
    }

    public void extendInvestigation(int days) {
        if (days > 0) {
            daysOpen = daysOpen + days;
            System.out.println("Investigation of case " + caseId
                    + " extended by " + days + " days.");
        } else {
            System.out.println("Error: days must be positive.");
        }
    }

    // Natural ordering by case ID
    @Override
    public int compareTo(CrimeCase other) {
        return Integer.compare(this.caseId, other.caseId);
    }

    // Equality by case ID and concrete class
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CrimeCase other = (CrimeCase) obj;
        return caseId == other.caseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), caseId);
    }
}