package November_December;

import java.util.Scanner;

/**
 * @author ethan
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // list of known words
        String[] words = {"tonight", "paragraph", "own", "every", "strip", "lot", "younger", "themselves", "number", "grow", "cut", "loss", "thumb", "wolf", "recent", "shelf", "managed", "drive", "tower", "sometime", "perfectly", "lungs", "tool", "farther", "hide", "know", "liquid", "bet", "held", "property", "tall", "list", "toy", "mad", "art", "form", "central", "breeze", "potatoes", "student", "sure", "sail", "wheat", "agree", "worried", "down", "cowboy", "plural", "pressure", "cabin", "prevent", "health", "third", "cat", "final", "cloth", "year", "meet", "clay", "automobile", "complex", "milk", "slept", "busy", "such", "collect", "doing", "writer", "giant", "applied", "military", "fully", "power", "proper", "source", "escape", "stopped", "unusual", "situation", "tales", "steel", "activity", "period", "ourselves", "ago", "seeing", "sea", "day", "victory", "quietly", "season", "only", "special", "gasoline", "past", "happened", "decide", "went", "due", "education", "section", "independent", "whispered", "faster", "jump", "result", "burst", "zoo", "by", "riding", "usually", "cup", "basket", "told", "large", "passage", "happy", "change", "saved", "box", "rest", "shut", "poor", "earth", "weight", "can", "noise", "green", "depth", "involved", "compare", "distance", "mathematics", "receive", "eat", "balloon", "carbon", "question", "mine", "hot", "dangerous", "meant", "myself", "rich", "customs", "find", "torn", "attack", "may", "somewhere", "recall", "grass", "realize", "dig", "almost", "sent", "met", "park", "engineer", "whatever", "silver", "jack", "changing", "bottle", "tail", "enough", "stretch", "asleep", "flow", "either", "cap", "reader", "share", "region", "behavior", "lie", "open", "rope", "negative", "prove", "husband", "harder", "chosen", "birds", "route", "sold", "summer", "construction", "manner", "tank", "how", "finally", "hidden", "aware", "advice", "tobacco", "represent", "close", "tape", "exclaimed", "pencil", "purple", "company", "motor", "light", "animal", "ten", "oil", "stock", "war", "orbit", "hay", "nothing", "private", "listen", "daily", "black", "look", "too", "strength", "wore", "appearance", "mission", "height", "hour", "huge", "everywhere", "recognize", "barn", "require", "cross", "road", "fence", "coal", "fun", "tent", "became", "mile", "occur", "forgotten", "trail", "cook", "old", "blue", "saw", "toward", "size", "mass", "sport", "made", "slide", "gave", "doubt", "yellow", "differ", "dirty", "shall", "stems", "want", "able", "ants", "spread", "struck", "go", "citizen", "foreign", "speed", "explore", "excellent", "pour", "fifteen", "they", "storm", "magnet", "ahead", "religious", "limited", "talk", "consonant", "trace", "business", "ship", "clothing", "speak", "would", "story", "effort", "town", "person", "both", "watch", "gradually", "speech", "bank", "found", "age", "instant", "tide", "brown", "labor", "frog", "electric", "knew", "guide", "former", "fill", "block", "laid", "necessary", "country", "give", "enemy", "fairly", "moving", "compound", "cold", "shine", "elephant", "organized", "leather", "scientific", "chamber", "man", "carry", "broke", "food", "wall", "leave", "fifty", "energy", "action", "magic", "body", "subject", "simply", "parts", "opposite", "many", "ice", "fighting", "native", "particles", "putting", "rubber", "nest", "men", "eight", "chest", "species", "connected", "rocky", "material", "great", "somebody", "water", "compass", "natural", "port", "grade", "must", "sudden", "spider", "desert", "writing", "pass", "choose", "title", "zero", "dawn", "father", "had", "physical", "globe", "grown", "peace", "hurry", "gone", "good", "belt", "correctly", "understanding", "herself", "blank", "general", "drew", "angle", "stop", "upward", "examine", "opportunity", "suddenly", "this", "simplest", "obtain", "difference", "selection", "here", "join", "memory", "vegetable", "view", "owner", "select", "doctor", "work", "shadow", "chicken", "fix", "people", "picture", "afraid", "equally", "then", "living", "acres", "dear", "fast", "sink", "bicycle", "official", "case", "slightly", "do", "any", "soft", "drawn", "dog", "dark", "week", "dish", "whale", "small", "none", "if", "support", "camp", "please", "make", "adjective", "gold", "lay", "nearly", "failed", "nearest", "principal", "barn", "rhyme", "driving", "circus", "couple", "wave", "off", "nest", "plate", "hardly", "grabbed", "struck", "thought", "rope", "disease", "happily", "desert", "hospital", "plan", "remember", "planet", "edge", "stove", "means", "burst", "exclaimed", "anyway", "reader", "fair", "town", "fine", "bottle", "that", "dollar", "every", "cost", "best", "lungs", "buried", "test", "news", "scene", "probably", "evidence", "throat", "character", "complex", "president", "information", "element", "slowly", "country", "club", "lake", "pie", "divide", "position", "shinning", "arrange", "chemical", "continent", "tea", "conversation", "victory", "trip", "beat", "am", "giant", "eaten", "spin", "sail", "personal", "smile", "appropriate", "until", "monkey", "difficult", "beneath", "pick", "track", "typical", "air", "ants", "material", "hand", "tune", "heading", "serious", "firm", "rabbit", "continent", "height", "discover", "chemical", "strange", "bill", "cat", "life", "information", "doubt", "independent", "major", "let", "fifty", "slabs", "ask", "handle", "lift", "famous", "palace", "particular", "helpful", "off", "language", "sold", "stop", "citizen", "worth", "forgot", "silk", "captain", "love", "week", "discover", "wonderful", "imagine", "thee", "universe", "living", "build", "donkey", "cause", "few", "hunter", "column", "available", "shadow", "lake", "movie", "bit", "snake", "machinery", "rubbed", "breakfast", "order", "now", "molecular", "dust", "frame", "street", "lost", "become", "reach", "kept", "naturally", "best", "courage", "clothes", "mountain", "fell", "decide", "shells", "above", "lack", "thy", "such", "friend", "already", "farm", "church", "central", "around", "hay", "shape", "manufacturing", "lot", "pool", "missing", "public", "massage", "writer", "town", "declared", "seeing", "this", "salt", "hill", "any", "my", "path", "tide", "everybody", "lift", "any", "identity", "wolf", "cat", "drew", "gasoline", "list", "corner", "aside", "handsome", "factor", "chain", "neighbor", "feathers", "put", "bowl", "wise", "spell", "nature", "anything", "experiment", "teach", "close", "horse", "plate", "hungry", "understanding", "gain", "run", "found", "slide", "won", "nose", "particularly", "loss", "top", "putting", "general", "therefore", "journey", "describe", "wing", "partly", "fuel", "tribe", "hunter", "piano", "string", "seeing", "stop", "pound", "indeed", "tomorrow", "coat", "history", "shot", "nearer", "greatly", "hidden", "settlers", "negative", "supply", "get", "appropriate", "lesson", "piece", "movie", "bus", "thread", "stiff", "try", "drew", "label", "me", "taught", "meet", "job", "exciting", "gulf", "base", "earth", "building", "tiny", "stared", "remarkable", "suit", "blood", "object", "basket", "customs", "ocean", "attempt", "gas", "post", "ill", "improve", "camera", "possible", "account", "right", "serve", "teach", "square", "poetry", "coffee", "extra", "below", "fence", "able", "forget", "deal", "slip", "very", "upon", "receive", "halfway", "given", "yet", "broad", "tired", "section", "poor", "kept", "chamber", "particles", "waste", "limited", "speak", "explore", "cotton", "information", "wheat", "settlers", "rich", "bag", "earlier", "log", "southern", "success", "merely", "dry", "slope", "gentle", "buffalo", "than", "double", "sister", "seems", "laugh", "active", "rapidly", "train", "cloth", "held", "weather", "gift", "fully", "explanation", "whole", "grew", "brave", "train", "simplest", "without", "cause", "carry", "speech", "screen", "pond", "younger", "spent", "accurate", "station", "triangle", "bowl", "take", "poet", "means", "introduced", "breathe", "pine", "dropped", "only", "at", "roof", "naturally", "symbol", "fuel", "plastic", "old", "tribe", "is", "seed", "driving", "dead", "flew", "owner", "suddenly", "seen", "mad", "suit", "disease", "belong", "alone", "that", "record", "instrument", "prove", "window", "written", "gold", "was", "recognize", "attack", "shaking", "mile", "goose", "either", "equator", "friendly", "dark", "complex", "slowly", "bridge", "tip", "press"};

        int wrongAttempts = 0;

        String attempt = "";

        String[] guessed = new String[26];
        int indexOfGuessed = 0;

        // Game introduction
        System.out.println("Welcome to Hangman!");
        System.out.println("The game of hangman has you guess letters in a word");
        System.out.println("You get a limited amount of tries");
        System.out.println("Guess too many wrong letters and you lose");
        System.out.println("There are " + words.length + " words known");
        System.out.println("Press enter to continue...");

        String waitFor;
        waitFor = input.nextLine();

        boolean run = true;
        boolean won = false;

        int attempts = 10;

        // assign empty valuess to guessed so it prints nicely
        for (int i = 0; i < guessed.length; i++) {
            guessed[i] = "";

        }

        // pick random word from list
        int random_word = (int) Math.floor(Math.random() * (words.length));

        // split up word chosen
        String[] splitWord = new String[words[random_word].length()];
        for (int i = 0; i < words[random_word].length(); i++) {
            splitWord[i] = "" + words[random_word].charAt(i);
        }

        // game run
        do {
            // check if lost
            if (wrongAttempts == attempts) {
                run = false;
            }

            // gui
            System.out.println("/-------\\");
            for (int i = 0; i < attempts - wrongAttempts; i++) {
                System.out.println("|       |");
            }

            System.out.println("|       O ");
            System.out.println("|      -|-");
            System.out.println("|      / \\");

            for (int i = 0; i < wrongAttempts; i++) {
                System.out.println("|");
            }

            System.out.println("+-----------+");

            // prints already made guesses
            for (int i = 0; i < guessed.length; i++) {
                if (guessed[i] != "") {
                    System.out.print(guessed[i] + " ");
                }
            }

            System.out.println("");
            // gets user guess
            System.out.println("Guess a letter");

            String letter = input.nextLine();

            boolean alreadyGuessed = false;

            // checks if letter input was already guessed
            for (int i = 0; i < guessed.length; i++) {
                if (letter.equals(guessed[i])) {
                    System.out.println("Letter already guessed try another");
                    alreadyGuessed = true;
                }
            }

            if (alreadyGuessed == false) {
                // adds user guess to the list of guessed letters if not already guessed
                if (alreadyGuessed == false) {
                    guessed[indexOfGuessed] = letter;
                    indexOfGuessed++;
                }

                int matches = 0;
                // checks if letter guessed is correct
                for (int i = 0; i < splitWord.length; i++) {
                    if (letter.equals(splitWord[i])) {
                        matches++;
                    }
                }

                System.out.println(wrongAttempts + " wrong guesses");

                if (matches == 0) {
                    wrongAttempts++;
                    System.out.println("Incorrect guess");
                }
            }

            // prints word progress
            attempt = "";
            boolean charFound = false;
            // loop for length of splitword
            for (int i = 0; i < splitWord.length; i++) {
                charFound = false;
                // prints letter if a letter in the guessed matches
                for (int j = 0; j < guessed.length; j++) {
                    // looks through the 26 values of guessed in the letter of the word
                    // if nothing matches the current character print '_'
                    if (guessed[j].equals(splitWord[i])) {
                        attempt = attempt + splitWord[i];
                        charFound = true;
                    }
                }
                if (charFound == false) {
                    attempt = attempt + " _";
                }
            }

            // game won
            if (attempt.equals(words[random_word])) {
                System.out.println(attempt + " was the word!");
                System.out.println("You Won!");
                won = true;
            } else {
                System.out.println(attempt);
            }

            // game lost
            if (run == false) {
                System.out.print(words[random_word] + " was the word!");
                System.out.println("");
                System.out.println("You lost!");
            }
        } while (run & !won);
    }
}
