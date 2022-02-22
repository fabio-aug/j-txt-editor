import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class FileManager {
    private final JTextArea textField;
    private final JFileChooser windowsSelect;

    public FileManager() {
        this.textField = new JTextArea();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        this.windowsSelect = new JFileChooser("c:");
        windowsSelect.setFileFilter(filter);
    }

    public JTextArea getTextField() {
        return textField;
    }

    public void New() {
        textField.setText("");
    }

    public void Open(JFrame screen) {
        int windowsSelectAction = windowsSelect.showOpenDialog(null);

        if (windowsSelectAction == JFileChooser.APPROVE_OPTION) {
            File file = new File(windowsSelect.getSelectedFile().getAbsolutePath());

            try {
                String line, text;
                FileReader readFile = new FileReader(file);
                BufferedReader readLines = new BufferedReader(readFile);
                text = readLines.readLine();

                while ((line = readLines.readLine()) != null) {
                    text = text.concat("\n").concat(line);
                }

                textField.setText(text);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(screen, ex.getMessage());
            }
        }
    }

    public void Save(JFrame screen) {
        int windowsSelectAction = windowsSelect.showSaveDialog(null);

        if (windowsSelectAction == JFileChooser.APPROVE_OPTION) {
            File file = new File(windowsSelect.getSelectedFile().getAbsolutePath());

            try {
                FileWriter writeLines = new FileWriter(file, false);
                BufferedWriter writerLines = new BufferedWriter(writeLines);
                writerLines.write(textField.getText());
                writerLines.flush();
                writerLines.close();
            } catch (Exception evt) {
                JOptionPane.showMessageDialog(screen, evt.getMessage());
            }
        }
    }

    public void Copy() {
        textField.copy();
    }

    public void Paste() {
        textField.paste();
    }

    public void Cut() {
        textField.cut();
    }

}
