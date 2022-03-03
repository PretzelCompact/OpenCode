package part4;

public class Sentence {
    private Word[] words;

    public int getWordsCount(){
        return words.length;
    }
    public String getOriginalSentence(){
        var sb = new StringBuilder();
        if(words.length==0)
            return "";

        sb.append(words[0].getOriginalWord());
        for(int i = 1; i < words.length; i++){
            sb.append(' ');
            sb.append(words[i].getOriginalWord());
        }
        return sb.toString();
    }
    public Sentence(String[] words){
        this.words = new Word[words.length];

        int i = 0;
        while(i < words.length){
            this.words[i] = new Word(words[i]);
            i++;
        }
    }
    public Word getWordByPosition(int pos){
        if(pos >= words.length)
            return null;
        return words[pos];
    }
}
