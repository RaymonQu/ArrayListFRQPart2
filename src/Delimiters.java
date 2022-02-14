import java.util.ArrayList;

public class Delimiters
{
    /** The open and close delimiters **/
    private String openDel;
    private String closeDel;

    /** Constructs a Delimiters object where open is the open delimiter and close is the
     *  close delimiter.
     *  Precondition: open and close are non-empty strings.
     */
    public Delimiters(String open, String close)
    {
        openDel = open;
        closeDel = close;
    }

    /** Returns an ArrayList of delimiters from the array tokens, as described in part (a). */
    public ArrayList<String> getDelimitersList(String[] tokens)
    {
        ArrayList<String> deLims = new ArrayList<String>();
        for (int i = 0; i < tokens.length; i++){
            if (tokens[i].equals("(") || tokens[i].equals(")")){
                deLims.add(tokens[i]);
            }
            if (tokens[i].indexOf("<") != -1 && tokens[i].indexOf((">")) != -1){
                deLims.add(tokens[i]);
            }
        }
        return deLims;
    }

    /** Returns true if the delimiters are balanced and false otherwise, as described in part (b).
     *  Precondition: delimiters contains only valid open and close delimiters.
     */
    public boolean isBalanced(ArrayList<String> delimiters)
    {
        int numOfOpenDel = 0;
        int numOfCloseDel = 0;
        for (int i = 0; i < delimiters.size(); i++){
            if (delimiters.get(i).equals(openDel)){
                numOfOpenDel++;
            }
            if(delimiters.get(i).equals(closeDel)){
                numOfCloseDel++;
            }
            if (numOfCloseDel > numOfOpenDel){
                return false;
            }
        }
        if (numOfCloseDel == numOfOpenDel) {
            return true;
        }
        return false;
    }
}