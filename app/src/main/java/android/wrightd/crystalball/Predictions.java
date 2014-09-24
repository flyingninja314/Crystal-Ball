package android.wrightd.crystalball;

public class Predictions {

    private static Predictions predictions;
    private String[] answers;

    private Predictions(){
        answers = new String[]{
            "Answer is hazy. $0.99 could clear that up, though. :D",
            "YOU SHOULD SPEAK UP I CANNOT HEAR YOU",
            "I'm sorry, I wasn't paying attention. Could you repeat yourself?"
        };
    }

    public static Predictions get(){
        if(predictions == null){
            predictions = new Predictions();
        }
        return predictions;
    }

    public String getPrediction() {
        return answers[0];
    }

}
