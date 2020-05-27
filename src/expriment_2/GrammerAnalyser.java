package expriment_2;

/**
 * 文法G(E)：
 * E::=E+T|T
 * T::=T*E|F
 * F::=(E)|i
 */
public class GrammerAnalyser {
    private int location=0;//目前符号的位置
    private String str;//代分析的字符串
    private char next;
    public GrammerAnalyser(String str) {
        this.str = str;
        next=str.charAt(location);
    }

    private void E() throws Exception {
        this.T();
        this._E_();

    }
    //E'
    private void _E_() throws Exception {
        if(next=='+'){
            nextChar();
            T();
            _E_();
        }

    }
    private void T() throws Exception {
        F();
        _T_();
    }
    //T'
    private void _T_() throws Exception {
        if(next=='*'){
            nextChar();
            F();
            _T_();
        }
    }

    private void F() throws Exception {
        if(next=='('){
            nextChar();
            E();
            if(next==')'){
                nextChar();
            } else {
                error();
            }
        } else if(next=='i'){
            nextChar();
        } else {
            error();
        }
    }
    private void error() throws Exception {
        throw new Exception("无法识别字符串："+this.str);
    }
    private void nextChar(){
        location++;
        if(location!=str.length()) {
            this.next = str.charAt(location);
        }
    }

    public void analyse() throws Exception {
       E();
       if(location!=str.length())
           error();
       else
           System.out.println("字符串："+str+"识别成功");
    }

    public static void main(String[] args) throws Exception {
        GrammerAnalyser grammerAnalyser=new GrammerAnalyser("i+i+(i+i)+i*i");
        grammerAnalyser.analyse();
    }
}
