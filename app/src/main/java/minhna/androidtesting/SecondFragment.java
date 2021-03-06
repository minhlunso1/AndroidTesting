package minhna.androidtesting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 05-Sep-17.
 */

public class SecondFragment extends Fragment {
    public String TAG = "";
    public int id;
    private MainActivity activity;

    public static SecondFragment newInstance(int id) {
        SecondFragment fragment = new SecondFragment();
        fragment.id = id;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        TAG = activity.TAG;
        Log.i(TAG, "Second Fragment id:" + id);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
