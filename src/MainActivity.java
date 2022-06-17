package ahmet.y.aydeniz.minimalist.hackernewsclient;



import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.*;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.app.*;

import android.os.*;

import android.view.*;

import android.view.View.*;

import android.widget.*;

import android.content.*;

import android.content.res.*;

import android.graphics.*;

import android.graphics.drawable.*;

import android.media.*;

import android.net.*;

import android.text.*;

import android.text.style.*;

import android.util.*;

import android.webkit.*;

import android.animation.*;

import android.view.animation.*;

import java.util.*;

import java.util.regex.*;

import java.text.*;

import org.json.*;

import android.webkit.WebView;

import android.webkit.WebSettings;

import android.view.View;

import android.content.ClipData;

import android.content.ClipboardManager;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.DialogFragment;





public class MainActivity extends AppCompatActivity {

	

	private FloatingActionButton _fab;

	private String url = "";

	

	private WebView webview1;

	

	private Notification notification;

	private Notification noti;

	

	@Override

	protected void onCreate(Bundle _savedInstanceState) {

		super.onCreate(_savedInstanceState);

		setContentView(R.layout.main);

		initialize(_savedInstanceState);

		initializeLogic();

	}

	

	private void initialize(Bundle _savedInstanceState) {

		_fab = (FloatingActionButton) findViewById(R.id._fab);

		

		webview1 = (WebView) findViewById(R.id.webview1);

		webview1.getSettings().setJavaScriptEnabled(true);

		webview1.getSettings().setSupportZoom(true);

		

		webview1.setWebViewClient(new WebViewClient() {

			@Override

			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {

				final String _url = _param2;

				

				super.onPageStarted(_param1, _param2, _param3);

			}

			

			@Override

			public void onPageFinished(WebView _param1, String _param2) {

				final String _url = _param2;

				

				super.onPageFinished(_param1, _param2);

			}

		});

		

		_fab.setOnLongClickListener(new View.OnLongClickListener() {

			 @Override

				public boolean onLongClick(View _view) {

				webview1.clearHistory();

				webview1.clearCache(true);

				SketchwareUtil.showMessage(getApplicationContext(), "You have cleared the cache");

				return true;

				}

			 });

		

		_fab.setOnClickListener(new View.OnClickListener() {

			@Override

			public void onClick(View _view) {

				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", webview1.getUrl()));

				SketchwareUtil.showMessage(getApplicationContext(), "Url has copied to the clipboard");

			}

		});

	}

	

	private void initializeLogic() {

		webview1.loadUrl("https://news.ycombinator.com/");

	}

	

	@Override

	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {

		super.onActivityResult(_requestCode, _resultCode, _data);

		switch (_requestCode) {

			

			default:

			break;

		}

	}

	

	@Override

	public void onBackPressed() {

		webview1.goBack();

	}

	@Deprecated

	public void showMessage(String _s) {

		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();

	}

	

	@Deprecated

	public int getLocationX(View _v) {

		int _location[] = new int[2];

		_v.getLocationInWindow(_location);

		return _location[0];

	}

	

	@Deprecated

	public int getLocationY(View _v) {

		int _location[] = new int[2];

		_v.getLocationInWindow(_location);

		return _location[1];

	}

	

	@Deprecated

	public int getRandom(int _min, int _max) {

		Random random = new Random();

		return random.nextInt(_max - _min + 1) + _min;

	}

	

	@Deprecated

	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {

		ArrayList<Double> _result = new ArrayList<Double>();

		SparseBooleanArray _arr = _list.getCheckedItemPositions();

		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {

			if (_arr.valueAt(_iIdx))

			_result.add((double)_arr.keyAt(_iIdx));

		}

		return _result;

	}

	

	@Deprecated

	public float getDip(int _input) {

		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());

	}

	

	@Deprecated

	public int getDisplayWidthPixels() {

		return getResources().getDisplayMetrics().widthPixels;

	}

	

	@Deprecated

	public int getDisplayHeightPixels() {

		return getResources().getDisplayMetrics().heightPixels;

	}

}
