package fr.fives.roosevelt2012;

import java.util.Iterator;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayImagesActivity extends Activity {

	private Button logoButton = null;
	private TextView titleImage;
	private ImageView imageView;
	
	int nbImages = 0;
	Bitmap bitmap;
	int indexCurentFile = -1;
	
	// To trace and to know if there is a move gesture :
	int xPtr=-1;
	int yPtr=-1;
	boolean inActionMove = false;
	int xPtrPrevForMove=-1;
	int yPtrPrevForMove=-1;

	final Context contextFinal = DisplayImagesActivity.this;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_images_activity);
        
        this.inActionMove = false;
        
        // Change color of the title :
        setTitleColor(VG.COLOR_BLACK);
        
        // Change backgound color of the title :
        View titleView = getWindow().findViewById(android.R.id.title);
        if (titleView != null) {
	        ViewParent parent = titleView.getParent();
	        if (parent != null && (parent instanceof View)) {
	          View parentView = (View)parent;
	          parentView.setBackgroundColor(VG.COLOR_YELLOW_WHITE);
	        }
        }
        
        // Change color of the background of the linearlayout:
        View someView = findViewById(R.id.linearlayout);
        View root = someView.getRootView();
   		root.setBackgroundColor(VG.COLOR_YELLOW_WHITE);

   		logoButton = (Button) this.findViewById(R.id.logo);
    	logoButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			Utils.execInternetBrowser(DisplayImagesActivity.this, VG.insternetSiteUrl);
    		}
   		});
        titleImage = (TextView) this.findViewById(R.id.title);

        imageView = (ImageView) this.findViewById(R.id.image);
        
        // First action on the page of the activity, load first file and display it :
		indexCurentFile = 0;
		nbImages = 0;
		if (VG.all_schemas != null && VG.all_schemas.size() > 0) {
			nbImages = VG.all_schemas.size()-1;
			OneFile oneFile = (OneFile) VG.all_schemas.get(indexCurentFile);
			titleImage.setText(Html.fromHtml("(" + indexCurentFile + "/" + nbImages + ")<br/><b>"+ oneFile.title + "</b>"));
			Bitmap bitmap = loadBitmapFromFile(DisplayImagesActivity.this,
					oneFile.filename);
			if (bitmap != null) {
				imageView.setImageBitmap(bitmap);
			} else {
				// File not in storage => we download all files :
				if (Utils.isConnectedToInternet(DisplayImagesActivity.this)) {
					Iterator<OneFile> iterator = VG.all_schemas.iterator();
					String url = null;
					while (iterator.hasNext()) {
						oneFile = (OneFile) iterator.next();
						final OneFile oneFileFinal = oneFile;
						DisplayImagesActivity.this.runOnUiThread(new Runnable() {
							public void run() {
								new ExtractPhotosOfSimpleDataAsyncTask(contextFinal, oneFileFinal,
										DisplayImagesActivity.this).execute();
							}
						});
					}
					// Then try again to display the first image :
					oneFile = (OneFile) VG.all_schemas.get(indexCurentFile);
					bitmap = loadBitmapFromFile(DisplayImagesActivity.this, oneFile.filename);
					if (bitmap != null) {
						imageView.setImageBitmap(bitmap);
						titleImage.setText(Html.fromHtml("(" + indexCurentFile + "/" + nbImages + ")<br/><b>"+ oneFile.title + "</b>"));
					}
				} else {
					Toast.makeText(
							DisplayImagesActivity.this,
							"Nécessite internet pour télécharger à la 1ére visualisation des schémas",
							Toast.LENGTH_SHORT).show();
				}

			}
		}

    }

    /**
     * Display the previous schema
     */
    protected void previousSchema() {
		if (VG.all_schemas != null && VG.all_schemas.size() > 0
				&& indexCurentFile - 1 >= 0) {
			indexCurentFile--;
			OneFile oneFile = (OneFile) VG.all_schemas
					.get(indexCurentFile);
			Bitmap bitmap = loadBitmapFromFile(
					DisplayImagesActivity.this, oneFile.filename);
			if (bitmap != null) {
				imageView.setImageBitmap(bitmap);
			} else {
				imageView.setImageBitmap(null);
			}
			titleImage.setText(Html.fromHtml("(" + indexCurentFile + "/" + nbImages + ")<br/><b>"+ oneFile.title + "</b>"));
		}
	}

    /**
     * Display the next schema
     */
	protected void nextSchema() {
		if (VG.all_schemas != null
				&& VG.all_schemas.size() > indexCurentFile + 1) {
			indexCurentFile++;
			OneFile oneFile = (OneFile) VG.all_schemas.get(indexCurentFile);
			Bitmap bitmap = loadBitmapFromFile(DisplayImagesActivity.this,
					oneFile.filename);
			if (bitmap != null) {
				imageView.setImageBitmap(bitmap);
			} else {
				imageView.setImageBitmap(null);
			}
			titleImage.setText(Html.fromHtml("(" + indexCurentFile + "/" + nbImages + ")<br/><b>"+ oneFile.title + "</b>"));
		}
	}

	/**  
	 * For navigate in schemas with finger
	 */
	public boolean onTouchEvent(MotionEvent event) {
    	int x = (int) event.getX();
		int y = (int) event.getY();
		// Test action :
		int action = event.getAction();
		switch (action) {
		case MotionEvent.ACTION_MOVE:
			xPtrPrevForMove = xPtr;
			xPtr = x;
			yPtrPrevForMove = yPtr;
			yPtr = y;
			break;
		case MotionEvent.ACTION_UP:
			// Indicate that end of ACTION_MOVE :
			Dot delta = new Dot(xPtr - xPtrPrevForMove, yPtr - yPtrPrevForMove);
			if (delta.x > 0) {// Towards right
				previousSchema();
			} else if (delta.x < 0) {// Towards left
				nextSchema();
			}
			// Indicate the end of ACTION_MOVE :
			inActionMove = false;
			break;
		case MotionEvent.ACTION_DOWN:
			// Indicate the begining of ACTION_MOVE :
			inActionMove = true;
			break;
		}
		return true;
    }
    
	/**
	 * Load bitmap
	 * @param context
	 * @param filename
	 * @return
	 */
	public Bitmap loadBitmapFromFile(Context context, String filename) {
		Bitmap bitmapRes = null;
		String path = null;
			path = context.getApplicationContext().getFilesDir() + "/"
					+ filename;
		bitmapRes = BitmapFactory.decodeFile(path);
		return bitmapRes;
	}
	
}
