package com.HeemaDev.calculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    //start
    //878789798789
    ArrayList<String> operator;
    ArrayList<ArrayList<Integer>> openBrackts =new ArrayList<>();
    ArrayList<ArrayList<Integer>> closeBrackts =new ArrayList<>();
    int countOpenBrackts=0,countCloseBrackts=0;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9, btnMul, btnSub, btnPlus, btnDiv, btnEq,btnX,
            btnC, btnBrackets,btnMOD,btnSQRT, btnXPowerOfY, btnXPower2,btnDot, btnPlusOrSub;
    EditText editText;
    TextView helloInMyCal,textResult;
    int count=0,countEq=0,indexEndOfValue=0,indexBeginOfValue=0,countBefore =0;

    String temp="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        openBrackts.add(new ArrayList<Integer>());
        closeBrackts.add(new ArrayList<Integer>());

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnMul = (Button) findViewById(R.id.btnMUL);
        btnSub = (Button) findViewById(R.id.btnSUB);
        btnPlus = (Button) findViewById(R.id.btnplus);
        btnDiv = (Button) findViewById(R.id.btnDIV);
        btnEq = (Button) findViewById(R.id.btnEQ);
        btnX = (Button) findViewById(R.id.btnx);
        btnC = (Button) findViewById(R.id.btnC);
        btnBrackets = (Button) findViewById(R.id.btnCE);
        btnMOD = (Button) findViewById(R.id.btnMod);
        btnSQRT = (Button) findViewById(R.id.btnsqrt);
        btnXPowerOfY = (Button) findViewById(R.id.btn1ONX);
        btnXPower2 = (Button) findViewById(R.id.btnXpower2);
        btnDot = (Button) findViewById(R.id.btnDOT);
        btnPlusOrSub = (Button) findViewById(R.id.btnPLUSORSUB);

        editText=(EditText)findViewById(R.id.textedit);

        helloInMyCal=(TextView)findViewById(R.id.textviewHello);
        textResult=(TextView)findViewById(R.id.result);

        operator=new ArrayList<>();
        Collections.addAll(operator,new String[]{"+","-","*","/","%","^","√"});

