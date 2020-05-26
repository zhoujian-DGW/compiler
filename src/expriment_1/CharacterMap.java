package expriment_1;

import java.util.*;

public class CharacterMap {
    //属性字表
    private static Map<String,Character> characterMap;
    //关键字表
    private static Map<String,Integer> keywordMap;
    //特殊字符表
    private static Map<String,Integer> sCharacterMap;
    public static Map<String,Character> getCharacterMap() {
        if(characterMap==null){
            characterMap=new HashMap<>();
            characterMap.put("未定义",new Character("未定义","",0));
            characterMap.put("标识符",new Character("标识符","",1));
            characterMap.put("整数",new Character("整数","",2));
            characterMap.put("+",new Character("符号","+",3));
            characterMap.put("-",new Character("符号","-",4));
            characterMap.put("*",new Character("符号","*",5));
            characterMap.put("/",new Character("符号","/",6));
            characterMap.put("<",new Character("符号","<",7));
            characterMap.put("<=",new Character("符号","<=",8));
            characterMap.put(">",new Character("符号",">",9));
            characterMap.put(">=",new Character("符号",">=",10));
            characterMap.put("==",new Character("符号","==",11));
            characterMap.put("!=",new Character("符号","!=",12));
            characterMap.put("&",new Character("符号","&",13));
            characterMap.put("&&",new Character("符号","&&",14));
            characterMap.put("||",new Character("符号","||",15));
            characterMap.put("=",new Character("符号","=",16));
            characterMap.put("(",new Character("符号","(",17));
            characterMap.put(")",new Character("符号",")",18));
            characterMap.put("[",new Character("符号","[",19));
            characterMap.put("]",new Character("符号","]",20));
            characterMap.put("{",new Character("符号","{",21));
            characterMap.put("}",new Character("符号","}",22));
            characterMap.put(":",new Character("符号",":",23));
            characterMap.put(";",new Character("符号",";",24));
            characterMap.put(",",new Character("符号",",",25));
            characterMap.put("void",new Character("关键字","void",26));
            characterMap.put("int",new Character("关键字","int",27));
            characterMap.put("float",new Character("关键字","float",28));
            characterMap.put("char",new Character("关键字","char",29));
            characterMap.put("if",new Character("关键字","if",30));
            characterMap.put("else",new Character("关键字","else",31));
            characterMap.put("while",new Character("关键字","while",32));
            characterMap.put("do",new Character("关键字","do",33));
            characterMap.put("return",new Character("关键字","return",33));
        }
        return characterMap;
    }

    public static Map<String, Integer> getKeywordMap() {
        if(keywordMap==null){
            keywordMap=new HashMap<String,Integer>();
            keywordMap.put("void","void".hashCode());
            keywordMap.put("int","int".hashCode());
            keywordMap.put("float","float".hashCode());
            keywordMap.put("char","char".hashCode());
            keywordMap.put("if","else".hashCode());
            keywordMap.put("while","while".hashCode());
            keywordMap.put("do","eo".hashCode());
            keywordMap.put("return","return".hashCode());
        }
        return keywordMap;
    }

    public static Map<String, Integer> getsChrarcterMap() {
        if(sCharacterMap==null){
            sCharacterMap=new HashMap<String,Integer>();
            sCharacterMap.put("+","+".hashCode());
            sCharacterMap.put("-","-".hashCode());
            sCharacterMap.put("*","*".hashCode());
            sCharacterMap.put("/","/".hashCode());
            sCharacterMap.put("<","<".hashCode());
            sCharacterMap.put("<=","<=>".hashCode());
            sCharacterMap.put(">",">".hashCode());
            sCharacterMap.put(">=",">=".hashCode());
            sCharacterMap.put("==","==".hashCode());
            sCharacterMap.put("!=","!=".hashCode());
            sCharacterMap.put("&","&".hashCode());
            sCharacterMap.put("&&","&&".hashCode());
            sCharacterMap.put("||","||".hashCode());
            sCharacterMap.put("=","=".hashCode());
            sCharacterMap.put("(","(".hashCode());
            sCharacterMap.put(")",")".hashCode());
            sCharacterMap.put("[","[".hashCode());
            sCharacterMap.put("]","]".hashCode());
            sCharacterMap.put("{","{".hashCode());
            sCharacterMap.put("}","}".hashCode());
            sCharacterMap.put(":",":".hashCode());
            sCharacterMap.put(";",";".hashCode());
            sCharacterMap.put(",",",".hashCode());
        }
        return sCharacterMap;
    }
}
