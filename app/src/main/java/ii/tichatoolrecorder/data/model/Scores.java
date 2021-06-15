package ii.tichatoolrecorder.data.model;

public class Scores {
    String scoresId;
    String firstScore;
    String secondScore;
    String thirdScore;
    String fourthScore;
    String exam;

    public Scores() {

    }

    public Scores(String scoresId, String firstScore, String secondScore, String thirdScore, String fourthScore, String exam) {
        this.scoresId = scoresId;
        this.firstScore = firstScore;
        this.secondScore = secondScore;
        this.thirdScore = thirdScore;
        this.fourthScore = fourthScore;
        this.exam = exam;
    }

    public String getScoresId() {
        return scoresId;
    }

    public String getFirstScore() {
        return firstScore;
    }

    public String getSecondScore() {
        return secondScore;
    }

    public String getThirdScore() {
        return thirdScore;
    }

    public String getFourthScore() {
        return fourthScore;
    }

    public String getExam() {
        return exam;
    }
}
