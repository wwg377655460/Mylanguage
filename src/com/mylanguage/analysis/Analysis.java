package com.mylanguage.analysis;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wsdevotion on 15/11/22.
 */
public class Analysis {

    public List<Token> lexical(String file){
        String str = "";
        List<Token> list = new ArrayList<>();
        FileReader fileReader = null;



        String path = null;
        try {
            path = test.class.getClassLoader().getResource("").toURI().getPath();
            BufferedReader bf= new BufferedReader(new FileReader(path + "1.txt"));
            while ((str = bf.readLine()) != null) {
                String [] arr = str.split(" ");
                for(int i=0; i<arr.length; i++){
                    LexicalAnalysis lexicalAnalysis = null;
                    if(!arr[i].equals("") && arr[i] != null && arr[i]!="\n") {
                        if(arr[i].contains("#")){
                            String first = arr[i].substring(0, arr[i].indexOf("#"));
                            String second = arr[i].substring(arr[i].indexOf("#"));
                            if(!first.equals("")){
                                lexicalAnalysis = new LexicalAnalysis(new StringReader(first));
                                Token token = lexicalAnalysis.read();
                                list.add(token);
                                System.out.println("类型:" + token.type + " 值：" + token.value);
                            }
                            while(i+1<arr.length){
                                second += " "+ arr[i+1];
                                i++;
                            }
                            lexicalAnalysis = new LexicalAnalysis(new StringReader(second));
                            Token token = lexicalAnalysis.read();
                            list.add(token);
                            System.out.println("类型:" + token.type + " 值：" + token.value);
                            break;
                        }

                        lexicalAnalysis = new LexicalAnalysis(new StringReader(arr[i]));
                        Token token = lexicalAnalysis.read();
                        list.add(token);
                        System.out.println("类型:" + token.type + " 值：" + token.value);
                    }
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LexicalAnalysisException e) {
            e.printStackTrace();
        }


        return list;

    }
}
