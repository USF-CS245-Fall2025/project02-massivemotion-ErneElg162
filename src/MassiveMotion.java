import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class MassiveMotion extends JPanel implements ActionListener
{
    protected Timer tm;
    protected Properties config;

    private static String listType;
    public static int window_size_x;
    public static int window_size_y;

    private static double gen_x;
    private static double gen_y;
    private static int body_size;
    private static double body_mass;
    private static int body_velocity;

    private static int star_position_x;
    private static int star_position_y;
    private static int star_size;
    private static double star_mass;
    private static int star_velocity_x;
    private static int star_velocity_y;

    private static List<CelestialBody> LIST;

    private final Random rand;

    /** Reads from property file and sets values of properties
     * @param propfile Name of property file
     */
    public MassiveMotion(String propfile) throws IOException
    {
        rand = new Random();

        config = new Properties();
        config.load(new FileReader(propfile));

        tm = new Timer(Integer.parseInt((String) config.get("timer_delay")), this);

        listType = (String) config.get("list");

        window_size_x = Integer.parseInt((String) config.get("window_size_x"));
        window_size_y = Integer.parseInt((String) config.get("window_size_y"));

        gen_x = Double.parseDouble((String) config.get("gen_x"));
        gen_y = Double.parseDouble((String) config.get("gen_y"));
        body_size = Integer.parseInt((String) config.get("body_size"));
        body_mass = Double.parseDouble((String) config.get("body_mass"));
        body_velocity = Integer.parseInt((String) config.get("body_velocity"));

        star_position_x = Integer.parseInt((String) config.get("star_position_x"));
        star_position_y = Integer.parseInt((String) config.get("star_position_y"));
        star_size = Integer.parseInt((String) config.get("star_size"));
        star_mass = Double.parseDouble((String) config.get("star_mass"));
        star_velocity_x = Integer.parseInt((String) config.get("star_velocity_x"));
        star_velocity_y = Integer.parseInt((String) config.get("star_velocity_y"));
    }

    /**
     * Paints celestial bodies
     * @param g the Graphics object
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // Probably best you leave this as is.

        for(int i = 0; i < LIST.size(); i++)
        {
            CelestialBody cb = LIST.get(i);

            g.setColor(cb.getColor());
            g.fillOval(cb.getPosX(), cb.getPosY(), cb.getSize(), cb.getSize());
        }

        // Recommend you leave the next line as is
        tm.start();
    }


    /**
     * Updates celestial bodies and spawns new ones
     * @param actionEvent the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        double randSpwn = rand.nextFloat();

        //Generate new body
        if(randSpwn < gen_x + gen_y)
        {
            int spdX = 0;
            int spdY = 0;

            //Generate non-zero speeds
            while(spdX == 0 && spdY == 0)
            {
                spdX = rand.nextInt(-body_velocity, body_velocity + 1);
                spdY = rand.nextInt(-body_velocity, body_velocity + 1);
            }

            int posX;
            int posY;

            //Generate along x-axis
            if(randSpwn < gen_x)
            {
                posX = rand.nextInt(window_size_x);
                posY = window_size_y * rand.nextInt(2);
            }

            //Generate along y-axis
            else
            {
                posX = window_size_x * rand.nextInt(2);
                posY = rand.nextInt(window_size_y);
            }

            CelestialBody cb = new CelestialBody(body_size, posX, posY, spdX, spdY);
            LIST.add(cb);
        }

        //update celestial bodies
        for(int i = 0; i < LIST.size(); i++)
        {
            if(LIST.get(i).update())
            {
                LIST.remove(i);
                i--;
            }
        }

        // Keep this at the end of the function (no matter what you do above):
        repaint();
    }

    public static void main(String[] args)
    {
        if(args.length < 1)
        {
            throw new RuntimeException("ERROR: NO PROPERTY FILE FOUND!");
        }

        System.out.println("Massive Motion starting...");

        MassiveMotion mm;

        try
        {
            mm = new MassiveMotion(args[0]);
        }

        catch (IOException e)
        {
            throw new RuntimeException(e.getMessage());
        }

        //use correct list
        if(listType.equals("arraylist"))
        {
            LIST = new ArrayList<>();
        }

        else if(listType.equals("single"))
        {
            LIST = new LinkedList<>();
        }

        else if(listType.equals("double"))
        {
            LIST = new DoublyLinkedList<>();
        }

        else if(listType.equals("dummyhead"))
        {
            LIST = new DummyHeadLinkedList<>();
        }

        else
        {
            throw new RuntimeException(listType + " IS AN INVALID LIST TYPE");
        }

        //add star to list
        CelestialBody star = new CelestialBody(star_size, star_position_x, star_position_y, star_velocity_x, star_velocity_y, Color.RED);
        LIST.add(star);

        JFrame jf = new JFrame();
        jf.setTitle("Massive Motion");
        jf.setSize(window_size_x, window_size_y);
        jf.add(mm);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
