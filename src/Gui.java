import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class Gui extends JFrame
{
    private JPanel rootPanel;
    public JCheckBox p1WonCheckBox;
    public JCheckBox p2WonCheckBox;
    public JComboBox player1ComboBox;
    public JComboBox pLayer2ComboBox;
    public JButton calculateRankingButton;
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JTextPane textPane3;
    private JTextPane textPane4;
    public String name1 = "";
    public String name2 = "";
    public String tournAmount1;
    public String tournAmount2;
    public int index1;
    public int index2;
    public Boolean aHasWon = false;
    public Boolean bHasWon = false;
    public Boolean tie = false;

    public Gui() throws FileNotFoundException, UnsupportedEncodingException, MalformedURLException
    {

        //Skapar gui:t

        JOptionPane.showMessageDialog(null, "Please select the textfile containing the players and their ranking.");
        ReadAndPick rdpk = new ReadAndPick();
        RankCalc rankcalc = new RankCalc();
        rdpk.readFile(rdpk.nameList, rdpk.rankingList);

        //Create the GUI
        setContentPane(rootPanel);
        setResizable(false);
        pack();
        setLocationRelativeTo(null); //Sätter fönstret i mitten av skärmen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Lägger till namnen i Comboboxes
        for (int i = 0; i < rdpk.nameList.size(); i++)
        {
            player1ComboBox.addItem(rdpk.nameList.get(i));
            pLayer2ComboBox.addItem(rdpk.nameList.get(i));
        }

        //När man trycker på knappen
        calculateRankingButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 aHasWon = false;
                 bHasWon = false;
                 tie = false;

                 textPane1.setText("");
                 textPane2.setText("");

                 //Hämtar det som har skrivits i textpane för antal turneringar
                 // och gör om till int för att räkna ut algorithm.
                 tournAmount1 = textPane3.getText();
                 tournAmount2 = textPane4.getText();

                 int intTourn1 = Integer.parseInt(tournAmount1);
                 int intTourn2 = Integer.parseInt(tournAmount2);

                 //Hämtar nuvarande namn i combobox och lägger i name1 string
                 name1 = player1ComboBox.getSelectedItem().toString();
                 name2 = pLayer2ComboBox.getSelectedItem().toString();

                 for(int i = 0; i < rdpk.nameList.size(); i++)
                 {
                     //Kollar igenom varje namn i namnlistan och se om det stämmer med name1 och name2
                     //och ge indexvärdet värdet av i, dvs samma plats som namnet är i.

                     if(name1 == rdpk.nameList.get(i))
                     {
                         index1 = i;
                     }
                     if(name2 == rdpk.nameList.get(i))
                     {
                         index2 = i;
                     }
                 }

                //Ger resultatet av vilken checkbox som har vunnit och lägger i boolean.
                 if(p1WonCheckBox.isSelected()&& !p2WonCheckBox.isSelected())
                 {
                     aHasWon = true;
                 }
                 else if(p2WonCheckBox.isSelected()&& !p1WonCheckBox.isSelected())
                 {
                     bHasWon = true;
                 }
                 else
                 {
                     tie = true;
                 }

                //Hämtar alla metoder från ReadAndPick och räknar ut ny ranking.

                 double finalsRankingA =  rdpk.rankingList.get(index1) + (rankcalc.kFactor( rdpk.rankingList.get(index1), intTourn1) *
                         ((rankcalc.actualScoreMethod(aHasWon, tie)- rankcalc.expectedScore(rdpk.rankingList.get(index1), rdpk.rankingList.get(index2)))));
                 double finalsRankingB =  rdpk.rankingList.get(index2) + (rankcalc.kFactor( rdpk.rankingList.get(index2), intTourn2) *
                         ((rankcalc.actualScoreMethod(bHasWon, tie)- rankcalc.expectedScore(rdpk.rankingList.get(index2),rdpk.rankingList.get(index1)))));

                 //Avrundar nya rankingresultatet
                 long roundedResultsA = Math.round(finalsRankingA);
                 long roundedResultsB = Math.round(finalsRankingB);

                 System.out.println(rdpk.rankingList.get(index1) + " "+ roundedResultsA + " ");
                 System.out.print(rdpk.rankingList.get(index2) + " "+ roundedResultsB);

                 //Lägg in nya resultaten i rankingList innan det skrivs ut.
                 rdpk.rankingList.set(index1, (int)roundedResultsA);
                 rdpk.rankingList.set(index2, (int)roundedResultsB);

                 //lägg in slutresultatet i textpane
                 textPane1.replaceSelection(String.valueOf(roundedResultsA));
                 textPane2.replaceSelection(String.valueOf(roundedResultsB));

                 try {
                     rdpk.writeFile(rdpk.nameList, rdpk.rankingList);
                 } catch (FileNotFoundException e1) {
                     e1.printStackTrace();
                 } catch (UnsupportedEncodingException e1) {
                     e1.printStackTrace();
                 }
             }
        });

        setVisible(true);

    }
}