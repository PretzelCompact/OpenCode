import java.time.LocalDate;

public class BuisinessRecord{
    private Sentence sentence;
    private LocalDate createdWhen;
    private LocalDate executeDate;

    public BuisinessRecord(String[] words, LocalDate creationDate){
        sentence = new Sentence(words);
        createdWhen = creationDate;
    }

    public LocalDate getCreatedWhen(){
        return createdWhen;
    }
    public LocalDate getExecuteDate(){
        return executeDate;
    }
    public void setExecuteDate(LocalDate date){
        executeDate = date;
    }

    public int getWordsCount(){
        return sentence.getWordsCount();
    }
    public String getOriginal(){
        return sentence.getOriginalSentence();
    }
    public Word getWordByPosition(int pos){
        return sentence.getWordByPosition(pos);
    }

    @Override
    public String toString(){
        return "Created: " + createdWhen + "\n" +
                "Executed: " + (executeDate==null ? "in process\n" : executeDate + "\n") +
                "Content:\n" +
                getOriginal();
    }
}
