import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  bygeorge
 *  @version Mar 30, 2014
 *  @author  Period: TODO
 *  @author  Assignment: AB1999Q1_QuiltJUSoln
 *
 *  @author  Sources: TODO
 */
public class Quilt
{
    char[][] myBlock;       // stores pattern for one block
    int myRowsOfBlocks;     // number of rows of blocks in the quilt 
    int myColsOfBlocks;     // number of columns of blocks in the quilt
    
    // precondition:   quiltBlock refers to an initialized quilt block,
    //                 rowsOfBlocks > 0, colsOfBlocks > 0
    // postcondition:  myRowsOfBlocks and myColsOfBlocks are initialized to
    //                 the number of rows and columns of blocks that make up
    //                 the quilt; myBlock has been initialized to the block
    //                 pattern of quiltBlock.
    public Quilt(char[][] quiltBlock, int rowsOfBlocks, int colsOfBlocks)
    {
        myRowsOfBlocks = rowsOfBlocks;
        myColsOfBlocks = colsOfBlocks;
        
        myBlock = new char[quiltBlock.length][quiltBlock[0].length];
        
        for (int r = 0; r < quiltBlock.length; r++)
        {
            for (int c = 0; c < quiltBlock[r].length; c++)
            {
                myBlock[r][c] = quiltBlock[r][c];
            }
        }
    }
    
    // precondition:  startRow >= 0; startCol >= 0;
    //                startRow + myBlock.numrows() <= qmat.numrows();
    //                startCol + myBlock.numcols() <= qmat.numcols();
    // postcondition: myBlock has been copied into the matrix
    //                qmat with its upper-left corner at the position
    //                startRow, startCol
    public void placeBlock(int startRow, int startCol, char[][] qmat)
    {
        for ( int r = 0; r < myBlock.length; r++ )
        {
            for ( int c = 0; c < myBlock[r].length; c++ )
            {
                qmat[startRow + r][startCol + c] = myBlock[r][c];
            }
        }
    }
    
    // precondition:  startRow >= 0; startCol >= 0;
    //  startRow + myBlock.length <= qmat.length;
    //  startCol + myBlock[0].length <= qmat[0].length;
    //postcondition: a flipped version of myBlock has been copied into the
    //  matrix qmat with its upper-left corner at the position
    //  startRow, startCol
    public void placeFlipped( int startRow, int startCol, char[][] qmat )
    {
        for ( int r = 0; r < myBlock.length; r++ )
        {
            for ( int c = 0; c < myBlock[r].length; c++ )
            {
                qmat[startRow + r][startCol + c] = myBlock[myBlock.length - r - 1][c];
            }
        }
    }
    
    public char[][] quiltToMat() // checkerboard alternation
    {
        int r, c;
        char[][] mat = new char[myRowsOfBlocks * myBlock.length][myColsOfBlocks * myBlock[0].length];

        for ( r = 0; r < myRowsOfBlocks; r++ )
        {
            for ( c = 0; c < myColsOfBlocks; c++ )
            {
                if ( ( r + c ) % 2 == 0 )
                {
                    placeBlock( r * myBlock.length, c * myBlock[r].length, mat );
                }
                else
                {
                    placeFlipped( r * myBlock.length, c * myBlock[r].length, mat );
                }
            }
        }

        return mat;
    }
    
    /*
     * Intended only for testing.
     */
    public char[][] getMyBlock()
    {
        return myBlock;
    }
    
    public int getMyRowsOfBlocks()
    {
        return myRowsOfBlocks;
    }

    public int getMyColsOfBlocks()
    {
        return myColsOfBlocks;
    }
    
    public static void main( String[] args )
    {
        char[][] qBlock = { {'x', '.', '.', '.', 'x'},
                            {'.', 'x', '.', 'x', '.'},
                            {'.', '.', 'x', '.', '.'},
                            {'.', '.', 'x', '.', '.'} };

        Quilt q = new Quilt(qBlock, 4, 4);
        
        char[][] quilt = q.quiltToMat();
        
        for (char r[] : quilt)
        {
            for (char ch : r)
            {
                System.out.print(ch);
            }
            System.out.println();
        }
        
    }
}
