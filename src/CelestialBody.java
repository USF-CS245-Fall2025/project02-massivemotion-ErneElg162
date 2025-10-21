import java.awt.*;

public class CelestialBody
{
    private int size;

    private int posX;
    private int posY;

    private int velX;
    private int velY;

    private Color color;

    public CelestialBody(int size, int posX, int posY, int velX, int velY)
    {
        this.size = size;

        this.posX = posX;
        this.posY = posY;

        this.velX = velX;
        this.velY = velY;

        this.color = Color.BLACK;
    }

    public CelestialBody(int size, int posX, int posY, int velX, int velY, Color color)
    {
        this.size = size;

        this.posX = posX;
        this.posY = posY;

        this.velX = velX;
        this.velY = velY;

        this.color = color;
    }

    //return true if out of bounds

    /**
     * Updates the position of the celestial object
     * @return true if it is out of bounds. false if it is in bounds
     */
    public boolean update()
    {
        posX += velX;
        posY += velY;

        if(posX < -size || posX > MassiveMotion.window_size_x + size || posY < -size || posY > MassiveMotion.window_size_y + size)
        {
            return true;
        }

        return false;
    }

    /**
     * @return size of celestial body
     */
    public int getSize()
    {
        return size;
    }

    /**
     * @return position along x-axis
     */
    public int getPosX()
    {
        return posX;
    }

    /**
     * @return position along y-axis
     */
    public int getPosY()
    {
        return posY;
    }

    /**
     * @return color of celestial body
     */
    public Color getColor()
    {
        return color;
    }
}
