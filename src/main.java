import javax.swing.*;
import java.awt.event.*;

public class main extends JFrame
{
    private DefaultListModel<String> dlm = new DefaultListModel<String>();
    private final String[] data2 = {"Имя +78888888888", "   "};
    public main()
    {
        super("телефонный справочник");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel contents = new JPanel();
        JTextField name1 =  new JTextField("имя",25);
        JTextField name2 =  new JTextField("телефон", 25);

        name1.setHorizontalAlignment(JTextField.LEFT);
        name2.setHorizontalAlignment(JTextField.LEFT);
        for (String string : data2) {
            dlm.add(0, string);
        }

        JButton add = new JButton("Добавить");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String name = name1.getText();
                String number = name2.getText();
                String data = name + " "+number;

                dlm.add(dlm.getSize(), data);
                validate();
                name1.setText("");
                name2.setText("");
            }
        });

        JList<String> list2 = new JList<String>(dlm);
        contents.add(add);
        contents.add(name1);
        contents.add(name2);
        contents.add(new JScrollPane(list2));
        setContentPane(contents);
        setSize(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new main();
    }
}