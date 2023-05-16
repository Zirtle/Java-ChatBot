
import java.awt.event.ActionEvent; //for action(commands) in GUI
import java.awt.event.ActionListener;
import java.util.Scanner;

import java.applet.Applet; //for music to be played using applet
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import java.awt.*; // to display a image
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import javax.swing.JButton; //to create text field,button,text display in GUI
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.text.SimpleDateFormat; //for date and time
import java.util.Date;

class image extends Panel {

    BufferedImage image;

    public image() {

        try {
            File input = new File("C:\\Users\\eglgo\\OneDrive\\Pictures\\test.png");
            image = ImageIO.read(input);
        } catch (IOException ie) {
            System.out.println("Error:" + ie.getMessage());
        }
    }

    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }

}

class Chatbot extends JFrame {

    /**
     * 
     */
    String name = "Elritz";
    static Scanner sc = new Scanner(System.in);
    private static final long serialVersionUID = 1L;
    private JTextArea ca = new JTextArea();
    private JTextField cf = new JTextField();
    private JButton b = new JButton();
    private JLabel l = new JLabel();

    Chatbot(long startTime) { // Layout and Properties defined in Constructer

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(true); // this to avoid unecessary testing phase issues
        f.setLayout(null);
        f.setSize(490, 650);
        f.getContentPane().setBackground(Color.gray);
        f.setTitle("ChatBot::DEMO");
        f.add(ca);
        f.add(cf);
        ca.setSize(450, 520);
        ca.setLocation(10, 1);
        ca.setBackground(Color.BLACK);
        cf.setSize(300, 23);
        cf.setLocation(70, 530);
        f.add(b);
        l.setText("                         --------SEND-------");
        b.add(l);
        b.setSize(300, 30);
        b.setLocation(70, 550);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b) { // Message sent on Click button

                    String text = cf.getText().toLowerCase();
                    ca.setForeground(Color.BLUE);
                    ca.append("CLIENT-->>" + text + "\n");
                    cf.setText("");

                    if (text.contains("hi") || text.contains("hello")) { // input Checking
                        replyMeth("Hi there");
                    }

                    else if (text.contains("how are you")) {
                        replyMeth("I'm Good :).Thankyou for asking");
                    }

                    else if (text.contains("what is your name") || text.contains("whats your name")
                            || text.contains("you name?")) {
                        if (name.contains(" ")) {
                            replymeth("I'm the your personel chatbot you shall give me a name:");
                        } else {
                            replymeth("By default i should mention the name of my maker: " + name);
                        }
                    }

                    else if (text.contains("gender")) {
                        replyMeth("Well i am a program");
                    }

                    else if (text.contains("what is your age") || text.contains("age")) {
                        long duration = System.nanoTime() - startTime;
                        duration = duration / 1000000000;
                        Long a = duration;
                        replymeth(a.toString() + " in seconds");
                        replyMeth("\n" + "I am a program after all");
                    }

                    else if (text.contains("lets talk") || text.contains("talk")) {
                        String s3 = "I can't think of good topic perhaps you can suggest one";
                        replymeth(s3);
                    }

                    else if (text.contains("date") || text.contains("today's date")) {
                        Date date = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                        String str = formatter.format(date);
                        replymeth("Today's date is: " + str);
                    }

                    else if (text.contains("time") || text.contains("what is time?")) {
                        String time = java.time.LocalTime.now().toString();
                        replymeth("Time is: " + time);
                        replymeth("i am so precise i give in miliseconds as well");
                    }

                    else if (text.contains("tell me a joke") || text.contains("tell me joke")
                            || text.contains("joke")) {
                        String s1 = "\"your dog ate your coding assignment?\" it took him couple of 'bytes'";
                        String s2 = "Why didn't the client tip the server?\r\n"
                                + "Because they didn't have enough cache!";
                        String s3 = "At the bank a lady asked me to check her balance\r\n" + "So I pushed her over";
                        String s4 = "I don't like computer science jokes...\r\n" + "Not one bit";
                        String s5 = "What is green and not heavy?\r\n" + "Light green";
                        String s6 = "Why was the computer cold?\r\n" + "Because Windows was left open";
                        String s7 = "What does a lemon need when it hurts itself?\r\n" + "Lemon-aid!";

                        int min = 1;
                        int max = 8;
                        int a = (int) (Math.random() * (max - min) + min);
                        if (a == 1) {
                            replymeth(s1);
                        }
                        if (a == 2) {
                            replymeth(s2);
                        }
                        if (a == 3) {
                            replymeth(s3);
                        }
                        if (a == 4) {
                            replymeth(s4);
                        }
                        if (a == 5) {
                            replymeth(s5);
                        }
                        if (a == 6) {
                            replymeth(s6);
                        }
                        if (a == 7) {
                            replymeth(s7);
                        }

                    }

                    else if (text.contains("play me song") || text.contains("song")) {
                        replymeth("playing song from url");
                        audio("p");
                    }

                    else if (text.contains("stop")) {
                        audio("s");
                        replymeth("song stoped");
                    }

                    else if (text.contains("pic")) {
                        JFrame frame = new JFrame("Display image");
                        Panel panel = new image();
                        frame.getContentPane().add(panel);
                        frame.setSize(500, 500);
                        frame.setVisible(true);
                    }

                    else if (text.contains("bye") || text.contains("gtg") || text.contains("see ya")
                            || text.contains("see you soon")) {
                        replyMeth("Too Soon :( AnyWays" + "\n" + "Have a Nice Day");
                    }

                    else
                        replyMeth("Reply unknown:" + "\n" + "please refer the user manual for commands" + "\n"
                                + "the bot is still in development");

                }

            }

        });

    }

    protected void relpyMeth(String string) { // Reply Method : Type 1(only string in reply)
        ca.append(string);
    }

    public void replyMeth(String s) { // Reply Method : Type 2(string + a some user characters)
        ca.append("CHATBOT-->>" + s + "\n");
    }

    public void replymeth(String s) { // Reply Method
        ca.append("CHATBOT-->>" + s + "\n");
        name = cf.getText();
    }

    public void audio(String s) {
        File file = new File("/path/your_directory/path/test.wav");
        URL url = null;
        try {
            if (file.canRead()) {
                url = file.toURI().toURL();
            }
        } catch (MalformedURLException ex) {
            replymeth("error");
        }
        ;
        AudioClip clip = Applet.newAudioClip(url);
        clip.play();
        if (s.equals("s")) {
            clip.stop();
        }
    }

}

public class chatbotdemo { // Driver Class

    public static void main(String[] args) { // main class
        final long startTime = System.nanoTime();
        new Chatbot(startTime); // instantiation
    }

}