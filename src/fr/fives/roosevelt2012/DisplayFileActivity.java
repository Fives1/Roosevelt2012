package fr.fives.roosevelt2012;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class DisplayFileActivity extends Activity {

	Button zoomIn;
	Button zoomOut;
	
	Button originalOrder;
	Button lastnameOrder;
	Button firstnameOrder;
	
	WebView webview = null;
	
	int numReform = 0;
	Reform reforme = null;
	int indexCurentFile = 0;
	
	// To trace and to know if there is a move gesture :
	int xPtr=-1;
	int yPtr=-1;
	boolean inActionMove = false;
	int xPtrPrevForMove=-1;
	int yPtrPrevForMove=-1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_file_activity);
        
        // Set title :
        Bundle bundle = this.getIntent().getExtras();
        numReform = bundle.getInt("numReform");
   		indexCurentFile = numReform;
   		if (VG.REFORMS_TITLE!=null && VG.REFORMS_TITLE.size()>=numReform) {
   			reforme = VG.REFORMS_TITLE.get(numReform);
   	   		if (reforme!=null) {
   	   			if (reforme.title!=null) {
   	   				setTitle(reforme.title);
   	   			}
   	   		}
   		}

        // Change color of the title :
        setTitleColor(VG.COLOR_WHITE);
        
        // Change backgound color of the title :
        View titleView = getWindow().findViewById(android.R.id.title);
        if (titleView != null) {
	        ViewParent parent = titleView.getParent();
	        if (parent != null && (parent instanceof View)) {
	          View parentView = (View)parent;
	          parentView.setBackgroundColor(VG.COLOR_ORANGE);
	        }
        }

        // Background of menu :
		View someView = findViewById(R.id.title_layout_of_display_file);
		View root = someView.getRootView();
		root.setBackgroundColor(VG.COLOR_YELLOW_WHITE);

		zoomOut = (Button) this.findViewById(R.id.zoomOut);
    	zoomOut.setVisibility(View.VISIBLE);
   		zoomOut.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (VG.textSizeOfBodyInButton>=6) {
					VG.textSizeOfBodyInButton -= 2;
			        WebSettings webSettings = webview.getSettings();
			        webSettings.setDefaultFontSize(VG.textSizeOfBodyInButton);
				}
			}
		});
    	zoomIn = (Button) this.findViewById(R.id.zoomIn);
    	zoomIn.setVisibility(View.VISIBLE);
   		zoomIn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				VG.textSizeOfBodyInButton += 2;
		        WebSettings webSettings = webview.getSettings();
		        webSettings.setDefaultFontSize(VG.textSizeOfBodyInButton);
			}
		});
        
    	// If page of 'names in the the collectif', then display button to choose ordered lines :
    	originalOrder = (Button) this.findViewById(R.id.original_order);
    	originalOrder.setVisibility(View.GONE);
    	originalOrder.setTextColor(VG.COLOR_WHITE);
    	originalOrder.setBackgroundColor(VG.COLOR_ORANGE);
    	if (VG.languageChoiced==VG.language.ITALIAN) {
    		originalOrder.setText("Ordine originale");
    	} else {
    		originalOrder.setText("Ordre original");
    	}
    	lastnameOrder = (Button) this.findViewById(R.id.lastname_order);
    	lastnameOrder.setVisibility(View.GONE);
    	lastnameOrder.setTextColor(VG.COLOR_WHITE);
    	lastnameOrder.setBackgroundColor(VG.COLOR_GREY);
    	if (VG.languageChoiced==VG.language.ITALIAN) {
    		lastnameOrder.setText("Per nome");
    	} else {
    		lastnameOrder.setText("Par nom");
    	}
    	firstnameOrder = (Button) this.findViewById(R.id.firstname_order);
    	firstnameOrder.setVisibility(View.GONE);
    	firstnameOrder.setTextColor(VG.COLOR_WHITE);
    	firstnameOrder.setBackgroundColor(VG.COLOR_GREY);
    	if (VG.languageChoiced==VG.language.ITALIAN) {
    		firstnameOrder.setText("Per cognome");
    	} else {
    		firstnameOrder.setText("Par prénom");
    	}
    	if (numReform==0) {
        	originalOrder.setVisibility(View.VISIBLE);
        	lastnameOrder.setVisibility(View.VISIBLE);
        	firstnameOrder.setVisibility(View.VISIBLE);
        }
        originalOrder.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				originalOrder.setBackgroundColor(VG.COLOR_ORANGE);
				lastnameOrder.setBackgroundColor(VG.COLOR_GREY);
				firstnameOrder.setBackgroundColor(VG.COLOR_GREY);
		        String summary = createStringArrayListFromFile(DisplayFileActivity.this, VG.TYPE_STORAGE.ASSETS, VG.COLLECTIFNAMESFILE_ORIGINALORDER, true);
		        webview.loadData(summary, "text/html; charset=utf-8", "UTF-8");
			}
		});
        firstnameOrder.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				originalOrder.setBackgroundColor(VG.COLOR_GREY);
				lastnameOrder.setBackgroundColor(VG.COLOR_GREY);
				firstnameOrder.setBackgroundColor(VG.COLOR_ORANGE);
		        String summary = createStringArrayListFromFile(DisplayFileActivity.this, VG.TYPE_STORAGE.ASSETS, VG.COLLECTIFNAMESFILE_FIRSTNAMESORDER, true);
		        webview.loadData(summary, "text/html; charset=utf-8", "UTF-8");
			}
		});
        lastnameOrder.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				originalOrder.setBackgroundColor(VG.COLOR_GREY);
				lastnameOrder.setBackgroundColor(VG.COLOR_ORANGE);
				firstnameOrder.setBackgroundColor(VG.COLOR_GREY);
		        String summary = createStringArrayListFromFile(DisplayFileActivity.this, VG.TYPE_STORAGE.ASSETS, VG.COLLECTIFNAMESFILE_LASTNAMESORDER, true);
		        webview.loadData(summary, "text/html; charset=utf-8", "UTF-8");
			}
		});
        
        // 
        webview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setDefaultFontSize(VG.textSizeOfBodyInButton);
		if (numReform==0) {
			// Case of the chooze of members of the Collective.
   			originalOrder.setBackgroundColor(VG.COLOR_ORANGE);
			lastnameOrder.setBackgroundColor(VG.COLOR_GREY);
			firstnameOrder.setBackgroundColor(VG.COLOR_GREY);
	        String summary = createStringArrayListFromFile(DisplayFileActivity.this, VG.TYPE_STORAGE.ASSETS, VG.COLLECTIFNAMESFILE_ORIGINALORDER, true);
	        webview.loadData(summary, "text/html; charset=utf-8", "UTF-8");
		} else {
			// Chooze of a real reform.
	        if (reforme==null || reforme.file==null || "".equals(reforme.file)) {
	        	Log.e("DisplayReform", "pathFile null ou vide");
	        } else {
		        if (VG.searchText==null || "".equals(VG.searchText)) {
			        String summary = createStringArrayListFromFile(DisplayFileActivity.this, VG.TYPE_STORAGE.ASSETS, reforme.file, true);
			        webview.loadData(summary, "text/html; charset=utf-8", "UTF-8");
			        // Remarque : les "utf-8" dans loadData ne changent rien. Il faut la ligne suivante dans le fichier .html :
			        // <head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
		        }
	        }
        }
        
        // Change background color of the big webview ! :
        webview.setBackgroundColor(VG.COLOR_YELLOW_WHITE);
        
    }
    
    /**
     * Make text to display.
     * @param context
     * @param typeStorage
     * @param stringFile
     * @param isUtf8
     * @return
     */
	public static String createStringArrayListFromFile(Context context, VG.TYPE_STORAGE typeStorage, String stringFile,
			boolean isUtf8) {
		String res = "";
		if (context!=null && stringFile!=null && !"".equals(stringFile) && typeStorage!=null) {
			int cptMaxLineToRead = 5000;
			try {
				InputStream is = null;
				if (VG.TYPE_STORAGE.ASSETS.equals(typeStorage)) {
					is = context.getResources().getAssets().open(stringFile);
				} else if (VG.TYPE_STORAGE.INTERNAL.equals(typeStorage)) {
					String path = context.getApplicationContext().getFilesDir() + "/" + stringFile;
					File file = new File(path);
					is = new BufferedInputStream(new FileInputStream(file));
				}
				InputStreamReader isr = null;
				// Certaines pages ne sont pas � lire en UTF-8, sinon probl�me d'accents
				// et donc probl�me de test sur les string
				if (isUtf8) {
					isr = new InputStreamReader(is, "UTF-8");
				} else {
					isr = new InputStreamReader(is);
				}
				BufferedReader in = new BufferedReader(isr);
				String line;
				int i = 0;
				while ((line = in.readLine()) != null && (i < cptMaxLineToRead)) {
					res += line;
					i++;
				}
				in.close();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				res = null;
			}
		}
		return res;
	}

}
