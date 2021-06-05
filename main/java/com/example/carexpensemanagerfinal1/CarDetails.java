package com.example.carexpensemanagerfinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class CarDetails extends Activity
{


   private EditText etCarID1,etCarModel1,etCarCapacity1,etCarColour1,etCarOwnerID1;

    private ImageView pic;
    private Car_Table db;

    private  ListView lv;
    private dataAdapter data;
    private Car dataModel;
    private Bitmap bp;
    private byte[] photo;
    private String carid;
    private String model;

    private String capacity;
    private String colour;

    private String ownerID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        //Instantiate database handler
        db=new Car_Table(this);

        lv = (ListView) findViewById(R.id.list1);
        pic= (ImageView) findViewById(R.id.pic);
        etCarID1=(EditText) findViewById(R.id.etCarID);
        etCarModel1=(EditText) findViewById(R.id.etCarModel);
        etCarOwnerID1=(EditText) findViewById(R.id.etCarOwnerID);
        etCarColour1=(EditText) findViewById(R.id.etCarColour);
        etCarCapacity1=(EditText) findViewById(R.id.etCarCapacity);

    }

    public void buttonClicked(View v){
        int id=v.getId();

        switch(id){

            case R.id.save:

                if(etCarID1.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(),"carid edit text is empty, Enter name", Toast.LENGTH_LONG).show();
                }  else{
                    addContact();
                }

                break;

            case R.id.display:

                ShowRecords();
                break;
            case R.id.pic:
                selectImage();
                break;
        }
    }

    public void selectImage()
    {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 2);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case 2:
                if(resultCode == RESULT_OK){
                    Uri choosenImage = data.getData();

                    if(choosenImage !=null){

                        bp=decodeUri(choosenImage, 400);
                        pic.setImageBitmap(bp);
                    }
                }
        }
    }
    //COnvert and resize our image to 400dp for faster uploading our images to DB
    protected Bitmap decodeUri(Uri selectedImage, int REQUIRED_SIZE) {

        try {

            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o);

            // The new size we want to scale to
            // final int REQUIRED_SIZE =  size;

            // Find the correct scale value. It should be the power of 2.
            int width_tmp = o.outWidth, height_tmp = o.outHeight;
            int scale = 1;
            while (true) {
                if (width_tmp / 2 < REQUIRED_SIZE
                        || height_tmp / 2 < REQUIRED_SIZE) {
                    break;
                }
                width_tmp /= 2;
                height_tmp /= 2;
                scale *= 2;
            }

            // Decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o2);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Convert bitmap to bytes
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    private byte[] profileImage(Bitmap b){

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG, 0, bos);
        return bos.toByteArray();

    }
    // function to get values from the Edittext and image
    private void getValues()
    {


        carid= etCarID1.getText().toString();
        model=etCarModel1.getText().toString();
        colour= etCarColour1.getText().toString();
        ownerID= etCarOwnerID1.getText().toString();
        capacity= etCarCapacity1.getText().toString();

        photo = profileImage(bp);
    }

    //Insert data to the database
    private void addContact(){
        getValues();
//Car(String carId, String model, String capacity, String colour, String ownerId, byte[] image) {
        db.addContacts(new Car(carid,model,capacity,colour,ownerID, photo));
        Toast.makeText(getApplicationContext(),"Saved successfully", Toast.LENGTH_LONG).show();
    }

    //Retrieve data from the database and set to the list view
    private void ShowRecords(){
        try{
        final ArrayList<Car> contacts = new ArrayList<>(db.getAllContacts());
        data=new dataAdapter(this, contacts);

        lv.setAdapter(data);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                dataModel = contacts.get(position);

                Toast.makeText(getApplicationContext(),String.valueOf(dataModel.getId()), Toast.LENGTH_SHORT).show();
            }
        });
    }
        catch (Exception e1){


            Toast.makeText(getApplicationContext(), e1.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
