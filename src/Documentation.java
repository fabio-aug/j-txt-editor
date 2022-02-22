import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Documentation {
    private final JFrame screenDocumentation;

    public Documentation() {
        screenDocumentation = new JFrame("Documentation");
        JPanel panel = new JPanel();

        GridBagConstraints layout = new GridBagConstraints();
        layout.gridwidth = GridBagConstraints.REMAINDER;
        layout.insets = new Insets(10, 0, 0, 0);

        panel.setLayout(new GridBagLayout());

        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("./logo.png")));
        JLabel labelIcon = new JLabel(icon);
        panel.add(labelIcon, layout);

        JLabel titleSectionFile = new JLabel("<html><h1 WIDTH=500>FILE</h1><hr></html>");
        panel.add(titleSectionFile, layout);

        JLabel fileItem1 = new JLabel("<html><div WIDTH=500><h3>New:</h3> Clears the entire text area for the creation of a new file.</div></html>");
        panel.add(fileItem1, layout);

        JLabel fileItem2 = new JLabel("<html><div WIDTH=500><h3>Open:</h3> Creates a window to search for a text file, once found and selected you must click on open in the window to be able to change the file through the editor.</div></html>");
        panel.add(fileItem2, layout);

        JLabel fileItem3 = new JLabel("<html><div WIDTH=500><h3>Save:</h3> Creates a window to search for a save location, once found, simply click save in the window to save your file.</div></html>");
        panel.add(fileItem3, layout);

        JLabel titleSectionEdit = new JLabel("<html><h1 WIDTH=500>EDIT</h1><hr></html>");
        panel.add(titleSectionEdit, layout);

        JLabel editItem1 = new JLabel("<html><div WIDTH=500><h3>Cut:</h3> Cut out a selected part of the written text and copy it.</div></html>");
        panel.add(editItem1, layout);

        JLabel editItem2 = new JLabel("<html><div WIDTH=500><h3>Copy:</h3> Copies a selected part of the written text.</div></html>");
        panel.add(editItem2, layout);

        JLabel editItem3 = new JLabel("<html><div WIDTH=500><h3>Paste:</h3> Pastes into the text something that has been copied or cut out.</div></html>");
        panel.add(editItem3, layout);

        JLabel titleSectionHelp = new JLabel("<html><h1 WIDTH=500>HELP</h1><hr></html>");
        panel.add(titleSectionHelp, layout);

        JLabel helpItem2 = new JLabel("<html><div WIDTH=500><h3>About:</h3> Area to talk about the developers, application and licenses.</div></html>");
        panel.add(helpItem2, layout);

        JLabel helpItem3 = new JLabel("<html><div WIDTH=500><h3>New:</h3> Area for application documentation. In this case, this documentation.<br>⠀</div></html>");
        panel.add(helpItem3, layout);


        screenDocumentation.add(panel);
        screenDocumentation.setResizable(false);
        screenDocumentation.setSize(550, 350);
        screenDocumentation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        screenDocumentation.setMaximumSize(new Dimension(550,350));
        JScrollPane scroll = new JScrollPane(panel);
        screenDocumentation.add(scroll);
    }

    public void OpenDocumentation() {
        screenDocumentation.setVisible(true);
    }

    public void CloseDocumentation() {
        screenDocumentation.dispose();
    }

}
