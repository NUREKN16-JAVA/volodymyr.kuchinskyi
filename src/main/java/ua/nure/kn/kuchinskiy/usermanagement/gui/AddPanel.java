package ua.nure.kn.kuchinskiy.usermanagement.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPanel extends JPanel implements ActionListener {
    private final MainFrame parent;
    private JPanel buttonPanel;
    private JPanel fieldPanel;
    private JButton cancelButton;
    private JButton submitButton;

    public AddPanel(MainFrame parent) {
        this.parent = parent;
        initialize();
    }

    private void initialize() {
        this.setLayout(new BorderLayout());
        this.add(getFieldPanel(), BorderLayout.NORTH);
        this.add(getButtonPanel(), BorderLayout.SOUTH);

    }

    private JPanel getButtonPanel() {
        if (buttonPanel == null) {
            buttonPanel = new JPanel();
            buttonPanel.add(getSubmitButton(), null);
            buttonPanel.add(getCancelButton(), null);
        }
        return buttonPanel;
    }

    private JButton getSubmitButton() {
        if (submitButton == null) {
            submitButton = new JButton();
            submitButton.setText("Submit");
            submitButton.setName("submitButton");
            submitButton.setActionCommand("submit");
            submitButton.addActionListener(this);
        }
        return submitButton;
    }

    private JButton getCancelButton() {
        if (cancelButton == null) {
            cancelButton = new JButton();
            cancelButton.setText("Cancel");
            cancelButton.setName("cancelButton");
            cancelButton.setActionCommand("cancel");
            cancelButton.addActionListener(this);
        }
        return cancelButton;
    }

    private JPanel getFieldPanel() {
        return fieldPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
