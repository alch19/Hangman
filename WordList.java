public class WordList {
    private String[] wordList;
    private String chosenWord;
    private int length;
    private String shownWord;

    public WordList() {
        this.wordList = new String[]
        {"apple", "banana", "orange", "grape", "melon", "lemon", "peach", "plum", "berry", "mango",
    "carrot", "broccoli", "potato", "tomato", "onion", "garlic", "pepper", "spinach", "cucumber", "lettuce",
    "horse", "sheep", "goat", "donkey", "zebra", "elephant", "giraffe", "lion", "tiger", "monkey",
    "house", "school", "library", "hospital", "market", "store", "office", "kitchen", "garden", "garage",
    "ocean", "river", "mountain", "forest", "desert", "valley", "beach", "island", "canyon", "plateau",
    "pencil", "paper", "notebook", "eraser", "marker", "crayon", "stapler", "ruler", "glue", "scissors",
    "phone", "tablet", "laptop", "camera", "watch", "clock", "radio", "television", "microwave", "toaster",
    "summer", "winter", "spring", "autumn", "rainy", "cloudy", "sunny", "stormy", "windy", "foggy",
    "happy", "sad", "angry", "excited", "bored", "scared", "nervous", "tired", "proud", "surprised"};
        this.chosenWord="";
        this.shownWord="";
    }

    public String generateRandomWord() {
        this.chosenWord=wordList[(int)(Math.random()*91)];
        this.length=chosenWord.length();
        for(int i=0; i<length; i++) {
            shownWord+="_";
        }
        return shownWord;
    }

    public int getLengthOfWord() {
        return this.length;
    }

    public String getWord() {
        return this.shownWord;
    }

    public String makeGuess(String character) {
        for(int i=0; i<this.length; i++) {
            if(chosenWord.substring(i,i+1).equals(character)) {
                String temp = shownWord;
                shownWord="";
                shownWord+=temp.substring(0,i);
                shownWord+=character;
                shownWord+=temp.substring(i+1);
            }
        }
        return shownWord;
    }

    public boolean wordCompleted() {
        return chosenWord.equals(shownWord);
    }
}
