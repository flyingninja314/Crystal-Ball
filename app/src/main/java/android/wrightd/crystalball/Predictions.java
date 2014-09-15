package android.wrightd.crystalball;

public class Predictions {

    private static Predictions predictions;
    private String[] answers;

    private Predictions(){
        answers = new String[]{
            "Answer is hazy. $0.99 could clear that up, though. :D"
        };
    }

    public static Predictions get(){
        if(predictions == null){
            predictions = new Predictions;
        }
        return predictions;
    }

}
