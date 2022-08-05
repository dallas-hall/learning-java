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
public class ImageViewer implements ActionListener
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
        //create the frame and content pane
        frame = new JFrame("ImageViewer");        
        Container contentPane = frame.getContentPane();
        
        makeMenuBar();
        //makeComponents(contentPane);
        
        //arrange all the components
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
        
        //add event listeners
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        quitMenuItem.addActionListener(this);
        aboutMenuItem.addActionListener(this);
    }
    
    private void makeComponents(Container contentPane)
    {
        //create components
        JLabel label = new JLabel("I am a label. I can display some text.");
        JButton button1 = new JButton("click me!");
        JButton button2 = new JButton("no click me!");
        
        //add the components to the content pane
        contentPane.add(label);
        contentPane.add(button1);
        contentPane.add(button2);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Open"))
        {
            System.out.println("Hi, you rang? " + e.getActionCommand());
            openFile();
        }
        else if(e.getActionCommand().equals("Save"))
        {
            System.out.println("Hi, you rang? " + e.getActionCommand());
            saveFile();            
        }
        else if(e.getActionCommand().equals("Quit"))
        {
            System.out.println("Hi, you rang? " + e.getActionCommand());
            quit();            
        }
        else if(e.getActionCommand().equals("About"))
        {
            System.out.println("Hi, you rang? " + e.getActionCommand());
            about();            
        }
    }
    
    private void openFile()
    {
    }
    
    private void saveFile()
    {
    }
    
    private void quit()
    {
    }
    
    private void about()
    {
    }
}
