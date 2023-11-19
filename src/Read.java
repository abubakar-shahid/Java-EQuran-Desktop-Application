import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Read extends JFrame implements ActionListener {
    //---------------------------------------------------------------------------------------------------------
    public Read() {
        //Frame
        setTitle("E-Qura'an Application");
        setSize(600, 700);
        addWindowListener(new MyWindowListener());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    public void startReading() {
        JButton b1 = new JButton("Para No.");
        b1.addActionListener(this);
        JButton b2 = new JButton("Surah No.");
        b2.addActionListener(this);
        JButton b3 = new JButton("Manzil");
        b3.addActionListener(this);

        JPanel header = new JPanel(new GridLayout(1,3));
        header.add(b1);
        header.add(b2);
        header.add(b3);

        //Frame
        setLayout(new BorderLayout());
        add(header, BorderLayout.NORTH);
    }

    public void continueReading() {

    }

    //---------------------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    //---------------------------------------------------------------------------------------------------------
    class MyWindowListener implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
//            int choice = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Confirm Close", JOptionPane.YES_NO_OPTION);
//            if (choice == JOptionPane.YES_OPTION) {
//                System.exit(0);
//            }
            dispose();
        }

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    }
    //---------------------------------------------------------------------------------------------------------
}
