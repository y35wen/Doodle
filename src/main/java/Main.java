
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Main {

    public static void main(String[] args) {

        // the window
        JFrame frame = new JFrame ("Painting");
        frame.setMinimumSize (new Dimension (400, 300));
        frame.setSize(new Dimension (900, 600));



        Model model = new Model();
        // the canvas that user to draw
        Canvas canvas = new Canvas (model);

        // the color palette
        RedColChoose redColChoose =new RedColChoose(model);
        BlueColChoose blueColChoose = new BlueColChoose(model);
        BlackColChoose blackColChoose = new BlackColChoose(model);
        GreenColChoose greenColChoose = new GreenColChoose(model);
        OrangeColChoose orangeColChoose = new OrangeColChoose(model);
        YellowColChoose yellowColChoose = new YellowColChoose(model);
        CustomCol customCol = new CustomCol(model);

        // thicknesss
        ThickChoose thickChoose = new ThickChoose(model);
        ThickChoose1 thickChoose1 = new ThickChoose1(model);
        ThickChoose2 thickChoose2 = new ThickChoose2(model);
        ThickChoose3 thickChoose3 = new ThickChoose3(model);
        ThickChoose4 thickChoose4 = new ThickChoose4(model);

        //current color
        ChosenThick chosenThick =new ChosenThick(model);


        JLabel colTitle = new JLabel("Color Palette",SwingConstants.CENTER);
        JLabel widthTitle = new JLabel("    ",SwingConstants.CENTER);
        widthTitle.setForeground(Color.WHITE);



        // panel contain all color
        JPanel colcorPanel = new JPanel();
        colcorPanel.setMinimumSize(new Dimension (75, 125));
        colcorPanel.setPreferredSize(new Dimension (150, 250));
        colcorPanel.setLayout(new GridLayout(3,2));
        colcorPanel.add (redColChoose);
        colcorPanel.add (blueColChoose);
        colcorPanel.add(blackColChoose);
        colcorPanel.add(greenColChoose);
        colcorPanel.add(orangeColChoose);
        colcorPanel.add(yellowColChoose);


        JPanel colcustom = new JPanel();
        colcustom.setMinimumSize(new Dimension (75, 150));
        colcustom.setPreferredSize (new Dimension (150, 300));
        colcustom.setLayout(new BorderLayout());
        colcustom.setBackground(Color.LIGHT_GRAY);
        colcustom.add(colTitle, BorderLayout.NORTH);
        colcustom.add(colcorPanel, BorderLayout.SOUTH);
        colcustom.add(customCol, BorderLayout.CENTER);


        // panel contain all thickness
        JPanel thickPanel = new JPanel();
        thickPanel.setMinimumSize(new Dimension (75, 125));
        thickPanel.setPreferredSize (new Dimension (150, 250));
        thickPanel.setLayout(new GridLayout(7,1));
        thickPanel.add(widthTitle);
        thickPanel.add(thickChoose);
        thickPanel.add(thickChoose1);
        thickPanel.add(thickChoose2);
        thickPanel.add(thickChoose3);
        thickPanel.add(thickChoose4);


        // panel contain current chosen color and thickness
        JPanel current = new JPanel(new GridLayout(1,1));
        current.setMinimumSize(new Dimension (75, 25));
        current.setPreferredSize(new Dimension (150, 50));
        current.add(chosenThick);


        // panel contain thickness and color palette
        JPanel ColThick = new JPanel(new BorderLayout());
         ColThick.setMinimumSize(new Dimension (75, 250));
        ColThick.setSize (new Dimension (150, 600));
        ColThick.setBackground(new Color(255,227,159));
        ColThick.add(colcustom, BorderLayout.NORTH);
        ColThick.add(current, BorderLayout.SOUTH);
        ColThick.add(thickPanel, BorderLayout.CENTER);



        ////////////////////////////////
        JMenuBar mb = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("View");
        JMenuItem nnew = new JMenuItem("new");
        JMenuItem ssave = new JMenuItem("save");
        JMenuItem load = new JMenuItem("load");
        JMenuItem exit = new JMenuItem("exit");

        JMenuItem fullSize = new JMenuItem("full size");
        JMenuItem smallSize = new JMenuItem("smallest size");
        JMenuItem resize = new JMenuItem("Resize");
        JMenuItem defaultsize =  new JMenuItem("Default size");
        menu2.add(fullSize);
        menu2.add(smallSize);
        menu2.add(defaultsize);
        menu2.add(resize);

        fullSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.addChoosableFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        if(f.isDirectory()){
                            return true;
                        }else {
                            return f.getName().toLowerCase().endsWith(".txt");
                        }
                    }

                    @Override
                    public String getDescription() {
                         return "*.txt";
                    }
                });
                int ret = fileChooser.showOpenDialog(null);
                if(ret == JFileChooser.APPROVE_OPTION){
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println(selectedFile.getName());
                }
            }
        });



        nnew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.clearPage();
            }
        });

        ssave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();

                jFileChooser.addChoosableFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        if(f.isDirectory()){
                            return true;
                        }else {
                            return f.getName().toLowerCase().endsWith(".txt");
                        }
                    }

                    @Override
                    public String getDescription() {
                        return "*.txt";
                    }
                });

                int suc = jFileChooser.showSaveDialog(null);
                if(suc == JFileChooser.APPROVE_OPTION){
                    File toSave = jFileChooser.getSelectedFile();
                    System.out.println("Save as: " + toSave.getAbsolutePath()+ ".txt");
                }
            }
        });


        menu1.add(nnew);
        menu1.add(ssave);
        menu1.add(load);
        menu1.add(exit);
        mb.add(menu1);
        mb.add(menu2);


        /////////////////////////////////
        JButton replayBtn  = new JButton("play");
        JButton startBtn  = new JButton("Start");
        JButton endBtn  = new JButton("End");
        JSlider slider = new JSlider(JSlider.HORIZONTAL,0,50,25);

        replayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.Replay();
            }
        });

        JPanel bottom = new JPanel(new GridLayout(1,4));
        bottom.setMinimumSize(new Dimension(400,20));
        bottom.setSize(new Dimension(900,40));
        bottom.add(replayBtn);
        bottom.add(slider);
        bottom.add(startBtn);
        bottom.add(endBtn);


        // panel contain canvas and  panel b
        JPanel p = new JPanel(new BorderLayout());
        p.setMinimumSize (new Dimension (400, 300));
        p.setSize(new Dimension (900, 600));
        frame.getContentPane().add(p);
        p.add (canvas, BorderLayout.CENTER);
        p.add (ColThick, BorderLayout.WEST);
        p.add(mb, BorderLayout.NORTH);
        p.add(bottom, BorderLayout.SOUTH);

        frame.setVisible (true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
