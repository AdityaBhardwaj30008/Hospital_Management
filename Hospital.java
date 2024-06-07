import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    private String name;
    private int age;
    private String disease;

    public Patient(String name, int age, String disease) {
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDisease() {
        return disease;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Disease: " + disease;
    }
}

class Doctor {
    private String name;
    private String specialty;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Specialty: " + specialty;
    }
}

class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment: " + patient.getName() + " with Dr. " + doctor.getName() + " on " + date;
    }
}

public class HospitalManagementSystem {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Create Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    addDoctor();
                    break;
                case 3:
                    createAppointment();
                    break;
                case 4:
                    viewPatients();
                    break;
                case 5:
                    viewDoctors();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 7:
                    System.out.println("Exiting... Thank you for using the Hospital Management System.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter patient disease: ");
        String disease = scanner.nextLine();
        patients.add(new Patient(name, age, disease));
        System.out.println("Patient added successfully.");
    }

    private static void addDoctor() {
        System.out.print("Enter doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter doctor specialty: ");
        String specialty = scanner.nextLine();
        doctors.add(new Doctor(name, specialty));
        System.out.println("Doctor added successfully.");
    }

    private static void createAppointment() {
        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("No patients or doctors available to create an appointment.");
            return;
        }
        System.out.println("Select a patient:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i));
        }
        int patientIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        System.out.println("Select a doctor:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i));
        }
        int doctorIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        System.out.print("Enter appointment date (yyyy-mm-dd): ");
        String date = scanner.nextLine();

        appointments.add(new Appointment(patients.get(patientIndex), doctors.get(doctorIndex), date));
        System.out.println("Appointment created successfully.");
    }

    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments available.");
            return;
        }
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }
}
