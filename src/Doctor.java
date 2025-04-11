// Doctor.java
public class Doctor implements SeesPatients, Comparable<Doctor> {
    private static int numDoctors = 0;
    private String name;
    private int licenseNumber;
    private Patient[] patients;
    private int numberOfPatients;

    public Doctor(String name) {
        this.name = name;
        this.licenseNumber = ++numDoctors;
        this.patients = new Patient[MAX_PATIENTS];
        this.numberOfPatients = 0;
    }

    public static int getNumDoctors() {
        return numDoctors;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }

    @Override
    public Patient[] getPatients() {
        Patient[] currentPatients = new Patient[numberOfPatients];
        System.arraycopy(patients, 0, currentPatients, 0, numberOfPatients);
        return currentPatients;
    }

    @Override
    public void addPatient(Patient p) throws PatientException {
        if (numberOfPatients >= MAX_PATIENTS) {
            throw new PatientException("Maximum number of patients reached for this doctor");
        }
        patients[numberOfPatients++] = p;
    }

    @Override
    public String getPatientsAsString() {
        StringBuilder sb = new StringBuilder("patients= ");
        for (int i = 0; i < numberOfPatients; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(patients[i].toString());
        }
        return sb.toString();
    }

    @Override
    public boolean isPatient(Patient p) {
        for (int i = 0; i < numberOfPatients; i++) {
            if (patients[i].equals(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Doctor: name= %20s | license number= %06d | %s", 
                            name, licenseNumber, getPatientsAsString());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Doctor) {
            Doctor other = (Doctor) o;
            return this.name.equals(other.name) && 
                   this.numberOfPatients == other.numberOfPatients;
        }
        return false;
    }

    @Override
    public int compareTo(Doctor other) {
        return Integer.compare(this.numberOfPatients, other.numberOfPatients);
    }
}