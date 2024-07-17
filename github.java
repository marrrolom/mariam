// MainObject Class (15 points)
public class MainObject {
    private int id;
    private String name;
    
    public MainObject(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // Getters and setters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}




// Subclasses (10 points each)
public class Subclass1 extends MainObject {
    public Subclass1(int id, String name) {
        super(id, name);
    }
}

public class Subclass2 extends MainObject {
    public Subclass2(int id, String name) {
        super(id, name);
    }
}

public class Subclass3 extends MainObject {
    public Subclass3(int id, String name) {
        super(id, name);
    }
}



// Abstract Class (5 points)
public abstract class AbstractClass {
    public abstract void abstractMethod();
}




import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Collection Class (20 points)
public class MyCollection<T> {
    private List<T> items = new ArrayList<>();
    
    public void add(T item) {
        items.add(item);
    }
    
    public List<T> getItems() {
        return items;
    }
    
    // Iterator Inner Class (10 points)
    public class MyIterator implements Iterator<T> {
        private int index = 0;
        
        @Override
        public boolean hasNext() {
            return index < items.size();
        }
        
        @Override
        public T next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            return items.get(index++);
        }
        
        @Override
        public void remove() {
            items.remove(--index);
        }
    }
}



import java.util.Comparator;

// Comparator Child Class (10 points)
public class MyComparator<T extends MainObject> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        // Example comparison based on ID
        return Integer.compare(o1.getId(), o2.getId());
    }
}




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

// GUI Class (10 points)
public class MyGUI extends JFrame {
    private Map<Integer, String> dataMap;
    private JTextArea textArea;
    private JButton addButton;
    private JTextField idField;
    private JTextField nameField;
    
    public MyGUI() {
        super("GUI Example");
        dataMap = new HashMap<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        
        JLabel idLabel = new JLabel("ID:");
        panel.add(idLabel, constraints);
        
        idField = new JTextField(10);
        constraints.gridx = 1;
        panel.add(idField, constraints);
        
        constraints.gridy = 1;
        constraints.gridx = 0;
        JLabel nameLabel = new JLabel("Name:");
        panel.add(nameLabel, constraints);
        
        nameField = new JTextField(10);
        constraints.gridx = 1;
        panel.add(nameField, constraints);
        
        addButton = new JButton("Add");
        constraints.gridy = 2;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(addButton, constraints);
        
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        constraints.gridy = 3;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        panel.add(scrollPane, constraints);
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText();
                    dataMap.put(id, name);
                    updateTextArea();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MyGUI.this, "Invalid ID format", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void updateTextArea() {
        textArea.setText("");
        for (Integer id : dataMap.keySet()) {
            textArea.append("ID: " + id + ", Name: " + dataMap.get(id) + "\n");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyGUI();
            }
        });
    }
}




MainObject Class (15 points)

Define a class MainObject with attributes id (int) and name (String).
Include appropriate constructors, getters, and setters.
Subclasses (10 points each)

Implement three subclasses of MainObject:
Subclass1
Subclass2
Subclass3
Each subclass should inherit from MainObject and include a constructor that initializes the superclass attributes.
Abstract Class (5 points)

Create an abstract class AbstractClass.
Include an abstract method abstractMethod() that subclasses must implement.
Collection Class with Iterator (30 points total)

Implement a generic collection class MyCollection<T>.
Include methods to add items (add method).
Implement an inner class MyIterator that implements Iterator<T>.
Provide methods to iterate over the collection (hasNext, next).
Comparator Child Class (10 points)

Define a comparator class MyComparator<T extends MainObject> that implements Comparator<T>.
Implement the compare method to compare MainObject instances based on their id.
GUI Class (10 points)

Create a GUI class MyGUI that extends JFrame.
Include components:
Text fields for entering id and name.
A button to add objects to the collection.
A text area to display the objects added.
Use a HashMap<Integer, String> to store and display the added objects.
Implement action listeners for the button to add objects and update the text area accordingly.
