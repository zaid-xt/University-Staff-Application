package universitystaffapplication;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RunUniversityStaffApplication extends JFrame implements ActionListener {

    JLabel departmentLable, firstLabel, lastLabel, employmentLabel;
    JPanel panelTop, radioButtons, panelMiddle, panelBottom, buttonPanel;
    JComboBox departmentBox;
    JTextField firstField, lastField;
    JRadioButton permanent, temporary;
    JButton addButton, exitButton;
    DefaultTableModel tableModel;
    JTable table;
    JScrollPane scrollPane;
    ButtonGroup buttonGroup;

    RunUniversityStaffApplication() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new GridLayout(3, 1));
        this.setTitle("University Staff Application");

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Department");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Employment Type");

        table = new JTable(tableModel);

        scrollPane = new JScrollPane(table);

        addButton = new JButton("Add To Table");
        addButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        permanent = new JRadioButton("Permanent");
        temporary = new JRadioButton("Tempoarary");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(permanent);
        buttonGroup.add(temporary);

        firstField = new JTextField();
        firstField.setColumns(10);

        lastField = new JTextField();
        lastField.setColumns(10);

        String department[] = {"Select", "Graphic Design", "Civil Engineering", "Information Technolog"};
        departmentBox = new JComboBox(department);

        departmentLable = new JLabel();
        departmentLable.setText("Department:");

        firstLabel = new JLabel();
        firstLabel.setText("First Name:");

        lastLabel = new JLabel();
        lastLabel.setText("Last Name:");

        employmentLabel = new JLabel();
        employmentLabel.setText("Employment Type:");

        radioButtons = new JPanel();
        radioButtons.setLayout(new GridLayout(2, 1));
        radioButtons.add(permanent);
        radioButtons.add(temporary);

        panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(5, 2, 5, 5));
        panelTop.add(departmentLable);
        panelTop.add(departmentBox);
        panelTop.add(firstLabel);
        panelTop.add(firstField);
        panelTop.add(lastLabel);
        panelTop.add(lastField);
        panelTop.add(employmentLabel);
        panelTop.add(radioButtons);

        panelMiddle = new JPanel();
        panelMiddle.setLayout(new BorderLayout());
        panelMiddle.add(scrollPane, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(exitButton);

        panelBottom = new JPanel();
        panelBottom.setLayout(new BorderLayout());
        panelBottom.add(buttonPanel, BorderLayout.SOUTH);

        this.add(panelTop);
        this.add(panelMiddle);
        this.add(panelBottom);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String department = (String) departmentBox.getSelectedItem();
        String firstName = firstField.getText();
        String lastName = lastField.getText();
        String employmentType = permanent.isSelected() ? "Permanent" : "Temporary";

        Object[] rowData = {department, firstName, lastName, employmentType};
        tableModel.addRow(rowData);

        firstField.setText("");
        lastField.setText("");
        departmentBox.setSelectedIndex(0);
        buttonGroup.clearSelection();
        
        //System.exit(0);
    }

}
