import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    // Buttons
    JButton sten = new JButton("Rock");
    JButton sax = new JButton("Scissors");
    JButton påse = new JButton("Paper");
    JButton stenAI = new JButton("Rock");
    JButton saxAI = new JButton("Scissors");
    JButton påseAI = new JButton("Paper");

    // Panels
    JPanel playerPanel = new JPanel(new GridLayout(1, 4));
    JPanel aiPanel = new JPanel(new GridLayout(1, 4));
    JPanel scorePanel = new JPanel(new GridLayout(2,1));

    // Labels
    JLabel startMessage = new JLabel("Rock - Paper - Scissors!", JLabel.CENTER);
    JLabel winLabel = new JLabel("Player wins: 0");
    JLabel lossLabel = new JLabel("AI wins: 0");

    int win = 0;
    int loss = 0;

    Main() {

        // Score panel
        scorePanel.add(winLabel);
        scorePanel.add(lossLabel);

        // Player panel
        playerPanel.add(sten);
        playerPanel.add(sax);
        playerPanel.add(påse);
        playerPanel.add(new JLabel("Your choice ", JLabel.RIGHT));

        // AI panel
        aiPanel.add(stenAI);
        aiPanel.add(saxAI);
        aiPanel.add(påseAI);
        aiPanel.add(new JLabel("AI's choice ", JLabel.RIGHT));

        // GUI
        setLayout(new GridLayout(4,1,0,2));
        setForeground(Color.gray);
        add(startMessage);
        add(playerPanel);
        add(aiPanel);
        add(scorePanel);

        sten.addActionListener(this);
        sax.addActionListener(this);
        påse.addActionListener(this);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        int STEN = 0;
        int SAX = 1;
        int PÅSE = 2;

        int player = -1;



        // Player decisions
        if (e.getSource() == sten) {
            player = STEN;
            sten.setBackground(Color.MAGENTA);
            sax.setBackground(null);
            påse.setBackground(null);
        }
        if (e.getSource() == sax) {
            player = SAX;
            sax.setBackground(Color.MAGENTA);
            sten.setBackground(null);
            påse.setBackground(null);
        }
        if (e.getSource() == påse) {
            player = PÅSE;
            påse.setBackground(Color.MAGENTA);
            sax.setBackground(null);
            sten.setBackground(null);
        }



        // AI Decisions
        int AI = (int) (Math.random() * 3);

        if (AI == STEN) {
            stenAI.setBackground(Color.CYAN);
            saxAI.setBackground(null);
            påseAI.setBackground(null);
        }
        if (AI == SAX) {
            saxAI.setBackground(Color.CYAN);
            stenAI.setBackground(null);
            påseAI.setBackground(null);
        }
        if (AI == PÅSE) {
            påseAI.setBackground(Color.CYAN);
            saxAI.setBackground(null);
            stenAI.setBackground(null);
        }



        // Result
        if (player == AI)
            startMessage.setText("It's a draw - Try again!");

        else if (player == STEN && AI == SAX ||
                player == PÅSE && AI == STEN ||
                player == SAX && AI == PÅSE) {
            startMessage.setText("You beat the AI!");
            winLabel.setText("Player wins: " + ++win);
        }
        else {
            startMessage.setText("You were beaten by the AI.. Try again!");
            lossLabel.setText("AI wins: " + ++loss);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}


