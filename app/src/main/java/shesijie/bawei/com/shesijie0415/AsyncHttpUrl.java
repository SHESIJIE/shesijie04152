package shesijie.bawei.com.shesijie0415;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncHttpUrl {
    private static final AsyncHttpUrl httpUrl = new AsyncHttpUrl ();
    //单例模式
    public static AsyncHttpUrl getInstance(String url , String name , String pass , AsyncCallback asyncCallback){
        return  httpUrl;
    }
    //异步请求
    public void PostAsync(final String url, final String username, final String pswd, final AsyncCallback callback) {
        new AsyncTask<String,Void,String> (){

            @Override
            protected String doInBackground(String... strings) {
                return PostData ( strings[0] );
            }
            @Override
            protected void onPostExecute(String s) {
                if (!TextUtils.isEmpty ( s )) {
                    callback.success ( s );
                } else {
                    callback.error ( 504,"没有请求到数据" );
                }
            }
        }.execute (url  );
    }

    private String PostData(String url) {
        try {
            URL url1 = new URL ( url );
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection ();
            connection.setRequestMethod ( "GET" );
            connection.setReadTimeout ( 5000 );
            connection.setConnectTimeout ( 5000 );
            if (connection.getResponseCode () == 200) {
                 return CharStreams.toString ( new InputStreamReader ( connection.getInputStream () ) );
                   }
        } catch (MalformedURLException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return  null;
    }


    public interface AsyncCallback{
        void success(String result);
        void error(int errcode,String message);

    }
}
