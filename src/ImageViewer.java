import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ImageViewer extends JFrame {
    protected JLabel imageLabel;
    protected int currentIndex;
    protected List<String> imagePaths;

    public ImageViewer(){

    }

    public void imageViewer() {
        setTitle("Image Viewer");
        addWindowListener(new MyWindowListener());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(600, 600);

        imagePaths = new ArrayList<>();
        for (int i = 2; i <= 549; i++) {
            imagePaths.add("D:\\FAST-NUCES l215845\\5th Semester\\Software Construction & Development\\Project\\Extras\\Pages\\" + i + ".jpeg");
        }

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        showImage();

        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousImage();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        showPreviousImage();
                        break;
                    case KeyEvent.VK_RIGHT:
                        showNextImage();
                        break;
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        add(imageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setFocusable(true);
        setVisible(true);
    }

    private void showImage() {
        //System.out.println("in showImage() : " + currentIndex + " , " + imagePaths.get(currentIndex));
        ImageIcon imageIcon = new ImageIcon(imagePaths.get(currentIndex));
        Image image = imageIcon.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(image);
        imageLabel.setIcon(imageIcon);
    }

    private void showNextImage() {
        currentIndex = (currentIndex + 1) % imagePaths.size();
        showImage();
    }

    private void showPreviousImage() {
        currentIndex = (currentIndex - 1 + imagePaths.size()) % imagePaths.size();
        showImage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageViewer();
            }
        });
    }

    //---------------------------------------------------------------------------------------------------------
    class MyWindowListener implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
//            int choice = JOptionPane.showConfirmDialog(null, "Quit Reading?", "Confirm Close", JOptionPane.YES_NO_OPTION);
//            if (choice == JOptionPane.YES_OPTION) {
//                dispose();
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