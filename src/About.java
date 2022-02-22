import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.Objects;

public class About {
    private final JFrame screenAbout;

    public About() {
        screenAbout = new JFrame("About");
        JPanel panel = new JPanel();

        GridBagConstraints layout = new GridBagConstraints();
        layout.gridwidth = GridBagConstraints.REMAINDER;
        layout.insets = new Insets(10, 0, 0, 0);

        panel.setLayout(new GridBagLayout());

        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("./logo.png")));
        JLabel labelIcon = new JLabel(icon);
        panel.add(labelIcon, layout);

        JLabel item1 = new JLabel("1.0");
        panel.add(item1, layout);

        JLabel item2 = new JLabel("A simple txt file editor");
        panel.add(item2, layout);

        JLabel item3 = new JLabel("<html>Author: <a href='https://github.com/fabio-aug'>Fábio Augusto Araújo Santos</a></html>");
        item3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/fabio-aug"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(screenAbout, ex.getMessage());
                }
            }
        });
        panel.add(item3, layout);

        JLabel item4 = new JLabel("E-mail: fabio.augusto1911@gmail.com");
        panel.add(item4, layout);

        JLabel item5 = new JLabel("JavaTxtEditor  Copyright (C) 2022  Fábio Augusto");
        panel.add(item5, layout);

        JLabel item6 = new JLabel("<html><a href='https://fsf.org/'>Copyright © 2007 Free Software Foundation, Inc. <https://fsf.org/></a><br>⠀</html>");
        item6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://fsf.org/"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(screenAbout, ex.getMessage());
                }
            }
        });
        panel.add(item6, layout);

        screenAbout.add(panel);
        screenAbout.setResizable(false);
        screenAbout.setSize(550, 350);
        screenAbout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        screenAbout.setMaximumSize(new Dimension(550, 350));
        JScrollPane scroll = new JScrollPane(panel);
        screenAbout.add(scroll);
    }

    public void OpenAbout() {
        screenAbout.setVisible(true);
    }

    public void CloseAbout() {
        screenAbout.dispose();
    }
}
