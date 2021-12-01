package login;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class QRGenerator extends AppCompatActivity {

	static public void setImageQR(String dataEdt, ImageView QR) {

		Bitmap bitmap;
		QRGEncoder qrgEncoder;
		// setting this dimensions inside our qr code
		// encoder to generate our qr code.
		qrgEncoder = new QRGEncoder(dataEdt, null, QRGContents.Type.TEXT, 200);
		try {
			// getting our qrcode in the form of bitmap.
			bitmap = qrgEncoder.encodeAsBitmap();
			// the bitmap is set inside our image
			// view using .setimagebitmap method.
			QR.setImageBitmap(bitmap);
		} catch (WriterException e) {
			// this method is called for
			// exception handling.
			Log.e("Tag", e.toString());
		}
	}
}