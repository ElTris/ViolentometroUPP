package com.example.tr.violentometroofupp;
import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
public class Ayuda extends AppCompatActivity {
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;
    LinearLayout l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Animation revote;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
        l1=(LinearLayout)findViewById(R.id.targeta1);
        l2=(LinearLayout)findViewById(R.id.targeta2);
        l3=(LinearLayout)findViewById(R.id.targeta3);
        l4=(LinearLayout)findViewById(R.id.targeta4);
        l5=(LinearLayout)findViewById(R.id.targeta5);
        l6=(LinearLayout)findViewById(R.id.targeta6);
        l7=(LinearLayout)findViewById(R.id.targeta7);
        l8=(LinearLayout)findViewById(R.id.targeta8);
        l9=(LinearLayout)findViewById(R.id.targeta9);
        l10=(LinearLayout)findViewById(R.id.targeta10);
        revote= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        l1.startAnimation(revote);
        l2.startAnimation(revote);
        l3.startAnimation(revote);
        l4.startAnimation(revote);
        l5.startAnimation(revote);
        l6.startAnimation(revote);
        l7.startAnimation(revote);
        l8.startAnimation(revote);
        l9.startAnimation(revote);
        l10.startAnimation(revote);
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para realizar llamadas telefónicas.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 225);
        } else {
            Log.i("Mensaje", "Se tiene permiso para realizar llamadas!");
        }
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(Ayuda.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(Ayuda.this);
                }
                builder.setMessage("¿Desea realizar llamada?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    if (ContextCompat.checkSelfPermission(Ayuda.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                                        intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:017717181550"));
                                        startActivity(intent);
                                    }else{
                                        ActivityCompat.requestPermissions(Ayuda.this,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
                                        return;
                                    }
                                }else{
                                    intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:017717181550"));
                                    startActivity(intent);
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.sym_action_call)
                        .show();
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(Ayuda.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(Ayuda.this);
                }
                builder.setMessage("¿Desea realizar llamada?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    if (ContextCompat.checkSelfPermission(Ayuda.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                                        intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:018005022221"));
                                        startActivity(intent);
                                    }else{
                                        ActivityCompat.requestPermissions(Ayuda.this,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
                                        return;
                                    }
                                }else{
                                    intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:018005022221"));
                                    startActivity(intent);
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.sym_action_call)
                        .show();
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(Ayuda.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(Ayuda.this);
                }
                builder.setMessage("¿Desea realizar llamada?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    if (ContextCompat.checkSelfPermission(Ayuda.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                                        intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:018008224460"));
                                        startActivity(intent);
                                    }else{
                                        ActivityCompat.requestPermissions(Ayuda.this,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
                                        return;
                                    }
                                }else{
                                    intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:018008224460"));
                                    startActivity(intent);
                                }

                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.sym_action_call)
                        .show();
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(Ayuda.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(Ayuda.this);
                }
                builder.setMessage("¿Desea realizar llamada?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    if (ContextCompat.checkSelfPermission(Ayuda.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                                        intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:017711532850"));
                                        startActivity(intent);
                                    }else{
                                        ActivityCompat.requestPermissions(Ayuda.this,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
                                        return;
                                    }
                                }else{
                                    intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:017711532850"));
                                    startActivity(intent);
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.sym_action_call)
                        .show();
            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(Ayuda.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(Ayuda.this);
                }
                builder.setMessage("¿Desea realizar llamada?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    if (ContextCompat.checkSelfPermission(Ayuda.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                                        intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:017717189962"));
                                        startActivity(intent);
                                    }else{
                                        ActivityCompat.requestPermissions(Ayuda.this,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
                                        return;
                                    }
                                }else{
                                    intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:017717189962"));
                                    startActivity(intent);
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.sym_action_call)
                        .show();
            }
        });
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(Ayuda.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(Ayuda.this);
                }
                builder.setMessage("¿Desea realizar llamada?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    if (ContextCompat.checkSelfPermission(Ayuda.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                                        intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:7717179000"));
                                        startActivity(intent);
                                    }else{
                                        ActivityCompat.requestPermissions(Ayuda.this,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
                                        return;
                                    }
                                }else{
                                    intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:7717179000"));
                                    startActivity(intent);
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.sym_action_call)
                        .show();
            }
        });
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(Ayuda.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(Ayuda.this);
                }
                builder.setMessage("¿Desea realizar llamada?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    if (ContextCompat.checkSelfPermission(Ayuda.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                                        intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:017717132633"));
                                        startActivity(intent);
                                    }else{
                                        ActivityCompat.requestPermissions(Ayuda.this,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
                                        return;
                                    }
                                }else{
                                    intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:017717132633"));
                                    startActivity(intent);
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.sym_action_call)
                        .show();
            }
        });
        l8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(Ayuda.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(Ayuda.this);
                }
                builder.setMessage("¿Desea realizar llamada?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    if (ContextCompat.checkSelfPermission(Ayuda.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                                        intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:018009029832"));
                                        startActivity(intent);
                                    }else{
                                        ActivityCompat.requestPermissions(Ayuda.this,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
                                        return;
                                    }
                                }else{
                                    intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:018009029832"));
                                    startActivity(intent);
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.sym_action_call)
                        .show();
            }
        });
        l9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(Ayuda.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(Ayuda.this);
                }
                builder.setMessage("¿Desea realizar llamada?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    if (ContextCompat.checkSelfPermission(Ayuda.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                                        intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:017717187144"));
                                        startActivity(intent);
                                    }else{
                                        ActivityCompat.requestPermissions(Ayuda.this,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
                                        return;
                                    }
                                }else{
                                    intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:017717187144"));
                                    startActivity(intent);
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.sym_action_call)
                        .show();
            }
        });
        l10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(Ayuda.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(Ayuda.this);
                }
                builder.setMessage("¿Desea realizar llamada?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    if (ContextCompat.checkSelfPermission(Ayuda.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                                        intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:018004627374"));
                                        startActivity(intent);
                                    }else{
                                        ActivityCompat.requestPermissions(Ayuda.this,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
                                        return;
                                    }
                                }else{
                                    intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:018004627374"));
                                    startActivity(intent);
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.sym_action_call)
                        .show();
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_ASK_PERMISSIONS:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // El usuario acepto los permisos.
                    Toast.makeText(this, "Gracias, aceptaste los permisos requeridos para el correcto funcionamiento de esta aplicación.", Toast.LENGTH_SHORT).show();
                }else{
                    // Permiso denegado.
                    Toast.makeText(this, "No se aceptó permisos", Toast.LENGTH_SHORT).show();
                }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}