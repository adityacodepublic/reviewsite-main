package app;
import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class YourApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private Stack<String> pageHistory; // Stack to keep track of visited pages
    //private JButton backButton;

    public YourApp() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        pageHistory = new Stack<>();
        pageHistory.push("reviewsearch");

        getRootPane().setOpaque(false);
        getContentPane().setBackground(new java.awt.Color(11,11,11));
        ImageIcon customLogo = new ImageIcon("src/Image/star.png");
        setIconImage(customLogo.getImage());

        // Add your different "pages" to the cardPanel
        cardPanel.add(new home(this), "home");

        cardPanel.add(new reviewsearch(), "reviewsearch");
        cardPanel.add(new searchpage(), "searchpage");


        add(cardPanel, BorderLayout.CENTER);

        // backButton = new JButton("Back");
        // backButton.addActionListener(e -> goBack());
        // add(backButton, BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void showHome() {
        cardLayout.show(cardPanel, "home");
        pageHistory.push("home"); // Push the page name onto the stack
    }

    public void showSearch() {
        cardLayout.show(cardPanel, "searchpage");
        pageHistory.push("searchpage"); // Push the page name onto the stack
    }

    public void showReview() {
        cardLayout.show(cardPanel, "reviewsearch");
        pageHistory.push("reviewsearch"); // Push the page name onto the stack
    }

    public void goBack() {
        if (!pageHistory.isEmpty()) {
            pageHistory.pop(); // Pop the current page from the stack
            if (!pageHistory.isEmpty()) {
            String previousPage = pageHistory.peek();
            cardLayout.show(cardPanel, previousPage);
            }
            else{ showReview();}
        }  
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new YourApp();
        });
    }
}
