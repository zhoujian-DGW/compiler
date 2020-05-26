package expriment_1;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class Analyser {
    /**
     *
     * @param ch 输入字符
     * @return 是否为字母
     */
    public boolean isWord(char ch){
        return ch>='A'&&ch<='z';
    }

    /**
     *
     * @param ch 输入字符
     * @return 是否为数字
     */
    public boolean isNumber(char ch){
        return ch>='0'&&ch<='9';
    }

    /**
     *
     * @param str 输入字符串
     * @return 是否为关键字
     */
    public boolean isMyKeywords(String str){
        return CharacterMap.getKeywordMap().containsKey(str);
    }

    /**
     *
     * @param ch 输入字符
     * @return 是否是特殊字符
     */
    public boolean isSCharacter(String ch){
        return CharacterMap.getsChrarcterMap().containsKey(ch);
    }

    /**
     * 输出属性字
     * @param str
     */
    public void showCharacter(String str,String type){
        Character ch=type==null?CharacterMap.getCharacterMap().get(str):CharacterMap.getCharacterMap().get(type);
        System.out.println(ch.getType()+":"+str+"   优先级："+ch.getCode());
    }

    /**
     * 进行词法分析
     * @param str
     */
    public void analysis(String str){
        int count=0;
        StringBuilder stringBuilder=new StringBuilder();
        while (count<str.length()){
            char ch=str.charAt(count);
            if(ch==' '||ch=='\t')
            {
                count++;
                continue;
            }
            if(this.isWord(ch)){//是字母
               stringBuilder.append(ch);
                ch=str.charAt(++count);
               while(this.isWord(ch)||this.isNumber(ch)){
                   stringBuilder.append(ch);
                   ch=str.charAt(++count);
               }
               String type=null;
               if(!this.isMyKeywords(stringBuilder.toString())){
                   type="标识符";
               }
               this.showCharacter(stringBuilder.toString(),type);
               stringBuilder.setLength(0);//清空stringBuilder
            } else if (this.isNumber(ch)){//是数字
                stringBuilder.append(ch);
                ch=str.charAt(++count);
                while (this.isNumber(ch)){
                    stringBuilder.append(ch);
                    ch=str.charAt(++count);
                }
                this.showCharacter(stringBuilder.toString(),"整数");
                stringBuilder.setLength(0);
            } else {
                stringBuilder.append(ch);
                count++;
                if(count<str.length()) {
                    ch = str.charAt(count);
                    stringBuilder.append(ch);
                }
                if(this.isSCharacter(stringBuilder.toString())){
                    this.showCharacter(stringBuilder.toString(),null);
                } else if(this.isSCharacter(stringBuilder.deleteCharAt(stringBuilder.length()-1).toString())){
                    this.showCharacter(stringBuilder.toString(),null);
                    count--;
                } else {
                    System.out.println("非法字符："+stringBuilder.toString());
                }
                stringBuilder.setLength(0);
                count++;
            }

        }
    }
    public String readFromFile(String path) throws Exception{
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
      a.analysis(a.readFromFile("Files/test.txt"));
    }
}
