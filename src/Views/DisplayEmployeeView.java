package Views;

import Controlleurs.ViewControlleur;
import Domain.Employee;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayEmployeeView extends JPanel {

    public JPanel salaryPanel;
    public JTable dispListEmployee;
    public JLabel salaryMoyen;
    public JTextField dispSalary;
    public JButton quit;

    public DisplayEmployeeView (ViewControlleur viewControlleur){
        int nbEmploye = Integer.valueOf(viewControlleur.p.nbTotalEmployee());
        Object[][] dataPersonnel = new Object[nbEmploye+1][];
        this.setLayout(new BorderLayout());
        ArrayList<Employee> employeeArrayList = viewControlleur.p.getEmploye();
        int i = 0;
        int sumSalaire = 0;
        for (Employee employee : employeeArrayList){
            dataPersonnel[i] = (new Object[]{
                    employee.getPosition(),
                    employee.getName(),
                    String.valueOf(employee.getAge()),
                    employee.getEntryYear(),
                    employee.calculerSalaire()}
                    );
            sumSalaire += employee.calculerSalaire();
            i++;
        }
        dataPersonnel[i] = (new Object[]{"Salaire Moyen", "", "", "", viewControlleur.p.salaireMoyen()});
        String[] headerTable = {"Poste", "Employé", "Age", "Année d'embauche", "Salaire"};
        dispListEmployee = new JTable(dataPersonnel, headerTable);
        quit = new JButton("Quittez");
        quit.addActionListener(viewControlleur);
        this.add(dispListEmployee, BorderLayout.CENTER);
        salaryPanel = new JPanel(new GridLayout(1,2));
        salaryMoyen = new JLabel("Salaire moyen :");
        dispSalary = new JTextField(String.valueOf(sumSalaire));
        salaryPanel.add(salaryMoyen);
        salaryPanel.add(dispSalary);
        this.add(salaryPanel, BorderLayout.NORTH);
        this.add(quit, BorderLayout.SOUTH);
    }

}
