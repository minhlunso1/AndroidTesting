package minhna.androidtesting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by Administrator on 05-Sep-17.
 */

public class FirstFragment extends Fragment {
    public String TAG = "";
    public int id;
    private MainActivity activity;

    public static FirstFragment newInstance(int id) {
        FirstFragment fragment = new FirstFragment();
        fragment.id = id;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        TAG = activity.TAG;
        Log.i(TAG, "First Fragment id:" + id);
    }

    @Override
    public void onStart() {
        super.onStart();
        activity.getSupportFragmentManager().beginTransaction().add(SecondFragment.newInstance(id), "second")
        .commitAllowingStateLoss();
    }
}
