package Controlleurs;

import Domain.Employee;
import Service.Personnel;
import Views.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewControlleur implements ActionListener {

    private JFrame vue;
    public Personnel p;

    public ViewControlleur (JFrame vue){

        this.vue = vue;
        this.p = new Personnel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String txtButton = source.getText();

        switch (txtButton){
            case "Ajout d'employé":
                navButton(new AddEmployeeView(this));
                break;
            case "Afficher la liste des employés":
                navButton(new DisplayEmployeeView(this));
                break;
            case "Retour":
                navButton(new MainView(this));
                break;
            case "Valider":
                Component component = vue.getContentPane().getComponent(0);
                if(component instanceof AddEmployeeView) {
                    Employee employe = ((AddEmployeeView) component).getEmployeeFromFields();
                    p.ajouterEmploye(employe);
                }
                navButton(new AddEmployeeView(this));
                break;
            case "Quittez":
                navButton(new MainView(this));
                break;
        }
    }

    public void navButton(JPanel newPanel){
        vue.getContentPane().removeAll();
        vue.getContentPane().add(newPanel);
        vue.revalidate();
        vue.repaint();
    }
}
