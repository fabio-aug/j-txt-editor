import javax.swing.*;

public class Editor {
    private final JFrame screenEditor;
    private final FileManager file;
    private final Documentation screenDocumentation;
    private final About screenAbout;

    Editor() {
        screenEditor = new JFrame("Java txt editor");
        file = new FileManager();
        screenDocumentation = new Documentation();
        screenAbout = new About();

        JMenuBar menuBar = new JMenuBar();

        JMenu menuFileSection = new JMenu("File");
        JMenuItem menuFileItem1 = new JMenuItem("New");
        JMenuItem menuFileItem2 = new JMenuItem("Open");
        JMenuItem menuFileItem3 = new JMenuItem("Save");
        menuFileItem1.addActionListener(e -> New());
        menuFileItem2.addActionListener(e -> Open());
        menuFileItem3.addActionListener(e -> Save());
        menuFileSection.add(menuFileItem1);
        menuFileSection.add(menuFileItem2);
        menuFileSection.add(menuFileItem3);

        JMenu menuEditSection = new JMenu("Edit");
        JMenuItem menuEditItem1 = new JMenuItem("Cut");
        JMenuItem menuEditItem2 = new JMenuItem("Copy");
        JMenuItem menuEditItem3 = new JMenuItem("Paste");
        menuEditItem1.addActionListener(e -> Cut());
        menuEditItem2.addActionListener(e -> Copy());
        menuEditItem3.addActionListener(e -> Past());
        menuEditSection.add(menuEditItem1);
        menuEditSection.add(menuEditItem2);
        menuEditSection.add(menuEditItem3);

        JMenu menuHelpSection = new JMenu("Help");
        JMenuItem menuHelpItem1 = new JMenuItem("About");
        JMenuItem menuHelpItem2 = new JMenuItem("Documentation");
        menuHelpItem1.addActionListener(e -> About());
        menuHelpItem2.addActionListener(e -> Documentation());
        menuHelpSection.add(menuHelpItem1);
        menuHelpSection.add(menuHelpItem2);

        menuBar.add(menuFileSection);
        menuBar.add(menuEditSection);
        menuBar.add(menuHelpSection);

        screenEditor.setJMenuBar(menuBar);
        screenEditor.add(file.getTextField());
        screenEditor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        screenEditor.setSize(600, 400);
        screenEditor.addWindowListener(
            new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    closeApplication();
                }
            }
        );
    }

    private void OpenEditor() {
        screenEditor.setVisible(true);
    }

    private void Cut() {
        file.Cut();
    }

    private void Copy() {
        file.Copy();
    }

    private void Past() {
        file.Paste();
    }

    private void Save() {
        file.Save(screenEditor);
    }

    private void Open() {
        file.Open(screenEditor);
    }

    private void New() {
        file.New();
    }

    private void About() {
        screenAbout.OpenAbout();
    }

    private void Documentation() {
        screenDocumentation.OpenDocumentation();
    }

    public void closeApplication() {
        screenDocumentation.CloseDocumentation();
        screenAbout.CloseAbout();
        screenEditor.dispose();
    }

    public static void main(String[] args) {
        Editor javaTxtEditor = new Editor();
        javaTxtEditor.OpenEditor();
    }
}