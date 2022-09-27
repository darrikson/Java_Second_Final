
package rwilliams_cit230_final;

import javafx.scene.image.ImageView;


public class RedPiece extends Piece{
    
    public RedPiece(ImageView image){
        Color = 1;
        Display = image;
        Direction = 1;
        homeColumn = 2;
        Active = 1;
    }       

    @Override
    public int Direction(RedPiece this){
        return this.Direction;
    }
}
