import javax.swing.*;
import java.awt.*;
//import java.io.*;

public class Currency_Converter_GUI extends Conversions{
    
    public static void GUI(){
        
        JFrame frame = new JFrame();
        
        JButton convert = new JButton("Convert");
        convert.setPreferredSize(new Dimension(100, 50)); // Desired size

        JLabel title = new JLabel("Enter current currency and amount you have");
        JLabel title2 = new JLabel("Select the currency you want to convert to");
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 300)); // Set preferred size for the panel

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Changed to BoxLayout

        JTextArea current_currency = new JTextArea(1, 1);
        current_currency.setLineWrap(true);

        String[] currency = {"USD", "EUR", "GBP", "JPY", "CHF", "CAD", "AUD", "CNY", "HKD", "SGD"};
        JComboBox<String> dropdown = new JComboBox<>(currency);
        JComboBox<String> dropdown2 = new JComboBox<>(currency);
        
        panel.add(title);
        panel.add(dropdown);
        panel.add(current_currency);
        panel.add(title2);
        panel.add(dropdown2);
        panel.add(convert);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Currency Converter");
        frame.pack();
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        
        GUI();

    }
}
