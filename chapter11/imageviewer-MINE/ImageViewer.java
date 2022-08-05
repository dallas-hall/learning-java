import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * ImageViewer is the main class of the image viewer application. It builds and
 * displays the application GUI and initialises all other components.
 * 
 * To start the application, create an object of this class.
 * 
 * @author Michael Kölling and David J. Barnes.
 * @version 0.4
 */
public class ImageViewer
{
    private JFrame frame;
    private ImagePanel imagePanel;
    private OFImage currentImage;
    private JLabel statusLabel;

    /**
     * Create an ImageViewer show it on screen.
     */
    public ImageViewer()
    {
        makeFrame();
    }

    // ---- implementation of menu functions ----
    /**
     * Open function: open a file chooser to select a new image file.
     */
    private void openFile()
    {
        OFImage image = ImageFileManager.getImage();
        imagePanel.setImage(image);
        currentImage = image;
        frame.pack();
    }

    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
        //show a confirmation modal dialog and store the value the user selects
        int selectedValue = JOptionPane.showConfirmDialog(null, "R U SERIOUS?", "WANNA QUIT?", JOptionPane.YES_NO_OPTION);
        //0 = yes
        //1 = no
        //-1 = close button (X)
        if(selectedValue == 0)
        {
                System.exit(0);
        }
        else if(selectedValue == 1)
        {
            showStatus(String.valueOf(selectedValue) + " means you pressed No!");
        }
        else
        {
            showStatus(String.valueOf(selectedValue) + " means you pressed X!");
        }
    }

    private void about()
    {
        //add a dialog box here
        /*JOptionPane aboutDialog = new JOptionPane();
        aboutDialog.showMessageDialog(null
        ,"Author: blindcant\nVersion: 1.0\nDick size: ~5 inches"
        ,"About ImageViewer"
        ,JOptionPane.INFORMATION_MESSAGE);*/

        JOptionPane.showMessageDialog(frame, "Author: blindcant\nVersion: 1.0\nDick size: ~5 inches", "About stuff", JOptionPane.INFORMATION_MESSAGE); 
    }

    private void changeStatusMessage()
    {
        String userInput = JOptionPane.showInputDialog(frame, "Dick size?", "TELL ME!", JOptionPane.QUESTION_MESSAGE); 
        showStatus(userInput);
    }

    private void makeDarker()
    {
        if (currentImage != null)
        {
            currentImage.darker();
            frame.repaint();
            showStatus("Applied the mother fucking filter!");
        }
        else
        {
            showStatus("lol wut, do u even image bro?");
        }
    }

    private void makeLighter()
    {
        if (currentImage != null)
        {
            currentImage.lighter();
            frame.repaint();
            showStatus("Applied the mother fucking filter!");
        }
        else
        {
            showStatus("lol wut, do u even image bro?");
        }
    }

    private void threshold()
    {
        if (currentImage != null)
        {
            currentImage.threshold();
            frame.repaint();
            showStatus("Applied the mother fucking filter!");
        }
        else
        {
            showStatus("lol wut, do u even image bro?");
        }
    }

    private void showStatus(String message)
    {
        statusLabel.setText(message);
    }

    // ---- swing stuff to build the frame and all its components ----

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {
        //make the frame
        frame = new JFrame("ImageViewer");
        
        //update the resolution
        //frame.setMinimumSize(new Dimension(1024, 768));
        
        //update teh position to the middle of the screen
        //frame.setLocation(100,100);
        frame.setLocationByPlatform(true);
        
        //make the menubar and attach to the frame
        makeMenuBar(frame);
        
        //create the content pane - need to cast to JPanel so we can use borders
        JPanel contentPane = (JPanel) frame.getContentPane();

        //set the content pane layout manager and add a border for spacing
        contentPane.setBorder(new EmptyBorder(16, 16, 16, 16));
        contentPane.setLayout(new BorderLayout(8, 8));

        
        //create the toolbar and attach to the conten pane
        makeToolBar(contentPane);
        
        //create a text label and add it to they content pane
        JLabel filenameLabel = new JLabel();
        contentPane.add(filenameLabel, BorderLayout.NORTH);

        //create an image panel and add it to they content pane        
        imagePanel = new ImagePanel();
        contentPane.add(imagePanel, BorderLayout.CENTER);
        imagePanel.setBorder(new EtchedBorder());

        //create a text label and add it to they content pane
        statusLabel = new JLabel("Version 1.0 bitches!");
        contentPane.add(statusLabel, BorderLayout.SOUTH);

        //arrange the components       
        frame.pack();
        
        // place the frame at the center of the screen and show
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }

    private void makeToolBar(Container contentPane)
    {
        //create a JPanel that using FlowLayout to create space around teh buttons
        JPanel buttonSpacing = new JPanel();
        buttonSpacing.setLayout(new FlowLayout());

        //create a JPanel that using GridLayout to align the buttons (rows = 0 and columns = 1)         
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,1));
        
        //create some buttons for the panel and attach it
        JButton aboutButton = new JButton("About");
        JButton statusButton = new JButton("Status");
        JButton quitButton = new JButton("Quit");
        
        buttonPanel.add(aboutButton);
        buttonPanel.add(statusButton);
        buttonPanel.add(quitButton);
        
        //create event listeners and handlers
        aboutButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { about(); }
            });
        statusButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { changeStatusMessage(); }
            });
        quitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { quit(); }
            });
            
        //create spacing around the buttons by attaching the panel to another panel
        buttonSpacing.add(buttonPanel);
        
        //attach the spaced panel and the grid panel (with buttons) to the container on the left
        contentPane.add(buttonSpacing, BorderLayout.WEST);
    }
    
    /**
     * Create the main frame's menu bar.
     * @param frame   The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame)
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        //@@@ MENUBAR @@@
        //create the menubar and add it to the frame
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        //@@@ FILE MENU @@@
        // create the File menu
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);

        //### MENU ITEMS ###
        //create the menu items
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem quitItem = new JMenuItem("Quit");
        
        //create the keyboard shortcuts
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, SHORTCUT_MASK));
        quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
        
        //create the event listeners and handlers
        openItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { openFile(); }
            });
        quitItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { quit(); }
            });

        //add the items to the menu
        fileMenu.add(openItem);
        fileMenu.add(quitItem);

        //@@@ FILTER MENU @@@
        //create the Filter menu
        JMenu filterMenu = new JMenu("Filter");
        menubar.add(filterMenu);

        //### MENU ITEMS ###        
        //create the menu items and their actionevent listener and handlers
        JMenuItem darkFilterMenuItem = new JMenuItem("Darker");
        JMenuItem lightFilterMenuItem = new JMenuItem("Lighter");
        JMenuItem thresholdFilterMenuItem = new JMenuItem("Threshold");

        //use an anonymous inner class to implement the ActionListener interface
        darkFilterMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { makeDarker(); }
            });
        lightFilterMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { makeLighter(); }
            });
        thresholdFilterMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { threshold(); }
            });

        //add the items to the menu
        filterMenu.add(darkFilterMenuItem);
        filterMenu.add(lightFilterMenuItem);
        filterMenu.add(thresholdFilterMenuItem);
        
        //@@@ ABOUT MENU @@@
        JMenu helpMenu = new JMenu("Help");
        menubar.add(helpMenu);

        //### MENU ITEMS ### 
        //create the menu items and their actionevent listener and handlers
        JMenuItem aboutMenuItem = new JMenuItem("About");
        JMenuItem statusMenuItem = new JMenuItem("Status Update");

        //use an anonymous inner class to implement the ActionListener interface
        aboutMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { about(); }
            });
        statusMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { changeStatusMessage(); }
            });

        //add themt o the menu bar
        helpMenu.add(aboutMenuItem);
        helpMenu.add(statusMenuItem);
    }
}
