import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class contactbook {
    private java.util.List<String[]> contactList = new java.util.ArrayList<>();

    contactbook() {
        Frame f = new Frame();
        f.setTitle("Welcome To Contact Book");
        f.setLayout(null);
        f.setSize(500, 500);
        f.setVisible(true);

        Button addcontact = new Button("Add Contacts");
        addcontact.setBounds(160, 110, 180, 60);
        f.add(addcontact);
        addcontact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame f1 = new Frame();
                f1.setTitle("Add Details");
                f1.setSize(300, 300);
                f1.setVisible(true);
                f1.setLayout(null);

                Label l1 = new Label("First Name:");
                l1.setBounds(50, 50, 80, 30);
                TextField t1 = new TextField(30);
                t1.setBounds(140, 50, 100, 30);

                Label l2 = new Label("Last Name:");
                l2.setBounds(50, 100, 80, 30);
                TextField t2 = new TextField(30);
                t2.setBounds(140, 100, 100, 30);

                Label l3 = new Label("Phone Number:");
                l3.setBounds(30, 150, 100, 30);
                TextField t3 = new TextField(30);
                t3.setBounds(140, 150, 100, 30);

                Button add = new Button("Add");
                add.setBounds(100, 200, 100, 30);

                add.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty()) {
                            showDialog(f1, "Error", "Please fill all the details.");
                        } else {
                            contactList.add(new String[] { t1.getText(), t2.getText(), t3.getText() });
                            showDialog(f1, "Success", "Details successfully added!");
                            f1.dispose();
                        }
                    }
                });

                f1.add(l1);
                f1.add(t1);
                f1.add(l2);
                f1.add(t2);
                f1.add(l3);
                f1.add(t3);
                f1.add(add);

                f1.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        f1.dispose();
                    }
                });
            }
        });

        Button deletecontact = new Button("Delete Contact");
        deletecontact.setBounds(160, 190, 180, 60);
        f.add(deletecontact);
        deletecontact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstNameToDelete = JOptionPane.showInputDialog(f,
                        "Enter the first name of the contact to delete:");
                if (firstNameToDelete != null) {
                    boolean found = false;
                    Iterator<String[]> iterator = contactList.iterator();
                    while (iterator.hasNext()) {
                        String[] contact = iterator.next();
                        if (contact[0].equalsIgnoreCase(firstNameToDelete)) {
                            iterator.remove();
                            showDialog(f, "Success", "Contact deleted successfully!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        showDialog(f, "Error", "Contact not found!");
                    }
                }
            }
        });

        Button searchcontact = new Button("Search Contact");
        searchcontact.setBounds(160, 270, 180, 60);
        f.add(searchcontact);
        searchcontact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstNameToSearch = JOptionPane.showInputDialog(f,
                        "Enter the first name of the contact to search:");
                if (firstNameToSearch != null) {
                    boolean found = false;
                    for (String[] contact : contactList) {
                        if (contact[0].equalsIgnoreCase(firstNameToSearch)) {
                            showDialog(f, "Contact Found",
                                    "Name: " + contact[0] + " " + contact[1] + "\nPhone: " + contact[2]);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        showDialog(f, "Error", "Contact not found!");
                    }
                }
            }
        });

        Button showcontactlist = new Button("Show Contact List");
        showcontactlist.setBounds(160, 350, 180, 60);
        f.add(showcontactlist);
        showcontactlist.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame f2 = new Frame("List of Contacts");
                f2.setSize(400, 400);
                f2.setVisible(true);
                f2.setLayout(new BorderLayout());

                String[] columnNames = { "First Name", "Last Name", "Phone Number" };
                String[][] data = contactList.toArray(new String[0][0]);

                JTable table = new JTable(data, columnNames);
                JScrollPane sp = new JScrollPane(table);
                table.setEnabled(false);
                f2.add(sp, BorderLayout.CENTER);

                f2.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        f2.dispose();
                    }
                });
            }
        });

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private void showDialog(Frame parent, String title, String message) {
        Dialog dialog = new Dialog(parent, title, true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label(message));
        Button okButton = new Button("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });
        dialog.add(okButton);
        dialog.setSize(200, 100);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        new contactbook();
    }
}
