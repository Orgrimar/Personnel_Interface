import Controlleurs.ViewControlleur;
import Views.MainView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("App_Employee");
        ViewControlleur viewControlleur = new ViewControlleur(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MainView(viewControlleur));
        frame.pack();
        frame.setSize(400,600);
        frame.setVisible(true);
    }
}
