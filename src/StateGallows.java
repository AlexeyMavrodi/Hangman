public enum StateGallows {
    ONE_MISTAKE("━━━━━━━━━━━\n" +
                "┃         ┋\n" +
                "┃         ┋\n" +
                "┃         O\n" +
                "┃          \n" +
                "┃          \n" +
                "━━━        \n"),
    TWO_MISTAKES("━━━━━━━━━━━\n" +
                 "┃         ┋\n" +
                 "┃         ┋\n" +
                 "┃         O\n" +
                 "┃         0\n" +
                 "┃          \n" +
                 "━━━        \n"),
    THREE_MISTAKES("━━━━━━━━━━━\n" +
                   "┃         ┋\n" +
                   "┃         ┋\n" +
                   "┃         O\n" +
                   "┃        /0\n" +
                   "┃          \n" +
                   "━━━        \n"),
    FOUR_MISTAKES("━━━━━━━━━━━\n" +
                  "┃         ┋\n" +
                  "┃         ┋\n" +
                  "┃         O\n" +
                  "┃        /0\\\n" +
                  "┃          \n" +
                  "━━━        \n"),
    FIVE_MISTAKES("━━━━━━━━━━━\n" +
                  "┃         ┋\n" +
                  "┃         ┋\n" +
                  "┃         O\n" +
                  "┃        /0\\\n" +
                  "┃        / \n" +
                  "━━━        \n"),
    SIX_MISTAKES("━━━━━━━━━━━\n" +
                 "┃         ┋\n" +
                 "┃         ┋\n" +
                 "┃         O\n" +
                 "┃        /0\\\n" +
                 "┃        / \\\n" +
                 "━━━        \n");

    private final String state;

    StateGallows(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
