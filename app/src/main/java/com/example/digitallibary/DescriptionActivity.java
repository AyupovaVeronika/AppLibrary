package com.example.digitallibary;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.shockwave.pdfium.PdfDocument;
import com.github.barteksc.pdfviewer.PDFView;

public class DescriptionActivity extends AppCompatActivity

{
    private static final String TAG = "DescriptionActivity";
    private Context mContext;
    private PDFView pdfView;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        mContext = DescriptionActivity.this;
        pdfView= ( PDFView ) findViewById(R.id.pdfView);
        extras= getIntent().getExtras();
        if(!extras.equals(null))
        {
            String data = extras.getString("titles");
            Log.d(TAG, "onCreate: The coming data is"+data );
            String url = data+".pdf";
            pdfView.fromAsset (url).load ();
        }}
}
