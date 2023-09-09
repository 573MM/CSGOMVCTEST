package csgomvc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyCompiler5 extends MyCompiler{
    private String KeywordAndSign;
    private String Variable;
    private String Integer;
    private String Assignment;

    @Override
    public String checkType(String str){
        if (isKeywordAndSign(str) == true){
            return(str + " is Keyword And Sign");
        }else if (isAssignment(str) == true){
            return(str + " is Assignment");
        }else if (isInteger(str) == true){
            return(str + " is Integer");
        }else if (isVariable(str) == true){
            return(str + " is Variable");
        }else return "error!!!!!";
    }

    public boolean isKeywordAndSign(String str){
        if(str.equals("declare") || str.equals("+")) return true;
        else return false;
    }
    public boolean isVariable(String str){
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
    public boolean isInteger(String str){
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
    public boolean isAssignment(String str){
        if(str.equals("=")) return true;
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
    public String getKeywordAndSign() {
        return this.KeywordAndSign;
    }

    public void setKeywordAndSign(String KeywordAndSign) {
        this.KeywordAndSign = KeywordAndSign;
    }

    public String getVariable() {
        return this.Variable;
    }

    public void setVariable(String Variable) {
        this.Variable = Variable;
    }

    public String getInteger() {
        return this.Integer;
    }

    public void setInteger(String Integer) {
        this.Integer = Integer;
    }

    public String getAssignment() {
        return this.Assignment;
    }

    public void setAssignment(String Assignment) {
        this.Assignment = Assignment;
    }

    public MyCompiler5(){

    }
    
}
