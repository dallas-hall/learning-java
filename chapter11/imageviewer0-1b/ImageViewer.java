import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ImageViewer is the main class of the image viewer application. It builds
 * and displays the application GUI and initialises all other components.
 * 
 * To start the application, create an object of this class.
 * 
 * @author Michael Kölling and David J. Barnes.
 * @version 0.1
 */
public class ImageViewer
{
    private JFrame frame;
    
    /**
     * Create an ImageViewer show it on screen.
     */
    public ImageViewer()
    {
        makeFrame();

    }
    
    // ---- swing stuff to build the frame and all its components ----
    
    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {
        //create the frame
        frame = new JFrame("ImageViewer");        
        
        //create the container and add it to the frame
        Container contentPane = frame.getContentPane();
        
        //set the layout manager for the container
        contentPane.setLayout(new BorderLayout());
       
        
        //create the menu bar and additional components
        makeMenuBar();
        makeComponents(contentPane);
        
        //recalculate and rearrange all the components
        frame.pack();
        
        //draw the frame
        frame.setVisible(true);
    }
    
    private void makeMenuBar()
    {
        //create the menu bar
        JMenuBar menuBar = new JMenuBar();
        //add it to the frame
        frame.setJMenuBar(menuBar);
        
        //create a menu and add it
        JMenu helpMenu = new JMenu("Help");
        JMenu fileMenu = new JMenu("File");
        
        //add the menu to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        
        //create a menu items
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem quitMenuItem = new JMenuItem("Quit");
        JMenuItem aboutMenuItem = new JMenuItem("About");        
        
        //add menu items
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(quitMenuItem);
        helpMenu.add(aboutMenuItem);
        
        //add event listeners by calling the constructor of the inner classes
        openMenuItem.addActionListener(new OpenActionListener());
        saveMenuItem.addActionListener(new SaveActionListener());
        quitMenuItem.addActionListener(new QuitActionListener());
        aboutMenuItem.addActionListener(new AboutActionListener());
    }
    
    private void makeComponents(Container contentPane)
    {
        //create components
        JLabel label = new JLabel("I am a label. I can display some text.");
        JButton button1 = new JButton("click me!");
        JButton button2 = new JButton("no click me!");
        
        //create new layout for buttons, add them
        GridLayout buttonGridLayout = new GridLayout(1, 0);
        
        //add the components to the content pane
        contentPane.add(label, BorderLayout.SOUTH);
        contentPane.add(button1);
        contentPane.add(button2);

    }
    
    class OpenActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Hi " + e.getActionCommand() + ", you rang?");
        }
    }
    
        class SaveActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Hi " + e.getActionCommand() + ", you rang?");
        }
    }
    
        class QuitActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Hi " + e.getActionCommand() + ", you rang?");
            System.exit(0);
        }
    }
    
        class AboutActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Hi " + e.getActionCommand() + ", you rang?");
        }
    }
}
