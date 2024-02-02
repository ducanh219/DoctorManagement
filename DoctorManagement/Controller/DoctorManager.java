
package Controller;

import View.Menu;
import Model.Doctor;
import Repository.DoctorRepository;
import java.util.ArrayList;

public class DoctorManager extends Menu<String> {
    static String[] mc = { "Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit" };
    ArrayList<Doctor> ld;
    DoctorRepository program;

    public DoctorManager() {
        super("\nDoctor Management", mc);
        ld = new ArrayList<>();
        program = new DoctorRepository();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                program.addDoctor(ld);
                break;
            case 2:
                program.addDoctor(ld);
                break;
            case 3:
                program.deleteDoctor(ld);
                break;
            case 4:
                program.searchDoctor(ld);
                break;
            case 5:
                System.exit(0);
        }
    }
}
