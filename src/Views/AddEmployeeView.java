package Views;

import Controlleurs.*;
import Domain.*;

import javax.swing.*;
import java.awt.*;

public class AddEmployeeView extends JPanel {

    public JLabel typeEmployee;
    public JComboBox<String> posteEmployee;
    public JLabel firstNameEmployee;
    public JLabel lastNameEmployee;
    public JLabel ageEmployee;
    public JLabel startEmployee;
    public JLabel salaryEmployee;
    public JTextField editFirstNameEmployee;
    public JTextField editLastNameEmployee;
    public JTextField editAgeEmployee;
    public JTextField editStartEmployee;
    public JTextField editSalaryEmployee;
    public JButton submit;
    public JButton back;
    private String selectPoste;
    private String firstName;
    private String lastName;
    private int age;
    private String startDate;
    private int salary;

    public AddEmployeeView (ViewControlleur viewControlleur){
        this.setLayout(new GridLayout(7,2));
        typeEmployee = new JLabel("Poste :");
        posteEmployee = new JComboBox<String>();
        posteEmployee.addItem("Sélectionner un poste");
        posteEmployee.addItem("ManutARisque");
        posteEmployee.addItem("Manutentionnaire");
        posteEmployee.addItem("Représentant");
        posteEmployee.addItem("TechARisque");
        posteEmployee.addItem("Technicien");
        posteEmployee.addItem("Vendeur");
        posteEmployee.addActionListener(e -> {
            selectPoste = (String) ((JComboBox<String>) e.getSource()).getModel().getSelectedItem();
        });
        firstNameEmployee = new JLabel("Prénom :");
        lastNameEmployee = new JLabel("Nom :");
        ageEmployee = new JLabel("Age :");
        startEmployee = new JLabel("Année d'embauche :");
        salaryEmployee = new JLabel("Unité de travail :");
        editFirstNameEmployee = new JTextField();
        editLastNameEmployee = new JTextField("");
        editAgeEmployee = new JTextField("");
        editStartEmployee = new JTextField("");
        editSalaryEmployee = new JTextField("");
        submit = new JButton("Valider");
        submit.addActionListener(viewControlleur);
        back = new JButton("Retour");
        back.addActionListener(viewControlleur);
        this.add(typeEmployee);
        this.add(posteEmployee);
        this.add(firstNameEmployee);
        this.add(editFirstNameEmployee);
        this.add(lastNameEmployee);
        this.add(editLastNameEmployee);
        this.add(ageEmployee);
        this.add(editAgeEmployee);
        this.add(startEmployee);
        this.add(editStartEmployee);
        this.add(salaryEmployee);
        this.add(editSalaryEmployee);
        this.add(submit);
        this.add(back);
    }

    public Employee getEmployeeFromFields() {
        Employee employee = null;
        firstName = editFirstNameEmployee.getText();
        lastName = editLastNameEmployee.getText();
        age = Integer.parseInt(editAgeEmployee.getText());
        startDate = editStartEmployee.getText();
        salary = Integer.parseInt(editSalaryEmployee.getText());
        switch (selectPoste){
            case "ManutARisque":
                employee = new ManutARisque(firstName, lastName, age, startDate, salary);
                break;
            case "Manutentionnaire":
                employee = new Manutentionnaire(firstName, lastName, age, startDate, salary);
                break;
            case "Représentant":
                employee = new Representant(firstName, lastName, age, startDate, salary);
                break;
            case "TechARisque":
                employee = new TechnARisque(firstName, lastName, age, startDate, salary);
                break;
            case "Technicien":
                employee = new Technicien(firstName, lastName, age, startDate, salary);
                break;
            case "Vendeur":
                employee = new Vendeur(firstName, lastName, age, startDate, salary);
                break;
        }
        return employee;
    }
}
