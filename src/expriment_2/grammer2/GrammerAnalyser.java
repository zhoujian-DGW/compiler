package expriment_2.grammer2;

import expriment_1.Analyser;

import java.util.LinkedList;

/**
 * 文法G[S]:
 * S::=S;T|T
 * T::=if e then S else S|if e then S|a
 */
public class GrammerAnalyser {
    /**
     * 单词列表
     */
    private LinkedList<String> list;
    /**
     * 当前位置
     */
    private int location=0;

    String str="";//当前字符串
    String analysed;//被分析字符串

    /**
     *      * 构造函数分析词法
     * @param str
     */
    public GrammerAnalyser(String str){
        this.analysed=str;
        Analyser analyser=new Analyser();
        this.list=new LinkedList<>(analyser.analysis(str));

    }

    /**
     * 获取一个单词
     * @return
     */
    private void getWord(){
        if(location<list.size()){
            str=list.get(location++);
        } else str="";
    }

    private void S() throws Exception {
        T();
        _S_();
    }

    //S'
    private void _S_() throws Exception {
        if(str.equals(";")){
            getWord();
            T();
            _S_();
        }   else if(!str.equals("")){
            error();
        }
    }

    private void T() throws Exception {
        if(str.equals("a")){
            getWord();
        } else if(str.equals("if")){
            getWord();
            if(str.equals("e")){
                getWord();
                if(str.equals("then")){
                    getWord();
                    S();
                    _T_();
                } else {
                    error();
                }
            } else {
                error();
            }
        } else {
            error();
        }

    }

    //T'
    private void _T_() throws Exception {
        if(str.equals("else")){
            getWord();
            S();
        } else if(!str.equals("")){
            error();
        }
    }

    private void error() throws Exception {
        throw new Exception("无法识别字符串:"+this.analysed);
    }
    public void analyse() throws Exception {
        getWord();
        S();
        if(location==list.size()){
            System.out.println("字符串："+analysed+"识别成功");
        }
    }
    public static void main(String[] args) throws Exception {
        GrammerAnalyser grammerAnalyser=new GrammerAnalyser("if e then a;");
        grammerAnalyser.analyse();
    }
}
