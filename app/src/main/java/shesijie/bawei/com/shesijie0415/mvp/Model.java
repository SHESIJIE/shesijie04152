package shesijie.bawei.com.shesijie0415.mvp;

import shesijie.bawei.com.shesijie0415.AsyncHttpUrl;

public class Model implements Conster.IModel {


    @Override
    public void getResult(String url , String name , String pass , final ModelCallBack modelCallBack) {
       AsyncHttpUrl.getInstance (url,name,pass, new AsyncHttpUrl.AsyncCallback () {
           @Override
           public void success(String result) {
                modelCallBack.onSuccess ( result );
           }

           @Override
           public void error(int errcode , String message) {

           }
       } );
    }
}
