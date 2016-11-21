import dao.*;

import javax.swing.*;
import gui.*;

/**
 * Created by Alexis on 16/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final MainLayout mainLayout = new MainLayout("Music Library");
                mainLayout.setVisible(true);
            }
        });
    }
}
