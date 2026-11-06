import java.util.ArrayList;

public class PoliceDepartment {

    private String departmentName;
    private ArrayList<Investigator> investigators;
    private ArrayList<CrimeCase> cases;

    public PoliceDepartment(String departmentName) {
        this.departmentName = departmentName;
        investigators = new ArrayList<>();
        cases = new ArrayList<>();
    }

    public void addInvestigator(Investigator investigator) {
        if (investigator != null) {
            investigators.add(investigator);
            System.out.println("Investigator added.");
        }
    }

    public void addCase(CrimeCase crimeCase) {
        if (crimeCase != null) {
            cases.add(crimeCase);
            System.out.println("Case added.");
        }
    }

    public void showInvestigators() {
        System.out.println("Department: " + departmentName);
        for (Investigator investigator : investigators) {
            investigator.displayInfo();
        }
    }

    public void showCases() {
        System.out.println("Cases in " + departmentName + ":");
        for (CrimeCase crimeCase : cases) {
            crimeCase.displayInfo();
            System.out.println("----------------");
        }
    }
}