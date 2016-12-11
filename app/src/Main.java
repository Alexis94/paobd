import java.sql.SQLException;

import dao.*;
import views.MainFrameController;

/**
 * Created by Alexis on 16/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            DatabaseConnection.connect();
            /*SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new MainFrameController();  // Let the constructor do the job
                    //MainFrameController.setView(new WelcomeView());
                }
            });*/
            new MainFrameController();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
