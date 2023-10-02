package app;

import java.awt.*;
import javax.swing.*;

public class search {

    public static void back(Container container, Container container2){
        

    }

    public static void redirect (Container container, String text) {
        if (text == null || text.trim().isEmpty()) {
            return;
        }
        // Add your processing logic here

        // Then, redirect to the search page
        YourApp app = (YourApp) SwingUtilities.getWindowAncestor(container);
        app.showSearch(); // Navigate to the search page
    }
}


// back, search and redirect, redirect to webpage