package com.example.amanda.overripepantry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class BarcodeScanner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Wiring up the Button
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Load the Image
                ImageView myImageView = (ImageView) findViewById(R.id.imgview);
                Bitmap myBitmap = BitmapFactory.decodeResource(
                        getApplicationContext().getResources(),
                        R.drawable.puppy);
                myImageView.setImageBitmap(myBitmap);
                //Setup the Barcode Detector
                BarcodeDetector detector =
                        new BarcodeDetector.Builder(getApplicationContext())
                            .setBarcodeFormats(Barcode.DATA_MATRIX |
                            Barcode.QR_CODE).build();
                //Detect the Barcode
                Frame frame = new Frame.Builder().setBitmap(myBitmap).build();
                SparseArray<Barcode> barcodes = detector.detect(frame);
                //Decode the Barcode
                Barcode thisCode = barcodes.valueAt(0);
                TextView txtView = (TextView) findViewById(R.id.txtContent);
                txtView.setText(thisCode.rawValue);
                if (!detector.isOperational()) {
                    txtView.setText("Could not set up the detector");
                    return;
                }

            }
        });
        setContentView(R.layout.activity_barcode_scanner);
    }

}
