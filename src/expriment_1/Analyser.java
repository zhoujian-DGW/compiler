package expriment_1;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class Analyser {
    //待分析的字符串
    private String str;
    //当前位置
    private int location=0;
    /**
     *
     * @param ch 输入字符
     * @return 是否为字母
     */
    private boolean isWord(char ch){
        return ch>='A'&&ch<='z';
    }

    /**
     *
     * @param ch 输入字符
     * @return 是否为数字
     */
    private boolean isNumber(char ch){
        return ch>='0'&&ch<='9';
    }

    /**
     *
     * @param str 输入字符串
     * @return 是否为关键字
     */
    private boolean isMyKeywords(String str){
        return CharacterMap.getKeywordMap().containsKey(str);
    }

    /**
     *
     * @param ch 输入字符
     * @return 是否是特殊字符
     */
    private boolean isSCharacter(String ch){
        return CharacterMap.getsChrarcterMap().containsKey(ch);
    }

    /**
     * 输出属性字
     * @param str
     */
    private void showCharacter(String str,String type){
        Character ch=type==null?CharacterMap.getCharacterMap().get(str):CharacterMap.getCharacterMap().get(type);
        System.out.println(ch.getType()+":"+str+"   优先级："+ch.getCode());
    }

    //获取一个字符
    private char getChar(){
        if(this.location<this.str.length())
            return str.charAt(location++);
        else return '#';
    }
    /**
     * 进行词法分析
     * @param str
     */

    public LinkedList<String> analysis(String str){
        this.str=str;
        StringBuilder stringBuilder=new StringBuilder();
        LinkedList<String> list=new LinkedList<>();
        char ch;
        while ((ch=getChar())!='#'){
            if(ch=='\t'||ch==' ')
            {
                continue;
            }
            if(this.isWord(ch)){//是字母
               stringBuilder.append(ch);
                ch=getChar();
               while(this.isWord(ch)||this.isNumber(ch)){
                   stringBuilder.append(ch);
                   ch=getChar();
               }
               String type=null;
               if(!this.isMyKeywords(stringBuilder.toString())){
                   type="标识符";
               }
               list.add(stringBuilder.toString());
               this.showCharacter(stringBuilder.toString(),type);
               stringBuilder.setLength(0);//清空stringBuilder
            } else if (this.isNumber(ch)){//是数字
                stringBuilder.append(ch);
                ch=getChar();
                while(this.isNumber(ch)){
                    stringBuilder.append(ch);
                    ch=getChar();
                }
                list.add(stringBuilder.toString());
                this.showCharacter(stringBuilder.toString(),"整数");
                stringBuilder.setLength(0);
            } else {
                stringBuilder.append(ch);
                ch=getChar();
                if(ch!='#') {
                    stringBuilder.append(ch);
                }
                if(this.isSCharacter(stringBuilder.toString())){
                    list.add(stringBuilder.toString());
                    this.showCharacter(stringBuilder.toString(),null);
                } else if(this.isSCharacter(stringBuilder.deleteCharAt(stringBuilder.length()-1).toString())){
                    list.add(stringBuilder.toString());
                    this.showCharacter(stringBuilder.toString(),null);
                    location--;
                }
                stringBuilder.setLength(0);
            }

        }
        return list;
    }
    private String readFromFile(String path) throws Exception{
        File file=new File(path);
        FileInputStream fin=new FileInputStream(file);
        int length=fin.available();
        byte[] bytes=new byte[length];
        fin.read(bytes);
        fin.close();
        return new String(bytes, StandardCharsets.UTF_8);
    }
    public static void main(String[] args) throws Exception {
      Analyser a=new Analyser();
      List ls=a.analysis(a.readFromFile("Files/test.txt"));
      System.out.println(ls);
    }
}
