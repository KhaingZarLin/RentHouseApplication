package com.example.renthouseapplication.delegate;

public interface FragmentDelegateOne  {
    void onTapDElegate(int holdId);
    void onLayoutChange(LayoutManagerDelegate layoutManagerDelegate);

    public interface LayoutManagerDelegate {
        void onChangeToLinearLayout();
        void onChangeToGridLayout();
    }
}
