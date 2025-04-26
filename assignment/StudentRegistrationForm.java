import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends JFrame {

    JTextField nameField, emailField;
    JRadioButton male, female, other;
    JComboBox<String> courseBox;
    JCheckBox reading, traveling, gaming;
    JButton submitBtn, resetBtn;
    JLabel outputLabel;

    public StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(new Color(240, 248, 255)); // light blue

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("Arial", Font.BOLD, 13);

        // Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        nameField = new JTextField(12);
        panel.add(nameField, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        panel.add(emailLabel, gbc);

        gbc.gridx = 1;
        emailField = new JTextField(12);
        panel.add(emailField, gbc);

        // Gender
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(labelFont);
        panel.add(genderLabel, gbc);

        gbc.gridx = 1;
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        genderPanel.setBackground(panel.getBackground());
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);
        panel.add(genderPanel, gbc);

        // Course
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setFont(labelFont);
        panel.add(courseLabel, gbc);

        gbc.gridx = 1;
        courseBox = new JComboBox<>(new String[] { "B.Tech", "B.Sc", "B.Com" });
        panel.add(courseBox, gbc);

        // Hobbies
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel hobbyLabel = new JLabel("Hobbies:");
        hobbyLabel.setFont(labelFont);
        panel.add(hobbyLabel, gbc);

        gbc.gridx = 1;
        reading = new JCheckBox("Reading");
        traveling = new JCheckBox("Traveling");
        gaming = new JCheckBox("Gaming");
        JPanel hobbyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        hobbyPanel.setBackground(panel.getBackground());
        hobbyPanel.add(reading);
        hobbyPanel.add(traveling);
        hobbyPanel.add(gaming);
        panel.add(hobbyPanel, gbc);

        // Buttons
        gbc.gridx = 0;
        gbc.gridy++;
        submitBtn = new JButton("Submit");
        resetBtn = new JButton("Reset");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(panel.getBackground());
        buttonPanel.add(submitBtn);
        buttonPanel.add(resetBtn);
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

        // Output Label
        gbc.gridx = 0;
        gbc.gridy++;
        outputLabel = new JLabel(" ");
        outputLabel.setForeground(new Color(0, 102, 0)); // green
        panel.add(outputLabel, gbc);

        add(panel);

        // Submit action
        submitBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();

            if (name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name and Email are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String gender = male.isSelected() ? "Male"
                    : female.isSelected() ? "Female" : other.isSelected() ? "Other" : "N/A";
            String course = (String) courseBox.getSelectedItem();
            String hobbies = "";
            if (reading.isSelected())
                hobbies += "Reading ";
            if (traveling.isSelected())
                hobbies += "Traveling ";
            if (gaming.isSelected())
                hobbies += "Gaming ";

            String output = String.format(
                    "<html>Name: %s<br>Email: %s<br>Gender: %s<br>Course: %s<br>Hobbies: %s</html>",
                    name, email, gender, course, hobbies.trim());
            outputLabel.setText(output);

        });

        // Reset action
        resetBtn.addActionListener(e -> {
            nameField.setText("");
            emailField.setText("");
            genderGroup.clearSelection();
            courseBox.setSelectedIndex(0);
            reading.setSelected(false);
            traveling.setSelected(false);
            gaming.setSelected(false);
            outputLabel.setText(" ");
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}
