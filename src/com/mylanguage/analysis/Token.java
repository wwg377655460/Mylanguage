package com.mylanguage.analysis;

import java.util.HashSet;

/**
 * Created by wsdevotion on 15/11/22.
 */
public class Token {

    public Token(Type type, String value) throws LexicalAnalysisException {
        if(type == Type.Identifier){
            char firstChar = value.charAt(0);

            if(firstChar >= '0' & firstChar < '9'){
                char secend = '\0';
                for(int i=1; i<value.length(); i++){
                    if(value.charAt(i) <'0' || value.charAt(i)>'9'){
                        throw new LexicalAnalysisException(value + "属性名称不符合规范");
                    }
                }
                type = Type.Number;
            }else if(keywordsSet.contains(value)){
                type = Type.Keyword;
            }
        }else if(type == Type.Annotation){
            value = value.substring(1);
        }else if(type == Type.String){
            value = value.substring(1, value.length() - 1);
        }else if(type == Type.EndSymbol){
            value = null;
        }
        this.type = type;
        this.value = value;
    }

    public static enum Type{
            Keyword, Number, Identifier, Sign, Annotation,
            String, Space, NewLine, EndSymbol;
    }

    private static final HashSet<String> keywordsSet = new HashSet<>();

    static {
        keywordsSet.add("if");
        keywordsSet.add("when");
        keywordsSet.add("elsif");
        keywordsSet.add("else");
        keywordsSet.add("while");
        keywordsSet.add("begin");
        keywordsSet.add("until");
        keywordsSet.add("for");
        keywordsSet.add("do");
        keywordsSet.add("try");
        keywordsSet.add("catch");
        keywordsSet.add("finally");
        keywordsSet.add("end");
        keywordsSet.add("def");
        keywordsSet.add("var");
        keywordsSet.add("this");
        keywordsSet.add("null");
        keywordsSet.add("throw");
        keywordsSet.add("break");
        keywordsSet.add("continue");
        keywordsSet.add("return");
    }

    final Type type;
    final String value;
}
