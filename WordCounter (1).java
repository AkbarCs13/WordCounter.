package WordCounter;
import javax.swing.*;
import  java.awt.*;
import java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
public class WordCounter extends JFrame {
    private JTextArea textArea;
    private JButton countButton;
    private  JLabel wordCountLabel;


    public WordCounter(){
        setLayout(new BorderLayout());

        textArea = new JTextArea(10 , 20);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                wordCountLabel.setText("Word Count: " + wordCount);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(countButton);
        add(buttonPanel, BorderLayout.SOUTH);

        wordCountLabel = new JLabel("Word Count: 0");
        add(wordCountLabel, BorderLayout.NORTH);

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        new WordCounter();
    }

}

