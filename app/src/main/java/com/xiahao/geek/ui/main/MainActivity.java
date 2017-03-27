package com.xiahao.geek.ui.main;

import android.content.DialogInterface;
import android.support.v7.widget.Toolbar;

import com.xiahao.geek.R;
import com.xiahao.geek.app.App;
import com.xiahao.geek.base.BaseActivity;
import com.xiahao.geek.presenter.MainPresenter;
import com.xiahao.geek.presenter.contract.MainContract;
import com.xiahao.geek.ui.gank.fragment.GankMainFragment;

import javax.inject.Inject;

import butterknife.BindView;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @Inject
    GankMainFragment mGankMainFragment;

    public static final String TAG = "MainActivity";


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
//        setToolBar(mToolBar, "知乎日报");
        loadRootFragment(R.id.fl_main_content, mGankMainFragment);
        showHideFragment(mGankMainFragment, mGankMainFragment);
    }


    @Override
    public void onBackPressedSupport() {
        showExitDialog();
    }


    private void showExitDialog() {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("确定退出GeekNews吗");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                App.getInstance().exitApp();
            }
        });
        builder.show();
    }

    @Override
    public void showUpdateDialog(String versionContent) {

    }

    @Override
    public void startDownloadService() {

    }

    @Override
    public void showError(String msg) {

    }
}
