
package rwilliams_cit230_final;

import javafx.scene.image.ImageView;


public class BluePiece extends Piece{
    
    public BluePiece(ImageView image){
        Color = 2;
        Display = image;
        Direction = -1;
        homeColumn = 7;
        Active = 1;
    }

    @Override
    public int Direction(BluePiece this) {
        return this.Direction;
    }
}
