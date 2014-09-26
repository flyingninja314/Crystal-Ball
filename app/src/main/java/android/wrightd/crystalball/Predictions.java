package android.wrightd.crystalball;

public class Predictions {

    private static Predictions predictions;
    private String[] answers;

    private Predictions(){
        /*
        sets up the array of strings that can be predictions
        */
        answers = new String[]{
            "Answer is hazy. $0.99 could clear that up, though. :D",
            "YOU SHOULD SPEAK UP I CANNOT HEAR YOU",
            "I'm sorry, I wasn't paying attention. Could you repeat yourself?"
        };
    }

    public static Predictions get(){
        /*
        if predictions isn't set, set it
        return it
         */
        if(predictions == null){
            predictions = new Predictions();
        }
        return predictions;
    }

    public String getPrediction() {
        /*
        gets the prediction to display
        - how to "randomize" is get all of the strings' "numbers" and have a piece of code that chooses a number from that group, saves the number in a variable, and instead of hardcoding "answers[0]", it puts in the variable and boom, you've got a randomized prediction
         */
        return answers[0];
    }

}
