package com.base.mycvproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import Data.MyCv;
import Data.MycvViewModule;

public class ActivitycreateCv extends AppCompatActivity {
    private ImageView imageViewpusi;
   private EditText editTextnamelastname;
   private EditText editTextprofeson;
   private EditText editTextpersonalinformation;
   private EditText editTexteducation;
   private EditText editTextlanguages;
   private EditText editTextskills;
   private EditText editTextexpirience;
   private EditText editTextAwards;
   private Button buttonaddpicteres;
   private static final int IMAGE_CODE=123;
   private static final int Permission_cose=122;
   private MycvViewModule mycvViewModule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitycreate_cv);
        imageViewpusi=findViewById(R.id.imageView);
        editTextnamelastname=findViewById(R.id.edittextfirstandlastname);
        mycvViewModule= ViewModelProviders.of(this).get(MycvViewModule.class);
        editTextprofeson=findViewById(R.id.editTextTextPersonProfession);
        editTextpersonalinformation=findViewById(R.id.editTextTextMultiLinepersonalinfo);
        editTexteducation=findViewById(R.id.editTextTextMultiLineeducations);
        editTextlanguages=findViewById(R.id.editTextTextMultiLinelanguages);
        editTextskills=findViewById(R.id.editTextTextMultiLineSkills);
        editTextexpirience=findViewById(R.id.editTextTextMultiLineexpirience);
        editTextAwards=findViewById(R.id.editTextTextMultiLineawards);
        buttonaddpicteres=findViewById(R.id.buttonuploadimage);
        buttonaddpicteres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                   if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                       String[]permissions={Manifest.permission.READ_EXTERNAL_STORAGE};
                       requestPermissions(permissions,Permission_cose);
                   }
                   else{
                      pickPhotoFromGallery();
                   }
               }
               else{
                   pickPhotoFromGallery();
               }
            }
        });
    }

    private void pickPhotoFromGallery() {
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,IMAGE_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case Permission_cose:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    pickPhotoFromGallery();
                }
                else{
                    Toast.makeText(this, "Permission was dineid", Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == IMAGE_CODE) {
              imageViewpusi.setImageURI(data.getData());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onCklickseReadyResume(View view) {
        String lastnamefirstname=editTextnamelastname.getText().toString().trim();
        String profession=editTextprofeson.getText().toString().trim();
        String personalinfo=editTextpersonalinformation.getText().toString().trim();
        String education=editTexteducation.getText().toString().trim();
        String lahguage=editTextlanguages.getText().toString().trim();
        String skills=editTextskills.getText().toString().trim();
        String expirience=editTextexpirience.getText().toString().trim();
        String awards=editTextAwards.getText().toString().trim();
        MyCv myCv=new MyCv(lastnamefirstname,profession,personalinfo,expirience,education,lahguage,skills,awards);
        if(!lastnamefirstname.isEmpty()&&!profession.isEmpty()&&
                !personalinfo.isEmpty()&&!education.isEmpty()
                &&!lahguage.isEmpty()&&!skills.isEmpty()&&!expirience.isEmpty()&&!awards.isEmpty()){
            mycvViewModule.insertMycVs(myCv);
            Intent intent3=new Intent(this,MainActivity3.class);
            startActivity(intent3);
        }
        else{
            Toast.makeText(this, "Pls Field the fields", Toast.LENGTH_LONG).show();
        }
    }
}