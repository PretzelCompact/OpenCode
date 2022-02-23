public class Word {
    private char[] word;

    public Word(String word){
        this.word = word.toCharArray();
    }
    public int getSymbolCount(){
        return word.length;
    }
    public String getOriginalWord(){
        return String.valueOf(word);
    }
    public void ReplaceAt(char sym, int pos){
        word[pos] = sym;
    }
}