// DoctorTest.java
public class DoctorTest {
    public static void main(String[] args) {
        try {
            // Test Doctor
            Doctor doc1 = new Doctor("John Smith");
            doc1.addPatient(new Patient("Alice", 2000, "Fever"));
            System.out.println(doc1);

            // Test Pediatrician
            Pediatrician ped = new Pediatrician("Emily Brown", true, "Children's Hospital");
            ped.addPatient(new Patient("Baby Bob", 2020, "Cold")); // OK (age < 18)
            System.out.println(ped);

            // Test Gerontologist
            Gerontologist ger = new Gerontologist("Robert Davis", true, 50.0);
            ger.addPatient(new Patient("Grandma Eve", 1940, "Arthritis")); // OK (age > 65)
            System.out.println(ger);
            
            Gerontologist ger1 = new Gerontologist("Dr. Smith");
            ger1.setVisitFee(50.0);  // Positive value
           // ger1.setVisitFee(-10.0); // Should default to 0.0
            ger1.setVisitFee(0.0);   // Edge case
            System.out.println(ger1);
            

        } catch (PatientException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}