
package rwilliams_cit230_final;

import javafx.scene.image.ImageView;

public abstract class Piece implements IMovable{
    
    protected int Color;
    protected ImageView Display;
    protected int Direction;
    public int Position;
    protected int homeColumn;
    public int Active;
    
    @Override
    public String toString(){
        return Position +" " + Active;
    };
}
