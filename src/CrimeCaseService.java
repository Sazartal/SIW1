import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;

public class CrimeCaseService {

    private ArrayList<CrimeCase> cases;
    private HashSet<CrimeCase> uniqueCases;
    private HashMap<Integer, CrimeCase> casesById;
    private ArrayDeque<CrimeCase> caseQueue;

    public CrimeCaseService() {
        cases = new ArrayList<>();
        uniqueCases = new HashSet<>();
        casesById = new HashMap<>();
        caseQueue = new ArrayDeque<>();
    }

    // CREATE
    public void addCase(CrimeCase crimeCase) {
        if (crimeCase == null) {
            System.out.println("Error: case cannot be null.");
            return;
        }

        if (casesById.containsKey(crimeCase.getCaseId())) {
            System.out.println("Error: case ID already exists.");
            return;
        }

        cases.add(crimeCase);
        uniqueCases.add(crimeCase);
        casesById.put(crimeCase.getCaseId(), crimeCase);
        caseQueue.add(crimeCase);

        System.out.println("Case added successfully.");
    }

    // READ
    public void showAllCases() {
        if (cases.isEmpty()) {
            System.out.println("No cases available.");
            return;
        }

        for (CrimeCase crimeCase : cases) {
            crimeCase.displayInfo();
            System.out.println("----------------");
        }
    }

    public CrimeCase findCase(int caseId) {
        return casesById.get(caseId);
    }

    // UPDATE
    public void updateCaseDays(int caseId, int newDays) {
        CrimeCase crimeCase = findCase(caseId);

        if (crimeCase != null && newDays >= 0) {
            crimeCase.setDaysOpen(newDays);
            System.out.println("Case updated.");
        } else {
            System.out.println("Error: case not found or invalid days.");
        }
    }

    // DELETE
    public void removeCase(int caseId) {
        CrimeCase crimeCase = casesById.remove(caseId);

        if (crimeCase != null) {
            cases.remove(crimeCase);
            uniqueCases.remove(crimeCase);
            caseQueue.remove(crimeCase);
            System.out.println("Case removed.");
        } else {
            System.out.println("Case not found.");
        }
    }

    public void sortById() {
        Collections.sort(cases);
        showAllCases();
    }

    public void sortByPriority() {
        cases.sort(Comparator.comparingDouble(CrimeCase::calculatePriority));
        showAllCases();
    }

    public void sortByDaysOpen() {
        cases.sort(Comparator.comparingInt(CrimeCase::getDaysOpen));
        showAllCases();
    }

    public void showCasesByType() {
        HashMap<String, ArrayList<CrimeCase>> groupedCases = new HashMap<>();

        for (CrimeCase crimeCase : cases) {
            String type = crimeCase.getCaseType();

            if (!groupedCases.containsKey(type)) {
                groupedCases.put(type, new ArrayList<>());
            }

            groupedCases.get(type).add(crimeCase);
        }

        for (String type : groupedCases.keySet()) {
            System.out.println("Type: " + type);

            for (CrimeCase crimeCase : groupedCases.get(type)) {
                System.out.println("Case ID: " + crimeCase.getCaseId());
            }
        }
    }

    public void processNextCase() {
        if (caseQueue.isEmpty()) {
            System.out.println("No cases in queue.");
        } else {
            CrimeCase crimeCase = caseQueue.poll();
            System.out.println("Processing case: " + crimeCase.getCaseId());
        }
    }

    public int getTotalCases() {
        return cases.size();
    }

    public int getUniqueCasesCount() {
        return uniqueCases.size();
    }
}