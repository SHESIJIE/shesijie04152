package shesijie.bawei.com.shesijie0415.mvp;

import shesijie.bawei.com.shesijie0415.MainActivity;

public class Presenter implements Conster.IPresenter {
    Conster.IView iView;
    Model model;
    MainActivity mainActivity;
    Model model1;
    Model model2;


    @Override
    public void attch(MainActivity mainActivity) {
          model = new Model ();
          this.iView = mainActivity;
    }

    @Override
    public void desch() {
        if (model != null) {
            model = null;
        }
        if (iView != null) {
            iView = null;
        }
        System.gc ();
    }

    @Override
    public void login(String url , String name , String pass) {
        model.getResult ( url , name , pass , new Conster.IModel.ModelCallBack () {
            @Override
            public void onSuccess(String data) {
                mainActivity.getPresenter ( data );
            }

            @Override
            public void fail() {

            }
        } );
    }
}
