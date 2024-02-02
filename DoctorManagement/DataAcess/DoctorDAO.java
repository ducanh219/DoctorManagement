
package DataAcess;

import Common.Library;
import Common.Validation;
import Model.Doctor;
import java.util.ArrayList;

public class DoctorDAO {
    private static DoctorDAO instance = null;
    Library l;
    Validation valid;

    ArrayList<Doctor> list;

    public DoctorDAO() {
        l = new Library();
        valid = new Validation();

        list = new ArrayList<>();
    }

    public static DoctorDAO Instance() {
        if (instance == null) {
            synchronized (DoctorDAO.class) {
                if (instance == null) {
                    instance = new DoctorDAO();
                }
            }
        }
        return instance;
    }

    public void addDoctor(ArrayList<Doctor> ld) {
        System.out.println("\nAdd Doctor");
        String code = l.inputString("Enter code: ");

        if (!valid.checkCodeExist(ld, code)) {
            System.err.println("Code exist!!!");
            code = l.inputString("Enter code again: ");
            // System.out.println("\nUpdate Doctor");
            // String codeUpdate = l.inputString("Enter update code: ");
            // Doctor doctor = getDoctorByCode(ld, code);
            // String name = l.inputString("Enter update name: ");
            // String specialization = l.inputString("Enter update specialization: ");
            // int availability = l.getIntNoLimit("Enter availability: ");
            // //check user change infomation or not
            // if (!valid.checkDuplicate(ld, name, specialization, availability)) {
            // System.err.println("Duplicate doctor information!!!");
            // return;
            // }
            // doctor.setCode(codeUpdate);
            // doctor.setName(name);
            // doctor.setSpecialization(specialization);
            // doctor.setAvailability(availability);
            // System.err.println("Update successful!!!");
        }
        // else {
        // System.out.println("\nAdd Doctor");
        // String name = l.inputString("Enter name: ");
        // String specialization = l.inputString("Enter specialization: ");
        // int availability = l.getIntNoLimit("Enter availability");
        //
        // if (!valid.checkDuplicate(ld, name, specialization, availability)) {
        // System.err.println("Duplicate.");
        // return;
        // }
        // ld.add(new Doctor(code, name, specialization, availability));
        // System.err.println("Add successful!!!");
        // }
        // System.out.println("\nAdd Doctor");
        String name = l.inputString("Enter name: ");
        String specialization = l.inputString("Enter specialization: ");
        int availability = l.getIntNoLimit("Enter availability");

        if (!valid.checkDuplicate(ld, name, specialization, availability)) {
            System.err.println("Duplicate.");
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.err.println("Add successful!!!");
    }

    public void updateDoctor(ArrayList<Doctor> ld) {
        System.out.println("\nUpdate Doctor");
        if (ld.isEmpty()) {
            System.err.println("There are no doctor in the list!!!");
            return;
        }
        String code = l.inputString("Enter code: ");
        if (valid.checkCodeExist(ld, code)) {
            System.err.println("Cann't found doctor!!!");
            code = l.inputString("Enter code again: ");
        }
        String codeUpdate = l.inputString("Enter update code: ");
        Doctor doctor = getDoctorByCode(ld, code);
        String name = l.inputString("Enter update name: ");
        String specialization = l.inputString("Enter update specialization: ");
        int availability = l.getIntNoLimit("Enter availability: ");

        if (!valid.checkDuplicate(ld, name, specialization, availability)) {
            System.err.println("Duplicate doctor information!!!");
            return;
        }
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println("Update successful!!!");
    }

    public void deleteDoctor(ArrayList<Doctor> ld) {
        System.out.println("\nDelete Doctor");
        if (ld.isEmpty()) {
            System.err.println("There are no doctor in the list!!!");
            return;
        }
        String code = l.inputString("Enter code: ");
        // check code exist or not
        if (valid.checkCodeExist(ld, code)) {
            System.err.println("Not found doctor");
            return;
        }
        Doctor doctor = getDoctorByCode(ld, code);
        if (doctor == null) {
            System.err.println("Cann't found doctor!!!");
            return;
        } else {
            ld.remove(doctor);
        }
        System.err.println("Delete successful!!!");
    }

    public void searchDoctor(ArrayList<Doctor> ld) {
        System.out.println("\nSearch Doctor");
        if (ld.isEmpty()) {
            System.err.println("There are no doctor in the list!!!");
            return;
        }
        String searchString = l.inputString("Enter text: ");
        ArrayList<Doctor> listFoundByString = getListDoctorByString(ld, searchString);
        if (listFoundByString.isEmpty()) {
            System.err.println("Cann't found any result!!!");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listFoundByString) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }

    public Doctor getDoctorByCode(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    public ArrayList<Doctor> getListDoctorByString(ArrayList<Doctor> ld, String searchString) {
        ArrayList<Doctor> list = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getCode().contains(searchString) || doctor.getName().contains(searchString)
                    || doctor.getSpecialization().contains(searchString)) {
                list.add(doctor);
            }
        }
        return list;
    }
}
