package com.example.jose.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t;
    TextView t2;
    boolean reinicio = false;
    Button b;
    String[] baseDatos = new String[3];
    String operando = "";
    String memoria = "";
    double resultado = 0;
    boolean mem = false;
    boolean punto = false;
    boolean suma = false;
    boolean resta = false;
    boolean div = false;
    boolean mult = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView) findViewById(R.id.textView3);
        t2 = (TextView) findViewById(R.id.textView4);
    }

    public void pulsado(View v) {
        b = (Button) findViewById(v.getId());
            if (v.getId() != R.id.bMas && v.getId() != R.id.bDividir && v.getId() != R.id.bMenos && v.getId() != R.id.bMul && v.getId() != R.id.bIgual && v.getId() != R.id.bC && v.getId() != R.id.bCE && v.getId() != R.id.bDEL && v.getId() != R.id.bM && v.getId()!=R.id.bTan && v.getId()!= R.id.bCos && v.getId()!= R.id.bSen && v.getId()!= R.id.bRaiz) {
                if (reinicio == false) {
                    if (b.getText().equals(".") && punto == false) {//Controlar que no se introduzan mas de un punto.
                        operando = operando + b.getText();
                        memoria = memoria + b.getText();
                        t2.setText(memoria);
                        t.setText(operando);
                        punto = true;
                    } else {
                        if (v.getId() != R.id.bPunto) {
                            operando = operando + b.getText();
                            t.setText(operando);
                            memoria = memoria + b.getText();
                            t2.setText(memoria);
                        } else {
                            t.setText(operando);
                            t2.setText(memoria);
                        }
                    }
                } else {
                    t.setText("");
                    t2.setText("");
                    baseDatos[0] = "";
                    baseDatos[1] = "";
                    memoria = "";
                    operando = "";
                    suma = false;
                    resta = false;
                    div = false;
                    mult = false;
                    reinicio = false;
                    if (b.getText().equals(".") && punto == false) {//Controlar que no se introduzan mas de un punto.
                        operando = operando + b.getText();
                        memoria = memoria + b.getText();
                        t2.setText(memoria);
                        t.setText(operando);
                        punto = true;
                    } else {
                        if (v.getId() != R.id.bPunto) {
                            operando = operando + b.getText();
                            t.setText(operando);
                            memoria = memoria + b.getText();
                            t2.setText(memoria);
                        } else {
                            t.setText(operando);
                            t2.setText(memoria);
                        }
                    }
                }
            } else {
                switch (v.getId()) {
                    case R.id.bMas:
                        if (suma == false && mult == false && div == false && resta == false) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[0] = t.getText().toString();
                                t.setText("");
                                operando = "";
                                memoria = memoria + b.getText();
                                t2.setText(memoria);
                                suma = true;
                                punto = false;
                            } else {
                                Toast.makeText(this, R.string.noDatos, Toast.LENGTH_SHORT).show();
                            }
                        } else if (mult) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[1] = t.getText().toString();
                                t.setText("");
                                double n = Double.parseDouble(baseDatos[0]) * Double.parseDouble(baseDatos[1]);
                                memoria = Double.toString(n);
                                baseDatos[0] = Double.toString(n);
                                t2.setText(memoria + "+");
                                punto = false;
                                mult = false;
                                suma = true;
                            } else {
                                memoria = memoria.replace("x", "+");
                                t2.setText(memoria);
                                suma = true;
                                mult = false;
                            }
                        } else if (div) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[1] = t.getText().toString();
                                t.setText("");
                                double n = Double.parseDouble(baseDatos[0]) / Double.parseDouble(baseDatos[1]);
                                memoria = Double.toString(n);
                                baseDatos[0] = Double.toString(n);
                                t2.setText(memoria + "+");
                                punto = false;
                                div = false;
                                suma = true;
                            } else {
                                memoria = memoria.replace("÷", "+");
                                t2.setText(memoria);
                                suma = true;
                                div = false;
                            }
                        } else if (resta) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[1] = t.getText().toString();
                                t.setText("");
                                double n = Double.parseDouble(baseDatos[0]) - Double.parseDouble(baseDatos[1]);
                                memoria = Double.toString(n);
                                baseDatos[0] = Double.toString(n);
                                t2.setText(memoria + "+");
                                punto = false;
                                resta = false;
                                suma = true;
                            } else {
                                memoria = memoria.replace("-", "+");
                                t2.setText(memoria);
                                suma = true;
                                resta = false;
                            }
                        } else {
                            if (suma) {
                                if (!t.getText().toString().isEmpty()) {
                                    baseDatos[1] = t.getText().toString();
                                    t.setText("");
                                    double n = Double.parseDouble(baseDatos[0]) + Double.parseDouble(baseDatos[1]);
                                    memoria = Double.toString(n);
                                    baseDatos[0] = Double.toString(n);
                                    t2.setText(memoria + "+");
                                    punto = false;
                                    suma = true;
                                } else {
                                    Toast.makeText(this, R.string.noSegOperando, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        operando = "";
                        break;
                    case R.id.bMenos:

                        if (suma == false && mult == false && div == false && resta == false) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[0] = t.getText().toString();
                                t.setText("");
                                operando = "";
                                memoria = memoria + b.getText();
                                t2.setText(memoria);
                                punto = false;
                                resta = true;
                            } else {
                                Toast.makeText(this, R.string.noDatos, Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            if (suma) {
                                if (!t.getText().toString().isEmpty()) {
                                    baseDatos[1] = t.getText().toString();
                                    t.setText("");
                                    double n = Double.parseDouble(baseDatos[0]) + Double.parseDouble(baseDatos[1]);
                                    memoria = Double.toString(n);
                                    baseDatos[0] = Double.toString(n);
                                    t2.setText(memoria + "-");
                                    punto = false;
                                    resta = true;
                                } else {
                                    memoria = memoria.replace("+", "-");
                                    t2.setText(memoria);
                                    suma = false;
                                    resta = true;
                                }
                            } else if (mult) {
                                if (!t.getText().toString().isEmpty()) {
                                    baseDatos[1] = t.getText().toString();
                                    t.setText("");
                                    double n = Double.parseDouble(baseDatos[0]) * Double.parseDouble(baseDatos[1]);
                                    memoria = Double.toString(n);
                                    baseDatos[0] = Double.toString(n);
                                    t2.setText(memoria + "-");
                                    punto = false;
                                    mult = false;
                                    resta = true;
                                } else {
                                    memoria = memoria.replace("x", "-");
                                    t2.setText(memoria);
                                    resta = true;
                                    mult = false;
                                }
                            } else if (div) {
                                if (!t.getText().toString().isEmpty()) {
                                    baseDatos[1] = t.getText().toString();
                                    t.setText("");
                                    double n = Double.parseDouble(baseDatos[0]) / Double.parseDouble(baseDatos[1]);
                                    memoria = Double.toString(n);
                                    baseDatos[0] = Double.toString(n);
                                    t2.setText(memoria + "-");
                                    punto = false;
                                    div = false;
                                    resta = true;
                                } else {
                                    memoria = memoria.replace("÷", "-");
                                    t2.setText(memoria);
                                    resta = true;
                                    div = false;
                                }
                            } else if (resta) {
                                if (!t.getText().toString().isEmpty()) {
                                    baseDatos[1] = t.getText().toString();
                                    t.setText("");
                                    double n = Double.parseDouble(baseDatos[0]) - Double.parseDouble(baseDatos[1]);
                                    memoria = Double.toString(n);
                                    baseDatos[0] = Double.toString(n);
                                    t2.setText(memoria + "-");
                                    punto = false;
                                    resta = true;
                                } else {
                                    Toast.makeText(this, R.string.noSegOperando, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        operando = "";
                        break;
                    case R.id.bMul:

                        if (suma == false && mult == false && div == false && resta == false) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[0] = t.getText().toString();
                                t.setText("");
                                punto = false;
                                operando = "";
                                memoria = memoria + "x";
                                t2.setText(memoria);
                                mult = true;
                            } else {
                                Toast.makeText(this, R.string.noDatos, Toast.LENGTH_SHORT).show();
                            }
                        } else if (suma) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[1] = t.getText().toString();
                                t.setText("");
                                double n = Double.parseDouble(baseDatos[0]) + Double.parseDouble(baseDatos[1]);
                                memoria = Double.toString(n);
                                baseDatos[0] = Double.toString(n);
                                t2.setText(memoria + "x");
                                punto = false;
                                suma = false;
                                mult = true;
                            } else {
                                memoria = memoria.replace("+", "x");
                                t2.setText(memoria);
                                mult = true;
                                suma = false;
                            }
                        } else if (mult) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[1] = t.getText().toString();
                                t.setText("");
                                double n = Double.parseDouble(baseDatos[0]) * Double.parseDouble(baseDatos[1]);
                                memoria = Double.toString(n);
                                baseDatos[0] = Double.toString(n);
                                t2.setText(memoria + "x");
                                punto = false;
                                mult = true;
                            } else {
                                Toast.makeText(this, R.string.noSegOperando, Toast.LENGTH_SHORT).show();
                            }
                        } else if (div) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[1] = t.getText().toString();
                                t.setText("");
                                double n = Double.parseDouble(baseDatos[0]) / Double.parseDouble(baseDatos[1]);
                                memoria = Double.toString(n);
                                baseDatos[0] = Double.toString(n);
                                t2.setText(memoria + "x");
                                punto = false;
                                div = false;
                                mult = true;
                            } else {
                                memoria = memoria.replace("÷", "x");
                                t2.setText(memoria);
                                mult = true;
                                div = false;
                            }
                        } else if (resta) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[1] = t.getText().toString();
                                t.setText("");
                                double n = Double.parseDouble(baseDatos[0]) - Double.parseDouble(baseDatos[1]);
                                memoria = Double.toString(n);
                                baseDatos[0] = Double.toString(n);
                                t2.setText(memoria + "x");
                                punto = false;
                                mult = true;
                                resta = false;
                            } else {
                                memoria = memoria.replace("-", "x");
                                t2.setText(memoria);
                                mult = true;
                                resta = false;
                            }
                        }
                        operando = "";
                        break;
                    case R.id.bDividir:

                        if (suma == false && mult == false && div == false && resta == false) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[0] = t.getText().toString();
                                t.setText("");
                                punto = false;
                                operando = "";
                                memoria = memoria + b.getText();
                                t2.setText(memoria);
                                div = true;
                            } else {
                                Toast.makeText(this, R.string.noDatos, Toast.LENGTH_SHORT).show();
                            }
                            break;
                        } else if (suma) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[1] = t.getText().toString();
                                t.setText("");
                                double n = Double.parseDouble(baseDatos[0]) + Double.parseDouble(baseDatos[1]);
                                memoria = Double.toString(n);
                                baseDatos[0] = Double.toString(n);
                                t2.setText(memoria + "÷");
                                punto = false;
                                suma = false;
                                div = true;
                            } else {
                                memoria = memoria.replace("+", "÷");
                                t2.setText(memoria);
                                div = true;
                                suma = false;
                            }
                        } else if (mult) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[1] = t.getText().toString();
                                t.setText("");
                                double n = Double.parseDouble(baseDatos[0]) * Double.parseDouble(baseDatos[1]);
                                memoria = Double.toString(n);
                                baseDatos[0] = Double.toString(n);
                                t2.setText(memoria + "÷");
                                punto = false;
                                mult = false;
                                div = true;
                            } else {
                                memoria = memoria.replace("x", "÷");
                                t2.setText(memoria);
                                div = true;
                                mult = false;
                            }
                        } else if (div) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[1] = t.getText().toString();
                                t.setText("");
                                double n = Double.parseDouble(baseDatos[0]) / Double.parseDouble(baseDatos[1]);
                                memoria = Double.toString(n);
                                baseDatos[0] = Double.toString(n);
                                t2.setText(memoria + "÷");
                                punto = false;
                                div = true;
                            } else {
                                Toast.makeText(this, R.string.noSegOperando, Toast.LENGTH_SHORT).show();
                            }
                        } else if (resta) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[1] = t.getText().toString();
                                t.setText("");
                                double n = Double.parseDouble(baseDatos[0]) - Double.parseDouble(baseDatos[1]);
                                memoria = Double.toString(n);
                                baseDatos[0] = Double.toString(n);
                                t2.setText(memoria + "÷");
                                punto = false;
                                div = true;
                                resta = false;
                            } else {
                                memoria = memoria.replace("-", "÷");
                                t2.setText(memoria);
                                div = true;
                                resta = false;
                            }
                        }
                        operando = "";
                        break;
                    case R.id.bIgual:
                        baseDatos[1] = t.getText().toString();
                        try {
                            if (!baseDatos[0].isEmpty() && !baseDatos[1].isEmpty()) {
                                reinicio = true;
                                if (suma) {
                                    resultado = Double.parseDouble(baseDatos[0]) + Double.parseDouble(baseDatos[1]);
                                    t.setText("" + resultado);
                                    suma = false;
                                    punto = false;
                                } else if (resta) {
                                    resultado = Double.parseDouble(baseDatos[0]) - Double.parseDouble(baseDatos[1]);
                                    t.setText("" + resultado);
                                    resta = false;
                                    punto = false;
                                } else if (mult) {
                                    resultado = Double.parseDouble(baseDatos[0]) * Double.parseDouble(baseDatos[1]);
                                    t.setText("" + resultado);
                                    mult = false;
                                    punto = false;
                                } else {
                                    resultado = Double.parseDouble(baseDatos[0]) / Double.parseDouble(baseDatos[1]);
                                    t.setText("" + resultado);
                                    div = false;
                                    punto = false;
                                }
                            } else {
                                Toast.makeText(this, R.string.noSegOperando, Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception er) {
                        }
                        break;
                    case R.id.bC:
                        t.setText(null);
                        if (suma == true || resta == true || div == true || mult == true) {
                            if (suma) {
                                t2.setText(memoria.substring(0, memoria.indexOf("+") + 1));
                                memoria = t2.getText().toString();
                                operando = null;
                                t.setText(operando);
                            } else if (resta) {
                                t2.setText(memoria.substring(0, memoria.indexOf("-") + 1));
                                memoria = t2.getText().toString();
                                operando = null;
                                t.setText(operando);
                            } else if (div) {
                                t2.setText(memoria.substring(0, memoria.indexOf("÷") + 1));
                                memoria = t2.getText().toString();
                                operando = null;
                                t.setText(operando);
                            } else {
                                t2.setText(memoria.substring(0, memoria.indexOf("x") + 1));
                                memoria = t2.getText().toString();
                                operando = null;
                                t.setText(operando);
                            }
                        } else {
                            memoria = "";
                            t2.setText(memoria);
                            operando = "";
                            t.setText(operando);

                        }
                        break;
                    case R.id.bCE:
                        try {
                            if (!baseDatos[0].isEmpty() || !baseDatos[1].isEmpty() || mem == true) {
                                baseDatos[0] = null;
                                baseDatos[1] = null;
                                baseDatos[2] = null;
                                resta = false;
                                suma = false;
                                div = false;
                                mem = false;
                                mult = false;
                                operando = "";
                                memoria = "";
                                t2.setText(memoria);
                                Toast.makeText(this, R.string.mBorrado, Toast.LENGTH_SHORT).show();
                                t.setText(operando);
                            } else {
                                operando = "";
                                memoria = "";
                                t.setText(operando);
                                t2.setText(memoria);
                                resta = false;
                                suma = false;
                                div = false;
                                mult = false;
                            }
                        } catch (Exception ae) {
                            Toast.makeText(this, R.string.mVacia, Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.bDEL:
                        if (reinicio == false) {
                            try {
                                if (!t.getText().toString().isEmpty()) {
                                    t2.setText(memoria.substring(0, memoria.length() - 1));
                                }
                                t.setText(operando.substring(0, operando.length() - 1));
                            } catch (Exception ae) {
                                Toast.makeText(this, R.string.noDatos, Toast.LENGTH_SHORT).show();
                            }
                            operando = t.getText().toString();
                        }
                        break;
                    case R.id.bM:
                        if (mem == false) {
                            if (!t.getText().toString().isEmpty()) {
                                baseDatos[2] = t.getText().toString();
                                Toast.makeText(this, R.string.mGuardada, Toast.LENGTH_SHORT).show();
                                reinicio = true;
                                mem = true;
                                t.setText("");
                                t2.setText("");
                                baseDatos[0] = "";
                                baseDatos[1] = "";
                                memoria = "";
                                operando = "";
                                suma = false;
                                resta = false;
                                div = false;
                                mult = false;
                                reinicio = false;
                            } else {
                                Toast.makeText(this, R.string.noDatos, Toast.LENGTH_SHORT).show();
                            }
                        } else if (mem) {
                            if (reinicio) {
                                baseDatos[2] = t.getText().toString();
                                Toast.makeText(this, R.string.mGuardada, Toast.LENGTH_SHORT).show();
                                reinicio = true;
                                mem = true;
                                t.setText("");
                                t2.setText("");
                                baseDatos[0] = "";
                                baseDatos[1] = "";
                                memoria = "";
                                operando = "";
                                suma = false;
                                resta = false;
                                div = false;
                                mult = false;
                                reinicio = false;
                            } else {
                                if (!t.getText().toString().isEmpty()) {
                                    memoria = memoria + baseDatos[2].toString();
                                    t2.setText(memoria);
                                    t.setText(baseDatos[2]);
                                } else {
                                    memoria = memoria + baseDatos[2].toString();
                                    t2.setText(memoria);
                                    operando = baseDatos[2];
                                    t.setText(baseDatos[2]);
                                }
                            }
                        }

                        break;
                    case R.id.bRaiz:
                        String n=t.getText().toString();
                        double op=Double.parseDouble(n);
                        t.setText(""+Math.sqrt(op));
                        break;
                    case R.id.bTan:
                        String n2=t.getText().toString();
                        double o2=Double.parseDouble(n2);
                        t.setText(""+ Math.tan(Math.toRadians(o2)));
                        break;
                    case R.id.bCos:
                        String n3=t.getText().toString();
                        double o3=Double.parseDouble(n3);
                        t.setText(""+ Math.cos(Math.toRadians(o3)));
                        break;
                    case R.id.bSen:
                        String n4=t.getText().toString();
                        double o4=Double.parseDouble(n4);
                        t.setText(""+ Math.cos(Math.toRadians(o4)));
                        break;
                }
            }
            memoria = t2.getText().toString();

    }
}
