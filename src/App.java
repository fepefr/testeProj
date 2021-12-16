public class App {
    static String input = "In 1991, while studying computer science at University of Helsinki, " +
            "Linus Torvalds began a project that later became the Linux kernel. He wrote the program specifically " +
            "for the hardware he was using and independent of an operating system because " +
            "he wanted to use the functions of his new PC with an 80386 processor. Development was done on MINIX using the GNU C Compiler.";

    public static void main(String[] args) throws Exception {
        String formattedText = limitLineCharacters(input, 40);
        System.out.println(formattedText);
    }

    private static String limitLineCharacters(final String text, final int limit) {
        String[] tokens = text.split(" ");
        StringBuffer result = new StringBuffer();
        StringBuffer formattedLine = new StringBuffer();
        int currentLineSize = 0;
        for (int i = 0; i < tokens.length;) {
            String word = tokens[i];
            if (currentLineSize + tokens[i].length() <= limit) {
                formattedLine.append(word);
                currentLineSize += word.length();
                if (currentLineSize + 1 <= limit){
                    formattedLine.append(" ");
                    currentLineSize++;
                }
                i++;
                continue;
            }
            assert(formattedLine.length() <= limit);
            result.append(formattedLine);
            result.append("\n");
            currentLineSize = 0;
            formattedLine = new StringBuffer();
        }
        result.append(formattedLine);
        return result.toString();
    }
}