//        onclick action
        editText.requestFocus();
        /* important method *****************************************************************************************/
        editText.setShowSoftInputOnFocus(false);
        try {
            editText.addTextChangedListener(new TextWatcher() {

                @Override
                public void beforeTextChanged(CharSequence s, int start, int coun, int after) {
                    countBefore =editText.length();
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    System.out.println(openBrackts +"     open   >>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<< ");
                    System.out.println(closeBrackts+"  close   <>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<");
                }
                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            btn0.setOnClickListener(v -> {

                if(!editText.getText().toString().isEmpty()&&")".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart()-1)))){
                    editText.getText().insert(editText.getSelectionStart(), "*0");
                    updateIndexOfBrackts();
                }else {
                    editText.getText().insert(editText.getSelectionStart(), "0");
                    updateIndexOfBrackts();
                }
                result();
            });
            btn1.setOnClickListener(v -> {
                if(!editText.getText().toString().isEmpty()&&")".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart()-1)))){
                    editText.getText().insert(editText.getSelectionStart(), "*1");
                    updateIndexOfBrackts();
                }else {
                    editText.getText().insert(editText.getSelectionStart(), "1");
                    updateIndexOfBrackts();
                }
                result();
            });
            btn2.setOnClickListener(v -> {

                if(!editText.getText().toString().isEmpty()&&")".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart()-1)))){
                    editText.getText().insert(editText.getSelectionStart(), "*2");
                    updateIndexOfBrackts();
                }else {
                    editText.getText().insert(editText.getSelectionStart(), "2");
                    updateIndexOfBrackts();
                }
                result();
            });
            btn3.setOnClickListener(v -> {

                if(!editText.getText().toString().isEmpty()&&")".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart()-1)))){
                    editText.getText().insert(editText.getSelectionStart(), "*3");
                    updateIndexOfBrackts();
                }else {
                    editText.getText().insert(editText.getSelectionStart(), "3");
                    updateIndexOfBrackts();
                }

                result();
            });
            btn4.setOnClickListener(v -> {

                if(!editText.getText().toString().isEmpty()&&")".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart()-1)))){
                    editText.getText().insert(editText.getSelectionStart(), "*4");
                    updateIndexOfBrackts();
                }else {
                    editText.getText().insert(editText.getSelectionStart(), "4");
                    updateIndexOfBrackts();
                }

                result();
            });
            btn5.setOnClickListener(v -> {
                if(!editText.getText().toString().isEmpty()&&")".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart()-1)))){
                    editText.getText().insert(editText.getSelectionStart(), "*5");
                    updateIndexOfBrackts();
                }else {
                    editText.getText().insert(editText.getSelectionStart(), "5");
                    updateIndexOfBrackts();
                }

                result();
            });
            btn6.setOnClickListener(v -> {

                if(!editText.getText().toString().isEmpty()&&")".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart()-1)))){
                    editText.getText().insert(editText.getSelectionStart(), "*6");
                    updateIndexOfBrackts();
                }else {
                    editText.getText().insert(editText.getSelectionStart(), "6");
                    updateIndexOfBrackts();
                }

                result();
            });
            btn7.setOnClickListener(v -> {

                if(!editText.getText().toString().isEmpty()&&")".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart()-1)))){
                    editText.getText().insert(editText.getSelectionStart(), "*7");
                    updateIndexOfBrackts();
                }else {
                    editText.getText().insert(editText.getSelectionStart(), "7");
                    updateIndexOfBrackts();
                }

                result();
            });
            btn8.setOnClickListener(v -> {

                if(!editText.getText().toString().isEmpty()&&")".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart()-1)))){
                    editText.getText().insert(editText.getSelectionStart(), "*8");
                    updateIndexOfBrackts();
                }else {
                    editText.getText().insert(editText.getSelectionStart(), "8");
                    updateIndexOfBrackts();
                }

                result();
            });
            btn9.setOnClickListener(v -> {

                if(!editText.getText().toString().isEmpty()&&")".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart()-1)))){
                    editText.getText().insert(editText.getSelectionStart(), "*9");
                    updateIndexOfBrackts();
                }else {
                    editText.getText().insert(editText.getSelectionStart(), "9");
                    updateIndexOfBrackts();
                }

                result();
            });
            btnDiv.setOnClickListener(v -> {
                print(editText.getSelectionStart() + "   ");
                print((!editText.getText().toString().isEmpty() && !"(".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))) + "");
                if (!editText.getText().toString().isEmpty() && !"(".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))) {
                    if (operator.contains(editText.getText().toString().charAt(editText.getSelectionStart() - 1) + "")) {
                        editText.getText().replace(editText.getSelectionStart() - 1, editText.getSelectionStart(), "/");
                    } else if (!editText.getText().toString().isEmpty()) {
                        editText.getText().insert(editText.getSelectionStart(), "/");
                        updateIndexOfBrackts();
                    } else {
                        Toast.makeText(this, "enter number", Toast.LENGTH_SHORT).show();
                    }
                }
                result();
            });
            btnMul.setOnClickListener(v -> {
                if (!editText.getText().toString().isEmpty() && !"(".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))) {
                    if (operator.contains(editText.getText().toString().charAt(editText.getSelectionStart() - 1) + "")) {
                        editText.getText().replace(editText.getSelectionStart() - 1, editText.getSelectionStart(), "*");
                    } else if (!editText.getText().toString().isEmpty()) {
                        editText.getText().insert(editText.getSelectionStart(), "*");
                        updateIndexOfBrackts();
                    } else {
                        Toast.makeText(this, "enter number", Toast.LENGTH_SHORT).show();
                    }
                }
                result();
            });
            btnMOD.setOnClickListener(v -> {
                if (!editText.getText().toString().isEmpty() && !"(".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))) {
                    if (operator.contains(editText.getText().toString().charAt(editText.getSelectionStart() - 1) + "")) {
                        editText.getText().replace(editText.getSelectionStart() - 1, editText.getSelectionStart(), "%");
                    } else if (!editText.getText().toString().isEmpty()) {
                        editText.getText().insert(editText.getSelectionStart(), "%");
                        updateIndexOfBrackts();
                    } else {
                        Toast.makeText(this, "enter number", Toast.LENGTH_SHORT).show();
                    }
                }
                result();
            });
            btnSub.setOnClickListener(v -> {
                if (!editText.getText().toString().isEmpty() && !"(".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))) {
                    if (operator.contains(editText.getText().toString().charAt(editText.getSelectionStart() - 1) + "")) {
                        editText.getText().replace(editText.getSelectionStart() - 1, editText.getSelectionStart(), "-");
                    } else if (!editText.getText().toString().isEmpty()) {
                        editText.getText().insert(editText.getSelectionStart(), "-");
                        updateIndexOfBrackts();
                    } else {
                        Toast.makeText(this, "enter number", Toast.LENGTH_SHORT).show();
                    }
                }
                result();
            });
            btnPlus.setOnClickListener(v -> {
                if (!editText.getText().toString().isEmpty() && !"(".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))) {
                    if (operator.contains(editText.getText().toString().charAt(editText.getSelectionStart() - 1) + "")) {
                        editText.getText().replace(editText.getSelectionStart() - 1, editText.getSelectionStart(), "+");
                    } else if (!editText.getText().toString().isEmpty()) {
                        editText.getText().insert(editText.getSelectionStart(), "+");
                        updateIndexOfBrackts();
                    } else {
                        Toast.makeText(this, "enter number", Toast.LENGTH_SHORT).show();
                    }
                }
                result();
            });
            btnC.setOnClickListener(v -> {
                editText.setText("");
                textResult.setText("");
                temp = "";
                openBrackts.clear();
                closeBrackts.clear();
                openBrackts.add(new ArrayList<Integer>());
                closeBrackts.add(new ArrayList<Integer>());
                countOpenBrackts=countCloseBrackts=0;
            });
            btnBrackets.setOnClickListener(v -> {
                if (editText.getText().toString().isEmpty() || editText.getSelectionStart() == 0 || "(".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))
                        || operator.contains(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))) {
                    editText.getText().insert(editText.getSelectionStart(), "(");
                    updateIndexOfBrackts();
                    count++;
                    openBrackts.get(countOpenBrackts).add(editText.getSelectionStart()-1);
                } else if ((Character.isDigit(editText.getText().toString().charAt(editText.getSelectionStart() - 1)) || editText.getText().toString().charAt(editText.getSelectionStart() - 1) == ')') && count > 0) {
                    editText.getText().insert(editText.getSelectionStart(), ")");
                    updateIndexOfBrackts();
                    count--;
                    closeBrackts.get(countCloseBrackts).add(editText.getSelectionStart()-1);
                } else if (")".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1))) || count == 0) {
                    editText.getText().insert(editText.getSelectionStart(), "*(");
                    updateIndexOfBrackts();
                    count++;
                    openBrackts.get(countOpenBrackts).add(editText.getSelectionStart()-1);
                } else {
                    Toast.makeText(this, "invalid format used!", Toast.LENGTH_SHORT).show();
                }
                for (int i = 0; i< openBrackts.size(); i++)
                    Collections.sort(openBrackts.get(i));
                for (int i=0;i<closeBrackts.size();i++)
                    Collections.sort(closeBrackts.get(i));
                result();
                if (count==0&&editText.getText().toString().contains("(")){
                    countCloseBrackts++;
                    countOpenBrackts++;
                    openBrackts.add(new ArrayList<Integer>());
                    closeBrackts.add(new ArrayList<Integer>());
                }
            });
            btnX.setOnClickListener(v -> {
                Object o=editText.getSelectionStart()-1;
                if (editText.getText().toString().isEmpty() || editText.getSelectionStart() == 0) {
                } else {
                    if (")".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))) {
                        count++;
                        editText.getText().replace(editText.getSelectionStart() - 1, editText.getSelectionStart(), "");
                        for (int i=0;i<closeBrackts.size();i++) {
                            closeBrackts.get(i).remove(o);
                            System.out.println(closeBrackts+"close /////////////////+++++++++++++++++++++++");
                            /***************************************************************************************************************************************/
                            if(closeBrackts.get(i).isEmpty()){
                                closeBrackts.remove(i);
                                countCloseBrackts--;
                                if(closeBrackts.isEmpty()){
                                    closeBrackts.add(new ArrayList<Integer>());
                                    countCloseBrackts=0;
                                }
                            }
                        }
                    } else if ("(".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))) {
                        count--;
                        editText.getText().replace(editText.getSelectionStart() - 1, editText.getSelectionStart(), "");
                        for (int i=0;i<openBrackts.size();i++){
                            openBrackts.get(i).remove(o);
                            if(openBrackts.get(i).isEmpty()){
                                openBrackts.remove(i);
                                countOpenBrackts--;
                                if(openBrackts.isEmpty()){
                                    openBrackts.add(new ArrayList<Integer>());
                                    countOpenBrackts=0;
                                }
                            }
                        }
                    } else {
                        editText.getText().replace(editText.getSelectionStart() - 1, editText.getSelectionStart(), "");
                    }
                }
                result();
            });
            btnX.setOnLongClickListener(v -> {
                try {

                } catch (Exception e) {
                    print("not>>>>>>>>>>>>>>>>>>>>>>>>");
                }
                return false;
            });//search how to delete from edittext seqencial at long click
            btnXPower2.setOnClickListener(v -> {
                if (!editText.getText().toString().isEmpty() &&!"^".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1))) && !"(".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))) {
                    editText.getText().insert(editText.getSelectionStart(), "^2");
                    updateIndexOfBrackts();
                } else {
                    Toast.makeText(this, "invalid format used", Toast.LENGTH_SHORT).show();
                }
                result();
            });
            btnXPowerOfY.setOnClickListener(v -> {
                if ((!editText.getText().toString().isEmpty() || editText.getText().toString().equals("0")) && !"^".equals(String.valueOf(editText.getText().charAt(editText.getSelectionStart() - 1))) && !"(".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))) {
                    editText.getText().insert(editText.getSelectionStart(), "^");
                    updateIndexOfBrackts();
                } else {
                    Toast.makeText(this, "invalid format used", Toast.LENGTH_SHORT).show();
                }
                result();
            });
            btnSQRT.setOnClickListener(v -> {
                if(!openBrackts.get(countOpenBrackts).isEmpty()){
                    countOpenBrackts++;
                    openBrackts.add(new ArrayList<Integer>());
                }
                if (editText.getText().toString().isEmpty()) {
                    editText.getText().insert(editText.getSelectionStart(), "√(");
                    updateIndexOfBrackts();
                } else if (Character.isDigit(editText.getText().toString().charAt(editText.getSelectionStart() - 1))||")".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))) {
                    editText.getText().insert(editText.getSelectionStart(), "*√(");
                    updateIndexOfBrackts();
                } else {
                    editText.getText().insert(editText.getSelectionStart(), "√(");
                    updateIndexOfBrackts();
                }
                openBrackts.get(countOpenBrackts).add(editText.getSelectionStart()-1);
                count++;
                result();
            });
            btnDot.setOnClickListener(v -> {
                if (editText.getText().toString().isEmpty()) {
                    editText.getText().insert(editText.getSelectionStart(), ".");
                    updateIndexOfBrackts();
                } else {
                    ArrayList<String> s = setUpStringToFunCulc(editText.getText().toString());
                    if (getIndexInArrayList(editText.getSelectionStart(), editText.getText().toString(), s) != -1) {
                        if (!s.get(getIndexInArrayList(editText.getSelectionStart(), editText.getText().toString(), s)).contains(".")) {
                            editText.getText().insert(editText.getSelectionStart(), ".");
                            updateIndexOfBrackts();
                        } else {
                            Toast.makeText(this, "Not possible", Toast.LENGTH_SHORT).show();
                        }
                    } else if (operator.contains(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))) {
                        editText.getText().insert(editText.getSelectionStart(), ".");
                        updateIndexOfBrackts();
                    }
                }
                result();
            });
            btnPlusOrSub.setOnClickListener(v -> {
                ArrayList<String> s = setUpStringToFunCulc(editText.getText().toString());
                int index = getIndexInArrayList(editText.getSelectionStart(), editText.getText().toString(), s);
                if (!editText.getText().toString().isEmpty() && !"(".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart() - 1)))) {
                    if (index == 0) {
                        editText.getText().insert(0, "-");
                        updateIndexOfBrackts(0);
                        updateIndexOfBrackts(0);
                    } else if(index !=-1) {
                        if (s.get(index - 1).equals("-")) {
                            editText.getText().replace(indexBeginOfValue - 1, indexBeginOfValue, "+");
                        } else if ((s.get(index - 1).equals("+"))) {
                            editText.getText().replace(indexBeginOfValue - 1, indexBeginOfValue, "-");
                        } else {
                            if (!openBrackts.get(countOpenBrackts).isEmpty()) {
                                countOpenBrackts++;
                                openBrackts.add(new ArrayList<Integer>());
                            }
                            if (!closeBrackts.get(countCloseBrackts).isEmpty()) {
                                countCloseBrackts++;
                                closeBrackts.add(new ArrayList<Integer>());
                            }
                            openBrackts.get(countOpenBrackts).add(indexBeginOfValue);
                            editText.getText().replace(indexBeginOfValue, indexBeginOfValue, "(-");
                            editText.getText().insert(indexEndOfValue + 2, ")");
                            updateIndexOfBrackts();
                            closeBrackts.get(countCloseBrackts).add(indexEndOfValue + 2);
                            System.out.println(countOpenBrackts + "    >(   " + openBrackts);
                            System.out.println(countCloseBrackts + "    >)   " + closeBrackts);
                        }
                    }else{
                        Toast.makeText(this, "Invalid format used.", Toast.LENGTH_SHORT).show();
                    }
                } else if (editText.getText().toString().isEmpty()) {
                    editText.getText().insert(editText.getSelectionStart(), "-");
                    updateIndexOfBrackts();
                }
                result();
            });
            btnEq.setOnClickListener(v -> {
                try {
                    if (countEq > 0) {
                        if (!editText.getText().toString().isEmpty() && !"(".equals(String.valueOf(editText.getText().toString().charAt(editText.getText().toString().length() - 1)))) {
                            String s = editText.getText().toString();
                            if (s.charAt(0) == '-' || s.charAt(0) == '+')
                                s = "0" + s;
                            s = culc(culcBrackts(setUpStringToFunCulc(s + temp))) + "";
                            if (s.charAt(s.length() - 2) == '.' && s.charAt(s.length() - 1) == '0')
                                s = s.substring(0, s.length() - 2);
                            if(!s.equals("Infinity")){
                                editText.setText(s);
                            }else{
                                Toast.makeText(this, "Calculation outside of accepted range.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        if (!editText.getText().toString().isEmpty() && !"(".equals(String.valueOf(editText.getText().toString().charAt(editText.getText().toString().length() - 1)))) {
                            String s = editText.getText().toString();
                            if (s.charAt(0) == '-' || s.charAt(0) == '+') {
                                s = "0" + s;
                            }
                            s = culc(culcBrackts(setUpStringToFunCulc(s))) + "";
                            if (s.charAt(s.length() - 2) == '.' && s.charAt(s.length() - 1) == '0') {
                                s = s.substring(0, s.length() - 2);
                            }
                            if(!s.equals("Infinity")){
                                editText.setText(s);
                            }else{
                                Toast.makeText(this, "Calculation outside of accepted range.", Toast.LENGTH_SHORT).show();
                            }
                            countEq++;
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(this, "invalid format used ياخنزير", Toast.LENGTH_SHORT).show();
                }
                editText.setSelection(editText.getSelectionStart());
                textResult.setText("");
            });

        }catch (Throwable e){
            Toast.makeText(this, "ياخنزير ", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultStatusCode, @Nullable Intent resultIntent) {
        super.onActivityResult(requestCode, resultStatusCode, resultIntent);

        if (requestCode == 100 ) {
            if (resultStatusCode==RESULT_OK){
                SharedPreferences sharedPreferences = getSharedPreferences("StoreData", Context.MODE_PRIVATE);


                String Name = sharedPreferences.getString("name", "you");
                if (Name.equals("you") ) {
                    Toast.makeText(this, "Default values are loaded .", Toast.LENGTH_SHORT).show();
                } else {
                    helloInMyCal.setText("Hello"+Name+"in my calculator \uD83D\uDE0A\t");
                    Toast.makeText(this, "Data are loaded Successfully .", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    private  ArrayList<String> setUpStringToFunCulc(String s){
        ArrayList<String> content=new ArrayList<>();
        String temp = "";
        for (int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))||s.charAt(i)=='.'){
                temp+=s.charAt(i);
                if(i==s.length()-1){
                    content.add(temp);
                }
            }else{
                if(!temp.isEmpty()){
                    content.add(temp);
                }
                content.add(s.charAt(i)+"");
                temp="";
            }
        }
        if (operator.contains(content.get(0))){
            content.add(0,"0");
        }
        return content;
    }
    private  ArrayList<String> culcBrackts(ArrayList<String> content){/***************** Error here************************************************************ */
        try {
            content=setUpStringToFunCulc(editText.getText().toString());
            int indexOfEnd=0;
            for (int j = 0; j < openBrackts.size(); j++) {
                int k = openBrackts.get(j).size() - 1;
                for (int i = 0; i < closeBrackts.get(j).size()||i < openBrackts.get(j).size(); i++) {
                    ArrayList<String> contentOfBrackts = new ArrayList<>();
                    try {
                        indexOfEnd=closeBrackts.get(j).get(i);
                        contentOfBrackts.addAll(content.subList(openBrackts.get(j).get(k)+1, indexOfEnd));
                    }catch (Exception e){
                        indexOfEnd=editText.length();
                        contentOfBrackts.addAll(content.subList(openBrackts.get(j).get(k)+1, indexOfEnd));
                        indexOfEnd--;
                    }
                    if (contentOfBrackts.size() == 2 && operator.contains(contentOfBrackts.get(0))) {
                        contentOfBrackts.add(0, "0");
                    }
                    int index=openBrackts.get(j).get(k);
                    System.out.println(contentOfBrackts+"con bra");

                    for (int h = index; h <= indexOfEnd; h++) {
                        content.remove(h);
                        content.add(h,"");
                        System.out.println(content + "   content after h= "+h);
                    }
                    for (int r=0;r<contentOfBrackts.size();r++)
                        if(contentOfBrackts.contains(""))
                            contentOfBrackts.remove("");
                    if (contentOfBrackts.contains("*") || contentOfBrackts.contains("/") || contentOfBrackts.contains("+") || contentOfBrackts.contains("-")
                            || contentOfBrackts.contains("^") || contentOfBrackts.contains("%") || contentOfBrackts.contains("√")) {
                        System.out.println(content + "   content before");
                        content.remove(index);
                        content.add(index, culc(contentOfBrackts) + "");
                        System.out.println(content + "   content after");
                    } else {
                        content.remove(index);
                        content.add(index, contentOfBrackts.get(0));
                    }
                    if (k >= 0) {
                        k--;
                    }
                    else {
                        print("error");
                    }

                }
            }
            return content;
        }catch (Exception e){
            print("error () ");
            return content;
        }
    }
    private double culc(ArrayList<String> content){
        try {
            while (content.contains("")) {
                content.remove("");
            }
            if (content.size()==1)
                return Double.parseDouble(content.get(0));
            System.out.println(content+"   cluc 1111>>>>>>>>>>>>>>>>>>>>>>>>");
            double result = 0;
            if(content.size()>=2)
                temp =content.get(content.size()-2)+content.get(content.size()-1);
            for(int i = 0; i < content.size(); i++){
                if ("^".equals(content.get(i))) {
                    double t1 = Double.parseDouble(content.get(i - 1)), t2 = Double.parseDouble(content.get(i + 1));
                    content.remove(i - 1);
                    content.remove(i - 1);
                    content.remove(i - 1);
                    content.add(i - 1, String.valueOf(Math.pow(t1,t2)));
                    i = 0;
                }
                if ("√".equals(content.get(i))) {
                    double t1 = Double.parseDouble(content.get(i + 1));
                    content.remove(i );
                    content.remove(i );
                    content.add(i, String.valueOf(Math.sqrt(t1)));
                    i = 0;
                }
            }
            for (int i = 0; i < content.size(); i++) {
                if ("*".equals(content.get(i))||"x".equals(content.get(i))) {
                    double t1 = Double.parseDouble(content.get(i - 1)), t2 = Double.parseDouble(content.get(i + 1));
                    content.remove(i - 1);
                    content.remove(i - 1);
                    content.remove(i - 1);
                    content.add(i - 1, String.valueOf(t1 * t2));
                    i = 0;
                }
                if ("/".equals(content.get(i))||"÷".equals(content.get(i))) {
                    double t1 = Double.parseDouble(content.get(i - 1)), t2 = Double.parseDouble(content.get(i + 1));
                    if (t2 != 0) {
                        content.remove(i - 1);
                        content.remove(i - 1);
                        content.remove(i - 1);
                        content.add(i - 1, String.valueOf(t1 / t2));
                    } else {
                        Toast.makeText(this, "can't div on 0 ", Toast.LENGTH_SHORT).show();
                        btnX.callOnClick();
                        throw new ArithmeticException("div on zero");
                    }
                    i = 0;
                }
                if ("%".equals(content.get(i))) {
                    double t1 = Double.parseDouble(content.get(i - 1)), t2 = Double.parseDouble(content.get(i + 1));
                    content.remove(i - 1);
                    content.remove(i - 1);
                    content.remove(i - 1);
                    content.add(i - 1, String.valueOf(t1 % t2));
                    i = 0;
                }

            }

            for (int i = 0; i < content.size(); i++) {
                if ("+".equals(content.get(i))) {
                    double t1 = Double.parseDouble(content.get(i - 1)), t2 = Double.parseDouble(content.get(i + 1));
                    content.remove(i - 1);
                    content.remove(i - 1);
                    content.remove(i - 1);
                    content.add(i - 1, String.valueOf(t1 + t2));
                    i = 0;
                }
                if ("-".equals(content.get(i))) {
                    double t1 = Double.parseDouble(content.get(i - 1)), t2 = Double.parseDouble(content.get(i + 1));
                    content.remove(i - 1);
                    content.remove(i - 1);
                    content.remove(i - 1);
                    content.add(i - 1, String.valueOf(t1 - t2));
                    i = 0;
                }
            }
            result = Double.parseDouble(content.get(0));
            return result;
        }catch (Exception e){
            print("error culc ");
            return Double.parseDouble("");
        }
    }
    public void print(String s){
        Log.e( "ebrahemHassan",s);
    }
    private void result(){
        try {
            if((!editText.getText().toString().isEmpty()&&!"(".equals(String.valueOf(editText.getText().toString().charAt(editText.getText().toString().length() - 1))))
                    &&setUpStringToFunCulc(editText.getText().toString()).size()!=1){
                String s=editText.getText().toString();
                if (s.charAt(0)=='-'||s.charAt(0)=='+')
                    s="0"+s;
                s=culc(culcBrackts(setUpStringToFunCulc(s)))+"";
                if (s.charAt(s.length()-2)=='.'&&s.charAt(s.length()-1)=='0')
                    s=s.substring(0,s.length()-2);
                if(!s.equals("Infinity")){
                    textResult.setText(s);
                }else{
                    textResult.setText("");
                }
                countEq=0;
            }else{
                textResult.setText("");
            }
        }catch (Exception e){
            textResult.setText("");
        }
        editText.setSelection(editText.getSelectionStart());
    }
    private int getIndexInArrayList(int indexInString ,String string,ArrayList<String> arr){
        int indexInArr = 0;
        if(")".equals(String.valueOf(editText.getText().toString().charAt(editText.getSelectionStart()-1)))){
            for (int i=0;i<closeBrackts.size();i++){
                if(closeBrackts.get(i).indexOf(editText.getSelectionStart()-1)!=-1) {
                    indexInArr=openBrackts.get(i).get(openBrackts.get(i).size()-1-closeBrackts.get(i).indexOf(editText.getSelectionStart() - 1));
                    if (indexInArr!=0){
                        indexInArr--;
                    }
                }
            }
        }else {
            indexEndOfValue = 0;
            indexBeginOfValue = 0;
            if (indexInString < string.length()) {
                for (int i = indexInString; i < string.length(); i++) {
                    if (operator.contains(String.valueOf(string.charAt(i))) || i == string.length() - 1) {
                        indexEndOfValue = i;
                        break;
                    }
                }
            } else {
                indexEndOfValue = string.length();
            }
            for (int i = indexInString - 1; i >= 0; i--) {
                if (operator.contains(String.valueOf(string.charAt(i))) || "(".equals(String.valueOf(string.charAt(i))) || ")".equals(String.valueOf(string.charAt(i))) || i < 0) {
                    indexBeginOfValue = i + 1;
                    break;
                }
            }
            indexInArr = arr.indexOf(string.substring(indexBeginOfValue, indexEndOfValue));
        }
        return indexInArr;
    }/*ضيف , فى ال cursor قبل ما تبحث */
    private void updateIndexOfBrackts(){
        if(countBefore <editText.length()) {
            for (int i = 0; i < openBrackts.size(); i++) {
                for (int j = 0; j < openBrackts.get(i).size(); j++) {
                    if (editText.getSelectionStart() <= openBrackts.get(i).get(j)) {
                        openBrackts.get(i).add(j, openBrackts.get(i).get(j) + 1);
                        openBrackts.get(i).remove(j + 1);
                        System.out.println(openBrackts + "  open >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
                    }
                }
            }
            for (int i = 0; i < closeBrackts.size(); i++) {
                for (int j = 0; j < closeBrackts.get(i).size(); j++) {
                    if (editText.getSelectionStart() <= closeBrackts.get(i).get(j)) {
                        closeBrackts.get(i).add(j, closeBrackts.get(i).get(j) + 1);
                        closeBrackts.get(i).remove(j + 1);
                        System.out.println(closeBrackts + " close>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
                    }
                }
            }
        }
    }
    private void updateIndexOfBrackts(int x){
        if(countBefore <editText.length()) {
            for (int i = 0; i < openBrackts.size(); i++) {
                for (int j = 0; j < openBrackts.get(i).size(); j++) {
                    if (x <= openBrackts.get(i).get(j)) {
                        openBrackts.get(i).add(j, openBrackts.get(i).get(j) + 1);
                        openBrackts.get(i).remove(j + 1);
                        System.out.println(openBrackts + "  open >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> x");
                    }
                }
            }
            for (int i = 0; i < closeBrackts.size(); i++) {
                for (int j = 0; j < closeBrackts.get(i).size(); j++) {
                    if (x <= closeBrackts.get(i).get(j)) {
                        closeBrackts.get(i).add(j, closeBrackts.get(i).get(j) + 1);
                        closeBrackts.get(i).remove(j + 1);
                        System.out.println(closeBrackts + " close>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> x");
                    }
                }
            }
        }
    }
}