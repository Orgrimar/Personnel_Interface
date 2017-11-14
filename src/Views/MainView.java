package Views;

import Controlleurs.ViewControlleur;

import javax.swing.*;
import java.awt.*;

public class MainView extends JPanel {

    public JPanel navPanel;
    public JLabel titre;
    public JButton addEmployee;
    public JButton dispEmployee;

    public MainView(ViewControlleur Controlleur){
        this.setLayout(new BorderLayout());
        titre = new JLabel("Gestionnaire des Employés");
        this.add(titre, BorderLayout.NORTH);
        navPanel = new JPanel(new GridLayout(2,1));
        addEmployee = new JButton("Ajout d'employé");
        addEmployee.addActionListener(Controlleur);
        dispEmployee = new JButton("Afficher la liste des employés");
        dispEmployee.addActionListener(Controlleur);
        navPanel.add(addEmployee);
        navPanel.add(dispEmployee);
        this.add(navPanel, BorderLayout.CENTER);
    }

}
