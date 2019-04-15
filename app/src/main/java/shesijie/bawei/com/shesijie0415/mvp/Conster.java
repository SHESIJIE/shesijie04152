package shesijie.bawei.com.shesijie0415.mvp;

import shesijie.bawei.com.shesijie0415.MainActivity;

public interface Conster {

    public interface IView{
        void getPresenter(String data);

    }
    public interface IModel{
        void getResult(String url,String name,String pass,ModelCallBack modelCallBack);
        public interface ModelCallBack{
            void onSuccess(String data);
            void fail();
        }
    }
    public interface IPresenter{

        void attch(MainActivity mainActivity);
        void desch();
        void login(String url,String name,String pass);
    }
}
