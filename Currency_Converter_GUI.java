import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Currency_Converter_GUI extends Conversions{
    
    public static void GUI(){
        
        JFrame frame = new JFrame();
        
        JButton convert = new JButton("Convert");
        convert.setPreferredSize(new Dimension(100, 50));

        JLabel resultLabel = new JLabel(" ", SwingConstants.CENTER); //For the result of the conversion
        resultLabel.setBorder(new EmptyBorder(10, 0, 0, 0));

        JLabel instructions = new JLabel("Select the currency you want to convert from and to. Press convert when ready.", SwingConstants.CENTER);
        JLabel drop1 = new JLabel("Enter current currency and amount you have:", SwingConstants.CENTER);
        JLabel drop2 = new JLabel("Select the currency you want to convert to:", SwingConstants.CENTER);
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(800, 400)); // Set preferred size for the panel

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // This keeps the labels in the same spot
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 5, 0);

        JTextArea current_currency = new JTextArea(1, 1);
        current_currency.setLineWrap(true);

        String[] currency1 = {"USD", "EUR", "GBP", "JPY", "CHF", "CAD", "AUD", "CNY", "HKD", "SGD"};
        String[] currency2 = {"USD", "EUR", "GBP", "JPY", "CHF", "CAD", "AUD", "CNY", "HKD", "SGD"};
        JComboBox<String> dropdown = new JComboBox<>(currency1);
        JComboBox<String> dropdown2 = new JComboBox<>(currency2);
        
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(instructions, gbc);
        panel.add(drop1, gbc);
        panel.add(dropdown, gbc);
        panel.add(current_currency, gbc);
        panel.add(drop2, gbc);
        panel.add(dropdown2, gbc);
        panel.add(convert, gbc);
        gbc.insets = new Insets(15, 0, 0, 0);
        panel.add(resultLabel, gbc);

        // 
        convert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String fromCurrency = (String)dropdown.getSelectedItem(); //Takes the selected currency from the dropdown
                    String toCurrency = (String)dropdown2.getSelectedItem(); //Takes the selected currency from the dropdown2
                    double amount = Double.parseDouble(current_currency.getText()); // Convert the text to a double
                    
                    // Get conversion method name dynamically
                    String methodName = fromCurrency + "_to_" + toCurrency;
                    java.lang.reflect.Method method = Conversions.class.getMethod(methodName, double.class);
                    double result = (double)method.invoke(null, amount);
                    
                    resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, result, toCurrency));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number"); //Catches if the user enters something that isn't a number
                } catch (Exception ex) {
                    resultLabel.setText("Conversion error occurred"); //catches negative numbers and other errors
                }
            }
        });
        //

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
