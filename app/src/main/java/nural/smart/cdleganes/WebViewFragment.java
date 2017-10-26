package nural.smart.cdleganes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;

import nural.smart.cdleganes.components.MyWebViewClient;

/**
 * Created by alvaro on 27/3/17.
 */

public class WebViewFragment extends Fragment {

    private static final String urlKey = "URL";

    public static WebViewFragment newInstance(String url) {
        WebViewFragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString(urlKey, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.fragment_webview, container, false);


        Bundle args = getArguments();
        String url = args.getString(urlKey, "");

        final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBarWebView);
        final WebView webView = (WebView) view.findViewById(R.id.schedule_web_view);
        webView.setWebViewClient(new MyWebViewClient(progressBar));
        webView.loadUrl(url);

        return view;
    }
}
