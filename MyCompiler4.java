package csgomvc;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyCompiler4 extends MyCompiler{
    private String Keyword;
    private String Identifier;
    private String Literal;
    private String Symbol;

    public MyCompiler4(){

    }
    @Override
    public String checkType(String str){
        if (isKeyword(str) == true){
            return(str + " is Keyword");
        }else if (isSymbol(str) == true){
            return(str + " is Symbol");
        }else if (isLiteral(str) == true){
            return(str + " is Literal");
        }else if (isIdentifier(str) == true){
            return(str + " is Identifier");
        }else return "error!!!!!";
    }

    public boolean isKeyword(String str){
        if(str.equals("declare")) return true;
        else return false;
    }
    public boolean isIdentifier(String str){
        if((str.equals("declare"))) return false;

        String rex = "[a-zA-z0-9]*" ;
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(str);
        boolean matchFound = matcher.find();
        if(matchFound) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isLiteral(String str){
         String rex = "[0-9]" ;
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(str);
        boolean matchFound = matcher.find();
        if(matchFound) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isSymbol(String str){
        if(str.equals("+") || str.equals("=")) return true;
        else return false;
    }
    @Override
    public boolean isComment(String str){
        String rex = "[//*]" ;
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(str);
        boolean matchFound = matcher.find();
        if(matchFound) {
            return true;
        } else {
            return false;
        }
    }

    public String getKeyword() {
        return this.Keyword;
    }

    public void setKeyword(String Keyword) {
        this.Keyword = Keyword;
    }

    public String getIdentifier() {
        return this.Identifier;
    }

    public void setIdentifier(String Identifier) {
        this.Identifier = Identifier;
    }

    public String getLiteral() {
        return this.Literal;
    }

    public void setLiteral(String Literal) {
        this.Literal = Literal;
    }

    public String getSymbol() {
        return this.Symbol;
    }

    public void setSymbol(String Symbol) {
        this.Symbol = Symbol;
    }

    
    
}
