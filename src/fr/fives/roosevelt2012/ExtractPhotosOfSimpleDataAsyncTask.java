package fr.fives.roosevelt2012;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class ExtractPhotosOfSimpleDataAsyncTask extends AsyncTask<Integer, OneFile, Integer> {

	private Context context;
	private Activity activity;
	private OneFile oneFile;

	public ExtractPhotosOfSimpleDataAsyncTask(Context context, OneFile oneFile, Activity activity) {
		this.context = context;
		this.activity = activity;
		this.oneFile = oneFile;
	}

	@Override
	protected Integer doInBackground(Integer... params) {
		if (oneFile!=null && oneFile.url!=null && !"".equals(oneFile.url) && oneFile.filename!=null && !"".equals(oneFile.filename)) {
			extractBitmapFromUrlToFile(this.context, oneFile.url, oneFile.filename);
		}
		return 42;
	}
		

	@Override
	protected void onPostExecute(Integer result) {
		super.onPostExecute(result);
	}
	
	/**
	 * Extract a image, resize it and save it into a file
	 * @param fromUrl
	 * @param toFile
	 * @param typeStorage
	 * @param newHeight if 0 then no resize
	 * @param newWidth if 0 then no resize
	 */
	public boolean extractBitmapFromUrlToFile(Context context, String fromUrl, String toFile) {
		boolean bitmapSaved = false;
		Log.i("extractBitmapFromUrlToFile", fromUrl + " -> " + toFile);
		if (fromUrl!=null && toFile!=null) {
			Bitmap bitmap = extractImageFromUrlToBitmap(fromUrl);
			if (bitmap!=null) {
				saveBitmapIntoFile(context, bitmap, toFile);
				bitmapSaved = true;
			}
		}
		return bitmapSaved;
	}
	
	public Bitmap extractImageFromUrlToBitmap(String imageUrl) {
		HttpGet httpRequest = new HttpGet(imageUrl);
		HttpClient httpclient = new DefaultHttpClient();
		HttpResponse response;
		Bitmap b = null;
		try {
			response = (HttpResponse) httpclient.execute(httpRequest);
			HttpEntity entity = response.getEntity();
			BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(
					entity);
			InputStream is = bufferedHttpEntity.getContent();
			b = BitmapFactory.decodeStream(is);
		} catch (ClientProtocolException e1) {
			Log.i("extractImageFromUrlToBitmap", "ClientProtocolException.");
			e1.printStackTrace();
		} catch (IOException e1) {
			Log.i("extractImageFromUrlToBitmap", "IOException");
			e1.printStackTrace();
		}
		return b;
	}
	
	public void saveBitmapIntoFile(Context context, Bitmap bitmap, String filename) {
		String path = null;
		path = context.getApplicationContext().getFilesDir() + "/" + filename;
		OutputStream outputstream;
		try {
			outputstream = new FileOutputStream(path);
			bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputstream);
			outputstream.flush();
			outputstream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
