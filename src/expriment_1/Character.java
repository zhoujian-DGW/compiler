package expriment_1;

public class Character {
    //符号类
    private String type;
    //符号
    private String character;
    //编码
    private int code;

    public Character(String type, String character,int code) {
        this.type = type;
        this.code = code;
        this.character=character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    public String getType() {
        return type;
    }

    public int getCode() {
        return code;
    }
}
