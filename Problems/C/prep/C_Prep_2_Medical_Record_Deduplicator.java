package C.prep;

public class C_Prep_2_Medical_Record_Deduplicator {

    public static int removeDuplicates(String[] admissions) {
        if (admissions == null) {
            throw new IllegalArgumentException("Admissions cannot be null");
        }
        if (admissions.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < admissions.length; j++) {
            if (!admissions[j].equals(admissions[i])) {
                i++;
                admissions[i] = admissions[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        String[] admissions = {
                "P10", "P10", "P20", "P30", "P30", "P40"
        };
        int length = removeDuplicates(admissions);
        System.out.println("Unique length: " + length);
        System.out.println("Unique records:");
        for (int i = 0; i < length; i++) {
            System.out.print(admissions[i] + " ");
        }
    }
}