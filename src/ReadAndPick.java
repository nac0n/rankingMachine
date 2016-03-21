import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

//Läser och skriver till fil.

public class ReadAndPick
{
    public static List<String> nameList;
    public List<Integer> rankingList;
    private JFileChooser fChooser;
    private int ranking2;
    public Gui gui;

    //Constructor
    public ReadAndPick()
    {
        nameList = new ArrayList();
        rankingList = new ArrayList();
        fChooser = new JFileChooser();
        ranking2 = fChooser.showOpenDialog(null);
    }
    ///------------------------------------------------------------------------------
    /// Methods Below
    ///------------------------------------------------------------------------------

    public void readFile(List<String> nameList, List<Integer> rankingList) throws FileNotFoundException
    {

        if(ranking2 != JFileChooser.APPROVE_OPTION)
        {
            JOptionPane.showMessageDialog(null, "Program interupted.");
            System.exit(0);
        }

        String filename = fChooser.getSelectedFile().getAbsolutePath();
        Scanner file = new Scanner(new File(filename));

        while(file.hasNext())
        {
            String name = file.next();
            while (!file.hasNextInt())
            {
                name += file.next();
            }

            nameList.add(name);
            int ranking = file.nextInt();
            rankingList.add(ranking);
            System.out.print(nameList + " ");
            System.out.println(rankingList);
        }
        System.out.print(nameList + " ");
        System.out.println(rankingList);
    }

    public void writeFile(List<String> nameList, List<Integer> rankingList) throws FileNotFoundException, UnsupportedEncodingException
    {

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("./rankingTEMP.txt"), "UTF-8"));

        try
        {
            for(int i=0;i < nameList.size();i++)
            {
                writer.write(nameList.get(i) + " " + rankingList.get(i));
                writer.newLine();
            }
            writer.flush();
            writer.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}