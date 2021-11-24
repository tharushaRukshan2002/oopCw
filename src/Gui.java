import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.awt.Color.BLACK;

public class Gui {
    private ArrayList<Formula1Driver> drivers = new ArrayList<>();
    JTable table;


    public Gui() {
        readAndSortFile();//reading data from driver.ser
        Object[] columnNames = {"Name", "Team", "Country", "Points", "1st Places", "2nd Places"};
        Object[][] rowData = new Object[drivers.size()][6];
        for (int i = 0; i < drivers.size(); i++) {

            rowData[i][0] = drivers.get(i).getName();
            rowData[i][1] = drivers.get(i).getTeam();
            rowData[i][2] = drivers.get(i).getCountry();
            rowData[i][3] = drivers.get(i).getTotalPoints();
            rowData[i][4] = drivers.get(i).getFirstPositions();
            rowData[i][5] = drivers.get(i).getSecondPositions();
        }

        DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
        JTable table = new JTable(model);
        table.setAutoCreateRowSorter(true);
        table.setPreferredSize(new Dimension(680, 500));
        table.setRowHeight(50);






        //----------Main panels have been created here------
        JPanel northPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        northPanel.setBackground(Color.red);
        northPanel.setPreferredSize(new Dimension(80, 70));
        centerPanel.setBackground(Color.blue);
        centerPanel.setPreferredSize(new Dimension(80, 100));
        southPanel.setBackground(Color.GREEN);
        southPanel.setPreferredSize(new Dimension(80, 90));
        eastPanel.setBackground(Color.MAGENTA);
        eastPanel.setPreferredSize(new Dimension(500, 80));


        //Creating The main frame.
        JFrame frame = new JFrame();
        frame.setSize(1200, 700);
        frame.setTitle("F1 Championship manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("logo.png");
        frame.setIconImage(image.getImage());
        frame.setResizable(false);
        Border border = BorderFactory.createLineBorder(Color.cyan);

        //Main panels has been added--------------------------
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.add(eastPanel, BorderLayout.EAST);
        //-----------------------------------------------------

        //Sub panels in the main center panel.
        JPanel centerPanelCenter = new JPanel();
        //---------------------------------------

        centerPanelCenter.setBackground(Color.black);
        centerPanelCenter.setPreferredSize(new Dimension(800, 500));

        JLabel headingName = new JLabel("F1 CHAMPIONSHIP MANAGER");
        headingName.setFont(new Font("Arial", Font.BOLD, 20));
        headingName.setForeground(BLACK);
        northPanel.add(headingName);

        centerPanel.add(centerPanelCenter, BorderLayout.CENTER);
        //centerPanelCenter.add(new JScrollPane(table));

        //headingName.setBorder(border);
        headingName.setBounds(530, -5, 500, 80);
        northPanel.setLayout(null);
        frame.add(new JScrollPane(table));
        //table.setAutoCreateRowSorter(true);
        frame.setVisible(true);


    }

    public void readAndSortFile() {
        try {
            FileInputStream fis = new FileInputStream("drivers.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            drivers = (ArrayList) ois.readObject();
            ois.close();

            drivers.sort(new Comparator<Formula1Driver>() {
                @Override
                public int compare(Formula1Driver o1, Formula1Driver o2) {
                    int comparison;
                    comparison = Integer.compare(o2.getTotalPoints(), o1.getTotalPoints());
                    if (comparison == 0) {
                        comparison = Integer.compare(o2.getFirstPositions(), o1.getFirstPositions());
                    }
                    return comparison;
                }
            });


        } catch (Exception e) {

        }
    }


}
