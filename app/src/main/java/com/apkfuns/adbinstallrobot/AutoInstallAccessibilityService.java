package com.apkfuns.adbinstallrobot;


import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;



/**
 * Created by pengwei on 2017/6/16.
 */

public class AutoInstallAccessibilityService extends AccessibilityService {

    public static String[] installBtnId = new String[]{
            "vivo:id/vivo_adb_install_ok_button"};

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        AccessibilityServiceInfo mAccessibilityServiceInfo = new AccessibilityServiceInfo();
        mAccessibilityServiceInfo.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        mAccessibilityServiceInfo.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN;
        mAccessibilityServiceInfo.packageNames = HiApplication.packageList.toArray(new String[]{});
        setServiceInfo(mAccessibilityServiceInfo);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        int eventType = event.getEventType();
        switch (eventType) {
            case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                for (String id : installBtnId) {
                    AccessibilityNodeInfo node = AccessibilityNodeUtil.findNodeById(event.getSource(),id);
                    if (node != null) {
                        AccessibilityNodeUtil.click(node);
                        Toast.makeText(this, "安装成功", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onInterrupt() {

    }
}
