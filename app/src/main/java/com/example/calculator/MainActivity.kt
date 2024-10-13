package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(),OnClickListener {

    var operator: String = ""
    var firstOperand = 0
    var secondOperand = 0
    var isOperatorClicked: Boolean = false
    var isEqualClicked:Boolean = false
    lateinit var upView :TextView
    lateinit var downView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         upView = findViewById(R.id.upText)
         downView = findViewById(R.id.downText)
        var buttonList = Array<Button?>(size = 20){findViewById<Button>(R.id.button0)}
        buttonList[0] = findViewById(R.id.button0)
        buttonList[1] = findViewById(R.id.button1)
        buttonList[2] = findViewById(R.id.button2)
        buttonList[3] = findViewById(R.id.button3)
        buttonList[4] = findViewById(R.id.button4)
        buttonList[5] = findViewById(R.id.button5)
        buttonList[6] = findViewById(R.id.button6)
        buttonList[7] = findViewById(R.id.button7)
        buttonList[8] = findViewById(R.id.button8)
        buttonList[9] = findViewById(R.id.button9)
        buttonList[10] = findViewById(R.id.CE_button)
        buttonList[11] = findViewById(R.id.C_button)
        buttonList[12] = findViewById(R.id.BS_button)
        buttonList[13] = findViewById(R.id.div_button)
        buttonList[14] = findViewById(R.id.time_button)
        buttonList[15] = findViewById(R.id.plus_button)
        buttonList[16] = findViewById(R.id.minus_button)
        buttonList[17] = findViewById(R.id.dot_button)
        buttonList[18] = findViewById(R.id.sign_button)
        buttonList[19] = findViewById(R.id.equal_button)

        for(i in 0..19){
            buttonList[i]?.setOnClickListener(this)
        }

    }

    override fun onClick(view: View?) {
        var text = (view as Button) .text.toString()
        when(text){
            "+"->{
                operator  = "+"
                isOperatorClicked = true
                upView.text = "$firstOperand + "
            }
            "-"->{
                operator = "-"
                isOperatorClicked = true
                upView.text = "$firstOperand - "
            }
            "x"->{
                operator  = "x"
                isOperatorClicked = true
                upView.text = "$firstOperand x "
            }
            "/"->{
                operator = "/"
                isOperatorClicked = true
                upView.text = "$firstOperand / "
            }
            "C"->{
                firstOperand = 0
                secondOperand = 0
                upView.text = "0"
                downView.text = "0"
                isOperatorClicked = false
            }
            "CE"->{
                secondOperand = 0
                downView.text = "0"

            }
            "BS"->{
                if(isOperatorClicked){
                    secondOperand/=10;
                    downView.text = "$secondOperand"
                }else {
                    firstOperand /=10
                    downView.text = "$firstOperand"
                }
            }
            "."->{
                //do nothing
            }
            "+/-"->{
                if(isOperatorClicked){
                    secondOperand = -secondOperand
                    downView.text = "$secondOperand"
                }else {
                    firstOperand = -firstOperand
                    downView.text = "$firstOperand"
                }
            }
            "="->{
                if(isOperatorClicked){
                    isOperatorClicked = false
                    isEqualClicked = true;
                    upView.text = "$firstOperand $operator $secondOperand = "
                    when(operator){
                        "+"->{
                            firstOperand = firstOperand + secondOperand
                            downView.text = "$firstOperand"
                        }
                        "-"->{
                            firstOperand = firstOperand - secondOperand
                            downView.text = "$firstOperand"
                        }
                        "x"->{
                            firstOperand = firstOperand * secondOperand
                            downView.text = "$firstOperand"
                        }
                        "/"->{
                            if(secondOperand != 0) {
                                firstOperand = firstOperand / secondOperand
                                downView.text = "$firstOperand"
                            } else {
                                downView.text = "Error"
                            }
                        }
                    }
                }
            }
            else->{
                if(isEqualClicked == true){
                    if(!isOperatorClicked){
                        firstOperand = text.toInt();
                        downView.text = "$firstOperand"
                        secondOperand = 0
                        upView.text = ""
                        isEqualClicked = false
                    }else{
                        secondOperand=text.toInt()
                        downView.text = "$secondOperand"
                        isEqualClicked = false
                    }
                }
                else{
                    if(isOperatorClicked){
                        secondOperand=secondOperand*10+text.toInt()
                        downView.text = "$secondOperand"
                    }else{
                        firstOperand = firstOperand*10+text.toInt()
                        downView.text = "$firstOperand"
                    }
                }
            }
        }
    }
    }
